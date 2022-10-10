package hu.bme.aut.retelab2.controller;


import hu.bme.aut.retelab2.domain.Ad;
import hu.bme.aut.retelab2.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public List<Ad> getRequest(@RequestParam(required = false, defaultValue = "0") int min, @RequestParam(required = false, defaultValue = "10000000") int max){
        return adRepo.searchMinMax(min, max);
    }

    @PutMapping
    public ResponseEntity<Ad> update(@RequestBody Ad ad){
        ad = adRepo.authorizedUpdate(ad);
        if(ad==null)
            return ResponseEntity.status(403).build();
        else
            return ResponseEntity.ok(ad);
    }

    @GetMapping("/{tag}")
    public List<Ad> searchTag(@PathVariable String tag){
        return adRepo.searchTag(tag);
    }

}
