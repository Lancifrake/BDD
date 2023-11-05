package jpu2016.javapetri.dao;
import jpu2016.javapetri.model.JavaCell;
import  jpu2016.javapetri.model.JavaPetri;
import jpu2016.javapetri.dao.DAOJavapetri;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class QueryJavaPetri {

    private Statement statement;

    public static String getQueryInsert(final JavaPetri javaPetri) {
        return "INSERT INTO `corbeillejavapetri`.`javapetri` " +
                " (`ID`, `LABEL`, `WIDTH`, `HEIGHT`)" +
                " VALUES ( NULL, '" + javaPetri.getLabel() +
                "','"+ javaPetri.getWidth() +
                "','" + javaPetri.getHeight() +
                "');";
    }
    public static String getQuerySelectById(int id){
        return "SELECT ID FROM 'javapetri'.'javapetri'";
    }
    public static String getQuerySelectAll(){
        return "SELECT * FROM 'javapetri'.'javapetri'";
    }

    private int executeUpdate(String queryInsert) {
        return 0;
    }


}

