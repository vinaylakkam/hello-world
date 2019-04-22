package hello.world;

import hello.world.beans.Vehicle;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloController {

    private Vehicle vehicle;

    public HelloController(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        return "Hello World .. " + vehicle.start();
    }
}