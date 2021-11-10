package javacourse.studentorder.dao;

import javacourse.studentorder.domain.PassportOffice;
import javacourse.studentorder.domain.RegisterOffice;
import javacourse.studentorder.domain.Street;
import javacourse.studentorder.exeption.DaoExeption;

import java.util.List;

public interface DictionaryDao {
    List<Street> findStreet(String pattern) throws DaoExeption;
    List<PassportOffice> findPassportOffices(String areaId) throws DaoExeption;
    List<RegisterOffice> findRegisterOffices(String areaId) throws DaoExeption;
}
