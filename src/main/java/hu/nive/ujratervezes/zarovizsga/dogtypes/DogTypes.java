package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {
    DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    List<String> getDogsByCountry(String country) {
        List<String> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT name FROM dog_types WHERE country=? ORDER BY name");
        ) {
            stmt.setString(1, country.toUpperCase());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
//                System.out.println(name);
                result.add(name.toLowerCase());
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by SELECT", sqle);
        }

        return  result;
    }
}
