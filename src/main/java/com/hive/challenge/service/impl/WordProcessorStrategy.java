package com.hive.challenge.service.impl;

import com.hive.challenge.domain.Occurrence;
import com.hive.challenge.service.ProcessorStrategy;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * This class is a concrete ProcessorStrategy
 */
public class WordProcessorStrategy implements ProcessorStrategy<Map<String, Occurrence>> {

  /**
   * This method will filter elements what occurred more than once and also sort them based on
   * the precedence of {@link Occurrence}
   *
   * @param words - the internal data structure
   * @return a {@link List} of words what met the requirements
   */
  @Override
  public List<String> process(Map<String, Occurrence> words) {
    return words.entrySet().stream()
        .filter(word -> word.getValue().getNumOfOccurence() > 1)
        .sorted(Entry.comparingByValue())
        .map(Entry::getKey)
        .collect(Collectors.toList());
  }
}
