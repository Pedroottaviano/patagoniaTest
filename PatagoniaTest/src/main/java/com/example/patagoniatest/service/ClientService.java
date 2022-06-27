package com.example.patagoniatest.service;

import com.example.patagoniatest.model.Client;
import com.example.patagoniatest.model.Role;
import com.example.patagoniatest.repository.ClientRepository;
import com.example.patagoniatest.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, RoleRepository roleRepository) {
        this.clientRepository = clientRepository;
        this.roleRepository = roleRepository;
    }

    public Role saveRole(Role role){
        log.info("saving role to the database");
        return roleRepository.save(role);
    }

    @Transactional
    public void addRoleToClient(String fullName, String roleName){
        log.info("Adding {} role to user: {}", roleName, fullName);
        Client client = clientRepository.findByFullName(fullName);
        Role role = roleRepository.findByName(roleName);
        client.getRoles().add(role);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
    }

    @Transactional
    public void updateClient(Client client, Long id) {
        Client updatedClient = clientRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "client with id: " + id + "doesn´t exists"
        ));
        if (!Objects.equals(updatedClient.getFullName(), client.getFullName())){
            updatedClient.setFullName(client.getFullName());
        }
        if (updatedClient.getIncome() != client.getIncome()){
            updatedClient.setIncome(client.getIncome());
        }
    }

    public OptionalDouble getEarningsAverage() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .mapToDouble(Client::getIncome)
                .average();
    }

    public List<Client> getTopEarners() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .filter(client -> client.getIncome() >= 10000).collect(Collectors.toList());
    }
}
