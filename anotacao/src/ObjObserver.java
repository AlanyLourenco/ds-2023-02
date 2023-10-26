
@Observer(observado = "objeto")
public class ObjObserver {
    public void onCarEvent(String event) {
        System.out.println("Objeto Observer: " + event);
    }
}


