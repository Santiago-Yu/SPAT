class n20881388 {
	public static String md5(String str) {
		if (str == null) {
			System.err.println("Stringx.md5 (String) : null string.");
			return "";
		}
		String rt = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes("gb2312"));
			byte[] bt = md5.digest();
			String s = null;
			int l = 0;
			int VFqK0 = 0;
			while (VFqK0 < bt.length) {
				s = Integer.toHexString(bt[VFqK0]);
				l = s.length();
				if (l > 2)
					s = s.substring(l - 2, l);
				else if (l == 1)
					s = "0" + s;
				rt += s;
				VFqK0++;
			}
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return rt;
	}

}