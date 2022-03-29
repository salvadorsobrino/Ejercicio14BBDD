Ejercicio de hace la entidad coches para trabajar con ella en BBDD:

Los coches tendrán las siguientes atributos
id
matricula;
marca;
modelo;
kilometros;

Se mostrará un menu con las siguientes opciones:

1. Alta de coche
2. Eliminar coche por id
3. Modificar coche por id
4. buscar coche por id
5. buscar coche por matricula
6. buscar coches por marca
7. buscar coches por modelo
8. listar todos los coches
9. Salir de la aplicación

Tendremos las siguientes reglas de negocio

La matricula tendrá una longitud de 7
No puede haber dos matriculas repetidas
Los kilometros no podrán ser negativos

Hacerlo mediante el modelo de las 3 capas que hemos visto en clase

APUNTES:

Para añadir el jar a nuestro proyecto debemos de:

Pulsar boton derecho sobre el proyecto.

Build Path -> Configure Build Path

En la pestaña "libraries" pulsar el boton "Add Jar"

Buscar la carpeta lib de nuestro proyecto y elegir el fichero "mysql-connector-java-8.0.22.jar"

CREATE TABLE coches(id INT NOT NULL AUTO_INCREMENT, matricula varchar(7) DEFAULT NULL, marca varchar(20) DEFAULT NULL,modelo varchar(20) DEFAULT NULL, km int DEFAULT NULL, PRIMARY KEY (id));

IMPORTANTE: 

No esta implementado pero al ser la matricula única, debería ser Primary Key. Controlaremos esto a través de las reglas de NEGOCIO.
Tratamiento de nulls en el main