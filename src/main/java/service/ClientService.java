package service;

import domain.person.Client;
import repository.RepoInterface;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClientService implements ClientServiceInterface {

    RepoInterface<Client> clientRepo;

    public ClientService(RepoInterface<Client> clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public void addClient() {
    }

    @Override
    public void addClient(Client client) {
        clientRepo.add(client);
    }

    @Override
    public void readFromFile(String fileName) {
        Charset charset = Charset.forName("UTF8");

        File file = new File(fileName);
        System.out.println(file.getAbsolutePath());
        Path path = Paths.get(file.getPath());

        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                long id = Long.parseLong(split[0]);
                String cnp = split[1];
                String firstName = split[2];
                String lastName = split[3];
                int age = Integer.parseInt(split[4]);
                String phoneNumber = split[5];

                Client client = new Client(id,cnp, firstName, lastName, age, phoneNumber);
                clientRepo.add(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(String fileName) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(out);

            for(Client client: clientRepo.getAll()){
                objectOut.writeObject(client);
            }
            objectOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}