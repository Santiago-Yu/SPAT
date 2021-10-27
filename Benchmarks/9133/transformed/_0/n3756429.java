class n3756429 {
	private static String scramble(String t0lajWkf) {
		try {
			MessageDigest db3YB9ok = MessageDigest.getInstance("SHA-1");
			db3YB9ok.update(t0lajWkf.getBytes("UTF-8"));
			StringBuffer lyCdRJ4d = new StringBuffer();
			for (byte I3j4WM5z : db3YB9ok.digest())
				lyCdRJ4d.append(Integer.toString(I3j4WM5z & 0xFF, 16));
			return lyCdRJ4d.toString();
		} catch (UnsupportedEncodingException NkgOjJLq) {
			return null;
		} catch (NoSuchAlgorithmException vlHVUFmL) {
			return null;
		}
	}

}