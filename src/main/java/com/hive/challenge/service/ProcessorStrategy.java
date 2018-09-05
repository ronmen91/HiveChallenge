package com.hive.challenge.service;

import java.util.List;

/**
 * This interface gives the functionality process the internal data structure
 */
public interface ProcessorStrategy<T> {

  /**
   * It processes the internal data structure based on the implemented criteria
   * @param data - the internal data structure
   * @return with the processed elements of the internal data structure
   */
  List<String> process(T data);
}
