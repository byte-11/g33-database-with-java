package uz.pdp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@ToString
public class Film {
    private Long id;
    private String title;
    private int length;

    public Film(final ResultSet resultSet) throws SQLException {
        this.id = resultSet.getLong("film_id");
        this.title = resultSet.getString("title");
        this.length = resultSet.getInt("length");
    }
}
