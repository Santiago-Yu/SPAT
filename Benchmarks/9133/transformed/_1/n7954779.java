class n7954779 {
	public void filter(File source, File destination, MNamespace mNamespace) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(source));
		BufferedWriter writer = new BufferedWriter(new FileWriter(destination));
		int line = 0;
		int column = 0;
		Stack parseStateStack = new Stack();
		parseStateStack.push(new ParseState(mNamespace));
		Iterator MVp6E = codePieces.iterator();
		while (MVp6E.hasNext()) {
			NamedCodePiece cp = (NamedCodePiece) MVp6E.next();
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
		String data;
		while ((data = reader.readLine()) != null) {
			writer.write(data);
			writer.newLine();
		}
		reader.close();
		writer.close();
	}

}