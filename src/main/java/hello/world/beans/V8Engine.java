package hello.world.beans;

import javax.inject.Singleton;

@Singleton
public class V8Engine implements Engine {
    public String start() {
        return "Starting V8";
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    private int cylinders = 8;
}
