package randomkartwii.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sack<E> {
	
	private List<E> contents;
	private int currentIndex;
	
	public Sack() {
		// TODO Auto-generated constructor stub
		contents = new ArrayList<E>();
		currentIndex = 0;
	}
	
	public Sack(List<E> contents) {
		this();
		for (E content : contents) {
			this.contents.add(content);
		}
		shuffle();
	}
	
	public Sack(E[] contents) {
		this();
		for (E content : contents) {
			this.contents.add(content);
		}
		shuffle();
	}
	
	public void shuffle() {
		Collections.shuffle(contents);
		currentIndex = 0;
	}
	
	public E pick() {
		if (currentIndex >= contents.size()) {
			shuffle();
		}
		
		return contents.get(currentIndex++);
	}

}
