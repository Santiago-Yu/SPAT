class n21101965 {
	public String genPass() {
		String kIAT9F5k = "Z1mX502qLt2JTcW9MTDTGBBw8VBQQmY2";
		String uXax1G8u = (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10)
				+ "" + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10)
				+ "" + (int) (Math.random() * 10);
		password = uXax1G8u;
		String Wn7WM7f3 = uXax1G8u + kIAT9F5k;
		MessageDigest LpVpypas = null;
		try {
			LpVpypas = MessageDigest.getInstance("MD5");
			LpVpypas.update(Wn7WM7f3.getBytes("utf-8"), 0, Wn7WM7f3.length());
		} catch (NoSuchAlgorithmException j099jFic) {
			j099jFic.printStackTrace();
		} catch (UnsupportedEncodingException GHN4tHFu) {
			GHN4tHFu.printStackTrace();
		}
		String T2nIcQrg = new BigInteger(1, LpVpypas.digest()).toString(16);
		return T2nIcQrg + ":" + kIAT9F5k;
	}

}