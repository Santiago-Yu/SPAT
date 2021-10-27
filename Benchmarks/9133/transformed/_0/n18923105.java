class n18923105 {
	public static byte[] read(URL DEH4vjTU) throws IOException {
		byte[] c8EWi3aP;
		InputStream uLdI2Vth = null;
		try {
			uLdI2Vth = DEH4vjTU.openStream();
			c8EWi3aP = readAllBytes(uLdI2Vth);
		} finally {
			if (uLdI2Vth != null) {
				uLdI2Vth.close();
			}
		}
		return c8EWi3aP;
	}

}