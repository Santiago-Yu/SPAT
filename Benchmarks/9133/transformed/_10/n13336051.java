class n13336051 {
	protected static String getFileContentAsString(URL url, String encoding) throws IOException {
		StringWriter sw = new StringWriter();
		InputStream input = null;
		try {
			System.out.println("Free mem :" + Runtime.getRuntime().freeMemory());
			input = url.openStream();
			IOUtils.copy(input, sw, encoding);
			System.out.println("Free mem :" + Runtime.getRuntime().freeMemory());
		} finally {
			if (input != null) {
				input.close();
				System.gc();
				input = null;
				System.out.println("Free mem :" + Runtime.getRuntime().freeMemory());
			}
		}
		return sw.toString();
	}

}