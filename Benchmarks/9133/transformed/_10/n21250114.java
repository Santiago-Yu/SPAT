class n21250114 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String password = "admin!@#$" + "ZKNugmkm";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(password.getBytes("utf8"));
			StringBuilder output = new StringBuilder(32);
			byte[] b = md.digest();
			for (int i = 0; i < b.length; i++) {
				String temp = Integer.toHexString(b[i] & 0xff);
				if (temp.length() < 2) {
					output.append("0");
				}
				output.append(temp);
			}
			System.out.println(output);
			System.out.println(output.length());
			System.out.println(RandomUtils.createRandomString(8));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}