package br.com.rudolfoborges.q3;

/**
 * Created by rudolfoborges on 28/07/17.
 */
public class AppStarter {

	public static void main(String[] args) {
		final Stream stream = new CharacterStream(args[0]);

		char firstChar = CharUtils.firstChar(stream);

		System.out.println(String.format("This is first char = %s", firstChar));
	}

}
