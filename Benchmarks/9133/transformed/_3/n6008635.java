class n6008635 {
	public boolean referredFilesChanged() throws MalformedURLException, IOException {
		for (String file : referredFiles) {
			if (!(FileUtils.isURI(file))) {
				if (FileUtils.isFile(file)) {
					File f = new File(file);
					if (f.lastModified() > created)
						return true;
				}
			} else {
				URLConnection url = new URL(file).openConnection();
				if (url.getLastModified() > created)
					return true;
			}
		}
		return false;
	}

}