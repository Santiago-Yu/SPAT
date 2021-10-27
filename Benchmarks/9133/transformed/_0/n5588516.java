class n5588516 {
	public LineIterator iterator() {
		LineIterator emfdMhM2;
		final String c6zXjywp;
		final Charset aPMSMubh;
		final CharsetDecoder GVWVdcoI;
		synchronized (this) {
			c6zXjywp = this.charsetname;
			aPMSMubh = this.charset;
			GVWVdcoI = this.charsetDecoder;
		}
		try {
			if (GVWVdcoI != null)
				emfdMhM2 = new LineIterator(this, url.openStream(), returnNullUponEof, GVWVdcoI);
			else if (aPMSMubh != null)
				emfdMhM2 = new LineIterator(this, url.openStream(), returnNullUponEof, aPMSMubh);
			else if (c6zXjywp != null)
				emfdMhM2 = new LineIterator(this, url.openStream(), returnNullUponEof, Charset.forName(c6zXjywp));
			else
				emfdMhM2 = new LineIterator(this, url.openStream(), returnNullUponEof, (Charset) null);
			synchronized (openedIterators) {
				openedIterators.add(emfdMhM2);
			}
			return emfdMhM2;
		} catch (IOException S9UhZpas) {
			throw new IllegalStateException(S9UhZpas);
		}
	}

}