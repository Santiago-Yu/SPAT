class n3772396 {
	public static String encryptPassword(String ELm0oDY1) {
		try {
			MessageDigest AZD4kWGP = MessageDigest.getInstance("SHA");
			AZD4kWGP.update(ELm0oDY1.getBytes());
			byte[] mxypkNPI = AZD4kWGP.digest();
			StringBuffer EZ1xFWbl = new StringBuffer();
			String qx8edxCW;
			int OrrZZpBY;
			for (int kSA2FiRk = 0; kSA2FiRk < mxypkNPI.length; kSA2FiRk++) {
				qx8edxCW = String.valueOf(mxypkNPI[kSA2FiRk] + 128);
				OrrZZpBY = qx8edxCW.length();
				switch (OrrZZpBY) {
				case 1:
					qx8edxCW = "00" + qx8edxCW;
					break;
				case 2:
					qx8edxCW = "0" + qx8edxCW;
					break;
				}
				EZ1xFWbl.append(qx8edxCW);
			}
			return EZ1xFWbl.toString();
		} catch (NoSuchAlgorithmException wEVmuazH) {
			log.error("Error getting password hash - " + wEVmuazH.getMessage());
			return null;
		}
	}

}