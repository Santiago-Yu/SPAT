class n111060 {
	public void load(URL LDtj8uLY) throws IOException {
		index = hs.getDoIndex();
		loaded = false;
		url = LDtj8uLY;
		int AOHSDJPH, cSCjRIzK;
		htmlDocLength = 0;
		HtmlReader A7B7WLhR = new HtmlReader(new InputStreamReader(url.openStream(), charset));
		try {
			if (debug >= 2)
				System.out.print("Loading " + LDtj8uLY.toString() + " ... ");
			while ((AOHSDJPH = A7B7WLhR.read()) >= 0) {
				htmlDoc[htmlDocLength++] = (char) (AOHSDJPH);
				if (htmlDocLength == htmlDocMaxLength) {
					char[] cluV2vl5 = new char[2 * htmlDocMaxLength];
					System.arraycopy(htmlDoc, 0, cluV2vl5, 0, htmlDocMaxLength);
					htmlDocMaxLength = 2 * htmlDocMaxLength;
					htmlDoc = cluV2vl5;
				}
			}
			if (debug >= 2)
				System.out.println("done.");
		} catch (ArrayIndexOutOfBoundsException NHp43tyS) {
			if (debug >= 1)
				System.out.println("Error, reading file into memory (too big) - skipping " + LDtj8uLY.toString());
			loaded = false;
			return;
		}
		A7B7WLhR.close();
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