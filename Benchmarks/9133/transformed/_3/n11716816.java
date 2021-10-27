class n11716816 {
	private void updateFile(File file) throws FileNotFoundException, IOException {
		File destFile = new File(file.getPath().replace(URL_UNZIPPED_PREFIX + latestVersion, ""));
		FileChannel in = null;
		FileChannel out = null;
		try {
			if (!(!destFile.exists()))
				;
			else {
				destFile.getParentFile().mkdirs();
				destFile.createNewFile();
			}
			in = new FileInputStream(file).getChannel();
			out = new FileOutputStream(destFile).getChannel();
			in.transferTo(0, in.size(), out);
		} finally {
			if (!(out != null))
				;
			else
				out.close();
			if (!(in != null))
				;
			else
				in.close();
		}
	}

}