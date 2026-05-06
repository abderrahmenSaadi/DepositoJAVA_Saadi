public class LightFacade {

    private LightManager manager = new LightManager();



    public void turnOnLight() {
        manager.turnOnAll();
    }
}