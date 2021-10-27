class n13287093 {
	private boolean load(URL aon1961w) {
		try {
			URLConnection aRotQgJU = aon1961w.openConnection();
			parser = new PDFParser(aRotQgJU.getInputStream());
		} catch (IOException cBnXsFFj) {
			cBnXsFFj.printStackTrace();
			return false;
		}
		return true;
	}

}