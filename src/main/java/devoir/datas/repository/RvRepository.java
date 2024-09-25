package devoir.datas.repository;

import java.sql.Date;
import java.util.List;

import devoir.core.repository.Repository;
import devoir.datas.entities.Rv;

public interface RvRepository extends Repository<Rv>{
    List<Rv> getByDate(Date date);
}
