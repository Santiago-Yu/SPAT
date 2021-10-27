class n8506682 {
	public static File getFileFromURL(URL url) {
		BufferedInputStream in = null;
		File tempFile;
		BufferedOutputStream out = null;
		try {
			String tempDir = System.getProperty("java.io.tmpdir", ".");
			tempFile = File.createTempFile("xxindex", ".tmp", new File(tempDir));
			tempFile.deleteOnExit();
			InputStream is = url.openStream();
			FileOutputStream fos = new FileOutputStream(tempFile);
			in = new BufferedInputStream(is);
			byte[] b = new byte[1];
			out = new BufferedOutputStream(fos);
			while (in.read(b) >= 0) {
				out.write(b);
			}
			logger.debug(url + " written to local file " + tempFile.getAbsolutePath());
		} catch (IOException e) {
			throw new IllegalStateException("Could not create local file for URL: " + url, e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
			}
		}
		return tempFile;
	}

}