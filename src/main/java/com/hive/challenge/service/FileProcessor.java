package com.hive.challenge.service;

import java.util.List;

/**
 * This interface gives the functionality to process files
 */
public interface FileProcessor<T> {

  /**
   * It reads a file in an internally used data structure
   *
   * @return internally used data structure
   */
  T readInputFile();

  /**
   * It writes the processed elements of the internally used data structure into file
   *
   * @param processedElements should be written to file
   */
  void writeToOutputFile(List<String> processedElements);
}
