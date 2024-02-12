import java.util.Scanner;

public class Kataa {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println("Введите данные от 1/I до 10/X");
        String input = scan.nextLine();
        System.out.println("Результат:");
        System.out.println(calc(input));
     }
    public static String calc(String input) throws IllegalArgumentException{
        String[] parts = input.split("");
        if (parts.length !=3){
            throw new IllegalArgumentException("Я могу разобрать только 2 символа и 1 действие (6+9).");
}
        boolean isRoman1 = false;
        boolean isRoman2 = false;
        int num1, num2;
        int result;
        try {
            num2 = Integer.parseInt(parts[2]);
        }catch (IllegalArgumentException e){
            num2 = RomanNumerals.romToArab(parts[2]);
            isRoman1 = true;
        }
        try {
            num1 = Integer.parseInt(parts[0]);
        }catch (IllegalArgumentException e){
            num1 = RomanNumerals.romToArab(parts[0]);
            isRoman2 = true;
        }
        if (isRoman1 && isRoman2) {
        } else
        if (!isRoman1 && !isRoman2) {
        } else {
            throw new IllegalArgumentException("Значения должны быть в одном фомате (1+1/II+V)");
        }
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10){
            throw new IllegalArgumentException("Сейчас я понимаю диапазон от 1 до 10, но я ОБЯЗАТЕЛЬНО научусь большему");
        }
        char operation = parts[1].charAt(0);
        switch (operation){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num1 == 0 || num2 == 0){
                    throw new ArithmeticException("Я не умею делить на ноль...");
                }
                result = num1/num2;
                break;
            default:
                throw new IllegalArgumentException("Неизвестное действие");
        }
         if (!(isRoman1 && isRoman2)){
            return String.valueOf(result);
        }
        else return RomanNumerals.arabToRom(result);
}
}
class RomanNumerals {
    private static final String[] roman_Numerals = {"zero","I","II","III","IV","V",
            "VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII"
            ,"XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII",
            "XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI",
            "XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII","XLIV","XLV",
            "XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV",
            "LVI","LVII","LVIII","LIX","LX","LXI","LXII","LXIII","LXIV","LXV",
            "LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXII","LXXIII","LXXIV",
            "LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII","LXXXIII",
            "LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC","XCI","XCII","XCIII",
            "XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};

    public static int romToArab(String romanNumeral){
        String inputUp = romanNumeral.toUpperCase();
        for (int i = 0; i< roman_Numerals.length; i++){
            if (inputUp.equals(roman_Numerals[i])){
                return i;
            }

        }
        return 0;
    }
    public static String arabToRom(int arabNumeral){
        if (arabNumeral <= 0){
            throw new IllegalArgumentException("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
        }
        String arabNumber = roman_Numerals[arabNumeral];
        return arabNumber;
    }
}