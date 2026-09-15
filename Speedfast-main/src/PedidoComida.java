public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String direccionEntrega, int distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        return 15 + (2 * getDistanciaKm());
    }
}
