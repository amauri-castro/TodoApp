
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;
import util.ConnectionFactory;

/**
 *
 * @author Amauri
 */
public class UserController {
    
    public User getByNameAndPassword(String username, String password) {

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        //Lista de tarefas que será devolvida quando a chamada do metodo acontecer
        User user = new User();
        
        try {
            //Criação da conexão
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            int parameter = 0;
            //Setando o valor que correponde ao filtro de busca
            statement.setString(1, username);
            statement.setString(2, password);
            
            //valor retornado pela execucao da query
            resultSet = statement.executeQuery();
            
            //enquanto houverem valores a serem percorrido no resulSet
            while (resultSet.next()) {                
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setUserName(resultSet.getString("username"));
                
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir a tarefa" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        //Lista de tarefas que foi criada e carregada do banco de dados
        return user;
    }
    
    
}
