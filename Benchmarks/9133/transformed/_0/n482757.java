class n482757 {
	public void load(URL OnWHmLwE) throws IOException {
		index = hs.getDoIndex();
		loaded = false;
		url = OnWHmLwE;
		int v9ZvHUXf, JK6D0mHF;
		htmlDocLength = 0;
		HtmlReader qbkiFQeV = new HtmlReader(new InputStreamReader(url.openStream(), charset));
		try {
			if (debug >= 2)
				System.out.print("Loading " + OnWHmLwE.toString() + " ... ");
			while ((v9ZvHUXf = qbkiFQeV.read()) >= 0) {
				htmlDoc[htmlDocLength++] = (char) (v9ZvHUXf);
				if (htmlDocLength == htmlDocMaxLength) {
					char[] DsVzfxba = new char[2 * htmlDocMaxLength];
					System.arraycopy(htmlDoc, 0, DsVzfxba, 0, htmlDocMaxLength);
					htmlDocMaxLength = 2 * htmlDocMaxLength;
					htmlDoc = DsVzfxba;
				}
			}
			if (debug >= 2)
				System.out.println("done.");
		} catch (ArrayIndexOutOfBoundsException Qdny9SmT) {
			if (debug >= 1)
				System.out.println("Error, reading file into memory (too big) - skipping " + OnWHmLwE.toString());
			loaded = false;
			return;
		}
		qbkiFQeV.close();
		fetchURLpos = 0;
		dumpPos = 0;
		dumpLastChar = SPACE;
		loaded = true;
		frameset = false;
		titledone = false;
		headdone = false;
		checkhead = false;
		checkbody = false;
	}

}