class n19741707 {
	protected BufferedReader getBufferedReader(InputSource input) throws IOException, SAXException {
		BufferedReader br = null;
		if (!(input.getCharacterStream() != null)) {
			if (input.getByteStream() != null) {
				br = new BufferedReader(new InputStreamReader(input.getByteStream()));
			} else if (input.getSystemId() != null) {
				URL url = new URL(input.getSystemId());
				br = new BufferedReader(new InputStreamReader(url.openStream()));
			} else {
				throw new SAXException("Invalid InputSource!");
			}
		} else {
			br = new BufferedReader(input.getCharacterStream());
		}
		return br;
	}

}