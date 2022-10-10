package hu.bme.aut.retelab2.controller;


import hu.bme.aut.retelab2.domain.Ad;
import hu.bme.aut.retelab2.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ads")
public class AdController {

    @Autowired
    AdRepository adRepo;

    @PostMapping
    public Ad create(@RequestBody Ad ad){
        ad.setId(null);
        return adRepo.save(ad);
    }

}
