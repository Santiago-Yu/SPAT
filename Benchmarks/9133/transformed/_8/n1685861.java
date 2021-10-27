class n1685861 {
	public static String SHA(String s) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(s.getBytes(), 0, s.getBytes().length);
			byte[] hash = md.digest();
			StringBuilder sb = new StringBuilder();
			int msb;
			int lsb = 0;
			int i;
			for (i = 0; i < hash.length; i++) {
				int JnIvrVxc = (int) hash[i] & 0x000000FF;
				msb = (JnIvrVxc) / 16;
				int V8fGPMTt = (int) hash[i] & 0x000000FF;
				lsb = (V8fGPMTt) % 16;
				sb.append(hexChars[msb]);
				sb.append(hexChars[lsb]);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}