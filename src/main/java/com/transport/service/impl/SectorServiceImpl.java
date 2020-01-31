package com.transport.service.impl;

import com.transport.dao.SectorDAO;
import com.transport.instance.SectorInstance;
import com.transport.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service("sectorService")
public class SectorServiceImpl implements SectorService {


    private SectorDAO sdao;

    @Autowired
    public void setSectorService(SectorDAO sdao) {
        this.sdao = sdao;
    }

    public List<SectorInstance> getSectors() {
        return sdao.getSectors();
    }

    public List<SectorInstance> getSectorsByWay(int wayId) { return sdao.getSectorsByWay(wayId); }

    public SectorInstance getSectorByID (int id) {
        return sdao.getSectorByID(id);
    }

    public void addSector(SectorInstance instance) {
        sdao.addSector(instance);
    }

    public void updateSector(SectorInstance instance) {
        sdao.updateSector(instance);
    }

    public void deleteSector(SectorInstance instance) {
        sdao.deleteSector(instance);
    }

}
