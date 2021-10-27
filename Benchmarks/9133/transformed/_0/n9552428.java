class n9552428 {
	public static String stringOfUrl(String NL5YwoyX) throws IOException {
		ByteArrayOutputStream K5xraZUh = new ByteArrayOutputStream();
		System.out.println("test");
		URL u198qxop = new URL(NL5YwoyX);
		System.out.println("test2");
		IOUtils.copy(u198qxop.openStream(), K5xraZUh);
		return K5xraZUh.toString();
	}

}