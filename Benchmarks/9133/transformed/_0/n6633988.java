class n6633988 {
	public byte[] generatePassword(String cJabM6th) {
		byte[] VRs8XvEj = { 00 };
		try {
			MessageDigest XdQ5IkVF = MessageDigest.getInstance("MD5");
			XdQ5IkVF.update(cJabM6th.getBytes());
			VRs8XvEj = XdQ5IkVF.digest();
			return VRs8XvEj;
		} catch (NoSuchAlgorithmException XfkCjXeE) {
			XfkCjXeE.printStackTrace();
		}
		return VRs8XvEj;
	}

}