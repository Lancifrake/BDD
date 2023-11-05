package jpu2016.javapetri.dao;
import java.sql.*;

import jpu2016.javapetri.model.JavaCell;
import jpu2016.javapetri.model.JavaPetri;
import  java.sql.ResultSet;

public class DAOJavapetri {
    private static final String URL = "jdbc:mysql://localhost/corbeillejavapetri";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DAOJavapetri(){
        this.connection = null;
        this.statement = null;
    }
    public boolean open(){
        System.out.println("\n --- open ---");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(DAOJavapetri.URL,
                    DAOJavapetri.LOGIN, DAOJavapetri.PASSWORD);
            this.statement = this.connection.createStatement();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (final SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public void close(){
        try{
            connection.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        System.out.println("\n --- close ---");
        return;
    }
    public JavaPetri getJavaPetriById(int id){
        return null;
    }
    public void insertJavaPetri(final JavaPetri javaPetri) {
        if (this.executeUpdate(QueryJavaPetri.getQueryInsert(javaPetri)) == 1) {
            final int idJavaPetri = this.getLastId();
            if (idJavaPetri != -1) {
                for (final JavaCell javaCell :
                        javaPetri.getJavaCells()) {

                    this.executeUpdate(QueryJavaCell.getQueryInsert(javaCell, idJavaPetri));
                }
            }
        }
    }


    private int getLastId() {
        try {
            ResultSet resultSet = this.statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public ResultSet executeQuery(String query){
        try {
            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int executeUpdate(String query){
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

}
