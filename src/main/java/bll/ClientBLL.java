package bll;

import bll.validators.EmailValidator;
import bll.validators.StudentAgeValidator;
import bll.validators.Validator;
import connection.ConnectionFactory;
import dao.ClientDAO;
import dao.StudentDAO;
import model.Client;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientBLL {
    //private List<Validator<Student>> validators;
    private ClientDAO clientDAO;

    public ClientBLL() {
        clientDAO = new ClientDAO();
    }

    public Client findByID(int clientId) {
        Client result = clientDAO.findById(clientId);
        /*if(result == null)
        {
            throw new NoSuchElementException("The student with id =" + clientId + " was not found!");
        }*/

        return result;
    }

    public Client insertClient(Client client){
        return clientDAO.insert(client);
    }

    public Client updateClient(Client client){
        return clientDAO.update(client);
    }

    public Client deleteClient(Client client){
        return clientDAO.delete(client);
    }

    public ArrayList<Client> findAllClient(){
        return clientDAO.findAll();
    }


}
