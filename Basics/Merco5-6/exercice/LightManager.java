public class LightManager {

    private Light cameraLight;
    private Light kitchenLight;

    public LightManager() {
        cameraLight = new CameraLight();
        kitchenLight = new KitchenLight();
    }

    public void turnOnAll() {
        cameraLight.turnOn();
        kitchenLight.turnOn();
    }
}