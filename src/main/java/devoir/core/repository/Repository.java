package devoir.core.repository;

import java.util.List;

public interface Repository<T> {
    List<T> selectAll();
    boolean insert(T object);
}
