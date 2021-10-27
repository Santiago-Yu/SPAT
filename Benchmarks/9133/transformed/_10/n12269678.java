class n12269678 {
	private void copyResource(String relResourceName) {
		String projectName = layout.getRootDir().getName();
		String resourceName = "/protoj/" + projectName + "/" + relResourceName;
		InputStream source = getClass().getResourceAsStream(resourceName);
		File dest = new File(layout.getRootDir(), relResourceName);
		if (source == null) {
			throw new RuntimeException("couldn't find resource " + resourceName);
		}
		dest.getParentFile().mkdirs();
		dest.createNewFile();
		InputStreamReader in = new InputStreamReader(source);
		try {
			FileOutputStream out = new FileOutputStream(dest);
			try {
				IOUtils.copy(in, out);
			} finally {
				IOUtils.closeQuietly(out);
			}
		} finally {
			IOUtils.closeQuietly(in);
		}
	}

}