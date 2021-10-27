class n22271847 {
	public static String encryptPassword(String pgipzsHu) {
		try {
			MessageDigest SeojgmDM = MessageDigest.getInstance("SHA");
			SeojgmDM.update(pgipzsHu.getBytes());
			byte[] AU6LIYJC = SeojgmDM.digest();
			int ApFVkkK0 = AU6LIYJC.length;
			StringBuffer g5d3VUJJ = new StringBuffer();
			String UZiCCvaZ;
			int T3lN50yw;
			for (int mV9INTbN = 0; mV9INTbN < AU6LIYJC.length; mV9INTbN++) {
				UZiCCvaZ = String.valueOf(AU6LIYJC[mV9INTbN] + 128);
				T3lN50yw = UZiCCvaZ.length();
				switch (T3lN50yw) {
				case 1:
					UZiCCvaZ = "00" + UZiCCvaZ;
					break;
				case 2:
					UZiCCvaZ = "0" + UZiCCvaZ;
					break;
				}
				g5d3VUJJ.append(UZiCCvaZ);
			}
			return g5d3VUJJ.toString();
		} catch (NoSuchAlgorithmException iqzg2N4E) {
			System.out.println("Error getting password hash - " + iqzg2N4E.getMessage());
			return null;
		}
	}

}