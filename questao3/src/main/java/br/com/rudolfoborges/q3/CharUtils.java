package br.com.rudolfoborges.q3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by rudolfoborges on 28/07/17.
 */
public class CharUtils {

	private static final String REGEX = "[+aeiou]";

	public static char firstChar(Stream stream){

		final List<String> matches = new ArrayList<>();

		final CountDownLatch countDownLatch = new CountDownLatch(2);

		final StringBuilder text = new StringBuilder();

		char last = Character.MAX_VALUE;

		while (stream.hashNext()) {
			final Character next = stream.getNext();

			text.append(next);

			if (countDownLatch.getCount() == 0l
					&& isConsonant(last)
					&& isVowel(next)) {
				matches.add(String.valueOf(next));
			}

			last = next;
			countDownLatch.countDown();
		}

		String firstVowel = matches
				.stream()
				.filter(vowel -> countVowel(vowel, text.toString()) == 1)
				.findFirst()
				.orElseThrow(RuntimeException::new);

		return firstVowel.toCharArray()[0];
	}

	private static boolean isVowel(char character) {
		return String.valueOf(character).matches(REGEX);
	}

	private static boolean isConsonant (char character) {
		return !isVowel(character);
	}

	private static int countVowel(String vowel, String text){
		return text.length() - text.replaceAll(vowel, "").length();
	}

}
