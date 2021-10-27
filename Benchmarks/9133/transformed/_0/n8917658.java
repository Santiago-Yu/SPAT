class n8917658 {
	public static void copyAll(URL SR992mqs, Writer GIiW7QtI) {
		Reader YBx43DHQ = null;
		try {
			YBx43DHQ = new InputStreamReader(new BufferedInputStream(SR992mqs.openStream()));
			copyAll(YBx43DHQ, GIiW7QtI);
		} catch (IOException xZ4nLeMs) {
			throw new RuntimeException(xZ4nLeMs);
		} finally {
			close(YBx43DHQ);
		}
	}

}