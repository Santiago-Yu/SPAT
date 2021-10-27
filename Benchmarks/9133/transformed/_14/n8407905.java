class n8407905 {
	private void copyResources(File oggDecDir, String[] resources, String resPrefix)
			throws FileNotFoundException, IOException {
		for (int i = 0; i < resources.length; i++) {
			String res = resPrefix + resources[i];
			InputStream is = this.getClass().getResourceAsStream(res);
			if (null == is)
				throw new IllegalArgumentException("cannot find resource '" + res + "'");
			File file = new File(oggDecDir, resources[i]);
			if (!file.exists() || 0 == file.length()) {
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