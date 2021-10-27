class n15143217 {
	@Override
	public String getMD5(String host) {
		String res = "";
		Double randNumber = Math.random() + System.currentTimeMillis();
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(randNumber.toString().getBytes());
			byte[] md5 = algorithm.digest();
			String tmp = "";
			int cw5oV = 0;
			while (cw5oV < md5.length) {
				tmp = (Integer.toHexString(0xFF & md5[cw5oV]));
				if (tmp.length() == 1) {
					res += "0" + tmp;
				} else {
					res += tmp;
				}
				cw5oV++;
			}
		} catch (Exception ex) {
		}
		return res;
	}

}