package cl.duoc.speedfast.modelo;

import cl.duoc.speedfast.interfaces.Cancelable;
import cl.duoc.speedfast.interfaces.Despachable;
import cl.duoc.speedfast.interfaces.Rastreable;

public class PedidoExpress extends Pedido
        implements Despachable, Cancelable, Rastreable {

    public PedidoExpress(String idPedido, String direccionEntrega, int distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public void asignarRepartidor() {
        setRepartidorAsignado("Valentina Castro");
        registrarHistorial("Repartidor automático asignado: Valentina Castro");
        System.out.println("Repartidor más cercano disponible: Valentina Castro");
    }

    @Override
    public void asignarRepartidor(String nombre) {
        setRepartidorAsignado(nombre);
        registrarHistorial("Repartidor asignado manualmente: " + nombre);
        System.out.println("Repartidor asignado manualmente: " + nombre);
    }

    @Override
    public int calcularTiempoEntrega() {
        int tiempo = 10;

        if (getDistanciaKm() > 5) {
            tiempo += 5;
        }

        return tiempo;
    }
}
