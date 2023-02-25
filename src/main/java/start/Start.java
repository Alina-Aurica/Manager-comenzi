package start;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import bll.StudentBLL;
import model.Client;
import model.Order;
import model.Product;
import model.Student;
import presentation.Controller;
import presentation.View;

import static connection.ConnectionFactory.LOGGER;

/**
 * @Author: Alina Aurică
 * @Since: Apr 18, 2022
 */
public class Start {
	//protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) throws SQLException {

		View view = new View();

		Controller controller = new Controller(view);

		view.setVisible(true);


		/*
		OrderBLL orderBLL = new OrderBLL();

		Order order1 = null;

		try {
			order1 = orderBLL.findByID(1);

		} catch (Exception ex) {
			LOGGER.log(Level.INFO, ex.getMessage());
		}

		// obtain field-value pairs for object through reflection
		ReflectionExample.retrieveProperties(order1);
		*/

		/*
		StudentBLL studentBll = new StudentBLL();

		Student student1 = null;

		try {
			student1 = studentBll.findStudentById(1245);

		} catch (Exception ex) {
			LOGGER.log(Level.INFO, ex.getMessage());
		}

		// obtain field-value pairs for object through reflection
		ReflectionExample.retrieveProperties(student1);
		 */

	}

}
