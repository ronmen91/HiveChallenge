package com.hive.challenge.domain;

import com.hive.challenge.helper.OccurrenceHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OccurrenceTest {
  private Occurrence underTest;

  @Before
  public void setUp(){
    underTest = new Occurrence(1);
    OccurrenceHelper.setupOccurrence(5, underTest, 10);
  }

  @Test
  public void testCompareToWhenNumberOfOccurrenceIsDifferent(){
    //GIVEN
    Occurrence occurrence = new Occurrence(2);
    OccurrenceHelper.setupOccurrence(6, occurrence, 9);
    //WHEN
    //THEN
    Assert.assertTrue(underTest.compareTo(occurrence) > 0);
  }

  @Test
  public void testCompareToWhenNumberOfOccurrenceIsTheSame(){
    //GIVEN
    Occurrence occurrence = new Occurrence(2);
    OccurrenceHelper.setupOccurrence(5, occurrence, 9);
    //WHEN
    //THEN
    Assert.assertTrue(underTest.compareTo(occurrence) < 0);
  }
}