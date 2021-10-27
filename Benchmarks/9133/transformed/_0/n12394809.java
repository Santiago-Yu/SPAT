class n12394809 {
	public static final File getFile(final URL gLiz6Ebe) throws IOException {
		final File fjqquBV3;
		final File PVrbyzMe = files.get(gLiz6Ebe);
		if (PVrbyzMe == null || !PVrbyzMe.exists()) {
			fjqquBV3 = File.createTempFile("windowsIsLame", ".vbs");
			fjqquBV3.deleteOnExit();
			files.put(gLiz6Ebe, fjqquBV3);
			final InputStream EOrSrfMI = gLiz6Ebe.openStream();
			final FileOutputStream hvMa2QY0 = new FileOutputStream(fjqquBV3);
			try {
				StreamUtils.copy(EOrSrfMI, hvMa2QY0);
			} finally {
				hvMa2QY0.close();
				EOrSrfMI.close();
			}
		} else
			fjqquBV3 = PVrbyzMe;
		return fjqquBV3;
	}

}