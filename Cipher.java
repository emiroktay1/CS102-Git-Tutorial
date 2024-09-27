// This class is used for encrypting or decrypting strings using character mapping
public class Cipher {

    // Strings for keeping the alphabets, one for the original letters and the other for the encrypted ones
    public static final String ORIGINAL_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String CIPHER_ALPHABET = "dfxyhrklvwuasgimnojpqetbcz";

    public String encrypt(String inputString) {
        // output string will be collected in this variable
        String outputString = "";

        // for all chars in the input string
        for (int i = 0; i < inputString.length(); i++) {
            outputString += replaceChar(inputString.charAt(i), true);
        }
        return outputString;
    }

    public String decrypt(String inputString) {
        // output string will be collected in this variable
        String outputString = "";

        // for all chars in the input string
        for (int i = 0; i < inputString.length(); i++) {
            outputString += replaceChar(inputString.charAt(i), false);
        }
        return outputString;
    }

    // replaces the given input char based on the given isEncrypt variable
    // if isEncrypt == true -> original to encrypted
    // if isEncrypt == false -> encrypted to original
    private char replaceChar(char inputChar, boolean isEncrypt) {
        if (Character.isLetter(inputChar)) {
            char lowerChar = Character.toLowerCase(inputChar); // handle uppercase letters
            if (isEncrypt) {
                for (int i = 0; i < ORIGINAL_ALPHABET.length(); i++) {
                    if (ORIGINAL_ALPHABET.charAt(i) == lowerChar) {
                        return CIPHER_ALPHABET.charAt(i);
                    }
                }
            } else {
                for (int i = 0; i < CIPHER_ALPHABET.length(); i++) {
                    if (CIPHER_ALPHABET.charAt(i) == lowerChar) {
                        return ORIGINAL_ALPHABET.charAt(i);
                    }
                }
            }
        }

        // return the input char if it's not in the alphabet (like spaces or punctuation)
        return inputChar;
    }
}
