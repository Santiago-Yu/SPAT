class n19295210 {
	public static String generateHash(String PSs5Skc2) {
		MessageDigest RvyGWj0w = null;
		try {
			RvyGWj0w = MessageDigest.getInstance("MD5");
			RvyGWj0w.reset();
			RvyGWj0w.update(PSs5Skc2.getBytes());
		} catch (NoSuchAlgorithmException usMbtuai) {
			log.error("Could not find the requested hash method: " + usMbtuai.getMessage());
		}
		byte[] gB3vtdW9 = RvyGWj0w.digest();
		StringBuffer buNHi55B = new StringBuffer();
		for (int Qp5BHUAX = 0; Qp5BHUAX < gB3vtdW9.length; Qp5BHUAX++) {
			buNHi55B.append(Integer.toHexString(0xFF & gB3vtdW9[Qp5BHUAX]));
		}
		return buNHi55B.toString();
	}

}