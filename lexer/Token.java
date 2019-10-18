package enshud.s1.lexer;

public class Token {

	// attributes
	private final int tag;
	private final String name;
	
	// constructor
	public Token(int tag, String name) {
		this.tag = tag;
		this.name = name;
	}
	
	// getter
	public int getTag() {
		return this.tag;
	}
	
	public String getName() {
		return this.name;
	}
}
