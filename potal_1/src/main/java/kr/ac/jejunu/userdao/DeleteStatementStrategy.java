package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementStrategy implements StatementStrategy {
    public DeleteStatementStrategy(Long id) {

    }

    @Override
    public PreparedStatement makePrepareStatement(Connection connection) throws SQLException {
        Long id = (Long) object;
        PreparedStatement preparedStatement = connection.prepareStatement
                ("delete from userinfo where id = ?");
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}