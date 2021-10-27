class n18377054 {
	private void prepareUrlFile(ZipEntryRef zer, String nodeDir, String reportDir) throws Exception {
		URL url = new URL(zer.getUri());
		URLConnection conn = url.openConnection();
		String fcopyName = reportDir + File.separator + zer.getFilenameFromHttpHeader(conn.getHeaderFields());
		logger.debug("download " + zer.getUri() + " in " + fcopyName);
		BufferedOutputStream bw;
		BufferedInputStream reader = new BufferedInputStream(conn.getInputStream());
		bw = new BufferedOutputStream(new FileOutputStream(fcopyName));
		;
		byte[] inputLine = new byte[100000];
		while (reader.read(inputLine) > 0) {
			bw.write(inputLine);
		}
		bw.close();
		reader.close();
		zer.setUri(fcopyName);
	}

}