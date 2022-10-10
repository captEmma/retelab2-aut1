package hu.bme.aut.retelab2.repository;

import hu.bme.aut.retelab2.domain.Ad;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AdRepository {

    @PersistenceContext
    private EntityManager eManager;

    @Transactional
    public Ad save(Ad ad){
        return eManager.merge(ad);
    }

    public List<Ad> searchMinMax(int min, int max){
        return eManager.createQuery("SELECT x FROM Ad WHERE x.price BETWEEN ?1 AND ?2", Ad.class).setParameter(1, min).setParameter(2, max).getResultList();
    }

}
