package cz.soukal.spring.controllers;

import cz.soukal.spring.entity.Client;
import cz.soukal.spring.entity.Insurance;
import cz.soukal.spring.repository.ClientRepository;
import cz.soukal.spring.repository.InsuranceRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/pojisteni")
public class InsurancesController {

    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private ClientRepository clientRepository;


    // Renders list of all insurances of all clients
    @GetMapping
    public String renderInsurances(Model model) {

        List<Insurance> allInsurances = insuranceRepository.findAll();
        model.addAttribute("allInsurances", allInsurances);

        return "insurances";
    }


    // Renders profile of specific insurance
    @GetMapping("/{id}")
    public String renderInsuranceProfile(@PathVariable Long id, Model model) {

        Insurance insurance = insuranceRepository.findById(id).orElse(null);
        model.addAttribute("insurance", insurance);

        return "insurance-profile";
    }


    // Renders form for creating new insurance for the client
    @GetMapping("/novy")
    public String renderInsurancesNewForm(@RequestParam Long id, Model model) {

        Client client = clientRepository.findById(id).orElse(null);
        model.addAttribute("client", client);
        model.addAttribute("insurance", new Insurance());

        return "insurances-new";
    }


    // Saves data from the form into the database
    @PostMapping("/novy")
    public String saveInsuranceData(@ModelAttribute Insurance insurance, @RequestParam Long id) {

        if (id != null) {
            insurance.setClient(clientRepository.findById(id).orElse(null));
            insuranceRepository.save(insurance);
        } else {
            throw new IllegalArgumentException("Client value must not be null");
        }

        return "redirect:/pojistenci/klient/" + id;
    }


    // Deletes insurance from database
    @PostMapping("/delete")
    public String deleteInsurance(@RequestParam Long idInsurance, @RequestParam(required = false) Long idClient) {

        insuranceRepository.findById(idInsurance).ifPresent(insurance -> insuranceRepository.delete(insurance));

        if (idClient != null) {
            return "redirect:/pojistenci/klient/" + idClient;
        } else {
            return "redirect:/pojisteni";
        }
    }


    // Renders form filled with data ready to be edited
    @GetMapping("/edit")
    public String editInsuranceForm(@RequestParam Long idInsurance, Model model) {

        Insurance insurance = insuranceRepository.findById(idInsurance).orElse(null);
        model.addAttribute("insurance", insurance);

        return "insurances-edit";
    }


    // Saves edited data into the database
    @PostMapping("/edit")
    public String editInsurance(HttpServletRequest request, @ModelAttribute Insurance insurance, @RequestParam Long idInsurance) {

        // Gets date values, couldn't use @ModelAttribute because of inserting into <input>
        LocalDate validFrom = LocalDate.parse(request.getParameter("validityFrom"));
        LocalDate validTo = LocalDate.parse(request.getParameter("validityTo"));


        insurance.setValidFrom(validFrom);
        insurance.setValidTo(validTo);
        insurance.setId(idInsurance);

        insurance.setClient(insuranceRepository.findById(idInsurance).get().getClient());
        insuranceRepository.save(insurance);

        return "redirect:/pojisteni";
    }


}
