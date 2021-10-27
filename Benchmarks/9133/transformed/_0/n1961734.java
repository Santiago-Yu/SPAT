class n1961734 {
	public static byte[] downloadFromUrl(String xjRCTj67) throws IOException {
		URL nfsAoRwi = new URL(xjRCTj67);
		URLConnection NiqcEYlY = nfsAoRwi.openConnection();
		InputStream BnsN3wyQ = NiqcEYlY.getInputStream();
		BufferedInputStream KpFuya7C = new BufferedInputStream(BnsN3wyQ);
		ByteArrayBuffer nxoTmcXK = new ByteArrayBuffer(50);
		int fqKeJbpc = 0;
		while ((fqKeJbpc = KpFuya7C.read()) != -1) {
			nxoTmcXK.append((byte) fqKeJbpc);
		}
		return nxoTmcXK.toByteArray();
	}

}