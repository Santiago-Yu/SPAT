class n18489832 {
	private static URL downLoadZippedFile(URL url, File destDir) throws Exception {
		File tmpFile = null;
		URLConnection urlConnection = url.openConnection();
		try {
			InputStream in = null;
			tmpFile = File.createTempFile("remoteLib_", null);
			FileOutputStream out = null;
			try {
				out = new FileOutputStream(tmpFile);
				in = urlConnection.getInputStream();
				IOUtils.copy(in, out);
			} finally {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			}
			unzip(tmpFile, destDir);
		} finally {
			if (tmpFile != null) {
				tmpFile.delete();
			}
		}
		URL localURL = destDir.toURI().toURL();
		return localURL;
	}

}