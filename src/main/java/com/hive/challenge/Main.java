package com.hive.challenge;

import com.hive.challenge.service.impl.WordFileProcessor;
import com.hive.challenge.service.impl.WordProcessorStrategy;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);
  private static final String WRONG_INPUT_MESSAGE = "Please provide input and output file in this format: java -jar hiveChallenge-1.0.jar \"<input-file-name>\" \"<output-file-name>\"";
  private static final String INVALID_PATH = "Input and/or output path is invalid. Please check them.";

  public static void main(String[] args) {
    if(!isInputValid(args)) {
      logger.error(WRONG_INPUT_MESSAGE);
      return;
    }

    try {
      Path inputPath = Paths.get(args[0]);
      Path outputPath = Paths.get(args[1]);
      
    } catch (InvalidPathException e) {
      logger.error(INVALID_PATH);
    }
  }

  private static boolean isInputValid(String[] args) {
    return args.length >= 2 && !args[0].isEmpty() && !args[1].isEmpty();
  }
}
