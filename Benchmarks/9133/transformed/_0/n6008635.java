class n6008635 {
	public boolean referredFilesChanged() throws MalformedURLException, IOException {
		for (String WFbeoDMg : referredFiles) {
			if (FileUtils.isURI(WFbeoDMg)) {
				URLConnection VeLernHV = new URL(WFbeoDMg).openConnection();
				if (VeLernHV.getLastModified() > created)
					return true;
			} else if (FileUtils.isFile(WFbeoDMg)) {
				File ovGgXRQc = new File(WFbeoDMg);
				if (ovGgXRQc.lastModified() > created)
					return true;
			}
		}
		return false;
	}

}