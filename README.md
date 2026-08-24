 SpeedFast

 Desarrollo Orientado a Objetos II

Actividad correspondiente a la Semana 1, enfocada en la aplicación de polimorfismo mediante sobreescritura y sobrecarga de métodos en Java.

 Descripción

El proyecto representa un sistema de asignación de repartidores para la empresa SpeedFast, considerando tres tipos de pedidos:

* Pedido de comida.
* Pedido de encomienda.
* Pedido express.

Cada tipo de pedido implementa un comportamiento diferente para la asignación del repartidor.

 Estructura del proyecto


src/
├── Pedido.java
├── PedidoComida.java
├── PedidoEncomienda.java
├── PedidoExpress.java
└── Main.java


 Conceptos aplicados

* Herencia.
* Encapsulamiento.
* Polimorfismo.
* Sobreescritura de métodos.
* Sobrecarga de métodos.
* Constructores.
* Clases derivadas.

## Ejecución

La clase `Main` crea un objeto de cada tipo de pedido y ejecuta las versiones sobrescritas y sobrecargadas del método `asignarRepartidor()`.

El proyecto fue desarrollado en Java para su ejecución en IntelliJ IDEA.
