import java.util.Scanner;
public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculateContribution();
    }
    double calculateComplexPercentFunction(double amount, double yearRate, int depositPeriod) {
        double totalSum = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundNumber(totalSum,2);
    }
    double CalculateSimplePercentFunction(double amount, double yearRate, int depositPeriod) {
        return roundNumber(amount + amount * yearRate * depositPeriod,2);
    }
    double roundNumber(double value,int places) {
        double scale = Math.pow(10, places); //rounding- округление
        return Math.round(value * scale) / scale;
    }

    void calculateContribution( ) {
        Scanner scanner = new Scanner(System.in);
        int period;
        int action;


        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

         double totalSum = 0;
        if (action ==1){
             totalSum = CalculateSimplePercentFunction(amount, 0.06, period);

        } else if (action == 2) {
             totalSum = calculateComplexPercentFunction(amount, 0.06, period);
        }
            System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + totalSum);
    }
}
