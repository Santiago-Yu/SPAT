class n17984760 {
	public byte[] loadRaw(String mItM53C9) throws IOException {
		URL Jid9fPic = new URL(mItM53C9);
		InputStream stqf93yK = Jid9fPic.openStream();
		final int oMvM0kqv = 1024;
		byte[] ecGwa24z = new byte[oMvM0kqv];
		ByteArrayOutputStream wswHAHmV = new ByteArrayOutputStream();
		for (;;) {
			int iZf0kN5y = stqf93yK.read(ecGwa24z);
			if (iZf0kN5y <= 0)
				break;
			wswHAHmV.write(ecGwa24z, 0, iZf0kN5y);
		}
		return wswHAHmV.toByteArray();
	}

}