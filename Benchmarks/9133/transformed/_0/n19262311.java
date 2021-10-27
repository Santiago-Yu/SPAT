class n19262311 {
	public static String encrypt(String uej74y6P) {
		MessageDigest IWt8WPjA = null;
		try {
			IWt8WPjA = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException M1ceUWYO) {
			M1ceUWYO.printStackTrace();
		}
		IWt8WPjA.update(uej74y6P.getBytes());
		byte cON3XQpb[] = IWt8WPjA.digest();
		StringBuffer vvrTo0DC = new StringBuffer();
		for (int pjivGAtX = 0; pjivGAtX < cON3XQpb.length; pjivGAtX++) {
			String UrbdkDQp = Integer.toHexString(0xFF & cON3XQpb[pjivGAtX]);
			if (UrbdkDQp.length() == 1)
				UrbdkDQp = "0" + UrbdkDQp;
			vvrTo0DC.append(UrbdkDQp);
		}
		return vvrTo0DC.toString();
	}

}