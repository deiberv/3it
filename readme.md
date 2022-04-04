# statisticsdemo 


## statisticsdemo (FrontEnd)

Este proyecto se generó con [Angular CLI](https://github.com/angular/angular-cli) versión 13.3.1.

## Development server

Una vez descargado el repositorio ejecute `npm install` para instalar las dependencias del proyecto y luego ejecute `ng serve` ambos en la raiz del directorio. Al terminar el proceso de compilación de los archivos diríjase a visitar en su navegador `http://localhost:4200/` esto le permitirá probar la aplicación en modo desarrollo sin necesidad de realizar procedimientos de entornos de producción. 

Ejecute `ng serve` para un servidor de desarrollo. Navegue a `http://localhost:4200/`. La aplicación se recargará automáticamente si cambia alguno de los archivos de origen.

## Compilar para producción

 Ejecute `ng build --prod` . Esto generará los archivos que podrá subir al server en el directorio  `dist/`.



# statisticsdemo (Backend)
Este proyecto ha sido generado usando spring, se requiere java 11 para su ejecucion.

## Development

Para la ejecucion del proyecto se debe ejecutar el siguiente comando 
./mvnw


## Building for production

### Packaging as jar

Para construir el jar final y optimizar la aplicación de demostración de estadísticas para producción, ejecute:

./mvnw -Pprod clean verify

Esto concatenará y minimizará los archivos CSS y JavaScript del cliente. También modificará `index.html` para que haga referencia a estos nuevos archivos.
Para asegurarse de que todo funcionó, ejecute:

java -jar target/surveys-0.0.1-SNAPSHOT.jar

Luego navegue a [http://localhost:8080](http://localhost:8080) en su navegador.


## Contacto

Deiber Velandria -  `deiberv@gmail.com`