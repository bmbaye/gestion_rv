package devoir.service.impl;

import java.util.List;

import devoir.datas.entities.Rv;
import devoir.datas.repository.RvRepository;
import devoir.service.RvService;
import devoir.service.ServiceImpl;

public class RvServiceImpl extends ServiceImpl<Rv> implements RvService{
    protected RvRepository rvRepository;
     
    public RvServiceImpl(RvRepository rvRepository){
        this.rvRepository = rvRepository;
    }
    @Override
    public List<Rv> lister() {
        return this.rvRepository.selectAll();
    }

    @Override
    public boolean create(Rv object) {
        return this.rvRepository.insert(object);
    }
}
