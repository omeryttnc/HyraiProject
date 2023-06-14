package utilities;

import lombok.SneakyThrows;
import org.junit.Test;
import pojos.Promocode.PPromoCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseUtilities {
    private static final String db_url = ConfigurationReader.getProperty("db_url");
    private static final String db_username = ConfigurationReader.getProperty("db_username");
    private static final String db_password = ConfigurationReader.getProperty("db_password");

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    public static ResultSet resultSet;

    public static Connection createConnection() {
        try {
            connection = DriverManager.getConnection(db_url, db_username, db_password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeQuery(String query) throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
        return;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @SneakyThrows
    public static void createPromoCode_statement(String promocodeName, String startDate, String endDate) {
//
//        String promocodeName = "pro_4";
//        String startDate = "2023-06-14 18:16:10.000000";
//        String endDate = "2023-06-28 19:16:38";

        //'2023-06-14 18:16:10.000000', '2023-06-28 19:16:38'


        statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO `promo_code` (`id`, `code`, `starts_at`, `ends_at`, `number_of_users`, `discount`, `discount_type`) " +
                "VALUES (NULL, '" + promocodeName + "', '" + startDate + "', '" + endDate + "', '5', '35', 'money');");


    }


    @SneakyThrows
    public static void createPromocodePreStatement(String promocodeName, String startDate, String endDate) {
//        String promocodeName = "pro_5";
//        String startDate = "2023-06-14 18:16:10.000000";
//        String endDate = "2023-06-28 19:16:38";

        preparedStatement = connection.prepareStatement(" INSERT INTO `promo_code` (`id`, `code`, `starts_at`, `ends_at`, `number_of_users`, `discount`, `discount_type`) " +
                "VALUES (NULL, ?, ?, ?, ?, ?, ?);");
        preparedStatement.setString(1, promocodeName);
        preparedStatement.setString(2, startDate);
        preparedStatement.setString(3, endDate);
        preparedStatement.setInt(4, 5);
        preparedStatement.setInt(5, 20);
        preparedStatement.setString(6, "money");
        preparedStatement.executeUpdate();

    }


    @SneakyThrows
    public static void updatePromocode_statement(String columnName, String columnValue, int id) {

        executeUpdate("UPDATE `promo_code` SET `" + columnName + "` = '" + columnValue + "' WHERE `promo_code`.`id` = " + id + ";");

    }

    @SneakyThrows
    private static void executeUpdate(String query) {
        statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    @SneakyThrows
    public static void updatePomocode_preStatement(String columnValue, int id) {
        preparedStatement = connection.prepareStatement("UPDATE `promo_code` SET `code` = ? WHERE `promo_code`.`id` = ?;");
        preparedStatement.setString(1, columnValue);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();

    }

    @SneakyThrows
    public static void deletePromocode_statement(int id) {
        executeUpdate("DELETE FROM promo_code WHERE `promo_code`.`id` = " + id);

    }

    @SneakyThrows
    public static void deletePromocode_preStatetment(int id) {

        preparedStatement = connection.prepareStatement("DELETE FROM promo_code WHERE `promo_code`.`id` = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }


    @Test
    @SneakyThrows
    public static List<Map<String, Object>> getPromocode() {

        statement = connection.createStatement();

        resultSet = statement.executeQuery("SELECT * FROM `promo_code`");


        List<Map<String, Object>> list = new ArrayList<>();

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        System.out.println("columnCount = " + columnCount);
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();

            for (int i = 1; i <= columnCount; i++) {
                map.put(metaData.getColumnName(i), resultSet.getObject(i));
            }
//            map.put("id", resultSet.getInt(1));
//            map.put("code", resultSet.getString("code"));
            list.add(map);

        }

        return list;

    }


    @Test
    @SneakyThrows
    public static List<PPromoCode> getPromocode_innerClass() {

        statement = connection.createStatement();

        resultSet = statement.executeQuery("SELECT * FROM `promo_code`");


        List<PPromoCode> list = new ArrayList<>();

        while (resultSet.next()) {
            PPromoCode promoCode = new PPromoCode(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6),
                    resultSet.getString(7)

            );
            list.add(promoCode);

        }

        return list;

    }
}


