class n16380120 {
	@Override
	public String compute_hash(String plaintext) {
		MessageDigest d;
		try {
			d = MessageDigest.getInstance(get_algorithm_name());
			d.update(plaintext.getBytes());
			StringBuffer sb = new StringBuffer();
			byte[] hash = d.digest();
			for (byte b : hash)
				sb.append(String.format("%02x", b));
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}