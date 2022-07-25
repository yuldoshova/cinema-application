package uz.pdp.cinemaapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import uz.pdp.cinemaapplication.entity.Distributor;
import uz.pdp.cinemaapplication.payload.Result;
import uz.pdp.cinemaapplication.repository.DistributorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DistributorService {

    @Autowired
    DistributorRepository distributorRepository;

    public List<Distributor> getAllDistributors() {
        List<Distributor> distributors = distributorRepository.findAll();
        return distributors;
    }

    public Distributor getDistributorBuId(Integer id) {
        Optional<Distributor> distributor = distributorRepository.findById(id);
        if (distributor.isPresent()) {
            return distributor.get();
        }
        return new Distributor();
    }

    public boolean saveDistributor(Distributor distributor) {
        Distributor saved = distributorRepository.save(distributor);
        return saved != null;
    }

    public Result editDistributor(Distributor distributor, Integer id) {
        Distributor distributorById = getDistributorBuId(id);
        if (!distributorRepository.existsDistributorById(id)) {
            return new Result("Bunday distributor mavjut emas!!!",false);
        }
        distributorById.setName(distributor.getName());
        distributorById.setDescription(distributor.getDescription());
        return new Result("Successfully edited!!!", true, distributorById);
    }


    public boolean deleteDistributor(Integer id) {
        try {
            distributorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
