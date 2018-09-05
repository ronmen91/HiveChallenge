package com.hive.challenge.service.impl;

import com.hive.challenge.domain.Occurrence;
import com.hive.challenge.service.ProcessorStrategy;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class WordProcessorStrategy implements ProcessorStrategy<Map<String, Occurrence>> {

  @Override
  public List<String> process(Map<String, Occurrence> words) {
    return words.entrySet().stream()
        .filter(word -> word.getValue().getNumOfOccurence() > 1)
        .sorted(Entry.comparingByValue())
        .map(Entry::getKey)
        .collect(Collectors.toList());
  }
}
