package cz.soukal.spring.controllers;

import cz.soukal.spring.entity.Client;
import cz.soukal.spring.entity.Insurance;
import cz.soukal.spring.models.InsuranceService;
import cz.soukal.spring.repository.ClientRepository;
import cz.soukal.spring.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pojistenci")
public class ClientsController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private InsuranceService insuranceService;

    // Renders table with all clients in database
    @GetMapping
    public String renderPojistenci(Model model) {

        List<Client> allClients = clientRepository.findAll();
        model.addAttribute("allClients", allClients);

        return "clients";
    }


    // Renders form for adding new client
    @GetMapping("/novy")
    public String renderClientsNewForm(Model model) {

        model.addAttribute("client", new Client());

        return "clients-new";
    }


    // Saves data from clients-new form into the database
    @PostMapping("/novy")
    public String saveClientData(@ModelAttribute Client client) {

        clientRepository.save(client);

        return "redirect:/pojistenci";
    }


    // Renders profile of client by his id and all his insurances
    @GetMapping("/klient/{id}")
    public String renderClientProfile(@PathVariable Long id, Model model) {

        Client client = clientRepository.findById(id).orElse(null);
        model.addAttribute("client", client);

        List<Insurance> allInsurance = insuranceService.getAllInsuranceByClientId(id);
        model.addAttribute("allInsurance", allInsurance);

        return "client-profile";
    }


    // Deletes client from database, (insurances are deleted by cascade type), after confirmation in js
    @PostMapping("/klient/delete/{id}")
    public String deleteClient(@PathVariable Long id) {

        clientRepository.findById(id).ifPresent(client -> clientRepository.delete(client));

        return "redirect:/pojistenci";
    }


    // Renders client data into form for user to edit
    @GetMapping("/klient/edit/{id}")
    public String editClientForm(@PathVariable Long id, Model model) {

        Client client = clientRepository.findById(id).orElse(null);
        model.addAttribute("client", client);

        return "clients-edit";
    }


    //
    @PostMapping("/klient/edit/ulozit/{id}")
    public String editClient(@PathVariable Long id, @ModelAttribute Client client) {

        client.setId(id);
        client.setInsurance(clientRepository.findById(id).get().getInsurance());
        clientRepository.save(client);

        return "redirect:/pojistenci";
    }

}
