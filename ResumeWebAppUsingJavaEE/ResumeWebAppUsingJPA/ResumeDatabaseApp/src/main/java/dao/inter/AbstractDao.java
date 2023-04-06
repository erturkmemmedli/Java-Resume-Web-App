package dao.inter;

import javax.persistence.*;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {
    public static Connection connect() throws Exception {
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "my1783406sql";

        Connection connection = DriverManager.getConnection(url, username, password);

        return connection;
    }

    private static EntityManagerFactory entityManagerFactory = null;

    public EntityManager entityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("resumeAppPU");
        }
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager;
    }

    public void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }
}