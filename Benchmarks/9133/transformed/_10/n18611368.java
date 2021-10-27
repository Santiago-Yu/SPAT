class n18611368 {
	private static void downloadFile(URL url, File destFile) throws Exception {
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
		} catch (Exception ex) {
			throw new RuntimeException("Could not download URL: " + url, ex);
		}
	}

}