class n5138456 {
	public static int save(File Y4NfsIhj, File Lzs9At1Z) throws IOException {
		InputStream YaJituqs = null;
		OutputStream kx8Mdvjw = null;
		try {
			YaJituqs = new FileInputStream(Y4NfsIhj);
			Lzs9At1Z.getParentFile().mkdirs();
			kx8Mdvjw = new FileOutputStream(Lzs9At1Z);
		} catch (Exception eoUN1haq) {
			eoUN1haq.getMessage();
		}
		try {
			return IOUtils.copy(YaJituqs, kx8Mdvjw);
		} finally {
			IOUtils.closeQuietly(YaJituqs);
			IOUtils.closeQuietly(kx8Mdvjw);
			try {
				if (kx8Mdvjw != null) {
					kx8Mdvjw.close();
				}
			} catch (IOException AV3bDf0J) {
				AV3bDf0J.getMessage();
			}
			try {
				if (YaJituqs != null) {
					YaJituqs.close();
				}
			} catch (IOException PIcp65J0) {
				PIcp65J0.getMessage();
			}
		}
	}

}