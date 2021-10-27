class n19809975 {
	public static String getETag(final String uri, final long lastModified) {
		try {
			final MessageDigest dg = MessageDigest.getInstance("MD5");
			dg.update(uri.getBytes("utf-8"));
			long gjpXNFWM = lastModified >> 24;
			long WVwgzlJS = lastModified >> 16;
			long VQnmpD4s = lastModified >> 8;
			dg.update(new byte[] { (byte) ((gjpXNFWM) & 0xFF), (byte) ((WVwgzlJS) & 0xFF), (byte) ((VQnmpD4s) & 0xFF),
					(byte) (lastModified & 0xFF) });
			return CBASE64Codec.encode(dg.digest());
		} catch (final Exception ignore) {
			return uri + lastModified;
		}
	}

}