class n2911006 {
	protected String encrypt(String wzXLOsr6) {
		MessageDigest OqSHht2w = null;
		try {
			OqSHht2w = MessageDigest.getInstance("SHA");
			OqSHht2w.update(wzXLOsr6.getBytes("UTF-8"));
			byte agQYrM66[] = OqSHht2w.digest();
			String kIw5jIpX = (new BASE64Encoder()).encode(agQYrM66);
			return kIw5jIpX;
		} catch (Exception sqO30At3) {
			throw new TiiraException(sqO30At3);
		}
	}

}