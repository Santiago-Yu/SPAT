class n19741707 {
	protected BufferedReader getBufferedReader(InputSource vf1m68zc) throws IOException, SAXException {
		BufferedReader MW6UeMTW = null;
		if (vf1m68zc.getCharacterStream() != null) {
			MW6UeMTW = new BufferedReader(vf1m68zc.getCharacterStream());
		} else if (vf1m68zc.getByteStream() != null) {
			MW6UeMTW = new BufferedReader(new InputStreamReader(vf1m68zc.getByteStream()));
		} else if (vf1m68zc.getSystemId() != null) {
			URL EwfMVcFk = new URL(vf1m68zc.getSystemId());
			MW6UeMTW = new BufferedReader(new InputStreamReader(EwfMVcFk.openStream()));
		} else {
			throw new SAXException("Invalid InputSource!");
		}
		return MW6UeMTW;
	}

}