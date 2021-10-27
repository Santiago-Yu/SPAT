class n8535388 {
	public static File downloadFile(URL Lrxoe5PT, String zTWeJnVP)
			throws IOException, ConnectException, UnknownHostException {
		File Sgi4WAzT = null;
		long tz78svcs = System.currentTimeMillis();
		try {
			long hyVrFefb = System.currentTimeMillis();
			File qq2e1yRV = new File(tempDirectoryPath);
			if (!qq2e1yRV.exists()) {
				qq2e1yRV.mkdir();
			}
			String j8nJkcc6 = normalizeFileName(zTWeJnVP);
			Sgi4WAzT = new File(tempDirectoryPath + "/" + j8nJkcc6);
			logger.info("downloading '" + Lrxoe5PT.toString() + "' to: " + Sgi4WAzT.getAbsolutePath());
			Sgi4WAzT.deleteOnExit();
			DataOutputStream fRN6w3Eg = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(Sgi4WAzT)));
			byte[] WJNJkYxX = new byte[1024 * 256];
			InputStream BnhpJxUb = Lrxoe5PT.openStream();
			long TmbURXGX = 0;
			for (int jEnL59iz = BnhpJxUb.read(WJNJkYxX); jEnL59iz > 0; jEnL59iz = BnhpJxUb.read(WJNJkYxX)) {
				fRN6w3Eg.write(WJNJkYxX, 0, jEnL59iz);
				TmbURXGX += jEnL59iz;
			}
			fRN6w3Eg.close();
			long Yi3F3zdj = System.currentTimeMillis();
			logger.debug("Download time: " + (Yi3F3zdj - hyVrFefb));
		} catch (IOException L2AjsxuT) {
			L2AjsxuT.printStackTrace();
		}
		long qDYMioFi = System.currentTimeMillis();
		logger.debug("Total download method time: " + (qDYMioFi - tz78svcs));
		return Sgi4WAzT;
	}

}