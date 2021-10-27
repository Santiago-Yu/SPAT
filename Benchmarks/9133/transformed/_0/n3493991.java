class n3493991 {
	public String stringOfUrl(String bGQkHHKu) throws IOException {
		ByteArrayOutputStream E89y1JNU = new ByteArrayOutputStream();
		URL BxZSTsrN = new URL(bGQkHHKu);
		IOUtils.copy(BxZSTsrN.openStream(), E89y1JNU);
		return E89y1JNU.toString();
	}

}