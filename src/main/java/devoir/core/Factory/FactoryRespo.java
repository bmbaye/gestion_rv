package devoir.core.Factory;

import devoir.datas.repository.MedecinRepository;
import devoir.datas.repository.RvRepository;
import devoir.datas.repository.impl.MedecinRepositoryimpl;
import devoir.datas.repository.impl.RvRepositoryImpl;

public class FactoryRespo {
    private static MedecinRepository medecinRepository= null;
    private static RvRepository rvRepository = null;

    public static MedecinRepository getMedRepositoryInstance(){
        if(medecinRepository == null){
            medecinRepository = new MedecinRepositoryimpl();
        }
        return medecinRepository;
    }

    public static RvRepository getRvRepositoryInstance(){
        if(rvRepository == null){
            rvRepository = new RvRepositoryImpl();
        }
        return rvRepository;
    }
}
