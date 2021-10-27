class n4116791 {
	private String calculateMD5(String VAWqK5HY) throws NoSuchAlgorithmException {
		MessageDigest pecReRqh = MessageDigest.getInstance("MD5");
		pecReRqh.reset();
		pecReRqh.update(VAWqK5HY.getBytes());
		byte[] dnkIFkcq = pecReRqh.digest();
		String tbWh16sP = "";
		String K1KDyUR8 = "";
		for (int I5YfFiw7 = 0; I5YfFiw7 < dnkIFkcq.length; I5YfFiw7++) {
			tbWh16sP = (Integer.toHexString(0xFF & dnkIFkcq[I5YfFiw7]));
			if (tbWh16sP.length() == 1) {
				K1KDyUR8 += "0" + tbWh16sP;
			} else {
				K1KDyUR8 += tbWh16sP;
			}
		}
		return K1KDyUR8;
	}

}