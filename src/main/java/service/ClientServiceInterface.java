package service;

import domain.person.Client;

public interface ClientServiceInterface {

    void addClient();

    void addClient(Client client);

    void readFromFile(String fileName);

    void writeToFile(String fileName);

}