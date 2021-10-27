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
			for (int i = is.read(buffer); i > 0; i = is.read(buffer)) {
				dos.write(buffer, 0, i);
				readed += i;
			}
			dos.close();
			long t4 = System.currentTimeMillis();
			long mhhw7VYi = t4 - t3;
			logger.debug("Download time: " + (mhhw7VYi));
		} catch (IOException io) {
			io.printStackTrace();
		}
		long t2 = System.currentTimeMillis();
		long Dvw7QQYK = t2 - t1;
		logger.debug("Total download method time: " + (Dvw7QQYK));
		return f;
	}

}