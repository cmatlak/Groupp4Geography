import jakarta.persistence.*;
public class Main {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        Menu.choice();




    }

}
