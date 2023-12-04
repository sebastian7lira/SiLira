/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class TesteJDBC {

    public static void main(String[] args) {
        try {

            String url, user, password;
            url = "jdbc:mysql://localhost:3306/vendas";
            user = "root";
            password = "";
//            url = "jdbc:mysql://10.7.0.51:33062/db_francine_lorenzoni";
//            user= "francine_lorenzoni";
//            password = "francine_lorenzoni";
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //Statement stm;
            //stm = cnt.createStatement();
            //String sql = "insert into grupo values(7, 'grupo vespertino', 'S')";
            //String sql = "UPDATE grupo SET descricao='lia santos', ativo='N' WHERE idgrupo='9'";
            //String sql = "DELETE FROM grupo WHERE idgrupo=9";
            //stm.executeUpdate(sql);
            String sql = "select * from usuarios";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next() == true) {
                System.out.println(rs.getInt("idusuarios"));
                System.out.println(rs.getString("nome"));
                System.out.println(rs.getString("apelido"));                 
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("executou ");
    }
}
