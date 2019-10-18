package enshud.s1.lexer;

public class Constant extends Token {
	
	private final int num;

	public Constant(int num) {
		super(44, "SCONSTANT");
		this.num = num;
	}
	
	// getter
	public int getLexeme() {
		return this.num;
	}

	// printer
	public String toString() {
		return Integer.toString(this.num) + "\t" + this.getName() + "\t" + this.getTag();
	}
}
