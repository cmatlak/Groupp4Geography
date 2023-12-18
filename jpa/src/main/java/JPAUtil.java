import jakarta.persistence.*;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class JPAUtil {
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
        Runtime.getRuntime().addShutdownHook(new Thread(emf::close));
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
