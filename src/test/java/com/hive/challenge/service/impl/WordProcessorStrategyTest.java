package com.hive.challenge.service.impl;

import static org.junit.Assert.*;

import com.hive.challenge.domain.Occurrence;
import com.hive.challenge.helper.OccurrenceHelper;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordProcessorStrategyTest {
  private WordProcessorStrategy underTest;

  @Before
  public void setUp() throws Exception {
    underTest = new WordProcessorStrategy();
  }

  @Test
  public void testProcessWithEmptyInput() {
    //GIVEN
    Map<String, Occurrence> words = new HashMap<>();
    //WHEN
    //THEN
    Assert.assertEquals(0, underTest.process(words).size());
  }

  @Test
  public void testProcessWithOneOccuerrenceWords() {
    //GIVEN
    Map<String, Occurrence> words = new HashMap<>();
    //WHEN
    for (int i = 1; i < 6; i++) {
      Occurrence occurrence = new Occurrence(i);
      words.put("demo" + i , occurrence);
    }
    //THEN
    Assert.assertEquals(0, underTest.process(words).size());
  }

  @Test
  public void testProcessWithNormalWords() {
    //GIVEN
    Map<String, Occurrence> words = new HashMap<>();
    //WHEN
    for (int i = 1; i < 6; i++) {
      Occurrence occurrence = new Occurrence(i);
      words.put("demo" + i , occurrence);
    }
    //THEN
    Assert.assertEquals(0, underTest.process(words).size());
  }
}