package br.com.idwall.ChallegerIdWall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
//Manipualdor dos dados SQL
@Component
public class DataBaseManipulator {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void deleteAllDataFromTable(String tableName) {
        String sql = "DELETE FROM " + tableName;
        jdbcTemplate.update(sql);
    }
    public void resetSequence(String sequenceName) {
        String sql = "ALTER SEQUENCE " + sequenceName + " RESTART";
        jdbcTemplate.execute(sql);
    }
}
