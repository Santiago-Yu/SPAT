class n8216539 {
	protected String getFileContentAsString(String cNWlmjPc, String qe90RQVr) throws IOException {
		URL N6c62VnQ = Thread.currentThread().getContextClassLoader().getResource(cNWlmjPc);
		InputStream o4O2G7bh = null;
		StringWriter dkJ7tqxs = new StringWriter();
		try {
			if (N6c62VnQ != null) {
				o4O2G7bh = N6c62VnQ.openStream();
			} else {
				o4O2G7bh = new FileInputStream(cNWlmjPc);
			}
			IOUtils.copy(o4O2G7bh, dkJ7tqxs, qe90RQVr);
		} finally {
			if (o4O2G7bh != null) {
				o4O2G7bh.close();
			}
		}
		return dkJ7tqxs.toString();
	}

}