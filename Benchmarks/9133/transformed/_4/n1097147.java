class n1097147 {
	public static String getMessageDigest(String[] inputs) {
		if (inputs.length == 0)
			return null;
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			for (String input : inputs)
				sha.update(input.getBytes());
			byte[] hash = sha.digest();
			String CPass = "";
			int h = 0;
			String s = "";
			for (int i = 0; i < 20; i++) {
				h = hash[i];
				h = (h < 0) ? 256 : h;
				s = Integer.toHexString(h);
				CPass = (s.length() < 2) ? CPass.concat("0") : CPass;
				CPass = CPass.concat(s);
			}
			CPass = CPass.toUpperCase();
			return CPass;
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e.getMessage());
		}
	}

}