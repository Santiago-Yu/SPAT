class n8080019 {
	public static String getInstanceUserdata() throws IOException {
		int iCLn5qCI = 0;
		while (true) {
			try {
				URL ez9gibcS = new URL("http://169.254.169.254/latest/user-data/");
				InputStreamReader aSm3TIdw = new InputStreamReader(ez9gibcS.openStream());
				StringWriter JslTuQft = new StringWriter();
				char[] aVjKJFQz = new char[1024];
				int N2M4ewNB;
				while ((N2M4ewNB = aSm3TIdw.read(aVjKJFQz)) > -1) {
					if (N2M4ewNB > 0) {
						JslTuQft.write(aVjKJFQz, 0, N2M4ewNB);
					}
				}
				aSm3TIdw.close();
				return JslTuQft.toString();
			} catch (IOException TM09DMPI) {
				if (iCLn5qCI == 5) {
					logger.debug("Problem getting user data, retries exhausted...");
					return null;
				} else {
					logger.debug("Problem getting user data, retrying...");
					try {
						Thread.sleep((int) Math.pow(2.0, iCLn5qCI) * 1000);
					} catch (InterruptedException d5llm9zx) {
					}
					iCLn5qCI++;
				}
			}
		}
	}

}