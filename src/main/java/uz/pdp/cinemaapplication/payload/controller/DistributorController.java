package uz.pdp.cinemaapplication.payload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.cinemaapplication.entity.Distributor;
import uz.pdp.cinemaapplication.payload.Result;
import uz.pdp.cinemaapplication.service.DistributorService;

import java.util.List;

@RestController
@RequestMapping("/api/distributor")
public class DistributorController {

    @Autowired
    DistributorService distributorService;

    @GetMapping
    public ResponseEntity distributorList() {
        List<Distributor> allDistributors = distributorService.getAllDistributors();
        return ResponseEntity.ok(allDistributors);
    }

    @GetMapping("/{id}")
    public ResponseEntity oneDistributor(@PathVariable Integer id) {
        Distributor distributorBuId = distributorService.getDistributorBuId(id);
        return distributorBuId != null ?
                ResponseEntity.ok(distributorBuId)
                :
                ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity saveDistributor(@RequestBody Distributor distributor) {
        boolean saved = distributorService.saveDistributor(distributor);
        return saved ?
                new ResponseEntity("Successfully saved!!!", HttpStatus.CREATED)
                :
                new ResponseEntity("Could not saved!!!", HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    public ResponseEntity editDistributor(@PathVariable Integer id, @RequestBody Distributor distributor) {
        Result result = distributorService.editDistributor(distributor, id);
        return result.isSuccess() ?
                new ResponseEntity("Successfully saved!!!", HttpStatus.CREATED)
                :
                new ResponseEntity("Could not saved!!!", HttpStatus.CONFLICT);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteDistributor(@PathVariable Integer id) {
        boolean deleted = distributorService.deleteDistributor(id);
        return deleted ?
                new ResponseEntity<>("Successfully deleted!!!", HttpStatus.CREATED)
                :
                new ResponseEntity("Could not deleted!!!", HttpStatus.CONFLICT);
    }

}








