class n7072569 {
	public StringBuffer get(URL MhYqQJuw) throws IOException {
		StringBuffer zpIdEAdE = new StringBuffer();
		PDFReader Z5jyErKw = new PDFReader(MhYqQJuw.openStream());
		Z5jyErKw.open();
		int BgV6zciS = Z5jyErKw.getNumberOfPages();
		for (int xt3PF3OY = 0; xt3PF3OY < BgV6zciS; xt3PF3OY++)
			zpIdEAdE.append(new String(Z5jyErKw.extractTextFromPage(xt3PF3OY).getBytes(), "UTF-8"));
		Z5jyErKw.close();
		return zpIdEAdE;
	}

}