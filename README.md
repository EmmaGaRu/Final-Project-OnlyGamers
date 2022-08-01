![Logo](https://github.com/EmmaGaRu/Only-Gamers/blob/main/ONLYGAMERS-02%20(1).png)

# ¡Bienvenido a Only Gamers!

Only Gamers es una aplicación web que permite a los usuarios consultar las reseñas y puntuaciones de sus juegos favoritos y añadir sus propias valoraciones. Está construida sobre una base de microservicios desarrollada en java y se puede desplegar gracias al front desarrollado en angular.

Para compender mejor la base de este proyecto se pueden consultar los siguientes diagramas:

## Diagrama de casos de uso

![Diagrama de casos de uso](https://github.com/EmmaGaRu/Only-Gamers/blob/main/diagrama%20de%20casos%20de%20uso.jpg)

## Diagrama de clases

![Diagrama de clases](https://github.com/EmmaGaRu/Only-Gamers/blob/main/diagrama%20de%20clases.jpg)

## Instrucciones de uso

Para poner en marcha Only Gamers lo primero que hay que hacer es crear las siguientes bases de datos:

* user
* user_test
* onlygamers
* onlygamers_test

Tras esto se puede proceder a clonar el repositorio, abrir la carpeta "backend", cambiar "validate" por "update" en todos los application.properties (menos en los de las carpetas de los test y en el eureka-service) y a continuación a levantar todos los proyectos que contiene en el siguiente orden:
1. eureka-service
2. proxy-review y proxy-videogame (en cualquier orden)
3. edge-service

Una vez todos los microservicios estén levantados correctamente se puede abrir la carpeta frontend en Visual Studio y poner la web en marcha escribiendo en el terminal los siguienes comandos:

1. npm install
2. ng serve

Con esto ya podremos explorar todas las opciones que nos ofrece Only Gamers entrando en la siguiente URL: http://localhost:4200/

El funcionamiento de la web es totalmente intuitivo, ¡espero que la disfrutes!

## Próximamente

Por ahora las opciones que ofrece Only Gamers son limitadas, pero el back posee una serie de funciones que solo hay que implementar en el front como la distinción entre usuarios y administrador (quien puede añadir juegos a la web y eliminarlos) y la obtención de todo el catálogo de juegos.
Además, esta web está pensada para que los usuarios puedan ofertar sus juegos usados y que otros usuarios puedan contactarlos y realizar compra o intercambiarlos por otros juegos.

## Autoría

:purple_heart: Emma Gallardo Ruiz
