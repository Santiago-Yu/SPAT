class n7421563 {
	private StringBuffer encoder(String arg) {
		MessageDigest md5 = null;
		if (arg == null) {
			arg = "";
		}
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(arg.getBytes(SysConstant.charset));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toHex(md5.digest());
	}

}