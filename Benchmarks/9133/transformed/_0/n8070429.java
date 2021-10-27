class n8070429 {
	public String getSource(String sJQiiItv) throws Exception {
		HttpURLConnection m39fJh3N = null;
		URL lOrfu0RY = new URL(sJQiiItv);
		m39fJh3N = (HttpURLConnection) lOrfu0RY.openConnection();
		m39fJh3N.setConnectTimeout(timeout);
		if (!m39fJh3N.getContentType().contains("text/html")) {
			throw new Exception();
		}
		if (m39fJh3N.getResponseCode() != 200) {
			throw new Exception();
		}
		encoding = getPageEncoding(m39fJh3N);
		if (encoding == null) {
			encoding = defaultEncoding;
		}
		InputStream QHn1S2bz = lOrfu0RY.openStream();
		byte[] QgdCTR2T = new byte[12288];
		StringBuffer Iu9u2VYV = new StringBuffer();
		int OA69BSIi = 0;
		while ((OA69BSIi = QHn1S2bz.read(QgdCTR2T)) != -1) {
			String PQXEa3wj = new String(QgdCTR2T, 0, OA69BSIi, encoding);
			Iu9u2VYV.append(PQXEa3wj);
		}
		QHn1S2bz.close();
		return Iu9u2VYV.toString();
	}

}