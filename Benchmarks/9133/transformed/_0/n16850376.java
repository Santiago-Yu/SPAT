class n16850376 {
	public static void uncompress(File Rblw1awU, File bWI0vgPa) throws IOException {
		InputStream w7PkYJem = null;
		OutputStream rXksXNGD = null;
		try {
			w7PkYJem = new GZIPInputStream(new FileInputStream(Rblw1awU));
			rXksXNGD = new BufferedOutputStream(new FileOutputStream(bWI0vgPa));
			IOUtils.copyLarge(w7PkYJem, rXksXNGD);
		} finally {
			IOUtils.closeQuietly(rXksXNGD);
			IOUtils.closeQuietly(w7PkYJem);
		}
	}

}