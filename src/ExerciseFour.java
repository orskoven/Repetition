public class ExerciseFour {

    public static void main(String[] args) {
        int fiveYearsInSeconds = 60 * 60 * 24 * 365 * 5;
        int numberOfBirthsInFiveYears = fiveYearsInSeconds / 7;
        int numberOfDeathsInFiveYears = fiveYearsInSeconds / 13;
        int populationOfUSA2021 = 331002651;

        int projectedPopulationInFiveYears = numberOfBirthsInFiveYears - numberOfDeathsInFiveYears + populationOfUSA2021;
        System.out.println("THE SUM IN FIVE YEARS: " + projectedPopulationInFiveYears);
        int growthOfPopulationPerFiveYears = (projectedPopulationInFiveYears - populationOfUSA2021);
        double growthInPercent = ((double) growthOfPopulationPerFiveYears / projectedPopulationInFiveYears) * 100;
        System.out.printf("THE GROWTH PER FIVE YEARS: " + growthOfPopulationPerFiveYears + " (%.2f%s)", growthInPercent, "%");

    }
}
