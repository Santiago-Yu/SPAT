class n15143217 {
	@Override
	public String getMD5(String host) {
		Double randNumber = Math.random() + System.currentTimeMillis();
		String res = "";
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(randNumber.toString().getBytes());
			String tmp = "";
			byte[] md5 = algorithm.digest();
			for (int i = 0; i < md5.length; i++) {
				tmp = (Integer.toHexString(0xFF & md5[i]));
				if (tmp.length() == 1) {
					res += "0" + tmp;
				} else {
					res += tmp;
				}
			}
		} catch (Exception ex) {
		}
		return res;
	}

}