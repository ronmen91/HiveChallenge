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

  /**
   * The overridden method gives a higher precedence for {@link Occurrence} with higher number of
   * occurrence or later occurrence if number of occurrences are equal.
   *
   * @param occurrence {@link Occurrence}
   * @return a negative integer or a positive integer as number of occurrence of this object
   *          is less than, or greater than the specified object's and IF THEY ARE EQUAL then
   *          a negative integer or a positive integer as last occurrence of this object
   *          is less than, or greater than the specified object's
   */
  @Override
  public int compareTo(Occurrence occurrence) {
    if (occurrence.getNumOfOccurence() == this.getNumOfOccurence()) {
      return  occurrence.getLastOccurrence() - this.getLastOccurrence();
    }
    return occurrence.getNumOfOccurence() - this.getNumOfOccurence();
  }
}
