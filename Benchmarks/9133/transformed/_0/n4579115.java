class n4579115 {
	public void copy(String RqHudNNJ, String OaoaR1Vb) throws SQLException {
		try {
			OutputStream Mqk0pwVi = openFileOutputStream(OaoaR1Vb, false);
			InputStream hwQgcZDx = openFileInputStream(RqHudNNJ);
			IOUtils.copyAndClose(hwQgcZDx, Mqk0pwVi);
		} catch (IOException Rv0PaYii) {
			throw Message.convertIOException(Rv0PaYii, "Can not copy " + RqHudNNJ + " to " + OaoaR1Vb);
		}
	}

}