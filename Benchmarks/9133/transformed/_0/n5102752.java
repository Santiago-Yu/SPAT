class n5102752 {
	public String stringOfUrl(String GQuR8Sus) throws IOException {
		ByteArrayOutputStream NDoscanf = new ByteArrayOutputStream();
		URL ZcosSdx8 = new URL(GQuR8Sus);
		IOUtils.copy(ZcosSdx8.openStream(), NDoscanf);
		return NDoscanf.toString();
	}

}