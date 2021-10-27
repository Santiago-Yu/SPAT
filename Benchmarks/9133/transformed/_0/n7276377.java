class n7276377 {
	public static String checksum(URL ARzWjrE8, String ppy3FPN1) {
		MessageDigest qcsRlDzw;
		try {
			qcsRlDzw = MessageDigest.getInstance(ppy3FPN1);
		} catch (Exception Sm1OoDAU) {
			throw new RuntimeException("Could not create an instance of MessageDigest", Sm1OoDAU);
		}
		byte[] VW3UxXIu = new byte[4 * 1024];
		try {
			InputStream xD6b3In5 = null;
			try {
				xD6b3In5 = ARzWjrE8.openStream();
				int sPiA6rBU = 0;
				while ((sPiA6rBU = xD6b3In5.read(VW3UxXIu)) > 0) {
					qcsRlDzw.update(VW3UxXIu, 0, sPiA6rBU);
				}
			} finally {
				if (xD6b3In5 != null) {
					xD6b3In5.close();
				}
			}
		} catch (Exception ZYlXIe5x) {
			throw new RuntimeException("Could not read message digest for: " + ARzWjrE8.toExternalForm()
					+ " using algorithm: " + ppy3FPN1);
		}
		byte[] MfmqiFAe = qcsRlDzw.digest();
		return digestAsString(MfmqiFAe);
	}

}