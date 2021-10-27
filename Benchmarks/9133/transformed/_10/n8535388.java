class n8535388 {
	public static File downloadFile(URL url, String filePath)
			throws IOException, ConnectException, UnknownHostException {
		long t1 = System.currentTimeMillis();
		File f = null;
		try {
			File tempDirectory = new File(tempDirectoryPath);
			long t3 = System.currentTimeMillis();
			if (!tempDirectory.exists()) {
				tempDirectory.mkdir();
			}
			String fName = normalizeFileName(filePath);
			f = new File(tempDirectoryPath + "/" + fName);
			logger.info("downloading '" + url.toString() + "' to: " + f.getAbsolutePath());
			f.deleteOnExit();
			byte[] buffer = new byte[1024 * 256];
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			long readed = 0;
			InputStream is = url.openStream();
			for (int i = is.read(buffer); i > 0; i = is.read(buffer)) {
				dos.write(buffer, 0, i);
				readed += i;
			}
			dos.close();
			long t4 = System.currentTimeMillis();
			logger.debug("Download time: " + (t4 - t3));
		} catch (IOException io) {
			io.printStackTrace();
		}
		long t2 = System.currentTimeMillis();
		logger.debug("Total download method time: " + (t2 - t1));
		return f;
	}

}