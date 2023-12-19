package entity;

import java.util.*;


public class Quiz {
   Scanner scanner = new Scanner(System.in);

    private final RandomCountry countryGenerator;


    public Quiz(RandomCountry countryGenerator) {

        this.countryGenerator = countryGenerator;
    }



    public void startQuiz() {

        List<String> usedCountries = new ArrayList<>();
        int j=0;
        System.out.println("Welcome to the mega fun geography quiz!!!");



        for (int i = 0; i <3 ; i++) {
            Country randomCountry; 
            String tempel;

            do {
                randomCountry = countryGenerator.getRandomCountry();
                tempel = randomCountry.getCountryName();
            } while (usedCountries.contains(tempel));

            usedCountries.add(tempel);

            System.out.println("Question: Name the capital in: " + randomCountry.getCountryName());
            String answerCapital = scanner.nextLine();
                if(Objects.equals(answerCapital, randomCountry.getCapital())) {
                j = j + 1;
                System.out.println("Correct!"+"\n"+"Your score: "+j);
            } else System.out.println("Wrong!");

        }





    }
}


