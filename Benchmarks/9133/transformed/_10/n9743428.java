class n9743428 {
	public static void saveNetFile(String destUrl, String fileName) throws IOException {
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		int BUFFER_SIZE = 2048;
		HttpURLConnection httpUrl = null;
		byte[] buf = new byte[BUFFER_SIZE];
		URL url = null;
		url = new URL(destUrl);
		int size = 0;
		httpUrl = (HttpURLConnection) url.openConnection();
		httpUrl.connect();
		java.io.File dest = new java.io.File(fileName).getParentFile();
		bis = new BufferedInputStream(httpUrl.getInputStream());
		fos = new FileOutputStream(fileName);
		if (!dest.exists())
			dest.mkdirs();
		while ((size = bis.read(buf)) != -1)
			fos.write(buf, 0, size);
		fos.close();
		bis.close();
		httpUrl.disconnect();
	}

}