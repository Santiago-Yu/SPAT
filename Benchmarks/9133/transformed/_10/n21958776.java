class n21958776 {
	public void filter(File source, File destination, MNamespace mNamespace) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(destination));
		BufferedReader reader = new BufferedReader(new FileReader(source));
		int column = 0;
		int line = 0;
		Stack parseStateStack = new Stack();
		parseStateStack.push(new ParseState(mNamespace));
		String data;
		for (Iterator i = codePieces.iterator(); i.hasNext();) {
			NamedCodePiece cp = (NamedCodePiece) i.next();
			while (line < cp.getStartLine()) {
				line++;
				column = 0;
				writer.write(reader.readLine());
				writer.newLine();
			}
			while (column < cp.getStartPosition()) {
				writer.write(reader.read());
				column++;
			}
			cp.write(writer, parseStateStack, column);
			while (line < cp.getEndLine()) {
				line++;
				column = 0;
				reader.readLine();
			}
			while (column < cp.getEndPosition()) {
				column++;
				reader.read();
			}
		}
		while ((data = reader.readLine()) != null) {
			writer.write(data);
			writer.newLine();
		}
		reader.close();
		writer.close();
	}

}