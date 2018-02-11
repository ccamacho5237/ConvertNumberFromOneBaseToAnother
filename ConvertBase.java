import java.util.Scanner;
public class ConvertBase
{
    public static int baseBToDecimal(char input) {
        if (input >= '0' && input <= '9') {
            return Integer.parseInt(input + "");
        } else {
            return (int) (input - 'a') + 10;
        }
    }
 
    public static char decimalToBaseB(int input) {
        if (input >= 0 && input <= 9) {
            String str = String.valueOf(input);
            return str.charAt(0);
        } else {
            return (char) ('a' + (input - 10));
        }
    }
 
    public static int toDecimal(String input, int base) {
        int length = input.length();
        int decimal = 0;
        for (int placeValue = 0, index = length - 1; index >= 0; placeValue++, index--) {
            decimal = decimal + baseBToDecimal(input.charAt(index)) * (int) (Math.pow(base, placeValue));
        }
        return decimal;
    }
 
    public static String toBaseB(int input, int base) {
        String result = "";
        while (input > 0) {
            int remainder = input % base;
            input = input / base;
            result = decimalToBaseB(remainder) + result;
        }
        return result;
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese base de entrada: ");
        int inputBase = scanner.nextInt();
        System.out.print("Ingrese el numero en la base de entrada: ");
        String inputNumber = scanner.next();
        System.out.print("Ingrese base de salida: ");
        int outputBase = scanner.nextInt();
        int decimal = toDecimal(inputNumber, inputBase);
        String output = toBaseB(decimal, outputBase);
        System.out.println("Resultado = " + output);
    }
}
