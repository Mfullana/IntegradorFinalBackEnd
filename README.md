# Proyecto Clínica Odontológica: Proyecto Integrador BackEnd I

El proyecto consiste en una API REST de una clínica odontológica. 
- Administrrar datos de odontólgos y pacientes.
- Validar el ingreso al sistema mediante un login con usuario y password. 
- Asignar a un paciente un turno con un respectivo odontólogo a una determinada fecha y horario.
- Mostrar una grilla de turnos de la semana próxima. 

## Requerimientos
1) Java 11
2) Maven

## Instalación 
Para la instalación de Java y Maven se recomienda la siguiente documentación:
- [Instalacion Java 11](https://www.oracle.com/java/technologies/downloads/#java11) 
- [Instalacion Maven](https://maven.apache.org/download.cgi).

## Primer uso
1) Clonar este repositorio. Para esto, correr el siguiente comando en la teminal de tu computadora:
```

```
2) Deberías tener esta estructura de carpetas
```

```
3) Para correr el proyecto deben ejecutarse los siguientes comandos en la terminal (posicionándose en la carpeta del proyecto): 
```

```
4) Luego de correr el comando `mvn clean package` la estructura de carpetas debería ser:
```

```
5) Ahora, mediante los siguientes comandos debería ya estar corriendosé el proyecto en el puerto configurado por defecto (el puerto 8080): 
```

```
6) Si se quisiera modificar el puerto debería cambiarse la propiedad server.port=8080 por el puerto deseado. Esto debe hacerse en `/src/resources/application.properties`

## Iniciar sesión:

Una vez que el proyecto esta corriendo, dirigirse a la url [http://localhost:8080/login](http://localhost:8080/login) y logearse con el siguiente usuario y contraseña (el mismo tiene acceso de ADMIN, por lo que podrá acceder a todas las funcionalidades del sistema):
- Usuario --> marcelo@digital.com
- Contraseña --> marcelo

## Documentación 

Luego de haberse logueado, se puede accederse a la url [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) y ver la documentación del proyecto.

