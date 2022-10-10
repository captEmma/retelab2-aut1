package hu.bme.aut.retelab2.repository;

import hu.bme.aut.retelab2.domain.Ad;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class AdRepository {

    @PersistenceContext
    private EntityManager eManager;

    @Transactional
    public Ad save(Ad ad){
        return eManager.merge(ad);
    }

}
