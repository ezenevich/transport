package com.transport.dao.impl;

import com.transport.dao.SectorDAO;
import com.transport.instance.SectorInstance;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class SectorDAOImlp implements SectorDAO {

    private static final Logger logger = Logger.getLogger(SectorDAO.class);

    @Autowired
    private HibernateTemplate template;

    @Autowired
    private EntityManager entityManager;


    public List<SectorInstance> getSectors() {
        logger.info("Get all sectors from db");
        return template.loadAll(SectorInstance.class);
    }

    public List<SectorInstance> getSectorsByWay (int wayId) {
        logger.info("sectors with route id " + wayId + " was getted from db");
        List<SectorInstance> ways = (List<SectorInstance>) template.find("from SectorInstance a where a.wayId = ?", wayId);
        if ( ways.isEmpty() ) {
            return null;
        }
        return ways;
    }

    public SectorInstance getSectorByID(int id) {
        logger.info("sector with id " + id + " was getted from db");
        List<SectorInstance> r = (List<SectorInstance>) template.find("from SectorInstance a where a.id = ?", id);
        if ( r.isEmpty() ) {
            return null;
        }
        return (SectorInstance)r.get(0);
    }

    public void addSector(SectorInstance i) {
        template.save(i);
        logger.info("Add new sector with id " + i.getId());
    }

    public void updateSector(SectorInstance i) {
        template.update(i);
        logger.info("Update sector with id " + i.getId());
    }

    public void deleteSector(SectorInstance i){
        template.delete(i);
        logger.info("Delete sector with id " + i.getId());
    }


}
