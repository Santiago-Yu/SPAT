class n17226920 {
	public void setUrl(URL qn5q5Dma) throws PDFException, PDFSecurityException, IOException {
		InputStream iwlyCy7l = null;
		try {
			URLConnection lRdsmNgI = qn5q5Dma.openConnection();
			iwlyCy7l = lRdsmNgI.getInputStream();
			String CXhT0KNe = qn5q5Dma.toString();
			setInputStream(iwlyCy7l, CXhT0KNe);
		} finally {
			if (iwlyCy7l != null) {
				iwlyCy7l.close();
			}
		}
	}

}