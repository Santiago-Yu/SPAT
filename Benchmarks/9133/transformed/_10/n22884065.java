class n22884065 {
	public void testFidelity() throws ParserException, IOException {
		Node node;
		Lexer lexer;
		StringBuffer buffer;
		int position;
		char[] ref;
		String string;
		URL url = new URL("http://sourceforge.net");
		char[] test;
		position = 0;
		lexer = new Lexer(url.openConnection());
		buffer = new StringBuffer(80000);
		while (null != (node = lexer.nextNode())) {
			string = node.toHtml();
			if (position != node.getStartPosition())
				fail("non-contiguous" + string);
			buffer.append(string);
			position = node.getEndPosition();
			if (buffer.length() != position)
				fail("text length differed after encountering node " + string);
		}
		test = new char[buffer.length()];
		ref = lexer.getPage().getText().toCharArray();
		buffer.getChars(0, buffer.length(), test, 0);
		assertEquals("different amounts of text", ref.length, test.length);
		for (int i = 0; i < ref.length; i++)
			if (ref[i] != test[i])
				fail("character differs at position " + i + ", expected <" + ref[i] + "> but was <" + test[i] + ">");
	}

}