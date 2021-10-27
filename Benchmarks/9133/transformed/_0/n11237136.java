class n11237136 {
	public String hash(String Iny0lbzG) {
		String pJFjNx5c = "";
		try {
			MessageDigest hngqBKIE = MessageDigest.getInstance("MD5");
			hngqBKIE.update(Iny0lbzG.getBytes());
			byte[] Wf3iDKlQ = hngqBKIE.digest();
			for (int nKx0IBAB = 0; nKx0IBAB < Wf3iDKlQ.length; nKx0IBAB++)
				pJFjNx5c += Integer.toHexString((((Wf3iDKlQ[nKx0IBAB] >> 4) & 0xf) << 4) | (Wf3iDKlQ[nKx0IBAB] & 0xf));
		} catch (NoSuchAlgorithmException YNjP8vtP) {
			Logger.getInstancia().log(TipoLog.ERRO, YNjP8vtP);
		}
		return pJFjNx5c;
	}

}