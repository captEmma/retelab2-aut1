package hu.bme.aut.retelab2.controller;


import hu.bme.aut.retelab2.domain.Ad;
import hu.bme.aut.retelab2.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/search")
    public List<Ad> getRequest(@RequestParam(required = false, defaultValue = "0") int min, @RequestParam(required = false, defaultValue = "10000000") int max){
        return adRepo.searchMinMax(min, max);
    }

}
