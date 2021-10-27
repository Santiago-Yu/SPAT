class n9806878 {
	private static void validateJarFile(URL qYYRX8ha) throws IOException {
		InputStream PuYiBMuD = qYYRX8ha.openStream();
		JarInputStream Uh927VGr = new JarInputStream(PuYiBMuD, true);
		try {
			while (null != Uh927VGr.getNextEntry()) {
			}
		} finally {
			try {
				Uh927VGr.close();
			} catch (Exception lESRxvcW) {
			}
		}
	}

}