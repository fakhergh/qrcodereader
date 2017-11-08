package com.benboubaker.qrcodereader.database;

import com.benboubaker.qrcodereader.models.Code;

import java.util.List;

/**
 * Created by fekhe on 06/11/2017.
 */

public interface DB {
    int VERSION = 2;
    String DB_NAME = "qr_code";
    String TABLE_NAME = "codes";

    String TABLE_CREATION_QUERY = "CREATE TABLE " + TABLE_NAME + "(" +
            "id NUMBER PRIMARY KEY," +
            "content VARCHAR,"+
            "type VARCHAR);";

    List<Code> getAll();
    void addCode(Code code);
    void removeCode(int id);
}
