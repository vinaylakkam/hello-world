package hello.world;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloClientSpec  {

    private static EmbeddedServer server;

    private static HelloClient client;

    @BeforeClass
    public static void setupServer() {

        server = ApplicationContext.run(EmbeddedServer.class);

        client = server
                .getApplicationContext()
                .getBean(HelloClient.class);
    }

    @AfterClass
    public static void stopServer() {
        if (server != null) {
            server.stop();
        }
    }

    @Test
    public void testHelloWorldResponse(){
        assertEquals("Hello World .. Starting V6", client.hello().blockingGet());
    }
}
