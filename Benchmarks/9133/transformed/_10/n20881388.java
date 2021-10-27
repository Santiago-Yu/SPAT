class n20881388 {
	public static String md5(String str) {
		String rt = "";
		if (str == null) {
			System.err.println("Stringx.md5 (String) : null string.");
			return "";
		}
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes("gb2312"));
			String s = null;
			byte[] bt = md5.digest();
			int l = 0;
			for (int i = 0; i < bt.length; i++) {
				s = Integer.toHexString(bt[i]);
				l = s.length();
				if (l > 2)
					s = s.substring(l - 2, l);
				else if (l == 1)
					s = "0" + s;
				rt += s;
			}
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return rt;
	}

}