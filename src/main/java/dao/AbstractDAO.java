package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;

/**
 * @Author: Alina Aurică
 * @Since: Apr 18, 2022
 * @Source http://www.java-blog.com/mapping-javaobjects-database-reflection-generics
 */
public class AbstractDAO<T> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

	private final Class<T> type;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	private String createSelectQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM `");
		sb.append(type.getSimpleName());
		sb.append("` WHERE " + field + " =?");
		return sb.toString();
	}

	private String createAllQuery(){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM `");
		sb.append(type.getSimpleName());
		sb.append("`");
		return sb.toString();
	}

	private String createInsertQuery(Object object){
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO `");
		sb.append(type.getSimpleName());
		sb.append("` VALUES (");

		int sizeColumns = 0;
		for(Field field: type.getDeclaredFields())
		{
			sizeColumns++;
		}

		int index = 0;
		for(Field field: type.getDeclaredFields()){
			field.setAccessible(true);
			sb.append("?");
			if(sizeColumns - 1 != index)
				sb.append(",");
			index++;
		}
		sb.append(")");

		return sb.toString();
	}

	private String createUpdateQuery(Object object){
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE `");
		sb.append(type.getSimpleName());
		sb.append("` SET ");

		int sizeColumns = 0;
		for(Field field: type.getDeclaredFields())
		{
			sizeColumns++;
		}

		int index = 0;
		for(Field field: type.getDeclaredFields()){
			field.setAccessible(true);
			if(sizeColumns - 1 != index)
				sb.append(field.getName() + "=? ,");
			else
				sb.append(field.getName() + "=? ");
			index++;
		}
		sb.append(" WHERE id=?");

		return sb.toString();
	}

	private String createDeleteQuery(Object object){
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE ");
		sb.append("FROM `");
		sb.append(type.getSimpleName());
		sb.append("` WHERE id=?");

		return sb.toString();
	}



	public ArrayList<T> findAll() {
		// TODO:
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createAllQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			//statement.setInt(1, id);
			resultSet = statement.executeQuery();

			return createObjects(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	public T findById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectQuery("id");
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
		} catch (IndexOutOfBoundsException e){
			return null;
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	private ArrayList<T> createObjects(ResultSet resultSet) {
		ArrayList<T> list = new ArrayList<T>();
		Constructor[] ctors = type.getDeclaredConstructors();
		Constructor ctor = null;
		for (int i = 0; i < ctors.length; i++) {
			ctor = ctors[i];
			if (ctor.getGenericParameterTypes().length == 0)
				break;
		}
		try {
			while (resultSet.next()) {
				ctor.setAccessible(true);
				T instance = (T)ctor.newInstance();
				for (Field field : type.getDeclaredFields()) {
					String fieldName = field.getName();
					Object value = resultSet.getObject(fieldName);
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return list;
	}

	public T insert(T t) {
		// TODO:
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createInsertQuery(t);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			int index = 1;
			for (Field field : type.getDeclaredFields() ) {
				field.setAccessible(true);
				String fieldName = field.getName();
				Object value = field.get(t);
				if(value.getClass().getSimpleName().equals("String")==true)
					statement.setString(index, value.toString());
				else
					statement.setInt(index, Integer.parseInt(value.toString()));
				index++;
			}
			statement.executeUpdate();
			return t;
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:insertClient " + e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}

		return null;
	}

	public T update(T t) {
		// TODO:
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createUpdateQuery(t);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			int index = 1;
			int sizeColumns = 0;
			for(Field field : type.getDeclaredFields()){
				sizeColumns++;
			}
			for (Field field : type.getDeclaredFields() ) {
				field.setAccessible(true);
				String fieldName = field.getName();
				Object value = field.get(t);
				if(index == 1)
					statement.setInt(sizeColumns + 1, (Integer) field.get(t));
				if(value.getClass().getSimpleName().equals("String") == true)
					statement.setString(index, value.toString());
				else
					statement.setInt(index, Integer.parseInt(value.toString()));
				index++;
			}
			statement.executeUpdate();
			//return t;
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:updateClient " + e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}

		return t;
	}

	public T delete(T t){
		//TODO:
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createDeleteQuery(t);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			int index = 1;
			Object value = null;
			for (Field field : type.getDeclaredFields() ) {
				field.setAccessible(true);
				if(index == 1)
					value = field.get(t);
				index++;
			}
			statement.setInt(1, (int) value);
			statement.executeUpdate();
			return t;
			//System.out.println("stergerea a fost executata cu succes");
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:deleteClient " + e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}

		return null;
	}
}
