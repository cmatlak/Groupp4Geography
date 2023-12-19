import java.util.Scanner;


public class Quiz {
    private final RandomCountry countryGenerator; // Använd rätt namn för din randomCountry-klass

    public Quiz(RandomCountry countryGenerator) {
        this.countryGenerator = countryGenerator;
    }
    Scanner scanner = new Scanner(System.in);
    public void startQuiz() {
        // Hämta ett slumpmässigt land från randomCountry-klassen
        Country randomCountry = countryGenerator.getRandomCountry();

        // Använd det slumpmässiga landet i din quizlogik
        System.out.println("Quiz startar...");
        System.out.println("Fråga: Vad är huvudstaden i " + randomCountry.getCountryName() + "?");
        // Lägg till mer logik för att hantera svaret eller ställa fler frågor...
        String answerCapital = scanner.nextLine();

    }
}


