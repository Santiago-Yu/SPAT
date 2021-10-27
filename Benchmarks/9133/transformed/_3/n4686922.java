class n4686922 {
	public void extractResourceToFile(String resourcePath, File dest) {
		InputStream in = getClass().getResourceAsStream(resourcePath);
		try {
			FileOutputStream out = FileUtils.openOutputStream(dest);
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
	}

}