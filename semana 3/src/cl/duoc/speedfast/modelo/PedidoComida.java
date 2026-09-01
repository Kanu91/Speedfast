package cl.duoc.speedfast.modelo;

import cl.duoc.speedfast.interfaces.Cancelable;
import cl.duoc.speedfast.interfaces.Despachable;
import cl.duoc.speedfast.interfaces.Rastreable;

public class PedidoComida extends Pedido
        implements Despachable, Cancelable, Rastreable {

    public PedidoComida(String idPedido, String direccionEntrega, int distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public void asignarRepartidor() {
        setRepartidorAsignado("Nicolás Herrera");
        registrarHistorial("Repartidor automático asignado: Nicolás Herrera");
        System.out.println("Repartidor con mochila térmica asignado: Nicolás Herrera");
    }

    @Override
    public void asignarRepartidor(String nombre) {
        setRepartidorAsignado(nombre);
        registrarHistorial("Repartidor asignado manualmente: " + nombre);
        System.out.println("Repartidor con mochila térmica asignado: " + nombre);
    }

    @Override
    public int calcularTiempoEntrega() {
        return 15 + (2 * getDistanciaKm());
    }
}
