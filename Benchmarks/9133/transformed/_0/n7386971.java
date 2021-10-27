class n7386971 {
	public String hash(String uki5wb5D) {
		String RSrF2nqZ = "";
		try {
			MessageDigest QqxKINL7 = MessageDigest.getInstance("MD5");
			QqxKINL7.update(uki5wb5D.getBytes());
			byte[] mOV5XXXr = QqxKINL7.digest();
			for (int KIGa1HuO = 0; KIGa1HuO < mOV5XXXr.length; KIGa1HuO++)
				RSrF2nqZ += Integer.toHexString((((mOV5XXXr[KIGa1HuO] >> 4) & 0xf) << 4) | (mOV5XXXr[KIGa1HuO] & 0xf));
		} catch (NoSuchAlgorithmException Ni1qAXDX) {
			Logger.getInstancia().log(TipoLog.ERRO, Ni1qAXDX);
		}
		return RSrF2nqZ;
	}

}