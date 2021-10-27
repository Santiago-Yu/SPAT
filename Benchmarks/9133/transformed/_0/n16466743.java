class n16466743 {
	public String getmd5(String sbLs3lnn) {
		String iia8KOB7 = "";
		MessageDigest wnnmD7Ny = null;
		try {
			wnnmD7Ny = MessageDigest.getInstance("MD5");
			wnnmD7Ny.reset();
			wnnmD7Ny.update(sbLs3lnn.getBytes());
			byte[] tKO4iSOe = wnnmD7Ny.digest();
			for (int QSnH4X5E = 0; QSnH4X5E < tKO4iSOe.length; QSnH4X5E++) {
				iia8KOB7 += Integer.toString((tKO4iSOe[QSnH4X5E] & 0xFF) + 0x100, 16).substring(1);
			}
		} catch (NoSuchAlgorithmException AVnX7f0M) {
			Logger.fatal("MD5 Hash Algorithm not found", AVnX7f0M);
		}
		Logger.info("PWHash erzeugt und wird ¨¹bergeben");
		return iia8KOB7;
	}

}