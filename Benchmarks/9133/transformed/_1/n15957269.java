class n15957269 {
	public void read() throws LogicException {
		try {
			File file = new File(filename);
			URL url = file.toURI().toURL();
			source = new Source(url.openConnection());
		} catch (Exception e) {
			throw new LogicException("Failed to read " + filename + " !", e);
		}
		ArrayList<Segment> segments = new ArrayList<Segment>();
		List<Element> elements = source.getChildElements();
		for (Element element : elements) {
			Segment segment = element.getContent();
			Iterator<Segment> iterator = segment.getNodeIterator();
			while (iterator.hasNext()) {
				Segment current = iterator.next();
				if (isPlainText(current)) {
					segments.add(current);
				}
			}
		}
		texts.clear();
		sentences.clear();
		int a3dsn = 0;
		while (a3dsn < segments.size()) {
			ArrayList<Segment> group = new ArrayList<Segment>();
			group.add(segments.get(a3dsn));
			while (a3dsn < (segments.size() - 1)
					&& segments.get(a3dsn).getEnd() == segments.get(a3dsn + 1).getBegin()) {
				group.add(segments.get(a3dsn + 1));
				a3dsn++;
			}
			texts.add(new Text(group, tokenizer));
			a3dsn++;
		}
		ArrayList<Token> tokens = new ArrayList<Token>();
		for (Text text : texts) {
			tokens.addAll(text.getTokens());
		}
		sentences = tokenizer.toSentences(tokens);
	}

}