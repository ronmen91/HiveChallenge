package com.hive.challenge.helper;

import com.hive.challenge.domain.Occurrence;

public class OccurrenceHelper {
  public static void setupOccurrence(int numOfOccurence, Occurrence occurrence, int lastOccurrence) {
    for (int i = 1; i < numOfOccurence; i++) {
      occurrence.wordOccuredAgain(lastOccurrence);
    }
  }
}
