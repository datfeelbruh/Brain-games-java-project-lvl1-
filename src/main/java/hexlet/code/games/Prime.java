package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Arrays;
import java.util.Scanner;

public class Prime {
    public static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void start() {
        Engine.start();
        Scanner playerInput = new Scanner(System.in);
        String playerName = playerInput.nextLine();
        System.out.println("Hello, " + playerName + "!");
        System.out.println(DESCRIPTION);
        while (Engine.getRound() < Engine.MAXROUNDS) {
            int question = setQuestion();
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String answer = playerInput.nextLine();
            boolean check = checkAnswer(question, answer);
            String correctAnswer = answer.equals("yes") ? "no" : "yes";
            Engine.run(playerName, answer, check, correctAnswer);
        }
    }

    private static int setQuestion() {
        final int range = 50;
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
        return selectedArray == 0 ? primes[randomIndex] : notPrimes[randomIndex];
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
    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkAnswer(int num, String userAnswer) {
        if (isPrime(num) && userAnswer.equals("yes")) {
            return true;
        } else {
            return !isPrime(num) && userAnswer.equals("no");
        }
    }
}
