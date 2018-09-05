# HiveChallenge

## Description
Design and develop a Java application that will read in a file, count the number of 
occurrences of each word in the file and write the results into another file. 

The results should be the list of the words that appear more than once in the file 
ordered by their count and last appearance (in that precedence).

The java application should take 2 command line arguments, \
1 - filepath to input file \
2 - filepath to output file

The format of the input file should have each word separated by a new line. 

Please provide documentation explaining your solution and any assumptions/decisions made.

What is the space and time algorithmic complexity of your result?

## Solution
### Assumptions/decisions made
Command line arguments:
 - the arguments shouldn't be an empty string
 - additional arguments are allowed but skipped during processing
 
Input file: 
 - it's a valid input file what means that the file may contain no word as well
 but if does then every word is followed by new a new line
 - the words are case sensitive therefore e.g.: `hello` and `Hello` are different word
 
Output file:
 - it has the same format as the input file
 
### Design
For each word these 3 attributes should be stored:
- the word
- number of occurrence
- last occurrence 

As the application processes the input file these attributes should be stored in a 
data structure for every new word and if it was store then update the related 
attributes. \
For adding and searching with O(1) time complexity I choose `Hashmap` with the word
as `key` and `Occuerrence` object as a value which stores the number of occurrence 
and the last occurrence. If every word is distinct the map will contains N entries
so space complexity is O(N).

In the output file just those words can be written which occurred more than once 
and also these remaining words should be ordered by the number of occurrence and 
their last occurrence. \
This means that if a word occurred more times then it has a higher priority and if
two or more words have the same number of occurrence than the word has the later
occurrence has a higher priority. \
To met with this requirement a filter should be done on the stored words and 
`Occurrence` objects should me comparable and override the `compareTo` method with
taking the number of occurrence and their last occurrence into account.
The filtering go through the all words so it has O(N) time complexity and sorting 
with TimSort has O(n*log(n)).

### How to build
`mvn clean install`

### How to run
`java -jar hiveChallenge-1.0.jar "<input-file-name>" "<output-file-name>"`

