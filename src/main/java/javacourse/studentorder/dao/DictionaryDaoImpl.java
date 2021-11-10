package javacourse.studentorder.dao;

import javacourse.studentorder.config.Config;
import javacourse.studentorder.domain.PassportOffice;
import javacourse.studentorder.domain.RegisterOffice;
import javacourse.studentorder.domain.Street;
import javacourse.studentorder.exeption.DaoExeption;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {
    private static final String GET_STREET = "select street_code, street_name" +
            " from jc_street where UPPER(street_name) like UPPER(?)";
    private static final String GET_PASSPORT = "select * " +
            " from jc_passport_office where p_office_area_id = ?";
    private static final String GET_REGISTER = "select * " +
            " from jc_register_office where r_office_area_id = ?";

    private Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
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

    @Override
    public List<PassportOffice> findPassportOffices(String areaId) throws DaoExeption {
        List<PassportOffice> result = new LinkedList<>();
        try (Connection con = getConnection(); PreparedStatement statement = con.prepareStatement(GET_PASSPORT)) {
            statement.setString(1, areaId);
            ResultSet rlst = statement.executeQuery();
            while (rlst.next()) {
                PassportOffice passportOffice = new PassportOffice(rlst.getLong("p_office_id"),
                        rlst.getString("p_office_area_id"), rlst.getString("p_office_name"));
                result.add(passportOffice);
            }
        }catch (SQLException ex){
            throw new DaoExeption(ex);
        }
        return result;
    }

    @Override
    public List<RegisterOffice> findRegisterOffices(String areaId) throws DaoExeption {
        List<RegisterOffice> result = new LinkedList<>();
        try (Connection con = getConnection(); PreparedStatement statement = con.prepareStatement(GET_REGISTER)) {
            statement.setString(1, areaId);
            ResultSet rlst = statement.executeQuery();
            while (rlst.next()) {
                RegisterOffice registerOffice = new RegisterOffice(rlst.getLong("r_office_id"),
                        rlst.getString("r_office_area_id"), rlst.getString("r_office_name"));
                result.add(registerOffice);
            }
        }catch (SQLException ex){
            throw new DaoExeption(ex);
        }
        return result;
    }

}
