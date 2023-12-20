package uz.pdp;

import uz.pdp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        ResultSet resultSet = DatasourceUtils.statement().executeQuery("""
//                SELECT film_id, title, length FROM film LIMIT 5;
//                """);
//        DatasourceUtils.statement().executeUpdate("""
//                CREATE TABLE users(
//                    id bigserial PRIMARY KEY ,
//                    username varchar(255),
//                    email varchar(255)
//                )
//                """);
//        DatasourceUtils.statement().executeUpdate("""
//                INSERT INTO users(username, email)
//                VALUES('a', 'a@gmail.com'), ('b', 'b@gmai.com')
//                """);
//        long id = 2;
//        try (Connection connect = DatasourceUtils.connect();
//             Statement statement = connect.createStatement()) {
//
//            ResultSet resultSet = statement
//                    .executeQuery(
//                            "SELECT * FROM users WHERE id=" + id
//                    );
//            if (resultSet.next()) {
//                long userId = resultSet.getLong("id");
//                String username = resultSet.getString("username");
//                String email = resultSet.getString("email");
//                System.out.println("[id: " + userId + ", username: "
//                        + username + ", email: " + email + "]");
//
//            }
//        }
//        try (Connection connect = DatasourceUtils.connect()) {
//            long userId = 10;
//            String email = "a@gmail.com";
//            PreparedStatement preparedStatement = connect.prepareStatement(
//                    "SELECT * FROM users WHERE id = ? OR email = ?"
//            );
//            preparedStatement.setLong(1, userId);
//            preparedStatement.setString(2, email);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                long i = resultSet.getLong("id");
//                String username = resultSet.getString("username");
//                String e = resultSet.getString("email");
//                System.out.println("[id: " + i + ", username: "
//                        + username + ", email: " + e + "]");
//
//            }
//            preparedStatement.close();
//        }


/**

 ResultSet rs =  { [film_id: 133, title: Chamber Italian]
 [film_id: 384, title: Grosse Wonderful]
 [film_id: 8, title: Airport Pollock]
 [film_id: 98, title: Bright Encounters]
 [film_id: 1, title: Academy Dinosaur] }
 rs.next()

 */
//        while (resultSet.next()) {
//            System.out.println(new Film(resultSet));
//            long filmId = resultSet.getLong("film_id");
//            String title = resultSet.getString("title");
//            System.out.println("[film_id: " + filmId +", title: " + title+"]");
//        }

//        long l = 0;
//        while (l != -1) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Enter user id : ");
//            l = scanner.nextLong();
//            User user = UserRepository.findById(l);
//            System.out.println(user);
//        }
        String email = "";
        String username = "";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter user email : ");
            email = scanner.nextLine();
            scanner = new Scanner(System.in);
            System.out.print("Enter username : ");
            username = scanner.nextLine();
            User user = UserRepository.findByEmailOrUsernameSecure(email, username);
            System.out.println(user);
        }
    }
}