package devoir.datas.repository;

import devoir.core.repository.Repository;
import devoir.datas.entities.Medecin;

public interface MedecinRepository extends Repository<Medecin>{
    Medecin getById(int id);
}
