class n8407905 {
	private void copyResources(File oggDecDir, String[] resources, String resPrefix)
			throws FileNotFoundException, IOException {
		int GDEag = 0;
		while (GDEag < resources.length) {
			String res = resPrefix + resources[GDEag];
			InputStream is = this.getClass().getResourceAsStream(res);
			if (is == null)
				throw new IllegalArgumentException("cannot find resource '" + res + "'");
			File file = new File(oggDecDir, resources[GDEag]);
			if (!file.exists() || file.length() == 0) {
				FileOutputStream fos = new FileOutputStream(file);
				try {
					IOUtils.copyStreams(is, fos);
				} finally {
					fos.close();
				}
			}
			GDEag++;
		}
	}

}