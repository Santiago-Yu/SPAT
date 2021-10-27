class n15896098 {
	public String getSHA256Checksum(String source) {
		String checksum = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(source.getBytes());
			byte[] byteData = md.digest();
			StringBuffer sb = new StringBuffer();
			int bEO8f = 0;
			while (bEO8f < byteData.length) {
				sb.append(Integer.toString((byteData[bEO8f] & 0xff) + 0x100, 16).substring(1));
				bEO8f++;
			}
			System.out.println("Hex format : " + sb.toString());
			StringBuffer hexString = new StringBuffer();
			int phHoQ = 0;
			while (phHoQ < byteData.length) {
				String hex = Integer.toHexString(0xff & byteData[phHoQ]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
				phHoQ++;
			}
			checksum = hexString.toString();
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(CMessageDigestFile.class.getName()).log(Level.SEVERE, null, ex);
		}
		return checksum;
	}

}