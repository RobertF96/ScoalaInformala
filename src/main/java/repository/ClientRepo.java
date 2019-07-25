package repository;

import domain.person.Client;

import java.util.HashSet;
import java.util.Set;

public class ClientRepo implements ClientRepoInterface {

    Set<Client> clients = new HashSet<>();

    @Override
    public void add(Client client) {

        clients.add(client);
    }

    @Override
    public Set<Client> getAll() {

        return clients;
    }
}