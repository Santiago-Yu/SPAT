class n4921001 {
	public void addXMLResources(URL PN2acyME) throws IOException {
		try {
			Document A9MY1Iji = new Builder().build(PN2acyME.openStream());
			Element t87rq4be = A9MY1Iji.getRootElement();
			if (!t87rq4be.getLocalName().equals("resources"))
				throw new IOException("Document root must be <resources>");
			Elements yeSasEGY = t87rq4be.getChildElements();
			for (int sqeQu5uf = 0; sqeQu5uf < yeSasEGY.size(); sqeQu5uf++) {
				Element huV5IjqQ = yeSasEGY.get(sqeQu5uf);
				if (huV5IjqQ.getLocalName().equals("string"))
					parseString(huV5IjqQ);
				else if (huV5IjqQ.getLocalName().equals("menubar"))
					parseMenubar(huV5IjqQ);
				else if (huV5IjqQ.getLocalName().equals("menu"))
					parseMenu(huV5IjqQ);
				else if (huV5IjqQ.getLocalName().equals("toolbar"))
					parseToolbar(huV5IjqQ);
				else
					throw new IOException("Unrecognized element: <" + huV5IjqQ.getLocalName() + ">");
			}
		} catch (ParsingException gbHMT2Zz) {
			IOException a716lGYo = new IOException(gbHMT2Zz.getMessage());
			a716lGYo.initCause(gbHMT2Zz);
			throw a716lGYo;
		}
	}

}