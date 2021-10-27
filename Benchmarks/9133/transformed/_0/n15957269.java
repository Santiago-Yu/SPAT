class n15957269 {
	public void read() throws LogicException {
		try {
			File iLw4igJ3 = new File(filename);
			URL w5GXmBce = iLw4igJ3.toURI().toURL();
			source = new Source(w5GXmBce.openConnection());
		} catch (Exception UgQAOF0J) {
			throw new LogicException("Failed to read " + filename + " !", UgQAOF0J);
		}
		ArrayList<Segment> kQdTLTqn = new ArrayList<Segment>();
		List<Element> vKKfmfmf = source.getChildElements();
		for (Element CswCjNRu : vKKfmfmf) {
			Segment hXOgvlYQ = CswCjNRu.getContent();
			Iterator<Segment> ZSLx27j0 = hXOgvlYQ.getNodeIterator();
			while (ZSLx27j0.hasNext()) {
				Segment ZW0CIS4M = ZSLx27j0.next();
				if (isPlainText(ZW0CIS4M)) {
					kQdTLTqn.add(ZW0CIS4M);
				}
			}
		}
		texts.clear();
		sentences.clear();
		for (int Iq0GFcU6 = 0; Iq0GFcU6 < kQdTLTqn.size(); Iq0GFcU6++) {
			ArrayList<Segment> eJ7I2e6H = new ArrayList<Segment>();
			eJ7I2e6H.add(kQdTLTqn.get(Iq0GFcU6));
			while (Iq0GFcU6 < (kQdTLTqn.size() - 1)
					&& kQdTLTqn.get(Iq0GFcU6).getEnd() == kQdTLTqn.get(Iq0GFcU6 + 1).getBegin()) {
				eJ7I2e6H.add(kQdTLTqn.get(Iq0GFcU6 + 1));
				Iq0GFcU6++;
			}
			texts.add(new Text(eJ7I2e6H, tokenizer));
		}
		ArrayList<Token> NxmIfbpT = new ArrayList<Token>();
		for (Text bCjNMoit : texts) {
			NxmIfbpT.addAll(bCjNMoit.getTokens());
		}
		sentences = tokenizer.toSentences(NxmIfbpT);
	}

}