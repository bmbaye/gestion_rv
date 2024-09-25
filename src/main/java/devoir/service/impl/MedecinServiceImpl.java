package devoir.service.impl;

import java.util.List;

import devoir.datas.entities.Medecin;
import devoir.datas.repository.MedecinRepository;
import devoir.service.MedecinService;
import devoir.service.ServiceImpl;

public class MedecinServiceImpl extends ServiceImpl<Medecin> implements MedecinService{
    protected MedecinRepository medecinRepository;

    public MedecinServiceImpl(MedecinRepository medecinRepository){
        this.medecinRepository = medecinRepository;
    }
    @Override
    public List<Medecin> lister() {
       return this.medecinRepository.selectAll();
    }

    @Override
    public boolean create(Medecin object) {
        return this.medecinRepository.insert(object);
    }
    
}
