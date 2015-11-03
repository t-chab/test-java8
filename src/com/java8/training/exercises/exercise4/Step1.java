package com.java8.training.exercises.exercise4;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created on 03/11/2015.
 */

class WordUtils {
    public static String nLetterWords(Stream<String> stream, int size) {
        return stream.filter(w -> w.length() == size).findFirst().orElse("");
    }

    public static String abcWord(Stream<String> stream) {
        return stream.filter((w) -> {
            final String word = w.toLowerCase();
            return word.contains("a") && word.contains("b") && word.contains("c");
        }).findFirst().orElse("");
    }

    public static boolean isOoWord(final String word) {
        return word.toLowerCase().contains("oo");
    }

    public static void storeTwitterList(String input, String output) throws IOException {
        final Path inputPath = Paths.get(input);
        final FileWriter fw = new FileWriter(output);

        Files.lines(inputPath)
                .filter(w -> w.toLowerCase().contains("wow") || w.toLowerCase().contains("cool"))
                .sorted()
                .map(String::toUpperCase)
                .map(w -> w + "!")
                .forEach(w -> writeToFile(fw, w));

        fw.close();
    }

    private static void writeToFile(FileWriter fw, String word) {
        try {
            fw.write(String.format("%s\n", word));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

class FolderUtils {
    public static long numPathsInTree(final String folderName) throws IOException {
        Path folderPath = Paths.get(folderName);
        Stream<Path> paths = Files.walk(folderPath);
        return paths.count();
    }
}

class Step1 {

    private static final String PATH_PREFIX = "W:\\";

    public static void main(String[] args) throws IOException {
        System.out.println("exercise4.Step1");
        final String fileName = "enable1-word-list.txt";
        final String fullFileName = PATH_PREFIX + fileName;
        final Path inputPath = Paths.get(fullFileName);
        Stream<String> stream = Files.lines(inputPath);

        int n = 10;
        System.out.println("First word of " + n + " letters found: " + WordUtils.nLetterWords(stream, 10));
        stream.close();

        Stream<String> stream2 = Files.lines(inputPath);
        System.out.println("First word which contains a,b and c or A, B and C: " + WordUtils.abcWord(stream2));
        stream2.close();

        final Path upperCaseFile = Paths.get(PATH_PREFIX + "fm-word-list.txt");
        Stream<String> stream3 = Files.lines(upperCaseFile);
        System.out.println("First word which contains a,b and c or A, B and C: " + WordUtils.abcWord(stream3));
        stream3.close();

        Stream<String> stream4 = Files.lines(inputPath);
        System.out.println("First word which contains oo, has 6 or more letters, and contains a b: ");
        final String result = stream4
                .filter(w -> (w.length() >= 6 && w.toLowerCase().contains("b")))
                .filter(WordUtils::isOoWord)
                .findFirst().orElse("");
        System.out.println(result);
        stream4.close();

        final String outFile = PATH_PREFIX + "twitter-words.txt";
        WordUtils.storeTwitterList(fullFileName, outFile);
        System.out.println("File " + outFile + " written.");

        System.out.println("There are  " + FolderUtils.numPathsInTree(PATH_PREFIX) + " files in directory " + PATH_PREFIX);
    }
}
