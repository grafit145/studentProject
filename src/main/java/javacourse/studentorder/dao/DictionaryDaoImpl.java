package javacourse.studentorder.dao;

import javacourse.studentorder.domain.Street;
import javacourse.studentorder.exeption.DaoExeption;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {
    private static final String GET_STREET = "select street_code, street_name from jc_street where UPPER(street_name) like UPPER(?)";

    private Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jc_student",
                "postgres", "aiwprton");
        return con;
    }

    public List<Street> findStreet(String pattern) throws DaoExeption {
        List<Street> result = new LinkedList<>();
        try (Connection con = getConnection(); PreparedStatement statement = con.prepareStatement(GET_STREET)) {
            statement.setString(1, "%" + pattern + "%");
            ResultSet rlst = statement.executeQuery();
            while (rlst.next()) {
                Street street = new Street(rlst.getLong("street_code"), rlst.getString("street_name"));
                result.add(street);
            }
        }catch (SQLException ex){
            throw new DaoExeption(ex);
        }
        return result;
    }

}
