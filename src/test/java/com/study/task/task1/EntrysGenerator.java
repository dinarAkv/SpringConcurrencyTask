package com.study.task.task1;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class EntrysGenerator {
    /**
     * Method return random word with specified length.
     * @param length - number of characters in word.
     * @return - random word.
     */
    private String getRandomWord(int length) {
        String r = "";
        for(int i = 0; i < length; i++) {
            r += (char)(Math.random() * 26 + 97);
        }
        return r;
    }

    /**
     * Function generate key-value pairs of words.
     * @param wordLength - generated words length.
     * @param keyValNum - number of key-values.
     * @return - array of key-value arrays. [[key, value], ...]
     */
    private String[][] generateRandomKeyValue(int wordLength, int keyValNum) {
        String[][] pairs = new String[keyValNum][2];
        for (int i = 0; i < keyValNum; i++) {
            pairs[i] = new String[]{getRandomWord(wordLength), getRandomWord(wordLength)};
        }
        return pairs;
    }

    /**
     * Method write key value pairs in file as pattern: key-value.
     * @param keyVal - array of key/value arrays. [[key, value], ...]
     * @param fileName - name of file where key/value will write.
     */
    private void writeWordsInFile(String[][] keyVal, String fileName) {
        try(PrintWriter pw = new PrintWriter(fileName)) {
            Arrays.stream(keyVal)
                    .forEach(entry -> pw.println(entry[0] + "-" + entry[1]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method generate random key word and random value word.
     * Than it will write generated pairs
     * in file with pattern for every line: key-value.
     * @param wordLen - length of generated random word.
     * @param keyValNum - number of generated key-value pairs.
     * @param fileName - name of file where generated pairs will write.
     * @return - array of key/value arrays. [[key, value], ...]
     */
    public String[][] generateAndWriteInFile(int wordLen, int keyValNum, String fileName) {
        String[][] entries = generateRandomKeyValue(wordLen, keyValNum);
        writeWordsInFile(entries, fileName);
        return entries;
    }
}
