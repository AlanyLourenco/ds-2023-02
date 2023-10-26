import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Observable<T> {
    private List<Consumer<T>> observers = new ArrayList<>();
    private String observado;

    public Observable(String observado) {
        this.observado = observado;
    }

    public void addObserver(Consumer<T> observer) {
        if (observer.getClass().isAnnotationPresent(Observer.class)) {
            Observer annotation = observer.getClass().getAnnotation(Observer.class);
            if (annotation.observado().equals(this.observado)) {
                observers.add(observer);
            }
        }
    }

    public void notifyObservers(T event) {
        observers.forEach(observer -> observer.accept(event));
    }
}
