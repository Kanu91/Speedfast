package cl.duoc.speedfast.concurrencia;

import cl.duoc.speedfast.modelo.EstadoPedido;
import cl.duoc.speedfast.modelo.Pedido;

import java.util.concurrent.ThreadLocalRandom;

public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {

        Pedido pedido;

        while ((pedido = zonaDeCarga.retirarPedido()) != null) {

            try {
                pedido.setEstado(EstadoPedido.EN_REPARTO);

                System.out.println(
                        "[Repartidor - " + nombre + "] Retirando pedido #"
                                + pedido.getId() + "..."
                );

                System.out.println(
                        "[Repartidor - " + nombre + "] Estado: "
                                + pedido.getEstado()
                );

                int tiempoEntrega =
                        ThreadLocalRandom.current().nextInt(1000, 3001);

                Thread.sleep(tiempoEntrega);

                pedido.setEstado(EstadoPedido.ENTREGADO);

                System.out.println(
                        "[Repartidor - " + nombre + "] Pedido #"
                                + pedido.getId() + " entregado."
                );

                System.out.println(
                        "[Repartidor - " + nombre + "] Estado: "
                                + pedido.getEstado()
                );

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

                System.out.println(
                        "[Repartidor - " + nombre + "] Proceso interrumpido."
                );

                return;
            }
        }
    }
}
