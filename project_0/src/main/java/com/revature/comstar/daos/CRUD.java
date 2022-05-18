package com.revature.comstar.daos;

import java.io.IOException;
import java.util.List;

public interface CRUD <T> {

    T create(T newObject);

    List<T> findAll() throws IOException;


    boolean update(T updatedObj);

    boolean delete(String id);


}
