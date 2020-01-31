package com.transport.service;

import com.transport.instance.SectorInstance;
import java.util.List;


public interface SectorService {

    List<SectorInstance> getSectors();

    List<SectorInstance> getSectorsByWay(int wayId);

    SectorInstance getSectorByID(int id);

    void addSector(SectorInstance s);

    void updateSector(SectorInstance s);

    void deleteSector(SectorInstance s);
}
