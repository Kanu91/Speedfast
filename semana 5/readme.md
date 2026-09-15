# SpeedFast - Semana 5

Actividad de Desarrollo Orientado a Objetos II.

En esta semana se implementa programación concurrente con sincronización para controlar el acceso de varios repartidores a una zona de carga compartida.

## Estructura

El proyecto está organizado en los siguientes paquetes:

- `cl.duoc.speedfast.modelo`
- `cl.duoc.speedfast.concurrencia`
- `cl.duoc.speedfast.app`

## Modelo

La clase `Pedido` contiene:

- `id`
- `direccionEntrega`
- `estado`

El estado del pedido se controla mediante el enum `EstadoPedido`, que incluye:

- `PENDIENTE`
- `EN_REPARTO`
- `ENTREGADO`

## Zona de carga

La clase `ZonaDeCarga` funciona como recurso compartido entre los repartidores.

Los métodos `agregarPedido()` y `retirarPedido()` utilizan `synchronized` para evitar que dos repartidores retiren el mismo pedido.

## Repartidor

La clase `Repartidor` implementa `Runnable`.

Cada repartidor comparte la misma instancia de `ZonaDeCarga`.

Durante la ejecución:

1. Retira un pedido.
2. Cambia su estado a `EN_REPARTO`.
3. Simula la entrega utilizando `Thread.sleep()`.
4. Cambia el estado a `ENTREGADO`.

## Ejecución

En la clase `Main` se agregan seis pedidos y se crean tres repartidores:

- Tomás Vega
- Paula Contreras
- Matías Soto

Los repartidores se ejecutan en paralelo mediante `ExecutorService`.

El programa espera que todos los hilos finalicen antes de mostrar:

`Todos los pedidos han sido entregados correctamente`

## Concurrencia

El retiro de pedidos se realiza de forma sincronizada para evitar retiros duplicados y mantener la integridad de los datos.

También se controla `InterruptedException` durante la ejecución de los hilos.

## Entorno

Proyecto desarrollado en Java para su ejecución en IntelliJ IDEA.
