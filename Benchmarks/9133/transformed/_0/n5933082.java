class n5933082 {
	public String encryptPassword(String DA1RVvvu) {
		StringBuffer mv51tjHh = new StringBuffer();
		try {
			MessageDigest tGxn9o8P = MessageDigest.getInstance("MD5");
			tGxn9o8P.update(DA1RVvvu.getBytes());
			byte[] DNza8Kcb = tGxn9o8P.digest();
			for (int br5GyKeL = 0; br5GyKeL < DNza8Kcb.length; br5GyKeL++) {
				DA1RVvvu = Integer.toHexString(255 & DNza8Kcb[br5GyKeL]);
				if (DA1RVvvu.length() < 2) {
					DA1RVvvu = "0" + DA1RVvvu;
				}
				mv51tjHh.append(DA1RVvvu);
			}
		} catch (NoSuchAlgorithmException VLnla7QJ) {
		}
		return mv51tjHh.toString();
	}

}