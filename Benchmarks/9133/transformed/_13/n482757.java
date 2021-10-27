class n482757 {
	public void load(URL urlin) throws IOException {
		index = hs.getDoIndex();
		loaded = false;
		url = urlin;
		int i;
		int c;
		htmlDocLength = 0;
		HtmlReader in = new HtmlReader(new InputStreamReader(url.openStream(), charset));
		try {
			if (debug >= 2)
				System.out.print("Loading " + urlin.toString() + " ... ");
			while ((c = in.read()) >= 0) {
				htmlDoc[htmlDocLength++] = (char) (c);
				if (htmlDocLength == htmlDocMaxLength) {
					char[] newHtmlDoc = new char[2 * htmlDocMaxLength];
					System.arraycopy(htmlDoc, 0, newHtmlDoc, 0, htmlDocMaxLength);
					htmlDocMaxLength = 2 * htmlDocMaxLength;
					htmlDoc = newHtmlDoc;
				}
			}
			if (debug >= 2)
				System.out.println("done.");
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			if (debug >= 1)
				System.out.println("Error, reading file into memory (too big) - skipping " + urlin.toString());
			loaded = false;
			return;
		}
		in.close();
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