package presentation;

import model.Client;
import start.ReflectionExample;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShowTableClient extends JFrame {
    private JTable clientTable;

    public ShowTableClient(ArrayList<Client> clients)
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(320, 200);

        JPanel panel = new JPanel();

        Client client = null;
        client = clients.get(0);

        //System.out.println("id column: " + ReflectionExample.retrieveProperties(client).get(0));
        //String[] coloane = {"id", "name", "address"};

        String[] coloane = new String[3];

        coloane[0] = ReflectionExample.retrieveProperties(client).get(0);
        coloane[1] = ReflectionExample.retrieveProperties(client).get(1);
        coloane[2] = ReflectionExample.retrieveProperties(client).get(2);

        //System.out.println("coloana 1: " + coloane[0]);


        Object[][] linii = new Object[clients.size()][3];
        for(int i = 0; i < clients.size(); i++)
        {
            linii[i][0] = clients.get(i).getId();
            linii[i][1] = clients.get(i).getName();
            linii[i][2] = clients.get(i).getAdresa();
        }

        clientTable = new JTable(linii, coloane);
        JScrollPane sp = new JScrollPane(clientTable);

        panel.add(sp);

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        this.setContentPane(panel);

    }
}
