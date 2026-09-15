package cl.duoc.speedfast.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Pedido {

    private String idPedido;
    private String direccionEntrega;
    private int distanciaKm;
    private String repartidorAsignado;
    private String estado;
    private final List<String> historial;

    public Pedido(String idPedido, String direccionEntrega, int distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.estado = "Pendiente";
        this.historial = new ArrayList<>();
        this.historial.add("Pedido creado");
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public int getDistanciaKm() {
        return distanciaKm;
    }

    public String getRepartidorAsignado() {
        return repartidorAsignado;
    }

    public String getEstado() {
        return estado;
    }

    protected void setRepartidorAsignado(String repartidorAsignado) {
        this.repartidorAsignado = repartidorAsignado;
    }

    protected void registrarHistorial(String evento) {
        historial.add(evento);
    }

    public void mostrarResumen() {
        System.out.println(getClass().getSimpleName() + " #" + idPedido);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Estado: " + estado);

        if (repartidorAsignado != null) {
            System.out.println("Repartidor: " + repartidorAsignado);
        }
    }

    public void asignarRepartidor() {
        setRepartidorAsignado("Asignación automática");
        registrarHistorial("Repartidor asignado automáticamente");
    }

    public void asignarRepartidor(String nombre) {
        setRepartidorAsignado(nombre);
        registrarHistorial("Repartidor asignado: " + nombre);
    }

    public void reservar() {
        estado = "Reservado";
        registrarHistorial("Pedido reservado");
        System.out.println("Pedido #" + idPedido + " reservado.");
    }

    public void despachar() {
        estado = "Despachado";
        registrarHistorial("Pedido despachado");
        System.out.println("Pedido #" + idPedido + " despachado.");
    }

    public void cancelar() {
        estado = "Cancelado";
        registrarHistorial("Pedido cancelado");
        System.out.println("Pedido #" + idPedido + " cancelado.");
    }

    public void verHistorial() {
        System.out.println("Historial Pedido #" + idPedido);

        for (String evento : historial) {
            System.out.println("- " + evento);
        }
    }

    public abstract int calcularTiempoEntrega();
}
