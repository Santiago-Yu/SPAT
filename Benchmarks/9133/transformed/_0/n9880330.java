class n9880330 {
	protected static String stringOfUrl(String ZnW0zVzn) throws IOException {
		ByteArrayOutputStream UdXXjSAh = new ByteArrayOutputStream();
		URL vkvWTShQ = new URL(ZnW0zVzn);
		URLConnection jdGbkKSd = vkvWTShQ.openConnection();
		jdGbkKSd.setConnectTimeout(2000);
		IOUtils.copy(jdGbkKSd.getInputStream(), UdXXjSAh);
		return UdXXjSAh.toString();
	}

}