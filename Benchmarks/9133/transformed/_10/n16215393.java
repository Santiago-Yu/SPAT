class n16215393 {
	public void importSequences() {
		names = new ArrayList<String>();
		sequences = new ArrayList<String>();
		try {
			InputStream is = urls[urlComboBox.getSelectedIndex()].openStream();
			ImportHelper helper = new ImportHelper(new InputStreamReader(is));
			int ch = helper.read();
			while (ch != '>') {
				ch = helper.read();
			}
			do {
				String line = helper.readLine();
				StringTokenizer tokenizer = new StringTokenizer(line, " \t");
				StringBuffer seq = new StringBuffer();
				String name = tokenizer.nextToken();
				helper.readSequence(seq, ">", Integer.MAX_VALUE, "-", "?", "", null);
				ch = helper.getLastDelimiter();
				names.add(name);
				sequences.add(seq.toString());
			} while (ch == '>');
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
		}
	}

}