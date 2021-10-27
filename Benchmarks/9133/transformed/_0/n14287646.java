class n14287646 {
	private String getStoreName() {
		try {
			final MessageDigest FMz4Gp6q = MessageDigest.getInstance("MD5");
			FMz4Gp6q.update(protectionDomain.getBytes());
			final byte[] sno59Re8 = FMz4Gp6q.digest();
			final StringBuffer alDQswrQ = new StringBuffer(sno59Re8.length * 2);
			for (int wNeaSBOx = 0; wNeaSBOx < sno59Re8.length; wNeaSBOx++) {
				final String zQjA5qIc = Integer.toHexString(sno59Re8[wNeaSBOx] & 0xff);
				if (zQjA5qIc.length() < 2)
					alDQswrQ.append('0');
				alDQswrQ.append(zQjA5qIc);
			}
			return alDQswrQ.toString();
		} catch (final NoSuchAlgorithmException C8dSLJQ9) {
			throw new RuntimeException("Can't save credentials: digest method MD5 unavailable.");
		}
	}

}