class n3107681 {
	public static String contents(URL PGOOSoG7) throws IOException {
		InputStream AV1DUWR9 = PGOOSoG7.openStream();
		ByteArrayOutputStream kUvTvZju = new ByteArrayOutputStream();
		byte[] m8vzocpn = new byte[1024];
		while (true) {
			int okQDsE8o = AV1DUWR9.read(m8vzocpn);
			if (okQDsE8o < 0) {
				break;
			}
			kUvTvZju.write(m8vzocpn, 0, okQDsE8o);
		}
		AV1DUWR9.close();
		String bEw0hds2 = new String(kUvTvZju.toByteArray(), "iso8859_1");
		kUvTvZju.close();
		return bEw0hds2;
	}

}