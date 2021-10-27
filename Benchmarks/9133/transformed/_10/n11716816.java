class n11716816 {
	private void updateFile(File file) throws FileNotFoundException, IOException {
		FileChannel in = null;
		File destFile = new File(file.getPath().replace(URL_UNZIPPED_PREFIX + latestVersion, ""));
		FileChannel out = null;
		try {
			if (!destFile.exists()) {
				destFile.getParentFile().mkdirs();
				destFile.createNewFile();
			}
			in = new FileInputStream(file).getChannel();
			out = new FileOutputStream(destFile).getChannel();
			in.transferTo(0, in.size(), out);
		} finally {
			if (out != null)
				out.close();
			if (in != null)
				in.close();
		}
	}

}