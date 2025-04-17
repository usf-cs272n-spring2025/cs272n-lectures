package edu.usfca.cs272.lectures.regex.demos;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.usfca.cs272.lectures.regex.RegexHelper;

/**
 * Tests how well you combine different regex components.
 *
 * @see RegexHelper
 *
 * @author CS 272 Software Development (University of San Francisco)
 * @version Spring 2025
 */
public class RegexChallenge extends RegexHelper {
	/**
	 * Tests how well you combine different regex components.
	 *
	 * @param args unused
	 */
	public static void main(String[] args) {
		String text = null;
		String regex = null;

		/*
		 * Can you predict the output?
		 */

		text = "hubbub";
		printMatches(text, "[hb].*b");
		printMatches(text, "[hb].*?b");
		printMatches(text, "[hb].*bb*");
		printMatches(text, "[hb].*bb+");
		printMatches(text, "[hb].*bb?");
		printMatches(text, "[hb].*?bb??");

		console.println();

		/*
		 * Can you predict the output?
		 */

		text = "ant ape bat bee bug cat cow dog";
		printMatches(text, "\\w*a\\w*");
		printMatches(text, "\\w+a\\w+");
		printMatches(text, "\\w+t\\b");
		printMatches(text, "\\w*[^e]e\\b");

		console.println();

		/*
		 * Can you predict the output?
		 */

		text = "dragonfly";

		regex = "(drag(on))(fly)";
		printGroups(regex, text);

		regex = "(drag((on)(fly)))";
		printGroups(regex, text);

		/*
		 * Can you find other matches for this regex?
		 */

		// https://regex101.com/r/ayaRps/
		regex = "(?i).+?[+?]?(?:\\?[^?])+?";

		// create smallest text that matches this regex
		printMatches("???!", regex);
		printMatches("++?+", regex);
		printMatches("o+?o", regex);

		// create 10 char text that matches this regex
		printMatches("ahhhhh???!", regex);
		printMatches("?????????!", regex);
	}

	/**
	 * Outputs groups to the console.
	 *
	 * @param regex the regular expression
	 * @param text the text to match against
	 */
	public static void printGroups(String regex, String text) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);

		System.out.println(" Text: " + text);
		System.out.println("Regex: " + regex);
		System.out.println();

		if (m.matches()) {
			for (int i = 0; i <= m.groupCount(); i++) {
				console.println(i + ": " + m.group(i));
			}
		}

		System.out.println();
	}

	/*
	 * EXPECTED OUTPUT:

     [hb].*b ->  1 matches: [hubbub]
    [hb].*?b ->  2 matches: [hub, bub]
   [hb].*bb* ->  1 matches: [hubbub]
   [hb].*bb+ ->  1 matches: [hubb]
   [hb].*bb? ->  1 matches: [hubbub]
 [hb].*?bb?? ->  2 matches: [hub, bub]

     \w*a\w* ->  4 matches: [ant, ape, bat, cat]
     \w+a\w+ ->  2 matches: [bat, cat]
      \w+t\b ->  3 matches: [ant, bat, cat]
  \w*[^e]e\b ->  1 matches: [ape]

 Text: dragonfly
Regex: (drag(on))(fly)

0: dragonfly
1: dragon
2: on
3: fly

 Text: dragonfly
Regex: (drag((on)(fly)))

0: dragonfly
1: dragonfly
2: onfly
3: on
4: fly

(?i).+?[+?]?(?:\?[^?])+? ->  1 matches: [???!]
(?i).+?[+?]?(?:\?[^?])+? ->  1 matches: [++?+]
(?i).+?[+?]?(?:\?[^?])+? ->  1 matches: [o+?o]
(?i).+?[+?]?(?:\?[^?])+? ->  1 matches: [ahhhhh???!]
(?i).+?[+?]?(?:\?[^?])+? ->  1 matches: [?????????!]
	*/
}
