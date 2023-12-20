package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;

import java.sql.ResultSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Long id;
    private String username;
    private String email;

    @SneakyThrows
    public User(final ResultSet resultSet) {
        this.id = resultSet.getLong("id");
        this.username = resultSet.getString("username");
        this.email = resultSet.getString("email");
    }
}
