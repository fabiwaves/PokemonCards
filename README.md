#Tarea 2

##### 

### Implementación
#### Paquetes, clases y otros



### Supuestos implementados
#### Muy importante tener en cuenta!
##### Para esta tarea se asumieron las siguientes cosas:
##### 1. El pokemon activo siempre seria el primero del team, es decir, el que se encuentra en la posición 0 del team.
##### 2. Se buscaría simular los turnos, no implementar una partida de principio a fin.
##### 3. Los ataques ahora son una habilidad que contiene un efecto de daño extra.
##### 4. Los pokemon tienen tanto un tipo y una fase que necesitan ser inicializadas para que funcionen.
##### 5. El usuario no puede interactuar de manera directa en base a inputs con sus pokemon, asi que por convención se dejo que siempre se seleccionará la habilidad en el indice 0. 
##### 6. Para las evoluciones se asume que el Id de la pre-evolucion siempre va a ser el id1, vale decir si tengo la un Charmeleon su id1 va a corresponder a la id de Charmander y si tengo un Charizard su id1 va a corresponder a la id del Charmeleon.
##### 7. Para las implementaciones opcionales que requerian lanzar una moneda, se asumió que todos los numeros pares representarían un resultado cara y los impares un resultado sello.
##### 8. Además para las implementaciones opcionales, se asumió que donde dijiera x de algo, este valor representaria 10. 

### Patrones de diseño utilizados
#### Para esta entrega se utilizaron los patrones de diseño Observer, Visitor y Double Dispatch.
##### El primero se utilizó para poder crear el controlador del juego de manera tal que fuese notificado cada vez que se hiciera una modificacion significativa y de esta manera el pudiera intervenir en el estado del juego.
##### El segundo se utilizó para poder desligar responsabilidades, de manera tal que los objetos pudieran ser visitados, manteniendo su estructura pero utilizando la informacion que estos contenian. Asi mismo se crearon visitadores que visitaran los objetos de interes, para que posteriormente se pudieran implementar las funcionalidades opcionales.
##### El tercero es una herencia de la tarea 1, ya que se utilizó para desambiguar la interaccion entre los ataques de los pokemon (Que en esta tarea pasan a ser un tipo de habilidad) de manera tal que cada Pokemon sabe como enfrentarse a otro Pokemon en funcion del tipo. En esta tarea se utilizo este patron para desambiguar las fases del Pokemon de ina manera bastante similar a la señalada anteriormente.

### Como correr el programa 
#### Este programa en si no se puede correr.
##### Ya que se implementó hasta la funcionalidad para simular u turno, Asi que si se quiere correr desde un main se puede pero debe ser creado por uno mismo y todos los objetos que seran parte de este deben ser inicializados antes.

### Funcionalidades opcionales implementadas
#### Se implementó una funcionalidad por cada categoria de habilidad como efectos.

##### 1. Habilidad Pokemon: Energy Burn.
##### 2. Ataque: Electric Shock.
##### 3. Objetos: Potion.
##### 4. Estadio: Lucky Stadium
##### 5. Soporte: Professor Juniper.

### Testing
#### Creados en JUnit 4!
##### Hasta ahora los test solo abarcan las clases asociadas a los tipos de los Pokemon, asi que si se quiere probar más que eso no se puede.

 