package bll;

import dao.ClientDAO;
import dao.ProductDAO;
import model.Client;
import model.Product;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ProductBLL {
    private ProductDAO productDAO;

    public ProductBLL() {
        productDAO = new ProductDAO();
    }

    public Product findByID(int productId) {
        Product result = productDAO.findById(productId);
        /*
        if(result == null)
        {
            throw new NoSuchElementException("The product with id =" + productId + " was not found!");
        }
         */

        return result;
    }

    public Product insertProduct(Product product){
        return productDAO.insert(product);
    }

    public Product updateProduct(Product product){
        return productDAO.update(product);
    }

    public Product deleteProduct(Product product){
        return productDAO.delete(product);
    }

    public ArrayList<Product> findAllProduct(){
        return productDAO.findAll();
    }
}
