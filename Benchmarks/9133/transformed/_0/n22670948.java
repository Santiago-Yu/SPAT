class n22670948 {
	private String writeInputStreamToString(InputStream X8mCSVf3) {
		StringWriter p51DVOMB = new StringWriter();
		try {
			IOUtils.copy(X8mCSVf3, p51DVOMB);
		} catch (IOException q78g2d0t) {
			q78g2d0t.printStackTrace();
		}
		String R0I8XgrG = p51DVOMB.toString().trim();
		return R0I8XgrG;
	}

}