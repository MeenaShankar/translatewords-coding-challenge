# translatewords-coding-challenge

 
 Translate Words Challenge
The task
Given a text file, replace all possible words in English to French using any 
programming language of choice
What is the input?
The zip file (TranslateWordsChallenge.zip) has 4 files:
1. Instruction document (Translate Words Challenge.pdf)
2. A text file (t8.shakespeare.txt) that has more than one lakh lines
3. A find words list (find_words.txt) that has a 1000 words. The words in the list
should be replaced with case being maintained.
4. The English to French dictionary (french_dictionary.csv) to do the look up
What needs to be done?
1. Read the input text file, find words list text file and dictionary csv file
2. Find all words that is in the find words list, that has a replacement word in the 
dictionary
3. Replace the words in the input text file
4. Save the processed file as output
NOTE: Accuracy of the replace in terms of all occurrences, casing and special 
characters to be maintained
What is the expected output?
1. Unique list of words that was replaced with French words from the dictionary
2. Number of times a word was replace
3. Time taken to process
4. Memory taken to process
What to submit?
Submit a zip file. Please name your zip file according to the pattern given below:
YYYYMMDD.surname.givenname.college.zip
The zip file contains 4 parts:
1. YYYYMMDD - 4 digit year, 2 digit month (add 0 if needed), 2 digit date (add 0 if 
needed)
2. surname - your name
3. givenname - your father’s name
4. college - full college name
NOTE: Replace any spaces in the filename with underscore ( _ ) and use lowercase 
characters ONLY.
For example, if your name is Suresh Kumar and your father’s name is Selva 
Ganapathy and you are from ABC College of Engineering and Technology, and 
your are submitting the file on Feb 28, 2021 then zip file name should be
20210228.suresh_kumar.selva_ganapathy.abc_college_of_engineering_and_tech
nology.zip
The zip file should contain the following files:
1. performance.txt
2. frequency.csv
3. t8.shakespeare.translated.txt
4. githublink.txt
Note:
1. Select all the above files & Compress them into a Zip file & give them the Name 
in the Same Format Mentioned above ("What to submit ").
2. Please use the same file names as provided in the list above. Kindly do not use 
capital letters either.
3. Kindly do not create a folder with the four files and then compress it into Zip. 
While converting to zip, select the four files and directly convert to Zip.
performance.txt
This file should contain just 2 lines of text and follow the exact text given below. 
The first line should have the time taken for the script to complete and the 
second line should have the memory used by your script. Please update the 
Time to process: 0 minutes 0 seconds 
Memory used: 0 MB
NOTE: Please update the actual time taken to execute and memory taken. Do not 
leave it as 0
frequency.csv
This file should have 3 columns, first “English Word”, second “French Word” and 
third “Frequency” and this should be the first line of the file. The first column 
should have the English word that was found, the second column should have the 
corresponding French word that was used to replace and the third column should 
have the number of times the word was replaced. 
For example, if the English word “abide” was replaced with “respecter” 10 times, 
then the file will look like 
English word,French word,Frequency
abide,respecter,10
t8.shakespeare.translated.txt
This is the processed output file that contains the words translated to French
githublink.txt
This file should just contain just the link to your repo (just 1 line) and nothing else, 
for example:
https://github.com/sureshkumar/exeter-coding-challenge
