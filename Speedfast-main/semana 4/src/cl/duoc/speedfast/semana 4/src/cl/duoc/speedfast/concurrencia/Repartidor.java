package cl.duoc.speedfast.concurrencia;

import cl.duoc.speedfast.modelo.Pedido;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Repartidor implements Runnable {

    private String nombre;
    private List<Pedido> pedidosAsignados;

    public Repartidor(String nombre, List<Pedido> pedidosAsignados) {
        this.nombre = nombre;
        this.pedidosAsignados = pedidosAsignados;
    }

    @Override
    public void run() {

        for (Pedido pedido : pedidosAsignados) {

            try {
                System.out.println(
                        "[Repartidor: " + nombre + "] Entregando "
                                + pedido.getClass().getSimpleName()
                                + " #" + pedido.getIdPedido() + "..."
                );

                int tiempoEspera =
                        ThreadLocalRandom.current().nextInt(1000, 3001);

                Thread.sleep(tiempoEspera);

                pedido.despachar();

                System.out.println(
                        "[Repartidor: " + nombre + "] Pedido #"
                                + pedido.getIdPedido() + " entregado."
                );

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

                System.out.println(
                        "[Repartidor: " + nombre
                                + "] Proceso interrumpido."
                );

                return;
            }
        }
    }
}
