package cz.soukal.spring.models;

import cz.soukal.spring.entity.Insurance;
import cz.soukal.spring.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceRepository insuranceRepository;

    public List<Insurance> getAllInsuranceByClientId(Long id) {
        return insuranceRepository.findByClientId(id);
    }
    
}
