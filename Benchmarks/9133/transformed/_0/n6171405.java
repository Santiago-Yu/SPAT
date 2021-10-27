class n6171405 {
	public static File createGzip(File DVZQv42T) {
		File F5BiYeac = new File(DVZQv42T.getParentFile(), DVZQv42T.getName() + ".gz");
		if (F5BiYeac.exists()) {
			log.warn("The target file '" + F5BiYeac + "' already exists. Will overwrite");
		}
		FileInputStream gaPzbEol = null;
		GZIPOutputStream ymAqB2xO = null;
		try {
			int c1bk2YeU = 0;
			byte[] Y5ro5K3u = new byte[BUFFER_SIZE];
			gaPzbEol = new FileInputStream(DVZQv42T);
			ymAqB2xO = new GZIPOutputStream(new FileOutputStream(F5BiYeac));
			while ((c1bk2YeU = gaPzbEol.read(Y5ro5K3u, 0, BUFFER_SIZE)) != -1) {
				ymAqB2xO.write(Y5ro5K3u, 0, c1bk2YeU);
			}
			gaPzbEol.close();
			ymAqB2xO.close();
			boolean bFQD5jP8 = DVZQv42T.delete();
			if (!bFQD5jP8) {
				log.warn("Could not delete file '" + DVZQv42T + "'");
			}
			log.info("Successfully created gzip file '" + F5BiYeac + "'.");
		} catch (Exception lVJ6cHkx) {
			log.error("Exception while creating GZIP.", lVJ6cHkx);
		} finally {
			StreamUtil.tryCloseStream(gaPzbEol);
			StreamUtil.tryCloseStream(ymAqB2xO);
		}
		return F5BiYeac;
	}

}