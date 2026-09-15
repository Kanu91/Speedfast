package cl.duoc.speedfast.app;

import cl.duoc.speedfast.concurrencia.Repartidor;
import cl.duoc.speedfast.concurrencia.ZonaDeCarga;
import cl.duoc.speedfast.modelo.Pedido;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        zonaDeCarga.agregarPedido(
                new Pedido(501, "Av. Departamental 1850")
        );

        zonaDeCarga.agregarPedido(
                new Pedido(502, "Av. Pedro de Valdivia 2210")
        );

        zonaDeCarga.agregarPedido(
                new Pedido(503, "Av. Ecuador 4620")
        );

        zonaDeCarga.agregarPedido(
                new Pedido(504, "Av. Vitacura 4100")
        );

        zonaDeCarga.agregarPedido(
                new Pedido(505, "Av. Américo Vespucio 1380")
        );

        zonaDeCarga.agregarPedido(
                new Pedido(506, "Av. San Pablo 3250")
        );

        Repartidor repartidor1 =
                new Repartidor("Tomás Vega", zonaDeCarga);

        Repartidor repartidor2 =
                new Repartidor("Paula Contreras", zonaDeCarga);

        Repartidor repartidor3 =
                new Repartidor("Matías Soto", zonaDeCarga);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(repartidor1);
        executor.submit(repartidor2);
        executor.submit(repartidor3);

        executor.shutdown();

        try {

            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {

                System.out.println();
                System.out.println(
                        "Todos los pedidos han sido entregados correctamente"
                );

            } else {

                System.out.println(
                        "La ejecución superó el tiempo máximo de espera."
                );

                executor.shutdownNow();
            }

        } catch (InterruptedException e) {

            executor.shutdownNow();
            Thread.currentThread().interrupt();

            System.out.println(
                    "La ejecución fue interrumpida."
            );
        }
    }
}
