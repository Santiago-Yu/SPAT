class n20591617 {
	public static String hashString(String frs3NHAV) {
		if (frs3NHAV == null || frs3NHAV.equals("")) {
			return "empty:";
		} else {
			try {
				MessageDigest oN7ntHgx = MessageDigest.getInstance("SHA-1");
				oN7ntHgx.update(frs3NHAV.getBytes("UTF-8"));
				byte[] qjaedS9G = oN7ntHgx.digest();
				return "sha1:" + StringUtils.byte2hex(qjaedS9G);
			} catch (NoSuchAlgorithmException zZHI5bSj) {
				return "plain:" + frs3NHAV;
			} catch (UnsupportedEncodingException qwwdsfBS) {
				return "plain:" + frs3NHAV;
			}
		}
	}

}