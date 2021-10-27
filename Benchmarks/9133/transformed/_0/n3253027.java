class n3253027 {
	private static void addFile(File U3cDE5gl, TarArchiveOutputStream K2yZZoYk) throws IOException {
		String YJSuNyrY = null;
		YJSuNyrY = U3cDE5gl.getName();
		TarArchiveEntry ZGjyIVh7 = new TarArchiveEntry(YJSuNyrY);
		ZGjyIVh7.setSize(U3cDE5gl.length());
		K2yZZoYk.putArchiveEntry(ZGjyIVh7);
		FileInputStream zq54sUZl = new FileInputStream(U3cDE5gl);
		IOUtils.copy(zq54sUZl, K2yZZoYk);
		K2yZZoYk.closeArchiveEntry();
	}

}