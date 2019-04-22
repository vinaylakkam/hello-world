package hello.world.beans;

import javax.inject.Singleton;

@Singleton
public class V6Engine implements Engine {
    public String start() {
        return "Starting V6";
    }

    public int getCylinders() {
        return 6;
    }
}