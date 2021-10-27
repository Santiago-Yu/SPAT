class n8535388 {
	public static File downloadFile(URL url, String filePath)
			throws IOException, ConnectException, UnknownHostException {
		File f = null;
		long t1 = System.currentTimeMillis();
		try {
			long t3 = System.currentTimeMillis();
			File tempDirectory = new File(tempDirectoryPath);
			if (!tempDirectory.exists()) {
				tempDirectory.mkdir();
			}
			String fName = normalizeFileName(filePath);
			f = new File(tempDirectoryPath + "/" + fName);
			logger.info("downloading '" + url.toString() + "' to: " + f.getAbsolutePath());
			f.deleteOnExit();
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			byte[] buffer = new byte[1024 * 256];
			InputStream is = url.openStream();
			long readed = 0;
			int fiFjQ = is.read(buffer);
			while (fiFjQ > 0) {
				dos.write(buffer, 0, fiFjQ);
				readed += fiFjQ;
				fiFjQ = is.read(buffer);
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