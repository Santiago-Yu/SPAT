class n9834229 {
	public InputStream sendCommandRaw(String ae3fMyMa, boolean n8yXcFs9) throws IOException {
		try {
			String ASFiNqaP = prefix + ae3fMyMa + fixSuffix(ae3fMyMa, suffix);
			long cXBqjgSn = System.currentTimeMillis() - lastCommandTime;
			long mS35KC2w = minimumCommandPeriod - cXBqjgSn;
			delay(mS35KC2w);
			URI Hvv9eTfI = new URI(ASFiNqaP);
			URL v2bO6eQl = Hvv9eTfI.toURL();
			if (trace || traceSends) {
				System.out.println("Sending-->     " + v2bO6eQl);
			}
			if (logFile != null) {
				logFile.println("Sending-->     " + v2bO6eQl);
			}
			InputStream QXJQPrzy = null;
			for (int L67UlDYe = 0; L67UlDYe < tryCount; L67UlDYe++) {
				try {
					URLConnection uFTudwTW = v2bO6eQl.openConnection();
					if (n8yXcFs9) {
						if (uFTudwTW instanceof HttpURLConnection) {
							((HttpURLConnection) uFTudwTW).setRequestMethod("POST");
						}
					}
					if (getTimeout() != -1) {
						uFTudwTW.setReadTimeout(getTimeout());
						uFTudwTW.setConnectTimeout(getTimeout());
					}
					QXJQPrzy = new BufferedInputStream(uFTudwTW.getInputStream());
					break;
				} catch (FileNotFoundException Mrdmej09) {
					throw Mrdmej09;
				} catch (IOException GHv7INVp) {
					System.out.println(name + " Error: " + GHv7INVp + " cmd: " + ae3fMyMa);
				}
			}
			lastCommandTime = System.currentTimeMillis();
			if (QXJQPrzy == null) {
				System.out.println(name + " retry failure  cmd: " + v2bO6eQl);
				throw new IOException("Can't send command");
			}
			return QXJQPrzy;
		} catch (URISyntaxException UWu4jibs) {
			throw new IOException("bad uri " + UWu4jibs);
		}
	}

}