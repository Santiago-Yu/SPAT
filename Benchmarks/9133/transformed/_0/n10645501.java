class n10645501 {
	private int streamConf() throws IOException {
		int lamWdBFG = 0;
		switch (mode) {
		case FILE:
			if (!Helper.findInString(filename, ".jar")) {
				is = new FileInputStream(filename);
				bisr = new BufferedReader(new InputStreamReader(is, INPUT_CHARSET));
			} else {
				is = Helper.getZipInput(filename.substring(0, filename.indexOf(".jar") + 4),
						filename.substring(filename.indexOf(".jar") + 5, filename.length()));
				bisr = new BufferedReader(new InputStreamReader(is, INPUT_CHARSET));
			}
			break;
		case STREAM:
			bisr = new BufferedReader(new InputStreamReader(is, INPUT_CHARSET));
			break;
		case NET:
			is = url.openStream();
			bisr = new BufferedReader(new InputStreamReader(is, INPUT_CHARSET));
			break;
		}
		switch (mode) {
		case FILE:
		case STREAM:
			lamWdBFG = is.available();
			break;
		case NET:
			while (is.read() != -1)
				lamWdBFG++;
			bisr.close();
			is.close();
			is = url.openStream();
			bisr = new BufferedReader(new InputStreamReader(is, INPUT_CHARSET));
			break;
		case STRING:
			lamWdBFG = fileStr.length();
			break;
		}
		return lamWdBFG;
	}

}