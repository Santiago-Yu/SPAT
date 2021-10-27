class n16755434 {
	public static int getContentLength(URL urlFileLocation) {
		int iFileSize = -1;
		HttpURLConnection connFile = null;
		try {
			connFile = (HttpURLConnection) urlFileLocation.openConnection();
			connFile.setDoInput(true);
			InputStream is = connFile.getInputStream();
			iFileSize = connFile.getContentLength();
			is.close();
			connFile.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return iFileSize;
	}

}