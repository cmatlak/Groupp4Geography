import java.util.Scanner;


public class Menu {

    public static void choice(){
        Scanner scanner = new Scanner(System.in);

        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31;1m";
        String ANSI_GREEN = "\u001B[32;1m";
        String ANSI_BLUE = "\u001B[34m";
        String KURV = "\u001B[3m";
        String BOLD = "\u001B[1m";
        String Back_LithGrow = "\u001B[107m";
        String[] meny1 = {
                "1 - Add a country",
                "2 - Show countries",
                "3 - Update country",
                "4 - Delete country",

        };
        String[] meny2 = {
                "5 - Show capital density",
                "6 - Show languages of a country",
                "7 - Country quiz",
                "E - Exit"

        };

        boolean running = true;

        do {
            menu(meny1, ANSI_GREEN, BOLD, meny2, ANSI_RESET);
            String action = scanner.nextLine();

            switch (action){
                case "1" -> JPAUtil.createCountry();

                case "2" -> JPAUtil.readAllCountries();

                case "3" -> JPAUtil.updateCountry("Joe Biden", "Dictatorship", "United States", 1);

                case "4" -> JPAUtil.deleteCountry();

                case "5" -> JPAUtil.capitalDensity(1);

                case "6" -> JPAUtil.searchCountry();

                case "7" -> JPAUtil.searchCountry();

                case "e","E" -> running = false;
            }

            }
        while (running); {
            System.out.println("See ya later, alligator");
        }

    }

    private static void menu(String[] menu1, String ANSI_GREEN, String BOLD, String[] meny2, String ANSI_RESET) {
        int j = 0;
        for (int i = 0; i < menu1.length; i++, j++) {
            System.out.format(ANSI_GREEN + BOLD + "%-60s%-70s%n", menu1[i], meny2[j] + ANSI_RESET);
        }
    }
}
