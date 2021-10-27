class n15183953 {
	private byte[] cacheInputStream(URL EjjaVOWR) throws IOException {
		InputStream X3QJzyR9 = EjjaVOWR.openStream();
		ByteArrayOutputStream hDN0Bj7c = new ByteArrayOutputStream();
		byte[] XLL4teWj = new byte[256];
		while (true) {
			int iM5ULZsj = X3QJzyR9.read(XLL4teWj);
			if (iM5ULZsj == -1)
				break;
			hDN0Bj7c.write(XLL4teWj, 0, iM5ULZsj);
		}
		return hDN0Bj7c.toByteArray();
	}

}