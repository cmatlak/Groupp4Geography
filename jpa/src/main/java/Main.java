import jakarta.persistence.*;

import java.util.Currency;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        System.out.println("test");
        EntityManager em = JPAUtil.getEntityManager();

        System.out.print("Enter search term: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        // Validate user input
        if (name == null || name.isEmpty()) {
            System.out.println("Invalid input.");
            return;
        }

        TypedQuery<Currency> query = em.createQuery("SELECT c FROM Currency c WHERE c.currencyName = :name", Currency.class);
        query.setParameter("name", name);
        List<Currency> countries = query.getResultList();
        countries.forEach(System.out::println);

        em.close();
    }

    static void inTransaction(Consumer<EntityManager> work) {
        try (EntityManager entityManager = JPAUtil.getEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                work.accept(entityManager);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw e;
            }
        }
    }
}
