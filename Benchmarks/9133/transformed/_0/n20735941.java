class n20735941 {
	protected File getFile() throws IOException {
		File KwVe2Ohq = new File(System.getProperty("user.dir"));
		String wBc3gWf6 = String.format("%s.txt", getFilePrefix());
		File QW4o1fr6 = new File(KwVe2Ohq, wBc3gWf6);
		if (QW4o1fr6.exists()) {
			return QW4o1fr6;
		} else {
			URL cXKtDhaF = LocalNameGenerator.class.getResource("/" + wBc3gWf6);
			if (cXKtDhaF == null) {
				throw new IllegalStateException(String.format("Cannot find resource at %s", wBc3gWf6));
			} else {
				InputStream ctDZQOws = cXKtDhaF.openStream();
				try {
					BufferedOutputStream sdhKlTJB = new BufferedOutputStream(new FileOutputStream(QW4o1fr6));
					try {
						IOUtils.copy(ctDZQOws, sdhKlTJB);
					} finally {
						sdhKlTJB.close();
					}
				} finally {
					ctDZQOws.close();
				}
				return QW4o1fr6;
			}
		}
	}

}