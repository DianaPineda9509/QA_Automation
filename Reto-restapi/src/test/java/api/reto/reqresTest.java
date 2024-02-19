package api.reto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpStatus;
import org.apache.http.client.utils.URIBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class reqresTest {
    
    String returnResponse;
    Integer codeStatus;

    @BeforeEach
    public void setup(){
        System.out.println("Inicio de la configuracion de la pruebas REST API.");
    }

    //Consultar los usuarios de la pagina 2
    @Test
    public void userPageDos() throws URISyntaxException, IOException, InterruptedException{

        URIBuilder uri = new URIBuilder()
            .setScheme("https")
            .setHost("reqres.in")
            .setPath("api/users")
            .addParameter("page", "2");

        System.out.println("EndPoint " + uri.build());
        codeStatus = HttpStatus.SC_OK;
        executeEndPoint.execute(uri,codeStatus);
        returnResponse = executeEndPoint.resultResponse();
        assertTrue(returnResponse.contains("\"total_pages\":2"));
        validatorShemas.validationSchemas(returnResponse, "ReqresPageDosSchemas.json");
    }

    //Consultar los datos del usuario 12
    @Test
    public void userDataDoce() throws URISyntaxException, IOException, InterruptedException{

        URIBuilder uri = new URIBuilder()
            .setScheme("https")
            .setHost("reqres.in")
            .setPath("api/users")
            .addParameter("id", "12");

        System.out.println("EndPoint " + uri.build());
        codeStatus = HttpStatus.SC_OK;
        executeEndPoint.execute(uri,codeStatus);
        returnResponse = executeEndPoint.resultResponse();

        assertTrue(returnResponse.contains("\"first_name\":\"Rachel\""));
        validatorShemas.validationSchemas(returnResponse, "ReqresDataDoceSchemas.json");

    }

    //Consultar los datos de un usuario inexistente
    @Test
    public void userDataNotFound() throws URISyntaxException, IOException, InterruptedException{

        URIBuilder uri = new URIBuilder()
            .setScheme("https")
            .setHost("reqres.in")
            .setPath("api/users")
            .addParameter("id", "23");

         System.out.println("EndPoint " + uri.build());
         codeStatus = HttpStatus.SC_NOT_FOUND;
         executeEndPoint.execute(uri,codeStatus);
         returnResponse = executeEndPoint.resultResponse();

    }

     //Consultar endPoint unknown
     @Test
     public void endPointUnknown() throws URISyntaxException, IOException, InterruptedException{
 
         URIBuilder uri = new URIBuilder()
             .setScheme("https")
             .setHost("reqres.in")
             .setPath("api/unknown");
 
         System.out.println("EndPoint " + uri.build());
         codeStatus = HttpStatus.SC_OK;
         executeEndPoint.execute(uri,codeStatus);
         returnResponse = executeEndPoint.resultResponse();

         assertTrue(returnResponse.contains("\"page\":1"));
         validatorShemas.validationSchemas(returnResponse, "ReqresUnknownSchemas.json");

     }
 
     //Consumir servicio delayed response
     @Test
     public void endPointDelayed() throws URISyntaxException, IOException, InterruptedException{
 
         URIBuilder uri = new URIBuilder()
             .setScheme("https")
             .setHost("reqres.in")
             .setPath("api/users")
             .addParameter("delay", "3");
 
         System.out.println("EndPoint " + uri.build());
         codeStatus = HttpStatus.SC_OK;
         executeEndPoint.execute(uri,codeStatus);
         returnResponse = executeEndPoint.resultResponse();
         
         assertTrue(returnResponse.contains("\"page\":1"));
         validatorShemas.validationSchemas(returnResponse, "ReqresDelayedSchemas.json");
 
     }


}
