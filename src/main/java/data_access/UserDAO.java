package data_access;

import model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static com.portfolio.portfolio.MySQL_Connect.getConnection;

public class UserDAO {
    public static List<User> getAll() {
        List<User> list = new ArrayList<>();
        try (Connection connection = getConnection()) {
            try (CallableStatement statement = connection.prepareCall("{CALL sp_get_all_users()}")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int userId = resultSet.getInt("user_id");
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        String email = resultSet.getString("email");
                        String phone = resultSet.getString("phone");
                        char[] password = resultSet.getString("password").toCharArray();
                        String language = resultSet.getString("language");
                        String status = resultSet.getString("status");
                        String privileges = resultSet.getString("privileges");
                        Instant created_at = resultSet.getTimestamp("created_at").toInstant();
                        String timezone = resultSet.getString("timezone");
                        User user = new User(userId, firstName, lastName, email, phone, password, language, status, privileges, created_at, timezone);
                        list.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    public static void main(String[] args) {
        getAll().forEach(System.out::println);
    }
}
