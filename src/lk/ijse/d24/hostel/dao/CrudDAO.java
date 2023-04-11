package lk.ijse.d24.hostel.dao;

/*
    @author THINUX
    @created 11-Apr-23 - 19:03 
*/

import org.apache.poi.hssf.record.formula.functions.T;

import java.util.List;

public interface CrudDAO<T, ID> {
    List<T> getAll() throws Exception;

    ID save(T dto) throws Exception;

    void update(T dto) throws Exception;

    ID generateNewId() throws Exception;

    T getObject(ID id) throws Exception;
}
