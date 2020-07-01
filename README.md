# Tarea 2

##### 

### Implementación
#### Paquetes, clases y otros
##### Este proyecto cuenta con 11 paquetes para poder ordenar de mejor manera las clases e interfaces comunes.

##### 1: Paquete Visitor: Este cuenta con las interfaces IVisitable y IVisitor que permiten modelar que un objeto sea visitado y/o visitante.
##### 2. Paquete Types: Contiene la clase AbstractType que permite modelar lo basico de una entidad Type y las clases [Type] que modelan las interacciones en cuanto a ataques de los tipos.
##### 3. Paquete Player: Contiene la interface Player que permite modelar lo básico que debe tener cualquier jugador en el juego. La clase Trainer modela en este caso, la instancia de un Entrenador y sus atributos.
##### 4. Paquete Controller: Este paquete solo contiene una clase Game, que describe el controlador del juego, que en esta entrega es  el encargado de controlar el juego, ya que es  quien se encarga de manejar los turnos entre los jugadores, checkear condiciones y ver si una jugada es válida o no dependiendo del caso. Esta clase extiende la interfaz ya hecha de Java, 'Observer' de manera tal que los objetos notifican cuando un cambio ha sucedido.
##### 5. Paquete Cards: Este paquete contiene otros 3 paquetes más ademas de las interfaces ICard, IEnergy y Ipokemon que modelan lo básico que una Carta, Energia y Pokemon deben tener respectivamente, la clase AbstractCard que permite dar forma a la abstraccion en cuanto atributos de una carta y la clase Pokemon que es la encargada de generar el Pokemon y sus metodos necesarios.  
##### 5.1 Paquete TrainerCards: Contiene la interfaz ITrainerCard una nueva entidad para esta entrega, que permite modelar lo básico que toda carta de entrenador necesita tener. Además de esta interfaz, se encuentra la clase Abstracta asociada junto a las clases PKMObject, Stadium y Support que son las nuevas entidades presentes en el juego que generan un efecto a nivel juego-pokemon-entrenador según el caso.
##### 5.2 Paquete Phases: Este paquete contiene todo lo necesario para inicializar las fases de un pokemon, ya que contiene la Intefaa IPhase y la clase AbstractPhase que permiten englobar todo lo que una fase contiene, de manera tal que las clases Basic, Phase1 y Phase 2 que estan modeladas como una clase, puedan ser inicializadas y utilizadas de manera correcta por un pokemon.
##### 5.3 Paquete Energies: Contiene todo lo necesario para generar las energias del juego de manera tal que las energias saben por double dispatch agregarse solas al pokemon asociado.
##### 6. Abilities: Contiene dos paquetes más; El paquete Abilities que contiene la interfaz IAbility que permite modelar lo basico que toda habilidad en el juego debe tener. La clase abstracta AbstractAbility que permite agregarle a la interfaz descrita anteriormente los atributos correspondientes a una habilidad. Por ultimo este paquete contiene las clases Attack que permite describir un ataque (Que a diferencia de la entrega anterior ahora es una habilidad que hace daño) y la clase PokemonAbility que permite describir una habilidad asociadad a un pokemon. 
 

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
##### El paquete test contiene los tests para todas las clases menos Professor Juniper.

 
