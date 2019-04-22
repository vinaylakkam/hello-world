package hello.world.beans;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class Vehicle {
    private final Engine engine;

    public Vehicle(@Named("v6") Engine engine) {
        this.engine = engine;
    }

    public String start() {
        return engine.start();
    }
}