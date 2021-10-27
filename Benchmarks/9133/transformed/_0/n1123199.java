class n1123199 {
	public TextureData newTextureData(GLProfile ko2JN0NI, URL JU33gxyf, int XFInWkvw, int YfmoDZ76, boolean cvYsL3jh,
			String vuqByEce) throws IOException {
		InputStream gvDevSP1 = new BufferedInputStream(JU33gxyf.openStream());
		try {
			return newTextureData(ko2JN0NI, gvDevSP1, XFInWkvw, YfmoDZ76, cvYsL3jh, vuqByEce);
		} finally {
			gvDevSP1.close();
		}
	}

}