package cl.duoc.speedfast.app;

import cl.duoc.speedfast.concurrencia.Repartidor;
import cl.duoc.speedfast.modelo.Pedido;
import cl.duoc.speedfast.modelo.PedidoComida;
import cl.duoc.speedfast.modelo.PedidoEncomienda;
import cl.duoc.speedfast.modelo.PedidoExpress;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        List<Pedido> pedidosSofia = Arrays.asList(
                new PedidoComida("401", "Av. Escuela Agrícola 1234", 4),
                new PedidoExpress("402", "Av. Matta 890", 6)
        );

        List<Pedido> pedidosDiego = Arrays.asList(
                new PedidoEncomienda("403", "Camino Melipilla 5200", 9),
                new PedidoComida("404", "Av. La Florida 7640", 3)
        );

        List<Pedido> pedidosFernanda = Arrays.asList(
                new PedidoExpress("405", "Gran Avenida 4500", 7),
                new PedidoEncomienda("406", "Av. Recoleta 3150", 5)
        );

        Repartidor repartidor1 =
                new Repartidor("Sofía Morales", pedidosSofia);

        Repartidor repartidor2 =
                new Repartidor("Diego Fuentes", pedidosDiego);

        Repartidor repartidor3 =
                new Repartidor("Fernanda Ríos", pedidosFernanda);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(repartidor1);
        executor.submit(repartidor2);
        executor.submit(repartidor3);

        executor.shutdown();

        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println();
                System.out.println("Todos los repartidores finalizaron sus entregas.");
            } else {
                System.out.println("La simulación superó el tiempo de espera.");
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("La ejecución fue interrumpida.");
        }
    }
}
