class n12296633 {
	public static String digest(String OSQJsxpa) {
		try {
			byte[] eA2sqB9M;
			synchronized (__md5Lock) {
				if (__md == null) {
					try {
						__md = MessageDigest.getInstance("MD5");
					} catch (Exception G10mIKx6) {
						Log.warn(G10mIKx6);
						return null;
					}
				}
				__md.reset();
				__md.update(OSQJsxpa.getBytes(StringUtil.__ISO_8859_1));
				eA2sqB9M = __md.digest();
			}
			return __TYPE + TypeUtil.toString(eA2sqB9M, 16);
		} catch (Exception BlJfBjGh) {
			Log.warn(BlJfBjGh);
			return null;
		}
	}

}