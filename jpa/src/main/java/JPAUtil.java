import jakarta.persistence.*;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class JPAUtil {
    private static final EntityManagerFactory emf;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31;1m";
    public static final String ANSI_GREEN = "\u001B[32;1m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String KURV = "\u001B[3m";
    public static final String BOLD = "\u001B[1m";
    public static final String Back_LithGrow = "\u001B[107m";
    static Scanner scanner = new Scanner(System.in);


    static {
        emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
        Runtime.getRuntime().addShutdownHook(new Thread(emf::close));
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    public static void searchCountry() {
        EntityManager em = JPAUtil.getEntityManager();
        System.out.print("Enter search term: ");
        String name = scanner.nextLine();

        // Validate user input
        if (name == null || name.isEmpty()) {
            System.out.println("Invalid input.");
            return;
        }

        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c WHERE c.countryName = :name", Country.class);
        query.setParameter("name", name);
        List<Country> currencies = query.getResultList();
        currencies.forEach(System.out::println);

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


    public static void createCountry() {
        System.out.println("Enter the country name");
        String countryName = scanner.nextLine();
        System.out.println("Enter country code");
        String countryCode = scanner.nextLine();
        System.out.println("Enter the continent it belongs to");
        String continent = scanner.nextLine();
        System.out.println("Enter the country's area in km2");
        int area = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the type of government that runs the country");
        String governmentType = scanner.nextLine();
        System.out.println("Enter the head of government");
        String governmentHead = scanner.nextLine();
        System.out.println("Enter the state religion");
        String stateReligion = scanner.nextLine();

        inTransaction(entityManager -> {
            Country country = new Country();
            country.setCountryName(countryName);
            country.setCountryCode(countryCode);
            country.setContinent(continent);
            country.setAreaInKm2(area);
            country.setGovernmentType(governmentType);
            country.setGovernmentHead(governmentHead);
            country.setStateReligion(stateReligion);
            entityManager.persist(country);
        });
    }

    public static void readAllCountries() {
        inTransaction(entityManager -> {
            List<Country> countries = entityManager.createQuery("SELECT c FROM Country c", Country.class)
                    .getResultList();

            if (countries.isEmpty()) {
                System.out.println("No countries found in the database.");
            } else {
                System.out.format(Back_LithGrow + BOLD + ANSI_RED + "%-15s%-15s%-15s%-45s%-45s%-30s%-30s%-15s%n",
                        "CountryName", "CountryCode", "Continent",
                        "GovernmentType", "GovernmentHead", "AreaInKm2", "StateReligion", "Id" + ANSI_RESET);

                for (Country c : countries) {
                    System.out.format(ANSI_GREEN + "%-15s%-15s%-15s%-45s%-45s%-30s%-30s%-15s%n",
                            c.getCountryName(), c.getCountryCode(), c.getContinent(),
                            c.getGovernmentType(), c.getGovernmentHead(), c.getAreaInKm2(),
                            c.getStateReligion(), c.getCountryId() + ANSI_RESET);
                }
            }

            System.out.println("\nChoose an option in the menu");
        });
    }


    public static void updateCountry(String governmentHead, String governmentType, String countryName, int id) {
        inTransaction(entityManager -> {
            Country c = entityManager.find(Country.class, id);

            if (c != null) {
                c.setGovernmentHead(governmentHead);
                c.setGovernmentType(governmentType);
                c.setCountryName(countryName);
            }
        });


    }

    public static void deleteCountry() {
        System.out.println("Select country id to remove:");
        int id = scanner.nextInt(); // Läser in användar-input som ett heltal

        inTransaction(entityManager -> {
            Country c = entityManager.find(Country.class, id);
            if (c != null) {
                System.out.println(c + " Successfully removed");
                entityManager.remove(c);
            } else {
                System.out.println("Country not found with ID: " + id);
            }
        });

    }

    public static void capitalDensity(int id) {

        inTransaction(entityManager -> {
            int population;
            int areaCapital;
            String capitalName;
            Capital ca = entityManager.find(Capital.class, id);
            if (ca != null) {
                population = ca.getCapitalPopulation();
                areaCapital = ca.getAreaInKm2();
                capitalName = ca.getCapitalName();

                if (areaCapital > 0 && population > 0) {
                    int density = (int) population / areaCapital;
                    System.out.println(Back_LithGrow+ANSI_RED+BOLD
                     +"There are "+ density + " people living per km2 " + capitalName + "\n" + ANSI_RESET);
                } else {
                    System.out.println("Invalid population or areaCapital values");
                }
            }
        });
    }
}





