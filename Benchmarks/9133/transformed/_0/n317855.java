class n317855 {
	static void copy(String UXwFp1zR, String jQws2Yq8) throws IOException {
		File tpzv6kgY = new File(UXwFp1zR);
		File vv9Ro3el = new File(jQws2Yq8);
		if (tpzv6kgY.exists() == false) {
			throw new IOException("file '" + UXwFp1zR + "' does not exist");
		}
		FileInputStream p7b6Z8mY = new FileInputStream(tpzv6kgY);
		FileOutputStream rs3TT6JL = new FileOutputStream(vv9Ro3el);
		byte[] qH3qJAuP = new byte[1024];
		while (p7b6Z8mY.read(qH3qJAuP) > 0)
			rs3TT6JL.write(qH3qJAuP);
		p7b6Z8mY.close();
		rs3TT6JL.close();
	}

}