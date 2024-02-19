package api.reto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.apache.http.client.utils.URIBuilder;


public class executeEndPoint {

    private static HttpResponse<String> response;

    public static void execute(URIBuilder uri, Integer codeStatus) throws URISyntaxException, IOException, InterruptedException {
         
        HttpClient clientHttp = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

         HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(uri.build())
            .build();

            response = clientHttp.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response " + response.body());

            assertEquals(codeStatus, response.statusCode());
    }

    public static String resultResponse() {
        return response.body();
    }

}
