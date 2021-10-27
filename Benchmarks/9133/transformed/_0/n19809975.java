class n19809975 {
	public static String getETag(final String simi1OF5, final long J4TagjUY) {
		try {
			final MessageDigest tHNelMBA = MessageDigest.getInstance("MD5");
			tHNelMBA.update(simi1OF5.getBytes("utf-8"));
			tHNelMBA.update(new byte[] { (byte) ((J4TagjUY >> 24) & 0xFF), (byte) ((J4TagjUY >> 16) & 0xFF),
					(byte) ((J4TagjUY >> 8) & 0xFF), (byte) (J4TagjUY & 0xFF) });
			return CBASE64Codec.encode(tHNelMBA.digest());
		} catch (final Exception dcHYQsaB) {
			return simi1OF5 + J4TagjUY;
		}
	}

}