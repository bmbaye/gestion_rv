package devoir.service;

import java.util.List;

public interface Service<T> {
    List<T> lister();
    boolean create(T object);
}
