class n5600261 {
	private String calculateMD5(String XDCekvUb) {
		String Veupe8X7 = new String("");
		try {
			MessageDigest P4YCNqQR = MessageDigest.getInstance("MD5");
			P4YCNqQR.reset();
			P4YCNqQR.update(XDCekvUb.getBytes());
			byte MCF6jBao[] = P4YCNqQR.digest();
			StringBuffer gn0VTa3k = new StringBuffer();
			for (int nUGyrGIq = 0; nUGyrGIq < MCF6jBao.length; nUGyrGIq++) {
				String cDKb5Kk5 = Integer.toHexString(0xFF & MCF6jBao[nUGyrGIq]);
				if (cDKb5Kk5.length() == 1) {
					gn0VTa3k.append('0');
				}
				gn0VTa3k.append(cDKb5Kk5);
			}
			Veupe8X7 = gn0VTa3k.toString();
		} catch (NoSuchAlgorithmException CGexx9Pq) {
			throw new RuntimeException("Hashing error happened:", CGexx9Pq);
		}
		return Veupe8X7;
	}

}