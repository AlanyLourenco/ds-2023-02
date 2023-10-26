
public class Main {
    public static void main(String[] args) {
        Observable<String> carroObservable = new Observable<>("carro");
        ObjObserver carObserver = new ObjObserver();
        AnotherObjObserver anotherCarObserver = new AnotherObjObserver();

        carroObservable.addObserver(carObserver::onCarEvent);
        carroObservable.addObserver(anotherCarObserver::onCarEvent);

        carroObservable.notifyObservers("Evento no objeto!");
    }
}
