# SpeedFast - Desarrollo Orientado a Objetos II

Proyecto desarrollado en Java para las actividades de las semanas 1 y 2 de Desarrollo Orientado a Objetos II.

## Semana 1

En la primera semana se trabajó con una clase base `Pedido` y tres tipos de pedidos:

* `PedidoComida`
* `PedidoEncomienda`
* `PedidoExpress`

Se utilizaron los métodos `asignarRepartidor()` y `asignarRepartidor(String nombreRepartidor)` para trabajar con sobreescritura y sobrecarga.

Cada pedido tiene una forma distinta de asignar al repartidor:

* Comida: requiere mochila térmica.
* Encomienda: considera peso y embalaje.
* Express: considera al repartidor más cercano disponible.

## Semana 2

En la segunda semana se modificó la clase `Pedido` y se definió como abstracta.

Contiene los atributos:

* `idPedido`
* `direccionEntrega`
* `distanciaKm`

También contiene los métodos:

* `mostrarResumen()`
* `calcularTiempoEntrega()`

El método `calcularTiempoEntrega()` se implementa de manera distinta en cada tipo de pedido.

### PedidoComida

El tiempo de entrega corresponde a 15 minutos más 2 minutos por cada kilómetro.

### PedidoEncomienda

El tiempo de entrega corresponde a 20 minutos más 1.5 minutos por cada kilómetro.

### PedidoExpress

El tiempo base es de 10 minutos. Si la distancia supera los 5 kilómetros se agregan 5 minutos.

## Casos utilizados

### PedidoComida

* ID: 101
* Dirección: Av. Macul 2450
* Distancia: 6 km
* Tiempo estimado: 27 minutos

### PedidoEncomienda

* ID: 102
* Dirección: Av. Grecia 1780
* Distancia: 10 km
* Tiempo estimado: 35 minutos

### PedidoExpress

* ID: 103
* Dirección: Av. Tobalaba 3200
* Distancia: 8 km
* Tiempo estimado: 15 minutos

## Estructura

```text
src/
├── Main.java
├── Pedido.java
├── PedidoComida.java
├── PedidoEncomienda.java
└── PedidoExpress.java
```

## Ejecución

La clase `Main` crea un pedido de cada tipo y muestra su información junto con el tiempo estimado de entrega.

El proyecto fue desarrollado en Java utilizando IntelliJ IDEA.
