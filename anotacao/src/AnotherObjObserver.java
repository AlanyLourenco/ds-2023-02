@Observer(observado = "objeto")
public class AnotherObjObserver {
    public void onCarEvent(String event) {
        System.out.println("Outro Objeto Observer: " + event);
    }
}