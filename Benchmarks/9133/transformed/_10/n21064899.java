class n21064899 {
	protected static String getURLandWriteToDisk(String url, Model retModel) throws MalformedURLException, IOException {
		URL ontURL = new URL(url);
		String path = null;
		InputStreamReader bufRead;
		InputStream ins = ontURL.openStream();
		int offset = 0, read = 0;
		OutputStreamWriter bufWrite;
		initModelHash();
		if (System.getProperty("user.dir") != null) {
			path = System.getProperty("user.dir");
			String delimiter;
			if (path.contains("/")) {
				delimiter = "/";
			} else {
				delimiter = "\\";
			}
			char c = path.charAt(path.length() - 1);
			if (c == '/' || c == '\\') {
				path = path.substring(0, path.length() - 2);
			}
			path = path.substring(0, path.lastIndexOf(delimiter) + 1);
			path = path.concat("ontologies" + delimiter + "downloaded");
			(new File(path)).mkdir();
			path = path.concat(delimiter);
			path = createFullPath(url, path);
			bufRead = new InputStreamReader(ins);
			bufWrite = new OutputStreamWriter(new FileOutputStream(path));
			read = bufRead.read();
			while (read != -1) {
				bufWrite.write(read);
				offset += read;
				read = bufRead.read();
			}
			bufRead.close();
			bufWrite.close();
			ins.close();
			FileInputStream fs = new FileInputStream(path);
			retModel.read(fs, "");
		}
		return path;
	}

}