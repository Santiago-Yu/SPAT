class n16419225 {
	public static String encrypt(String lRnGOLeU, String ggN9sZlC) {
		try {
			MessageDigest dcpSAZfl = MessageDigest.getInstance(lRnGOLeU);
			dcpSAZfl.update(ggN9sZlC.getBytes());
			StringBuffer Xk7vrYAG = new StringBuffer();
			byte[] xu6NqZWg = dcpSAZfl.digest();
			for (int oxef3h4x = 0; oxef3h4x < xu6NqZWg.length; oxef3h4x++) {
				int cVkntiKd = xu6NqZWg[oxef3h4x] & 0xFF;
				if (cVkntiKd < 0x10)
					Xk7vrYAG.append('0');
				Xk7vrYAG.append(Integer.toHexString(cVkntiKd));
			}
			return Xk7vrYAG.toString();
		} catch (Exception L0eOMex9) {
			return "";
		}
	}

}