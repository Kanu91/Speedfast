# SpeedFast - Semana 4

Actividad de Desarrollo Orientado a Objetos II.

En esta semana se incorpora programación concurrente al sistema SpeedFast desarrollado anteriormente.

## Estructura del proyecto

El proyecto mantiene la organización por paquetes:

- `cl.duoc.speedfast.modelo`: clases relacionadas con los pedidos.
- `cl.duoc.speedfast.interfaces`: interfaces del sistema.
- `cl.duoc.speedfast.concurrencia`: clases relacionadas con la ejecución de hilos.
- `cl.duoc.speedfast.app`: clase principal del programa.

## Pedidos

Se mantienen los tres tipos de pedidos:

- `PedidoComida`
- `PedidoEncomienda`
- `PedidoExpress`

Todos heredan de la clase abstracta `Pedido`.

## Repartidor

La clase `Repartidor` implementa `Runnable`.

Cada repartidor tiene:

- Un nombre.
- Una lista de pedidos asignados.

El método `run()` recorre los pedidos asignados y simula cada entrega utilizando `Thread.sleep()` con tiempos aleatorios.

## Ejecución concurrente

En `Main` se crean tres repartidores:

- Sofía Morales
- Diego Fuentes
- Fernanda Ríos

Cada repartidor tiene dos pedidos asignados.

Los repartidores se ejecutan en paralelo mediante `ExecutorService` con un pool de tres hilos.

El programa espera la finalización de todos los repartidores antes de terminar.

## Manejo de excepciones

Se controla `InterruptedException` tanto durante la simulación de las entregas como durante la espera de finalización del `ExecutorService`.

## Casos utilizados

### Sofía Morales

- PedidoComida #401
- PedidoExpress #402

### Diego Fuentes

- PedidoEncomienda #403
- PedidoComida #404

### Fernanda Ríos

- PedidoExpress #405
- PedidoEncomienda #406

## Ejecución

Al ejecutar el programa, los tres repartidores procesan sus pedidos de manera concurrente.

El orden de los mensajes puede variar entre ejecuciones debido al trabajo simultáneo de los hilos.

El proyecto fue desarrollado en Java para su ejecución en IntelliJ IDEA.
