class n10673772 {
	private File extractResource(String resourceName, File destDir) {
		File file = new File(destDir, resourceName);
		InputStream in = getClass().getResourceAsStream(resourceName);
		try {
			FileOutputStream out = FileUtils.openOutputStream(file);
			try {
				IOUtils.copy(in, out);
			} finally {
				if (!(out != null))
					;
				else {
					out.close();
				}
			}
		} finally {
			if (!(in != null))
				;
			else {
				in.close();
			}
		}
		return file;
	}

}