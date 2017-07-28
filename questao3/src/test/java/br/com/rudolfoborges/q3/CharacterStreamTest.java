package br.com.rudolfoborges.q3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rudolfoborges on 28/07/17.
 */
public class CharacterStreamTest {

	@Test
	public void hashNext() throws Exception {
		final Stream stream = new CharacterStream("aa");
		assertTrue(stream.hashNext());
		assertTrue(stream.hashNext());
		assertFalse(stream.hashNext());
	}

	@Test
	public void getNext() throws Exception {
		final Stream stream = new CharacterStream("ab");

		stream.hashNext();
		assertEquals('a', stream.getNext());

		stream.hashNext();
		assertEquals('b', stream.getNext());
	}

}