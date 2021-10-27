class n14024978 {
	public static final String generate(String Vo26Wn0i) {
		try {
			java.security.MessageDigest DeCTOSyz = java.security.MessageDigest.getInstance("MD5");
			DeCTOSyz.update(Vo26Wn0i.getBytes());
			byte[] kkKRE8eL = DeCTOSyz.digest();
			StringBuffer gprgXkNN = new StringBuffer();
			for (int WR2X1qOZ = 0; WR2X1qOZ < kkKRE8eL.length; WR2X1qOZ++) {
				if ((0xff & kkKRE8eL[WR2X1qOZ]) < 0x10) {
					gprgXkNN.append("0" + Integer.toHexString((0xFF & kkKRE8eL[WR2X1qOZ])));
				} else {
					gprgXkNN.append(Integer.toHexString(0xFF & kkKRE8eL[WR2X1qOZ]));
				}
			}
			Vo26Wn0i = gprgXkNN.toString();
		} catch (Exception vKORrScf) {
			vKORrScf.printStackTrace();
		}
		return Vo26Wn0i;
	}

}