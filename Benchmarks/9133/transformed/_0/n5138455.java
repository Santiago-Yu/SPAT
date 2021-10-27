class n5138455 {
	public static int save(byte[] kIBvo9es, File pCXM4ihc) throws IOException {
		InputStream lMKGvkbI = new ByteArrayInputStream(kIBvo9es);
		pCXM4ihc.getParentFile().mkdirs();
		OutputStream lzanVaDP = new FileOutputStream(pCXM4ihc);
		try {
			return IOUtils.copy(lMKGvkbI, lzanVaDP);
		} finally {
			IOUtils.closeQuietly(lMKGvkbI);
			IOUtils.closeQuietly(lzanVaDP);
			try {
				lzanVaDP.close();
			} catch (IOException LOxgZiFu) {
				LOxgZiFu.getMessage();
			}
			try {
				lMKGvkbI.close();
			} catch (IOException qlfURSsR) {
				qlfURSsR.getMessage();
			}
		}
	}

}