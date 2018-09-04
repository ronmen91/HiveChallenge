package com.hive.challenge.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OccurrenceTest {
  private Occurrence underTest;

  @Before
  public void setUp() throws Exception {
    underTest = new Occurrence(1);
    setupOccurrence(5, underTest, 10);
  }

  @Test
  public void testCompareToWhenNumberOfOccurrenceIsDifferent() throws Exception {
    //GIVEN
    Occurrence occurrence = new Occurrence(2);
    setupOccurrence(6, occurrence, 9);
    //WHEN
    //THEN
    Assert.assertTrue(underTest.compareTo(occurrence) < 0);
  }

  @Test
  public void testCompareToWhenNumberOfOccurrenceIsTheSame() throws Exception {
    //GIVEN
    Occurrence occurrence = new Occurrence(2);
    setupOccurrence(5, occurrence, 9);
    //WHEN
    //THEN
    Assert.assertTrue(underTest.compareTo(occurrence) > 0);
  }

  private void setupOccurrence(int numOfOccurence, Occurrence occurrence, int lastOccurrence) {
    for (int i = 1; i < numOfOccurence; i++) {
      occurrence.wordOccuredAgain(lastOccurrence);
    }
  }
}