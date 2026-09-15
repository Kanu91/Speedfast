package cl.duoc.speedfast.modelo;

import cl.duoc.speedfast.interfaces.Cancelable;
import cl.duoc.speedfast.interfaces.Despachable;
import cl.duoc.speedfast.interfaces.Rastreable;

public class PedidoEncomienda extends Pedido
        implements Despachable, Cancelable, Rastreable {

    public PedidoEncomienda(String idPedido, String direccionEntrega, int distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public void asignarRepartidor() {
        setRepartidorAsignado("Martín Salazar");
        registrarHistorial("Repartidor automático asignado: Martín Salazar");
        System.out.println("Peso y embalaje validados.");
        System.out.println("Repartidor asignado: Martín Salazar");
    }

    @Override
    public void asignarRepartidor(String nombre) {
        setRepartidorAsignado(nombre);
        registrarHistorial("Repartidor asignado manualmente: " + nombre);
        System.out.println("Peso y embalaje validados.");
        System.out.println("Repartidor asignado: " + nombre);
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(20 + (1.5 * getDistanciaKm()));
    }
}
