package javacourse.studentorder.dao;

import javacourse.studentorder.domain.Street;
import javacourse.studentorder.exeption.DaoExeption;

import java.util.List;

public interface DictionaryDao {
    List<Street> findStreet(String pattern) throws DaoExeption;
}
