package cl.duoc.speedfast.app;

import cl.duoc.speedfast.modelo.PedidoComida;
import cl.duoc.speedfast.modelo.PedidoEncomienda;
import cl.duoc.speedfast.modelo.PedidoExpress;

public class Main {

    public static void main(String[] args) {

        PedidoComida comida =
                new PedidoComida("301", "Av. Vicuña Mackenna 2450", 5);

        PedidoEncomienda encomienda =
                new PedidoEncomienda("302", "Av. Pajaritos 1800", 8);

        PedidoExpress express =
                new PedidoExpress("303", "Av. Los Leones 920", 4);

        System.out.println("=== PEDIDO COMIDA ===");
        comida.mostrarResumen();
        comida.asignarRepartidor();
        comida.reservar();
        System.out.println("Tiempo estimado: "
                + comida.calcularTiempoEntrega() + " minutos");
        comida.despachar();
        comida.verHistorial();

        System.out.println();

        System.out.println("=== PEDIDO ENCOMIENDA ===");
        encomienda.mostrarResumen();
        encomienda.asignarRepartidor("Felipe Muñoz");
        encomienda.reservar();
        System.out.println("Tiempo estimado: "
                + encomienda.calcularTiempoEntrega() + " minutos");
        encomienda.despachar();
        encomienda.verHistorial();

        System.out.println();

        System.out.println("=== PEDIDO EXPRESS ===");
        express.mostrarResumen();
        express.asignarRepartidor("Andrea Silva");
        express.reservar();
        System.out.println("Tiempo estimado: "
                + express.calcularTiempoEntrega() + " minutos");
        express.cancelar();
        express.verHistorial();
    }
}
