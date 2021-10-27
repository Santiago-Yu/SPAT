class n18489831 {
	private static URL downloadFile(URL url, File destFile) throws Exception {
		try {
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
				FileUtils.copyFile(tmpFile, destFile);
			} finally {
				if (tmpFile != null) {
					tmpFile.delete();
				}
			}
			URL localURL = destFile.toURI().toURL();
			return localURL;
		} catch (Exception ex) {
			throw new RuntimeException("Could not download URL: " + url, ex);
		}
	}

}