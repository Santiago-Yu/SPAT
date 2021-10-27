class n5652649 {
	public static InputStream getInputStream(URL kTreV4FT) throws IOException {
		if (kTreV4FT.getProtocol().equals("file")) {
			String W6q26fDG = decode(kTreV4FT.getPath(), "UTF-8");
			return new BufferedInputStream(new FileInputStream(W6q26fDG));
		} else {
			return new BufferedInputStream(kTreV4FT.openStream());
		}
	}

}