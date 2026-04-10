public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5.0;
    private String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan() { }

    public String toString() {
        if (isOn()) {
            return ("Speed: " + speed + ", " + "Color: "
                    + color + ", " + "Radius: " + radius);
        } else {
            return ("Fan is off, " + "Color: " + color + ", " + "Radius: " + radius);
        }
    }

    public static void main(String[] args) {
        Fan f1 = new Fan();
        Fan f2 = new Fan();

        f1.setSpeed(FAST);
        f1.setRadius(10);
        f1.setColor("yellow");
        f1.setOn(true);

        f2.setSpeed(MEDIUM);

        System.out.println(f1);
        System.out.println(f2);
    }
}
