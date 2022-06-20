package hexlet.code.games;
import hexlet.code.Cli;

import java.util.Arrays;

public class Prime {
    public static void start() {
        Cli.greeting();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'..");
        run();
    }
    private static void run() {
        final int maxRounds = 3;
        final int range = 50;
        int rounds = 0;
        while (rounds < maxRounds) {
            // Массив чисел для генерации
            int[] numbers = numbersForRange(range);
            // Простые числа
            int[] primes = primeNumbers(numbers);
            // Массив чисел numbers без простых
            int[] notPrimes = getWithoutPrimes(numbers, primes);
            // Выбираем рандомный индекс
            int randomIndex = (int) (Math.random() * primes.length);
            // Выбираем из какого массива будем брать число 0 - простые, 1 - не простые
            int selectedArray = (int) (Math.round(Math.random()));
            // Объявляем значение загаданного числа
            int number = selectedArray == 0 ? primes[randomIndex] : notPrimes[randomIndex];
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String answer = Cli.getUserInput().nextLine();
            if (checkAnswer(number, answer))  {
                System.out.println("Correct!");
                if (rounds == 2) {
                    System.out.println("Congratulation, " + Cli.getPlayerName() + " !");
                }
                rounds++;
            } else {
                String correctAnswer = answer.equals("yes") ? "no" : "yes";
                System.out.println("'" + answer + "'" + " is wrong answer ;(. "
                        + "Correct answer was " + "'" + correctAnswer + "'.\n"
                        + "Let's try again, " + Cli.getPlayerName());
                rounds = maxRounds;
            }

        }

    }
    // Генерируем массив чисел до range
    private static int[] numbersForRange(int range) {
        // Задаем длину массива чисел равной переданному расстоянию
        int[] numbers = new int[range];
        int start = 2;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = start + i;
        }
        return numbers;
    }
    // Генерируем массив простых чисел из массива числе до range
    private static int[] primeNumbers(int[] numbers) {
        int size = numbers.length;
        int[] primes = new int[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (isPrime(numbers[i])) {
                primes[index] = numbers[i];
                index++;
            }
        }
        return Arrays.copyOfRange(primes, 0, index);
    }
    /*
     Генерируем массив БЕЗ простых чисел.
     Его длина будет равна длине массива простых чисел для того чтобы максимальный индекс был одинаковым
     */
    private static int[] getWithoutPrimes(int[] numbers, int[] primes) {
        int[] numbersWithoutPrimes = new int[numbers.length];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (!isPrime(numbers[i])) {
                numbersWithoutPrimes[index] = numbers[i];
                index++;
            }
        }
        return Arrays.copyOfRange(numbersWithoutPrimes, 0, primes.length);
    }
    // Проверка числа на простоту
    private static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkAnswer(int number, String userAnswer) {
        if (isPrime(number) && userAnswer.equals("yes")) {
            return true;
        } else {
            return !isPrime(number) && userAnswer.equals("no");
        }
    }
}
