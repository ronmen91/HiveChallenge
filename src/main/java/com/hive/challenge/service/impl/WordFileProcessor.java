package com.hive.challenge.service.impl;

import com.hive.challenge.Main;
import com.hive.challenge.domain.Occurrence;
import com.hive.challenge.service.FileProcessor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A concrete implementation of FileProcessor
 */
public class WordFileProcessor implements FileProcessor<Map<String, Occurrence>> {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);
  private Path inputFilePath;
  private Path outputFilePath;

  private final String INPUT_FILE_ERROR = "The input file cannot be opened.";
  private final String OUTPUT_FILE_ERROR = "The output file cannot be opened.";

  public WordFileProcessor(Path inputFilePath, Path outputFilePath) {
    this.inputFilePath = inputFilePath;
    this.outputFilePath = outputFilePath;
  }

  /**
   * It reads the input file containing new line separated words and create a {@link Map} to
   * with the words as keys and {@link Occurrence} objects as values
   *
   * @return {@literal Map<String, Occurrence>} as an internal data structure
   */
  @Override
  public Map<String, Occurrence> readInputFile () {
    Map<String, Occurrence> words = new HashMap<>();

    try (BufferedReader reader = Files.newBufferedReader(inputFilePath)) {
      String inputWord;

      int lineNumber = 1;

      while ((inputWord = reader.readLine()) != null) {
        if(words.containsKey(inputWord)) {
          Occurrence occurrence = words.get(inputWord);
          occurrence.wordOccuredAgain(lineNumber);
        } else {
          words.put(inputWord, new Occurrence(lineNumber));
        }
        lineNumber++;
      }
    } catch (IOException e) {
      logger.error(INPUT_FILE_ERROR);
    }

    return  words;
  }

  /**
   * It writes the processed words to the output file
   * @param outputWords - the processed words
   */
  @Override
  public void writeToOutputFile(List<String> outputWords) {
    try (BufferedWriter writer = Files.newBufferedWriter(outputFilePath))
    {
      for(String word: outputWords) {
        writer.write(word);
        writer.newLine();
      }
    } catch (IOException e) {
      logger.error(OUTPUT_FILE_ERROR);
    }
  }
}
