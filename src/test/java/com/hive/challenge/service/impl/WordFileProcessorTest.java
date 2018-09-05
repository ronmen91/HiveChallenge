package com.hive.challenge.service.impl;

import com.hive.challenge.domain.Occurrence;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordFileProcessorTest {
  private WordFileProcessor underTest;
  private static final Logger logger = LoggerFactory.getLogger(WordFileProcessorTest.class);

  private static final String INPUT_PATH_FOR_EMPTY_FILE = "test/testWordsEmpty.txt";
  private static final String INPUT_PATH_FOR_ONE_OCCURENCE = "test/testWordsOnlyOneOccurrence.txt";
  private static final String INPUT_PATH_FOR_NORMAL_FILE = "test/testWordsNormal.txt";
  private static final String OUTPUT_PATH = "test/outputWords.txt";

  private static final int NUM_OF_WORDS_IN_ONE_OCCURRENCE_FILE = 10;
  private static final int NUM_OF_WORDS_IN_NORMAL_FILE = 11;

  private static final int NUM_OF_OCCURRENCE_OF_DATE_IN_NORMAL_FILE = 3;
  private static final int LAST_OCCURRENCE_OF_DATE_IN_NORMAL_FILE = 15;
  private static final int NUM_OF_OCCURRENCE_OF_CAPTAIN_IN_NORMAL_FILE = 3;
  private static final int LAST_OCCURRENCE_OF_CAPTAIN_IN_NORMAL_FILE = 12;
  private static final int NUM_OF_OCCURRENCE_OF_CAPITAL_ENJOY_IN_NORMAL_FILE = 1;
  private static final int LAST_OCCURRENCE_OF_CAPITAL_ENJOY_IN_NORMAL_FILE = 18;
  private static final int NUM_OF_OCCURRENCE_OF_ENJOY_IN_NORMAL_FILE = 1;
  private static final int LAST_OCCURRENCE_OF_ENJOY_IN_NORMAL_FILE = 13;

  @Test
  public void testReadEmptyInputFile() {
    //GIVEN
    initializeWordFileProcessor(INPUT_PATH_FOR_EMPTY_FILE);
    //WHEN
    Map<String, Occurrence> words = underTest.readInputFile();
    //THEN
    Assert.assertEquals(0, words.size());
  }

  @Test
  public void testReadOneOccurrenceInputFile() {
    //GIVEN
    initializeWordFileProcessor(INPUT_PATH_FOR_ONE_OCCURENCE);
    //WHEN
    Map<String, Occurrence> words = underTest.readInputFile();
    //THEN
    Assert.assertEquals(NUM_OF_WORDS_IN_ONE_OCCURRENCE_FILE, words.size());
    for (Entry<String, Occurrence> word : words.entrySet()) {
      Assert.assertEquals(1, word.getValue().getNumOfOccurence());
    }
  }

  @Test
  public void testReadNormalInputFile() {
    //GIVEN
    initializeWordFileProcessor(INPUT_PATH_FOR_NORMAL_FILE);
    //WHEN
    Map<String, Occurrence> words = underTest.readInputFile();
    //THEN
    Assert.assertEquals(NUM_OF_WORDS_IN_NORMAL_FILE, words.size());
    Assert.assertEquals(NUM_OF_OCCURRENCE_OF_DATE_IN_NORMAL_FILE, words.get("date").getNumOfOccurence());
    Assert.assertEquals(LAST_OCCURRENCE_OF_DATE_IN_NORMAL_FILE, words.get("date").getLastOccurrence());
    Assert.assertEquals(NUM_OF_OCCURRENCE_OF_CAPTAIN_IN_NORMAL_FILE, words.get("captain").getNumOfOccurence());
    Assert.assertEquals(LAST_OCCURRENCE_OF_CAPTAIN_IN_NORMAL_FILE, words.get("captain").getLastOccurrence());
    Assert.assertEquals(NUM_OF_OCCURRENCE_OF_CAPITAL_ENJOY_IN_NORMAL_FILE, words.get("Enjoy").getNumOfOccurence());
    Assert.assertEquals(LAST_OCCURRENCE_OF_CAPITAL_ENJOY_IN_NORMAL_FILE, words.get("Enjoy").getLastOccurrence());
    Assert.assertEquals(NUM_OF_OCCURRENCE_OF_ENJOY_IN_NORMAL_FILE, words.get("enjoy").getNumOfOccurence());
    Assert.assertEquals(LAST_OCCURRENCE_OF_ENJOY_IN_NORMAL_FILE, words.get("enjoy").getLastOccurrence());
  }


  private void initializeWordFileProcessor(String inputFilePath) {
    try {
      Path inputPath = Paths.get(ClassLoader.getSystemResource(inputFilePath).toURI());
      Path outputPath = Paths.get("src/main/resources/" + OUTPUT_PATH);
      underTest = new WordFileProcessor(inputPath, outputPath);
    } catch (URISyntaxException e) {
      logger.error("Error during initializing WordFileProcessor. Please check the url of input test files");
    }
  }
}