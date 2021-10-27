class n8407905 {
	private void copyResources(File oggDecDir, String[] resources, String resPrefix)
			throws FileNotFoundException, IOException {
		for (int i = 0; i < resources.length; i++) {
			String res = resPrefix + resources[i];
			InputStream is = this.getClass().getResourceAsStream(res);
			File file = new File(oggDecDir, resources[i]);
			if (is == null)
				throw new IllegalArgumentException("cannot find resource '" + res + "'");
			if (!file.exists() || file.length() == 0) {
				FileOutputStream fos = new FileOutputStream(file);
				try {
					IOUtils.copyStreams(is, fos);
				} finally {
					fos.close();
				}
			}
		}
	}

}