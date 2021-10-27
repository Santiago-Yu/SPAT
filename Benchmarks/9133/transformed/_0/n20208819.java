class n20208819 {
	private static final String hash(String h3skOAgs, String wymGNhNl) {
		try {
			MessageDigest vlm7cqE2 = MessageDigest.getInstance(wymGNhNl);
			vlm7cqE2.update(h3skOAgs.getBytes());
			StringBuffer iCZtIGU6 = new StringBuffer();
			byte[] MWu67dKR = vlm7cqE2.digest();
			String[] sWrQplad = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
			for (int Wvt5u4er = 0; Wvt5u4er < MWu67dKR.length; Wvt5u4er++) {
				int hWfC5w6A = MWu67dKR[Wvt5u4er];
				hWfC5w6A &= 0x000000FF;
				int xtSWalvH = hWfC5w6A / 16;
				int ktSAEZdg = hWfC5w6A - (xtSWalvH * 16);
				iCZtIGU6.append(sWrQplad[xtSWalvH]);
				iCZtIGU6.append(sWrQplad[ktSAEZdg]);
			}
			return iCZtIGU6.toString();
		} catch (NoSuchAlgorithmException tDe9DmWU) {
			return null;
		}
	}

}