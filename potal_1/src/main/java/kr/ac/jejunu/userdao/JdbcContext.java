package kr.ac.jejunu.userdao;

import javax.sql.DataSource;

public class JdbcContext {
    DataSource dataSource;
    public JdbcContext(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
