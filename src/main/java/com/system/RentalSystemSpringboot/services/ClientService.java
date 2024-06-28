package com.system.RentalSystemSpringboot.services;

import com.system.RentalSystemSpringboot.models.Client;
import com.system.RentalSystemSpringboot.repository.ClientRepository;
import com.system.RentalSystemSpringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client>findByEmail(String email){

        return clientRepository.findByEmail(email);
    }
    public Optional<Client> findByNumeropermis(String numeropermis){
        return clientRepository.findByNumeropermis(numeropermis);
    }
    public Optional<Client> findByCin(String cin){
        return clientRepository.findByCin(cin);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public Client update(Long id,Client upclient){
        Optional<Client> clientexistes=  clientRepository.findById(id);
        if(clientexistes.isPresent()){
            Client client1=clientexistes.get();
            client1.setCin(upclient.getCin());
            client1.setEtat(upclient.getEtat());
            client1.setEmail(upclient.getEmail());
            client1.setNom(upclient.getNom());
            client1.setPrenom(upclient.getPrenom());
            client1.setAdresse(upclient.getAdresse());
            client1.setNumerotelephone(upclient.getNumerotelephone());
            client1.setVille(upclient.getVille());
            client1.setCodePostal(upclient.getCodePostal());
            client1.setNumeropermis(upclient.getNumeropermis());
            return clientRepository.save(client1);
        }
        else {
            throw new RuntimeException("Client introuvable avec id"+id);
        }


    }

    public void delete(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()) {
            clientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Client not found with id: " + id);
        }
    }

    public List<Client> findAll(){
        return  clientRepository.findAll();
    }
    public Client findById(Long id){
        return clientRepository.findById(id).get();
    }
    public Client updateClientEtat(Long id) {
        int updatedRows = clientRepository.updateClientEtatById(id);
        if (updatedRows > 0) {
            return clientRepository.findById(id).orElse(null);
        }
        return null;
    }
}
