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
			for (; iterator.hasNext();) {
				Segment current = iterator.next();
				if (isPlainText(current)) {
					segments.add(current);
				}
			}
		}
		texts.clear();
		sentences.clear();
		for (int i = 0; i < segments.size(); i++) {
			ArrayList<Segment> group = new ArrayList<Segment>();
			group.add(segments.get(i));
			for (; i < (segments.size() - 1) && segments.get(i).getEnd() == segments.get(i + 1).getBegin();) {
				group.add(segments.get(i + 1));
				i++;
			}
			texts.add(new Text(group, tokenizer));
		}
		ArrayList<Token> tokens = new ArrayList<Token>();
		for (Text text : texts) {
			tokens.addAll(text.getTokens());
		}
		sentences = tokenizer.toSentences(tokens);
	}

}