import java.util.LinkedHashMap;
import java.util.Map.Entry;

class Solution {
    private LinkedHashMap<Integer, String> mapping;

    public Solution() {
        this.mapping = new LinkedHashMap<>();
        this.mapping.put(1000, "M");
        this.mapping.put(900, "CM");
        this.mapping.put(500, "D");
        this.mapping.put(400, "CD");
        this.mapping.put(100, "C");
        this.mapping.put(90, "XC");
        this.mapping.put(50, "L");
        this.mapping.put(40, "XL");
        this.mapping.put(10, "X");
        this.mapping.put(9, "IX");
        this.mapping.put(5, "V");
        this.mapping.put(4, "IV");
        this.mapping.put(1, "I");
    }

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        for (Entry<Integer, String> entry : this.mapping.entrySet()) {
            if (num <= 0) {
                break;
            }
            if (num >= entry.getKey()) {
                int c = num / entry.getKey();
                for (int i = 0; i < c; i++) {
                    roman.append(entry.getValue());
                }
                num -= entry.getKey() * c;
            }
        }
        return roman.toString();
    }
}