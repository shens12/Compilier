package enshud.s1.lexer;

public class Identifier extends Token {
	
	private final String identifier;

	public Identifier(String lexeme) {
		super(43, "SIDENTIFIER");
		this.identifier = lexeme;
	}
	
	// getter
	public String getLexeme() {
		return this.identifier;
	}

	// printer
	public String toString() {
		return this.identifier + "\t" + this.getName() + "\t" + this.getTag();
	}
}
