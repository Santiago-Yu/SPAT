class n19141603 {
	public static String stringOfUrl(String yfucWMDK) throws IOException {
		ByteArrayOutputStream CwHnxVJA = new ByteArrayOutputStream();
		URL VyUbkM4F = new URL(yfucWMDK);
		IOUtils.copy(VyUbkM4F.openStream(), CwHnxVJA);
		return CwHnxVJA.toString();
	}

}