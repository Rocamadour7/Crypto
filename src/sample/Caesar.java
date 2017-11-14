package sample;

class Caesar {

    private static final String ALPHABET = "abcdefghijklmnñopqrstuvwxyz ";
    private int shift;

    public Caesar(String key) {
        setShift(key);
    }

    public int getShift() { return shift; }

    void setShift(String key) {
        int sum = 0;
        int index;

        String lowercaseText = key.toLowerCase().trim().replaceAll("\\s+", "");

        for(int i = 0; i<lowercaseText.length(); i++) {
            char ch = lowercaseText.charAt(i);

            if(Character.isLetter(ch)) {
                index = ALPHABET.indexOf(ch) + 1;
            } else if (Character.isDigit(ch)) {
                index = Integer.parseInt(String.valueOf(ch));
            } else {
                index = 0;
            }

            sum += index;
        }

        String sumString = String.valueOf(sum);
        sum = 0;

        for(int j = 0; j<sumString.length(); j++) {
            char sumChar = sumString.charAt(j);
            sum += Integer.parseInt(String.valueOf(sumChar));
        }

        shift = sum;
    }

    String encrypt(String plainText) {

        plainText = plainText.toLowerCase();
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
            int keyVal = (shift + charPosition) % ALPHABET.length();
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText.append(replaceVal);
        }

        return cipherText.toString();
    }

    String decrypt(String cipherText) {

        cipherText = cipherText.toLowerCase();
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shift) % ALPHABET.length();

            if (keyVal < 0) {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText.append(replaceVal);
        }

        return plainText.toString();
    }
}