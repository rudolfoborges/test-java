package br.com.rudolfoborges.q3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rudolfoborges on 28/07/17.
 */
public class CharUtilsTest {


	@Test
	public void findWithMatch(){
		final String text = "aAbBABacafe";

		char firstChar = CharUtils.firstChar(new CharacterStream(text));

		Assert.assertEquals('e', firstChar);
	}

	@Test
	public void findWithMatchMoreSample(){
		final String text = "atartafuyajhghdsagiift";

		char firstChar = CharUtils.firstChar(new CharacterStream(text));

		Assert.assertEquals('u', firstChar);
	}

	@Test(expected = RuntimeException.class)
	public void findWithoutMatch(){
		final String text = "text";

		char firstChar = CharUtils.firstChar(new CharacterStream(text));
	}

	@Test(expected = RuntimeException.class)
	public void oneChar(){
		final String text = "r";

		char firstChar = CharUtils.firstChar(new CharacterStream(text));
	}

	@Test
	public void onePair(){
		final String text = "abi";

		char firstChar = CharUtils.firstChar(new CharacterStream(text));

		Assert.assertEquals('i', firstChar);
	}

	@Test(expected = RuntimeException.class)
	public void onePairNoMatch(){
		final String text = "aba";

		char firstChar = CharUtils.firstChar(new CharacterStream(text));
	}

	@Test(expected = RuntimeException.class)
	public void onePairNoMatch2(){
		final String text = "bba";

		char firstChar = CharUtils.firstChar(new CharacterStream(text));
	}

	@Test(expected = RuntimeException.class)
	public void onePairNoMatch3(){
		final String text = "bbb";

		char firstChar = CharUtils.firstChar(new CharacterStream(text));
	}

}