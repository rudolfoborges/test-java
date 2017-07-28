package br.com.rudolfoborges.q3;

/**
 * Created by rudolfoborges on 28/07/17.
 */
public class CharacterStream implements Stream {

	private final char[] characters;
	private int index;

	public CharacterStream(String text) {
		if (text == null) {
			throw new RuntimeException();
		}

		characters = text.toLowerCase().toCharArray();
		index = -1;
	}

	@Override
	public boolean hashNext() {
		return ++index < characters.length;
	}

	@Override
	public char getNext() {
		final char character = characters[index];
		return character;
	}


}
