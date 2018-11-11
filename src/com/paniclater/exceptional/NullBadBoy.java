package com.paniclater.exceptional;

import javax.sound.sampled.UnsupportedAudioFileException;

public class NullBadBoy {
	String name;

	NullBadBoy(String name) {
		this.name = name;
	}

	NullBadBoy() {
		name = "2";
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		try {
			new UhOh();
			System.out.println("assdsddsdsd");
		} catch (UnsupportedOperationException npe) {
			System.out.println(npe);
		} catch (NullPointerException npe) {
			System.out.println(npe);
		}
	}
}

class UhOh {
	NullBadBoy nullBad;

	UhOh() {
		System.out.println("sdfsdf dsfsdfsdf sdfdsfsd");
		//throw new UnsupportedOperationException();
		System.out.println(nullBad.getName());
	}

}