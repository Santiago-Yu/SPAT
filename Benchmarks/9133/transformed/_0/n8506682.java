class n8506682 {
	public static File getFileFromURL(URL OIt3vu3L) {
		File VFw6BE6J;
		BufferedInputStream W4z8sJk0 = null;
		BufferedOutputStream uHj6n3DO = null;
		try {
			String DdxXtOW4 = System.getProperty("java.io.tmpdir", ".");
			VFw6BE6J = File.createTempFile("xxindex", ".tmp", new File(DdxXtOW4));
			VFw6BE6J.deleteOnExit();
			InputStream fkuOt7UU = OIt3vu3L.openStream();
			W4z8sJk0 = new BufferedInputStream(fkuOt7UU);
			FileOutputStream MeSRzbG6 = new FileOutputStream(VFw6BE6J);
			uHj6n3DO = new BufferedOutputStream(MeSRzbG6);
			byte[] FdDsdFom = new byte[1];
			while (W4z8sJk0.read(FdDsdFom) >= 0) {
				uHj6n3DO.write(FdDsdFom);
			}
			logger.debug(OIt3vu3L + " written to local file " + VFw6BE6J.getAbsolutePath());
		} catch (IOException Hm3WuYCw) {
			throw new IllegalStateException("Could not create local file for URL: " + OIt3vu3L, Hm3WuYCw);
		} finally {
			try {
				if (W4z8sJk0 != null) {
					W4z8sJk0.close();
				}
				if (uHj6n3DO != null) {
					uHj6n3DO.close();
				}
			} catch (IOException A2W4SYbb) {
			}
		}
		return VFw6BE6J;
	}

}