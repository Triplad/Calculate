import java.util.TreeMap;

public class Convert {
    TreeMap<Integer, String> arabianNumbers = new TreeMap<>();
    TreeMap<Character, Integer> romanNumbers = new TreeMap<>();

    public Convert() {


        arabianNumbers.put(1, "I");
        arabianNumbers.put(4, "IV");
        arabianNumbers.put(5, "V");
        arabianNumbers.put(9, "IX");
        arabianNumbers.put(10, "X");
        arabianNumbers.put(40, "XL");
        arabianNumbers.put(50, "L");
        arabianNumbers.put(90, "XC");
        arabianNumbers.put(100, "C");
        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);

    }


    public boolean isRoman(String number){
        return romanNumbers.containsKey(number.charAt(0));
    }

    public String intToRoman(int number) throws Exception {
    if (number <= 0) throw new Exception("т.к. в римской системе нет отрицательных чисел");
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabianNumbers.floorKey(number);
            roman += arabianNumbers.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);

        return roman;


    }
    public int romanToInt(String romanNumber) {
        int end = romanNumber.length() - 1; // END=1 romanNumber="IV"
        char[] arr = romanNumber.toCharArray(); //{'I', 'V'} [2]
        int currentArabian;
        char lastSymbol = arr[end]; //lastSymbol = V;
        int result = romanNumbers.get(lastSymbol); // RESULT=5 //lastSymbol всё еще ровняется V;

        for (int i = end - 1; i >= 0; i--) { // end=1 arr={I, V} i=0
            char currentSymbol = arr[i]; // I
            currentArabian = romanNumbers.get(currentSymbol); // arr[0]=I arabian=1

            char nextSymbol = arr[i + 1];
            if (currentArabian < romanNumbers.get(nextSymbol)) { //arr[1]=V romanNumbers.get('V')=5
                result = result - currentArabian; //4
            } else {
                result = result + currentArabian;
            }

        }

        return result;

    }
}