class n7273182 {
	public synchronized String encrypt(String kmsPPaxh) throws Exception {
		MessageDigest SN2rgdzf = null;
		try {
			SN2rgdzf = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException Mo3ehktU) {
			throw new Exception(Mo3ehktU.getMessage());
		}
		SN2rgdzf.update(kmsPPaxh.getBytes());
		byte cQzMG1RL[] = SN2rgdzf.digest();
		String Z0cekOoU = "";
		for (int vBCgM56p = 0; vBCgM56p < cQzMG1RL.length; vBCgM56p++) {
			byte WMpuvDaC = cQzMG1RL[vBCgM56p];
			String yZdf0tuU = Integer.toHexString(new Byte(WMpuvDaC));
			while (yZdf0tuU.length() < 2) {
				yZdf0tuU = "0" + yZdf0tuU;
			}
			yZdf0tuU = yZdf0tuU.substring(yZdf0tuU.length() - 2);
			Z0cekOoU += yZdf0tuU;
		}
		return Z0cekOoU;
	}

}