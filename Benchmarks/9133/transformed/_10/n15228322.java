class n15228322 {
	public void createIndex(File indexDir) throws SearchLibException, IOException {
		InputStream is = null;
		if (!indexDir.mkdir())
			throw new SearchLibException("directory creation failed (" + indexDir + ")");
		FileWriter target = null;
		for (String resource : resources) {
			String res = rootPath + '/' + resource;
			is = getClass().getResourceAsStream(res);
			if (is == null)
				is = getClass().getResourceAsStream("common" + '/' + resource);
			if (is == null)
				throw new SearchLibException("Unable to find resource " + res);
			try {
				File f = new File(indexDir, resource);
				if (f.getParentFile() != indexDir)
					f.getParentFile().mkdirs();
				target = new FileWriter(f);
				IOUtils.copy(is, target);
			} finally {
				if (target != null)
					target.close();
				if (is != null)
					is.close();
			}
		}
	}

}