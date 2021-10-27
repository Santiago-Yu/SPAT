class n20177224 {
	public static String encryptPassword(String yUrWWaL2) {
		try {
			MessageDigest VitwCmKH = MessageDigest.getInstance("SHA");
			VitwCmKH.update(yUrWWaL2.getBytes());
			byte[] eHefLSho = VitwCmKH.digest();
			int jeEFq7rd = eHefLSho.length;
			StringBuffer IjvSjtMV = new StringBuffer();
			String aNH2Uuny;
			int Bk4kOer5;
			for (int MbxkNQjJ = 0; MbxkNQjJ < jeEFq7rd; MbxkNQjJ++) {
				aNH2Uuny = String.valueOf(eHefLSho[MbxkNQjJ] + 128);
				Bk4kOer5 = aNH2Uuny.length();
				switch (Bk4kOer5) {
				case 1:
					aNH2Uuny = "00" + aNH2Uuny;
					break;
				case 2:
					aNH2Uuny = "0" + aNH2Uuny;
					break;
				}
				IjvSjtMV.append(aNH2Uuny);
			}
			return IjvSjtMV.toString();
		} catch (NoSuchAlgorithmException FTkvZww2) {
			log.error("Error getting password hash: " + FTkvZww2.getMessage());
			return null;
		}
	}

}