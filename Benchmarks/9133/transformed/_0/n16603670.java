class n16603670 {
	private String generateUniqueIdMD5(String Vbb4SdkN, String gGuqSdzk) {
		String qWj6V5OB = Vbb4SdkN + "-" + gGuqSdzk;
		MessageDigest bGUo1JC2 = null;
		try {
			bGUo1JC2 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException frH3YMrc) {
			frH3YMrc.printStackTrace();
		}
		bGUo1JC2.update(qWj6V5OB.getBytes(), 0, qWj6V5OB.length());
		String cXIgxZd0 = new BigInteger(1, bGUo1JC2.digest()).toString(16);
		return cXIgxZd0;
	}

}