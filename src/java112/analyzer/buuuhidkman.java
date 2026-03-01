//found this while trying to find a way to split strings apart on multiple indices. IT'LL DO!
/**public class Main {
    public static void main(String[] args) {
        String originalString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int INDICE = 5;

        int startIndex = 0;
        int checkIndex = originalString.length() / INDICE;
        for (int i = 0; i < checkIndex; i++) {
            int endIndex = INDICE * (i + 1);
            if (endIndex > originalString.length()) {
                endIndex = originalString.length(); // Handle cases where slice point exceeds string length
            }
            String sub = originalString.substring(startIndex, endIndex);
            System.out.println("Slice " + (i + 1) + ": " + sub);
            startIndex = endIndex;
        }

        // Get the remaining part if any
        if (startIndex < originalString.length()) {
            String remaining = originalString.substring(startIndex);
            System.out.println("Remaining part: " + remaining);
        }
    }
}
*/