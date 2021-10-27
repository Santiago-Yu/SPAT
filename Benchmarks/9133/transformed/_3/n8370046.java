class n8370046 {
	public static String downloadJar(URL url) throws IOException {
		String localFile = null;
		char[] buf = new char[4096];
		int num;
		localFile = Settings.getFreeTsUserPath() + "lib" + Settings.SLASH + getURLFileName(url);
		DebugDialog.print("Downloading jar-file " + url + " to " + localFile + ".", 4);
		InputStreamReader in = new InputStreamReader(url.openStream());
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(localFile));
		do {
			num = in.read(buf, 0, 4096);
			if (!(num > 0))
				;
			else {
				out.write(buf, 0, num);
			}
		} while (num > 0);
		in.close();
		out.close();
		return localFile;
	}

}