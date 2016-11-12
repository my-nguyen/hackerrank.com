import java.util.*;

class HikingSelfies {
    static int factorial(int number)
    {
        int product = 1;
        for (int i = 2; i <= number; i++)
            product *= i;
        return product;
    }

    static int combinations(int total, int select) {
        return factorial(total) / (factorial(select)*factorial(total-select));
    }

    static int calculate(int friends, int frames) {
        int sum = 0;
        for (int i = 0; i < friends; i++) {
            sum += combinations(friends, i);
        }
        return Math.abs(sum - frames);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int friends = scanner.nextInt();
        int frames = scanner.nextInt();
        System.out.println(calculate(friends, frames));
    }
}
