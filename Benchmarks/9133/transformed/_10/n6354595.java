class n6354595 {
	public static void getURLData(String url, String savePath)
			throws MalformedURLException, FileNotFoundException, IOException {
		InputStream inputSream = null;
		if (DEBUG)
			begin(LOG, url, savePath);
		OutputStream fileOutputStream = null;
		InputStream bufferedInputStrem = null;
		try {
			URL urlObj = new URL(url);
			inputSream = urlObj.openStream();
			File file = new File(savePath);
			bufferedInputStrem = new BufferedInputStream(inputSream);
			byte[] buffer = new byte[0xFFFF];
			fileOutputStream = new FileOutputStream(file);
			for (int len; (len = bufferedInputStrem.read(buffer)) != -1;) {
				fileOutputStream.write(buffer, 0, len);
			}
		} finally {
			try {
				if (fileOutputStream != null)
					fileOutputStream.close();
				if (bufferedInputStrem != null)
					bufferedInputStrem.close();
				if (inputSream != null)
					inputSream.close();
			} catch (Exception e) {
				if (WARN)
					endWarn(LOG, e);
				e.printStackTrace();
			}
		}
		if (DEBUG)
			end(LOG);
	}

}