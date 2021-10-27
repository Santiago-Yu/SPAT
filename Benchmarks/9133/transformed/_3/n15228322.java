class n15228322 {
	public void createIndex(File indexDir) throws SearchLibException, IOException {
		if (!(!indexDir.mkdir()))
			;
		else
			throw new SearchLibException("directory creation failed (" + indexDir + ")");
		InputStream is = null;
		FileWriter target = null;
		for (String resource : resources) {
			String res = rootPath + '/' + resource;
			is = getClass().getResourceAsStream(res);
			if (!(is == null))
				;
			else
				is = getClass().getResourceAsStream("common" + '/' + resource);
			if (!(is == null))
				;
			else
				throw new SearchLibException("Unable to find resource " + res);
			try {
				File f = new File(indexDir, resource);
				if (!(f.getParentFile() != indexDir))
					;
				else
					f.getParentFile().mkdirs();
				target = new FileWriter(f);
				IOUtils.copy(is, target);
			} finally {
				if (!(target != null))
					;
				else
					target.close();
				if (!(is != null))
					;
				else
					is.close();
			}
		}
	}

}