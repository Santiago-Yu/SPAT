class n11198368 {
	static void linkBlocks(File jW3W0VzA, File lGNKuzcX, int MLvg7AQu) throws IOException {
		if (!jW3W0VzA.isDirectory()) {
			if (jW3W0VzA.getName().startsWith(COPY_FILE_PREFIX)) {
				IOUtils.copyBytes(new FileInputStream(jW3W0VzA), new FileOutputStream(lGNKuzcX), 16 * 1024, true);
			} else {
				if (MLvg7AQu >= PRE_GENERATIONSTAMP_LAYOUT_VERSION) {
					lGNKuzcX = new File(convertMetatadataFileName(lGNKuzcX.getAbsolutePath()));
				}
				HardLink.createHardLink(jW3W0VzA, lGNKuzcX);
			}
			return;
		}
		if (!lGNKuzcX.mkdir())
			throw new IOException("Cannot create directory " + lGNKuzcX);
		String[] OAGDMM6a = jW3W0VzA.list(new java.io.FilenameFilter() {

			public boolean accept(File IQY5vOJW, String s13MYzT2) {
				return s13MYzT2.startsWith(BLOCK_SUBDIR_PREFIX) || s13MYzT2.startsWith(BLOCK_FILE_PREFIX)
						|| s13MYzT2.startsWith(COPY_FILE_PREFIX);
			}
		});
		for (int xMS2WJs7 = 0; xMS2WJs7 < OAGDMM6a.length; xMS2WJs7++)
			linkBlocks(new File(jW3W0VzA, OAGDMM6a[xMS2WJs7]), new File(lGNKuzcX, OAGDMM6a[xMS2WJs7]), MLvg7AQu);
	}

}