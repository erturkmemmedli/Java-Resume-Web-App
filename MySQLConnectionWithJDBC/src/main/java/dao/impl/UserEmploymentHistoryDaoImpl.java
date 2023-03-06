package dao.impl;

import dao.inter.AbstractDao;
import dao.inter.UserEmploymentHistoryDaoInter;
import entitiy.EmploymentHistory;
import entitiy.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserEmploymentHistoryDaoImpl extends AbstractDao implements UserEmploymentHistoryDaoInter {
    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int id) {
        List<EmploymentHistory> list = new ArrayList<>();
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("select " +
                    "u.id, e.id as employment_id, e.header, e.begin_date, e.end_date, e.job_description " +
                    "from employment_history e " +
                    "left join user u " +
                    "on e.user_id = u.id " +
                    "where e.user_id = ?");
            statement.setInt(1, id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                EmploymentHistory employmentHistory = getUserEmploymentHistory(resultSet);
                list.add(employmentHistory);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public EmploymentHistory getUserEmploymentHistory(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("employment_id");
        int userId = resultSet.getInt("id");
        String header = resultSet.getString("header");
        String jobDescription = resultSet.getString("job_description");
        Date beginDate = resultSet.getDate("begin_date");
        Date endDate = resultSet.getDate("end_date");
        return new EmploymentHistory(id, header, beginDate, endDate, jobDescription, new User(userId));
    }

}