#Tarea 2

##### 

### Implementación
#### Paquetes, clases y otros

##### Actualmente esta tarea cuenta con 5 paquetes principales y 3 paquetes, donde estan implementadas las siguientes cosas:
##### 1. Cards: En este paquete se encuentran todas las entidades que permiten crear las cartas del juego, tales como la clase Abstracta Abstract Card, las interfaces ICard, IEnergy y IPokemon y la clase Pokemon. Junto a estas se encuentran otros paquetes que contienen las clases necesarias para simular las Energies, Phases y TrainerCard.
##### 2. Controller:
##### 3. Other:
##### 4. Players
##### 5. Types
##### 6. Visitors: Contiene las interfaces Visitor y Visitable necesarias para poder implementar el patrón de diseño Visitor.

### Patrones de diseño utilizados
#### Para esta entrega se utilizaron los patrones de diseño Observer, Visitor y Double Dispatch.
##### El primero se utilizó para poder crear el controlador del juego de manera tal que fuese notificado cada vez que se hiciera una modificacion significativa y de esta manera el pudiera intervenir en el estado del juego.
##### El segundo se utilizó para poder desligar responsabilidades, de manera tal que los objetos pudieran ser visitados, manteniendo su estructura pero utilizando la informacion que estos contenian. Asi mismo se crearon visitadores que visitaran los objetos de interes, para que posteriormente se pudieran implementar las funcionalidades opcionales.
##### El tercero es una herencia de la tarea 1, ya que se utilizó para desambiguar la interaccion entre los ataques de los pokemon (Que en esta tarea pasan a ser un tipo de habilidad) de manera tal que cada Pokemon sabe como enfrentarse a otro Pokemon en funcion del tipo. En esta tarea se utilizo este patron para desambiguar las fases del Pokemon de ina manera bastante similar a la señalada anteriormente.

### Como correr el programa 
#### Este programa en si no se puede correr.
##### Ya que se implementó hasta la funcionalidad para simular u turno, Asi que si se quiere correr desde un main se puede pero debe ser creado por uno mismo y todos los objetos que seran parte de este deben ser inicializados antes.

### Funcionalidades opcionales implementadas
#### Proximante en su tarea más cercana!
#### Hasta ahora no hay ninguna funcionalidad opcional implementada

### Testing
####Creados en JUnit 4!
##### Hasta ahora los test solo abarcan las clases asociadas a los tipos de los Pokemon, asi que si se quiere probar más que eso no se puede.

 