package hello.world;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HelloControllerSpec {
    private static EmbeddedServer server;
    private static HttpClient client;

    @BeforeClass
    public static void setupServer() {

        server = ApplicationContext.run(EmbeddedServer.class);

        client = server
                .getApplicationContext()
                .createBean(HttpClient.class, server.getURL());
    }

    @AfterClass
    public static void stopServer() {
        if (client != null) {
            client.stop();
        }
        if (server != null) {
            server.stop();
        }
    }

    @Test
    public void testHelloWorldResponse() {
        String response = client.toBlocking()
                .retrieve(HttpRequest.GET("/hello"));
        assertEquals("Hello World", response); //)
    }
}