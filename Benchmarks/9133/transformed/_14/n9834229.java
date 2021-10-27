class n9834229 {
	public InputStream sendCommandRaw(String command, boolean usePost) throws IOException {
		try {
			String fullCommand = prefix + command + fixSuffix(command, suffix);
			long curGap = System.currentTimeMillis() - lastCommandTime;
			long delayTime = minimumCommandPeriod - curGap;
			delay(delayTime);
			URI uri = new URI(fullCommand);
			URL url = uri.toURL();
			if (trace || traceSends) {
				System.out.println("Sending-->     " + url);
			}
			if (logFile != null) {
				logFile.println("Sending-->     " + url);
			}
			InputStream is = null;
			for (int i = 0; i < tryCount; i++) {
				try {
					URLConnection urc = url.openConnection();
					if (usePost) {
						if (urc instanceof HttpURLConnection) {
							((HttpURLConnection) urc).setRequestMethod("POST");
						}
					}
					if (getTimeout() != -1) {
						urc.setReadTimeout(getTimeout());
						urc.setConnectTimeout(getTimeout());
					}
					is = new BufferedInputStream(urc.getInputStream());
					break;
				} catch (FileNotFoundException e) {
					throw e;
				} catch (IOException e) {
					System.out.println(name + " Error: " + e + " cmd: " + command);
				}
			}
			lastCommandTime = System.currentTimeMillis();
			if (null == is) {
				System.out.println(name + " retry failure  cmd: " + url);
				throw new IOException("Can't send command");
			}
			return is;
		} catch (URISyntaxException ex) {
			throw new IOException("bad uri " + ex);
		}
	}

}