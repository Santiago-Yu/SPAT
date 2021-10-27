class n20637944 {
	public final Reader open(URL voH02LIJ) throws IOException {
		Reader fJSobWCY = null;
		Charset mrW2eDUK = this.detectCodepage(voH02LIJ);
		if (mrW2eDUK != null) {
			fJSobWCY = new InputStreamReader(new BufferedInputStream(voH02LIJ.openStream()), mrW2eDUK);
		}
		return fJSobWCY;
	}

}