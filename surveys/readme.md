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


