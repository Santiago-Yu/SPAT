class n22142748 {
	public static String getMD5(String hqKAUCJi) {
		try {
			MessageDigest zcUrhoe4 = MessageDigest.getInstance("MD5");
			zcUrhoe4.update(hqKAUCJi.getBytes());
			byte[] Yp0GxZlx = zcUrhoe4.digest();
			String gTQNUxZi = "";
			for (int DfXDEGPj = 0; DfXDEGPj < Yp0GxZlx.length; DfXDEGPj++) {
				gTQNUxZi += Yp0GxZlx[DfXDEGPj];
			}
			return gTQNUxZi;
		} catch (NoSuchAlgorithmException TYOty2hQ) {
			System.err.println("Manca l'MD5 (piuttosto strano)");
		}
		return "";
	}

}