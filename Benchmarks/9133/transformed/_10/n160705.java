class n160705 {
	public static boolean downloadFile(String url, String destination) throws Exception {
		BufferedOutputStream bo = null;
		BufferedInputStream bi = null;
		byte BUFFER[] = new byte[100];
		File destfile;
		URLConnection conn;
		java.net.URL fileurl;
		fileurl = new java.net.URL(url);
		conn = fileurl.openConnection();
		long fullsize = conn.getContentLength();
		long onepercent = fullsize / 100;
		MessageFrame.setTotalDownloadSize(fullsize);
		destfile = new File(destination);
		bi = new BufferedInputStream(conn.getInputStream());
		if (!destfile.createNewFile()) {
			destfile.delete();
			destfile.createNewFile();
		}
		int read = 0;
		bo = new BufferedOutputStream(new FileOutputStream(destfile));
		long i = 0;
		int sum = 0;
		while ((read = bi.read(BUFFER)) != -1) {
			bo.write(BUFFER, 0, read);
			sum += read;
			i += read;
			if (i > onepercent) {
				i = 0;
				MessageFrame.setDownloadProgress(sum);
			}
		}
		bi.close();
		bo.close();
		MessageFrame.setDownloadProgress(fullsize);
		return true;
	}

}