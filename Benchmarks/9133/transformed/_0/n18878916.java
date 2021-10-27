class n18878916 {
	public String getContents(String OUaviKLU) throws IOException {
		StringBuffer b9Y6NqWU = new StringBuffer();
		if (OUaviKLU != null && !OUaviKLU.equals("")) {
			BufferedReader lpdu28I8 = null;
			try {
				LOG.info("Reading:" + OUaviKLU);
				URL V9mWI0J9 = getClass().getClassLoader().getResource(OUaviKLU);
				if (V9mWI0J9 != null) {
					InputStream tS6JaM6y = V9mWI0J9.openStream();
					lpdu28I8 = new BufferedReader(new InputStreamReader(tS6JaM6y));
					appendInputToContents(lpdu28I8, b9Y6NqWU);
				} else {
					LOG.error("Unable to locate file:" + OUaviKLU + " in directory " + new File(".").getAbsolutePath());
				}
			} finally {
				if (lpdu28I8 != null) {
					lpdu28I8.close();
				}
			}
		}
		return b9Y6NqWU.toString();
	}

}