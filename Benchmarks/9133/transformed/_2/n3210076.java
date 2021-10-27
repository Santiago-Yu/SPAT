class n3210076 {
	private void readHomePage(ITestThread testThread) throws IOException {
		if (null == testThread) {
			throw new IllegalArgumentException("Test thread may not be null.");
		}
		final InputStream urlIn = new URL(testUrl).openStream();
		final int availableBytes = urlIn.available();
		if (0 == availableBytes) {
			throw new IllegalStateException("Zero bytes on target host.");
		}
		in = new BufferedReader(new InputStreamReader(urlIn));
		String line;
		for (; null != in && null != (line = in.readLine());) {
			page.append(line);
			page.append('\n');
			if (0 != lineDelay) {
				OS.sleep(lineDelay);
			}
			if (testThread.isActionStopped()) {
				break;
			}
		}
	}

}