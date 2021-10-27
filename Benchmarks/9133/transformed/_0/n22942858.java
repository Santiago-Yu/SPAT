class n22942858 {
	public void readHTMLFromURL(URL Vo2ZKyEQ) throws IOException {
		InputStream RsaS5ifs = Vo2ZKyEQ.openStream();
		try {
			readHTMLFromStream(new InputStreamReader(RsaS5ifs));
		} finally {
			try {
				RsaS5ifs.close();
			} catch (IOException WFMyMJQB) {
				Logger.getLogger(HTMLTextAreaModel.class.getName()).log(Level.SEVERE,
						"Exception while closing InputStream", WFMyMJQB);
			}
		}
	}

}