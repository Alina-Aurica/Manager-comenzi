package bll;

import dao.ClientDAO;
import dao.OrderDAO;
import model.Client;
import model.Order;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class OrderBLL {

    private OrderDAO orderDAO;

    public OrderBLL() {
        orderDAO = new OrderDAO();
    }

    public Order findByID(int orderId) {
        Order result = orderDAO.findById(orderId);
        /*
        if(result == null)
        {
            throw new NoSuchElementException("The order with id =" + orderId + " was not found!");
        }
         */

        return result;
    }

    public Order insertOrder(Order order){
        return orderDAO.insert(order);
    }

    public ArrayList<Order> findAllOrder(){
        return orderDAO.findAll();
    }

}
