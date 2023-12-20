package entity;

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
        List<Country> countries = query.getResultList();
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
    public static void showLanguage() {
        System.out.println("Which country id do you want to check language on?");
        int id = scanner.nextInt();
        scanner.nextLine();
        inTransaction(entityManager -> {
            String language;
            String root;
            String country;
            Language l = entityManager.find(Language.class, id);
            Country c = entityManager.find(Country.class, id);
            if (l != null) {
                language = l.getLanguage();
                root = l.getLanguageRoot();
                country = c.getCountryName();
                System.out.println(Back_LithGrow + ANSI_RED + BOLD
                        + "In " + country + " They speak " + language + " That roots out of " + root + "\n" + ANSI_RESET);
            }
        });
    }
    public static void readAllContinents() {
        inTransaction(entityManager -> {
            List<Continent> continents = entityManager.createQuery("SELECT c2 FROM Continent c2", Continent.class)
                    .getResultList();

            if (continents.isEmpty()) {
                System.out.println("No continents found in the database.");
            } else {
                System.out.format(Back_LithGrow + BOLD + ANSI_RED + "%-25s%-25s%-25s%-40s%-15s%n",
                        "ContinentName", "numberOfTimezones", "geoLocation",
                        "numberOfCountries", "Id" + ANSI_RESET);

                for (Continent c2 : continents) {
                    System.out.format(ANSI_GREEN + "%-25s%-25s%-25s%-40s%-15s%n",
                            c2.getContinentName(), c2.getNumberOfTimezones(), c2.getGeoLocation(),
                            c2.getNumberOfCountries(),
                            c2.getId()
                                    + ANSI_RESET);
                }
            }

            System.out.println("\nChoose an option in the menu");
        });
    }
    public static void populationDensity() {
        System.out.println("which country id do you want to check population density on? ");
        int id = scanner.nextInt();
        scanner.nextLine();
        inTransaction(entityManager -> {
            int population;
            int areaInKm2;

            Country c = entityManager.find(Country.class, id);
            if (c != null) {
                population = c.getPopulation();
                areaInKm2 = c.getAreaInKm2();
                String name = c.getCountryName();
                if (areaInKm2 > 0 && population > 0) {
                    int density =  population / areaInKm2;
                    System.out.println(Back_LithGrow + ANSI_RED + BOLD
                            + "There are " + density + " people living per km2 " + name + "\n" + ANSI_RESET);
                } else {
                    System.out.println("Error");
                }
            }
        });
    }
    public static void createCountry() {
        System.out.println("Enter the country name");
        String countryName = scanner.nextLine();
        System.out.println("Enter country code");
        String countryCode = scanner.nextLine();
        System.out.println("Enter the capital");
        String capital= scanner.nextLine();
        System.out.println("Enter the government type");
        String governmentType= scanner.nextLine();
        System.out.println("Enter the population");
        Integer population= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the country's area in km2");
        int area = scanner.nextInt();
        scanner.nextLine();

        inTransaction(entityManager -> {
            Country country = new Country();
            country.setCountryName(countryName);
            country.setCountryCode(countryCode);
            country.setCapital(capital);
            country.setGovernmentType(governmentType);
            country.setPopulation(population);
            country.setAreaInKm2(area);

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
                System.out.format(Back_LithGrow + BOLD + ANSI_RED + "%-25s%-25s%-25s%-40s%-20s%-20s%-15s%n",
                        "CountryName", "CountryCode", "Capital",
                        "GovernmentType", "Population", "AreaInKm2", "Id" + ANSI_RESET);

                for (Country c : countries) {
                    System.out.format(ANSI_GREEN + "%-25s%-25s%-25s%-40s%-20s%-20s%-15s%n",
                            c.getCountryName(), c.getCountryCode(), c.getCapital(),
                            c.getGovernmentType(), c.getPopulation(), c.getAreaInKm2(),
                            c.getId()
                            + ANSI_RESET);
                }
            }

            System.out.println("\nChoose an option in the menu");
        });
    }





    public static void updateCountry() {
        System.out.println("Enter country id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the country name");
        String countryName = scanner.nextLine();
        System.out.println("Enter the capital");
        String capital= scanner.nextLine();
        System.out.println("Enter the government type");
        String governmentType= scanner.nextLine();
        System.out.println("Enter the population");
        Integer population= scanner.nextInt();
        scanner.nextLine();
        inTransaction(entityManager -> {
            Country c = entityManager.find(Country.class, id);

            if (c != null) {
                c.setCountryName(countryName);
                c.setCapital(capital);
                c.setPopulation(population);
                c.setGovernmentType(governmentType);
            }
        });


    }

    public static void deleteCountry() {
        System.out.println("Select country id to remove:");
        int id = scanner.nextInt();

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

    public static void populationDensity(int id) {

        inTransaction(entityManager -> {
            int population;
            int areaInKm2;

            Country c = entityManager.find(Country.class, id);
            if (c != null) {
                population = c.getPopulation();
                areaInKm2 = c.getAreaInKm2();
                 String name = c.getCountryName();
                if (areaInKm2 > 0 && population > 0) {
                    int density =  population / areaInKm2;
                    System.out.println(Back_LithGrow + ANSI_RED + BOLD
                            + "There are " + density + " people living per km2 " + name + "\n" + ANSI_RESET);
                } else {
                    System.out.println("Error");
                }
            }
        });
    }



    public static void createCurrency() {


        System.out.println("Enter currency name");
        String currencyName = scanner.nextLine();
        System.out.println("Enter ISO4217 code");
        String ISO = scanner.nextLine();
        System.out.println("Enter sub-currency");
        String subC = scanner.nextLine();
        System.out.println("Enter cost of one Euro");
        String euro = scanner.nextLine();
        ;


        inTransaction(entityManager -> {
            Currency currency = new Currency();
            currency.setCurrencyName(currencyName);
            currency.setEuroCost(ISO);
            currency.setSubCurrency(subC);
            currency.setEuroCost(euro);

            entityManager.persist(currency);
        });
    }

    public static void createLanguage() {
        System.out.println("Enter the language");
        String languageName = scanner.nextLine();
        System.out.println("Enter language origin");
        String languageRoot = scanner.nextLine();
        System.out.println("Enter the type of alphabet");
        String alphabet = scanner.nextLine();


        inTransaction(entityManager -> {
            Language language = new Language();
            language.setLanguage(languageName);
            language.setLanguageRoot(languageRoot);
            language.setAlphabet(alphabet);
            entityManager.persist(language);
        });
    }

    public static void readAllReligion() {
        inTransaction(entityManager -> {
            List<Religion> religions = entityManager.createQuery("SELECT r FROM Religion r", Religion.class)
                    .getResultList();

            if (religions.isEmpty()) {
                System.out.println("No religions found in the database.");
            } else {
                System.out.format(Back_LithGrow + BOLD + ANSI_RED + "%-25s%-25s%-25s%-15s%n",
                        "religionName", "holybook", "countryOfOrigin",
                         "Id" + ANSI_RESET);

                for (Religion r : religions) {
                    System.out.format(ANSI_GREEN + "%-25s%-25s%-25s%-15s%n",
                            r.getReligionName(), r.getHolyBook(), r.getCountryOfOrigin(),
                            r.getId()
                                    + ANSI_RESET);
                }
            }

            System.out.println("\nChoose an option in the menu");
        });

}
}








