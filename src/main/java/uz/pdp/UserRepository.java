package uz.pdp;

import lombok.SneakyThrows;
import uz.pdp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserRepository {
    @SneakyThrows
    public static User findById(long id) {
        try (Connection connect = DatasourceUtils.connect();
             Statement statement = connect.createStatement()) {

            ResultSet resultSet = statement
                    .executeQuery(
                            "SELECT * FROM users WHERE id= " + id
                    );
            if (resultSet.next()) {
                return new User(resultSet);
            }
        }
        return null;
    }

    @SneakyThrows
    public static User findByEmail(String email) {
        try (Connection connect = DatasourceUtils.connect();
             Statement statement = connect.createStatement()) {

            ResultSet resultSet = statement
                    .executeQuery(
                            "SELECT * FROM users WHERE email=" + email
                    );
            if (resultSet.next()) {
                return new User(resultSet);
            }
        }
        return null;
    }

    @SneakyThrows
    public static User findByEmailOrUsernameSecure(String email, String username){
        try (Connection connect = DatasourceUtils.connect()) {
            PreparedStatement preparedStatement = connect.prepareStatement("""
                    SELECT * FROM users WHERE email= ? OR username = ?
                    """);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return new User(resultSet);
            }
        }
        return null;
    }
}
