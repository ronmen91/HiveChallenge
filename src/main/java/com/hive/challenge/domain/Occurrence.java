package com.hive.challenge.domain;

/**
 * This class stores the related attributes for each word: number of occurrence and last occurrence
 */
public class Occurrence implements Comparable<Occurrence>{
  private int numOfOccurence ;
  private int lastOccurrence;

  public Occurrence(int lastOccurrence) {
    this.numOfOccurence = 1;
    this.lastOccurrence = lastOccurrence;
  }

  public int getLastOccurrence() {
    return lastOccurrence;
  }

  public int getNumOfOccurence() {
    return numOfOccurence;
  }

  public void wordOccuredAgain(int lastOccurrence) {
    numOfOccurence++;
    this.lastOccurrence = lastOccurrence;
  }

  @Override
  public int compareTo(Occurrence occurrence) {
    if (occurrence.getNumOfOccurence() == this.getNumOfOccurence()) {
      return this.getLastOccurrence() - occurrence.getLastOccurrence();
    }
    return this.getNumOfOccurence() - occurrence.getLastOccurrence();
  }
}
