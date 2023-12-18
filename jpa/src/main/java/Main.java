import jakarta.persistence.*;

import java.util.Currency;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        Menu.choice();




    }

}
