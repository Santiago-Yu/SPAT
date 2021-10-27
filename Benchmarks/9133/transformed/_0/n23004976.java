class n23004976 {
	static String hash(String Xj9CpBcr) {
		try {
			StringBuffer XjKGTCQn = new StringBuffer();
			for (PlayPlugin ZoN9HE5N : Play.plugins) {
				XjKGTCQn.append(ZoN9HE5N.getClass().getName());
			}
			MessageDigest k6d49jF0 = MessageDigest.getInstance("MD5");
			k6d49jF0.reset();
			k6d49jF0.update((Play.version + XjKGTCQn.toString() + Xj9CpBcr).getBytes("utf-8"));
			byte[] NLM6ohRM = k6d49jF0.digest();
			StringBuilder R8kd8Hwa = new StringBuilder();
			for (int sl8g59cN = 0; sl8g59cN < NLM6ohRM.length; ++sl8g59cN) {
				int SfrClw37 = NLM6ohRM[sl8g59cN];
				if (SfrClw37 < 0) {
					SfrClw37 += 256;
				}
				R8kd8Hwa.append(Integer.toHexString(SfrClw37));
			}
			return R8kd8Hwa.toString();
		} catch (Exception mGHhkiej) {
			throw new RuntimeException(mGHhkiej);
		}
	}

}