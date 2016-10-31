/*
Interview Question 2 - Text Justification
Given an natural language text, write an algorithm which will format the text by splitting it into lines of a specified length, with each line justified such that the text is evenly spaced according to specific rules.

Inputs:

String text - the text to format
int length - the line length for the output
Output: a String[] that meets the following requirements:

Each line should have exactly length characters, including whitespace
Each line should contain as many words as will fit, and the algorithm should return as few lines as possible
Each line should be padded with spaces, distributed as evenly as possible
If the number of spaces required to pad a line do not divide evenly between words, add the extra spaces between the leftmost words first
The last line of the output should be left justified, with no extra spaces between words and all padding added to the right.
Example:

Given the inputs:

String text = "This is an example of text justification.";
int length = 16;
...the output array should be:

String[] output = {
  "This    is    an",
  "example  of text",
  "justification.  "
};
Hint: you can use String.split(" ") to tokenize the input into words.

Remember to avoid helper functions and libraries, though you can use methods in java.lang.String and classes in java.lang and java.util

Bonus 1

Add support for both left and right justification via a parameter. Use an enum to specify values for all three use cases, with the above us case as the default. For left and right justification, the last line should be justified the same as the rest of the text.

Using the above example inputs, the outputs for these two variants would look like this:

Left justification:

String[] output = {
  "This is an      ",
  "example of text ",
  "justification.  "
};
Right justification:

String[] output = {
  "      This is an",
  " example of text",
  "  justification."
};
 */

import java.util.*;

public class TextJustification {


	// Center Justify
	public static String[] justifyCenter(String str, int length) {
		String[] words = str.split(" ");
		ArrayList<String> answer = new ArrayList<>();
		ArrayList<String> line = new ArrayList<>();
		int sumLength = 0;
		for (String x : words) {
			if (x.length() + sumLength+ line.size()-1< length) {
				line.add(x);
				sumLength += x.length();
			}
			else {
				String strLine = CreateLine(line, sumLength, length);
				answer.add(strLine);
				line.clear();
				line.add(x);
				sumLength = x.length();
			}
		}
		System.out.println(line);
		answer.add(CreateLine(line, sumLength, length));
		return answer.toArray(new String[answer.size()]);
	}
	public static String CreateLine(List<String> line, int sumLength, int length) {
		if (line.size()==1)
			return line.get(0);
		String space = calSpace(length, sumLength, line.size());
		String temp = "";
		for (String y : line) {
			temp += y + space;	
		}
		return temp;
	}
	public static String calSpace(int length, int sumLength, int numWords) {
		int numSpace = (length - sumLength)/(numWords-1);
		String s = "";
		for (int i=0;i<numSpace;i++)
			s += " ";
		return s;
	}

	public static void main(String[] args) {
		String text = "This is an example of text justification.";
		int length = 16;
		String[] ans = justifyCenter(text, length);
		for (String x : ans) 
			System.out.println(x);
	}
}