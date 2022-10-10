package hu.bme.aut.retelab2.repository;

import hu.bme.aut.retelab2.SecretGenerator;
import hu.bme.aut.retelab2.domain.Ad;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AdRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Ad save(Ad ad){
        ad.setSecretCode(SecretGenerator.generate());
        return em.merge(ad);
    }

   public List<Ad> searchMinMax(int min, int max){
        List<Ad> ads = em.createQuery("SELECT x FROM Ad x WHERE x.price BETWEEN ?1 AND ?2", Ad.class).setParameter(1, min).setParameter(2, max).getResultList();
        for(Ad ad : ads){
            ad.setSecretCode(null);
        }
        return ads;
    }

    @Transactional
    public Ad authorizedUpdate(Ad ad){
        Ad current = em.find(Ad.class, ad.getId());
        if(!ad.getSecretCode().equals(current.getSecretCode()))
            return null;
        save(ad);
        return ad;
    }

    public List<Ad> searchTag(String tag){
        List<Ad> ads = em.createQuery("SELECT x FROM Ad x WHERE ?1 MEMBER x.tags", Ad.class).setParameter(1, tag).getResultList();
        for(Ad ad : ads){
            ad.setSecretCode(null);
        }
        return ads;
    }

    @Scheduled(fixedDelay= 6000)
    @Transactional
    public void deleteExpired(){
        List<Ad> ads = em.createQuery("SELECT x FROM Ad x WHERE x.expiration < ?1", Ad.class).setParameter(1, LocalDateTime.now()).getResultList();
        for(Ad ad : ads){
            em.remove(ad);
        }
    }



}
