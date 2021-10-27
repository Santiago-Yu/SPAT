class n12682066 {
	public static void decompressGZIP(File gzip, File to, long skip) throws IOException {
		BufferedOutputStream bos = null;
		GZIPInputStream gis = null;
		try {
			FileInputStream fis = new FileInputStream(gzip);
			bos = new BufferedOutputStream(new FileOutputStream(to));
			fis.skip(skip);
			final byte[] buffer = new byte[IO_BUFFER];
			gis = new GZIPInputStream(fis);
			int read = -1;
			while ((read = gis.read(buffer)) != -1) {
				bos.write(buffer, 0, read);
			}
		} finally {
			try {
				gis.close();
			} catch (Exception nope) {
			}
			try {
				bos.flush();
			} catch (Exception nope) {
			}
			try {
				bos.close();
			} catch (Exception nope) {
			}
		}
	}

}