package jpu2016.javapetri.dao;
import jpu2016.javapetri.model.JavaCell;
public abstract class QueryJavaCell {
    public static String getQueryInsert(JavaCell javaCell, int idJavaPetri){
        return "INSERT INTO `corbeillejavapetri`.`rgbcell` " +
                " (`ID`, `X`, `Y`, `STRENGTH`, 'COLOR', 'ID_JAVAPETRI')" +
                " VALUES ( NULL, NULL, NULL, NULL, NULL, '" + javaCell.getStrength()+
                "');";

    }
}
