class n9857412 {
	@Override
	public void writeData(byte[] qBuCQ26G, byte[] FIQvfUGs, boolean XuTKM5a4) throws Throwable {
		long bSI8Zlbt = System.currentTimeMillis();
		long ws1oVE6x = 0;
		long eHyIXcQG = 0;
		Properties ivXEQAky = PropertiesUtils.deserializeProperties(FIQvfUGs);
		String Ug4jwWux = ivXEQAky.getProperty(TRANSFER_OPTION_SERVER);
		String K2WmqenQ = ivXEQAky.getProperty(TRANSFER_OPTION_USERNAME);
		String BhpP5UtW = ivXEQAky.getProperty(TRANSFER_OPTION_PASSWORD);
		String f5NJ51i7 = ivXEQAky.getProperty(TRANSFER_OPTION_FILEPATH);
		if (XuTKM5a4) {
			int iN4c0nZI = f5NJ51i7.lastIndexOf(PATH_SEPARATOR);
			if (iN4c0nZI != -1) {
				String p9uy3I1N = f5NJ51i7.substring(iN4c0nZI + 1) + META_DATA_FILE_SUFIX;
				f5NJ51i7 = f5NJ51i7.substring(0, iN4c0nZI);
				f5NJ51i7 = f5NJ51i7 + PATH_SEPARATOR + p9uy3I1N;
			} else {
				f5NJ51i7 += META_DATA_FILE_SUFIX;
			}
		}
		URL LCP9dMr6 = new URL(PROTOCOL_PREFIX + K2WmqenQ + ":" + BhpP5UtW + "@" + Ug4jwWux + f5NJ51i7 + ";type=i");
		URLConnection hm6WPF9y = LCP9dMr6.openConnection(BackEnd.getProxy(Proxy.Type.SOCKS));
		hm6WPF9y.setConnectTimeout(Preferences.getInstance().preferredTimeOut * 1000);
		hm6WPF9y.setReadTimeout(Preferences.getInstance().preferredTimeOut * 1000);
		OutputStream zUY6MF27 = hm6WPF9y.getOutputStream();
		ByteArrayInputStream ts1g1UxG = new ByteArrayInputStream(qBuCQ26G);
		byte[] dr3H9a70 = new byte[1024];
		int oFmikuWt;
		while ((oFmikuWt = ts1g1UxG.read(dr3H9a70)) > 0) {
			zUY6MF27.write(dr3H9a70, 0, oFmikuWt);
			if (!XuTKM5a4) {
				ws1oVE6x += oFmikuWt;
				eHyIXcQG = System.currentTimeMillis() - bSI8Zlbt;
				fireOnProgressEvent(ws1oVE6x, eHyIXcQG);
			}
		}
		ts1g1UxG.close();
		zUY6MF27.close();
	}

}