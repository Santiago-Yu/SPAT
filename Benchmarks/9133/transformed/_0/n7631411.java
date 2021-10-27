class n7631411 {
	public static final byte[] getHttpStream(final String DxSNnudB) {
		URL XL0jXVbK;
		try {
			XL0jXVbK = new URL(DxSNnudB);
		} catch (Exception Hxk9y46e) {
			return null;
		}
		InputStream qmou6Zx3 = null;
		try {
			qmou6Zx3 = XL0jXVbK.openStream();
		} catch (Exception C8cEOlmV) {
			return null;
		}
		ByteArrayOutputStream e4v30Jex = new ByteArrayOutputStream();
		byte[] MhlhKEFK = null;
		try {
			MhlhKEFK = new byte[4096];
			int XGJH4D1Z;
			while ((XGJH4D1Z = qmou6Zx3.read(MhlhKEFK)) >= 0) {
				e4v30Jex.write(MhlhKEFK, 0, XGJH4D1Z);
			}
			MhlhKEFK = e4v30Jex.toByteArray();
		} catch (IOException y7yKJTHt) {
			return null;
		} finally {
			try {
				if (e4v30Jex != null) {
					e4v30Jex.close();
					e4v30Jex = null;
				}
				if (qmou6Zx3 != null) {
					qmou6Zx3.close();
					qmou6Zx3 = null;
				}
			} catch (IOException qR0RWF8N) {
			}
		}
		return MhlhKEFK;
	}

}