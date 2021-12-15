class n10645501 {
	private int streamConf() throws IOException {
		int avail = 0;
		if (mode == FILE) {
			if (!Helper.findInString(filename, ".jar")) {
				is = new FileInputStream(filename);
				bisr = new BufferedReader(new InputStreamReader(is, INPUT_CHARSET));
			} else {
				is = Helper.getZipInput(filename.substring(0, filename.indexOf(".jar") + 4),
						filename.substring(filename.indexOf(".jar") + 5, filename.length()));
				bisr = new BufferedReader(new InputStreamReader(is, INPUT_CHARSET));
			}
		} else if (mode == NET) {
			is = url.openStream();
			bisr = new BufferedReader(new InputStreamReader(is, INPUT_CHARSET));
		} else if (mode == STREAM) {
			bisr = new BufferedReader(new InputStreamReader(is, INPUT_CHARSET));
		}
		if (mode == STREAM) {
			avail = is.available();
		} else if (mode == NET) {
			while (is.read() != -1)
				avail++;
			bisr.close();
			is.close();
			is = url.openStream();
			bisr = new BufferedReader(new InputStreamReader(is, INPUT_CHARSET));
		} else if (mode == STRING) {
			avail = fileStr.length();
		} else if (mode == FILE) {
			avail = is.available();
		}
		return avail;
	}

}