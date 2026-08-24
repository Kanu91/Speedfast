SpeedFast - Desarrollo Orientado a Objetos II

Proyecto desarrollado en Java para la empresa ficticia SpeedFast.

El repositorio contiene el desarrollo progresivo de las actividades correspondientes a las semanas 1 y 2.

Semana 1 - Polimorfismo, sobrecarga y sobreescritura

Durante la Semana 1 se desarrolló una jerarquía de clases para representar distintos tipos de pedidos.

Se implementaron:

- Clase base Pedido.
- PedidoComida.
- PedidoEncomienda.
- PedidoExpress.
- Sobreescritura del método asignarRepartidor().
- Sobrecarga del método asignarRepartidor(String nombreRepartidor).
- Clase Main para demostrar el funcionamiento del sistema.

Semana 2 - Clase abstracta y jerarquía

Durante la Semana 2 se modificó la estructura del proyecto utilizando una clase abstracta Pedido.

La clase Pedido contiene los atributos comunes:

- idPedido.
- direccionEntrega.
- distanciaKm.

Además, implementa el método mostrarResumen() y declara el método abstracto calcularTiempoEntrega().

Cada subclase implementa su propio cálculo de tiempo de entrega:

PedidoComida

Tiempo de entrega:

15 minutos base + 2 minutos por kilómetro.

PedidoEncomienda

Tiempo de entrega:

20 minutos base + 1.5 minutos por kilómetro.

PedidoExpress

Tiempo de entrega:

10 minutos base.

Si la distancia es mayor a 5 kilómetros, se agregan 5 minutos adicionales.

 Estructura del proyecto

src/

- Pedido.java
- PedidoComida.java
- PedidoEncomienda.java
- PedidoExpress.java
- Main.java
Ejemplo de resultados

PedidoComida: 4 km - 23 minutos.

PedidoEncomienda: 6 km - 29 minutos.

PedidoExpress: 7 km - 15 minutos.

## Entorno de desarrollo

Proyecto desarrollado en Java para su ejecución en IntelliJ IDEA.
