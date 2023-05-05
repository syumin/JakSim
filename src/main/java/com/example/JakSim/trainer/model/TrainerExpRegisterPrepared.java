package com.example.JakSim.trainer.model;

import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TrainerExpRegisterPrepared implements PreparedStatementCreator {
    private TrainerDo trainerDo;
    private String[] keyColumns;
    private String sql;


    public TrainerExpRegisterPrepared(TrainerDo trainerDo, String[] keyColumns, String sql){
        this.trainerDo = trainerDo;
        this.keyColumns = keyColumns;
        this.sql = sql;
    }
    public TrainerExpRegisterPrepared(TrainerDo trainerDo, String sql){
        this(trainerDo, new String[] {}, sql);
    }

    @Override
    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement pstmt = null;

        if(keyColumns.length > 0 ){
            pstmt = con.prepareStatement(sql, keyColumns);
        }else{
            pstmt = con.prepareStatement(sql);
        }
        // pstmt.setString(1, "USER_TRAINER_SEQ.NEXTVAL");
        pstmt.setString(1, "1");
        pstmt.setString(2, "3");

        return pstmt;
    }
}