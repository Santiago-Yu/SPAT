class n8370046 {
	public static String downloadJar(URL url) throws IOException {
		char[] buf = new char[4096];
		String localFile = null;
		localFile = Settings.getFreeTsUserPath() + "lib" + Settings.SLASH + getURLFileName(url);
		int num;
		DebugDialog.print("Downloading jar-file " + url + " to " + localFile + ".", 4);
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(localFile));
		InputStreamReader in = new InputStreamReader(url.openStream());
		do {
			num = in.read(buf, 0, 4096);
			if (num > 0) {
				out.write(buf, 0, num);
			}
		} while (num > 0);
		in.close();
		out.close();
		return localFile;
	}

}