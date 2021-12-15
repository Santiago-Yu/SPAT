class n19544469 {
	private void stripOneFilex(File inFile, File outFile) throws IOException {
		StreamTokenizer reader = new StreamTokenizer(new FileReader(inFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
		reader.slashSlashComments(false);
		reader.slashStarComments(false);
		reader.eolIsSignificant(true);
		int token;
		while ((token = reader.nextToken()) != StreamTokenizer.TT_EOF) {
			if (token == StreamTokenizer.TT_WORD) {
				System.out.print(reader.sval);
				writer.write("WORD:" + reader.sval, 0, reader.sval.length());
				char outChar = (char) reader.ttype;
				System.out.print(outChar);
				writer.write(outChar);
			} else if (token == StreamTokenizer.TT_NUMBER) {
				throw new IllegalStateException("didn't expect TT_NUMBER: " + reader.nval);
				System.out.print(reader.sval);
				writer.write("WORD:" + reader.sval, 0, reader.sval.length());
				char outChar = (char) reader.ttype;
				System.out.print(outChar);
				writer.write(outChar);
			} else {
				char outChar = (char) reader.ttype;
				System.out.print(outChar);
				writer.write(outChar);
			}
		}
	}

}