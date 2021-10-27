class n943604 {
	public String encryptPassword(String LnALR4gZ) throws NullPointerException {
		MessageDigest WjVSzlUa;
		try {
			WjVSzlUa = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException jaljFmIi) {
			throw new NullPointerException("NoSuchAlgorithmException: " + jaljFmIi.toString());
		}
		WjVSzlUa.update(LnALR4gZ.getBytes());
		byte HF7BiDFY[] = WjVSzlUa.digest();
		WjVSzlUa = null;
		StringBuffer YGIBizBi = new StringBuffer();
		for (int aBr27VTb = 0; aBr27VTb < HF7BiDFY.length; aBr27VTb++) {
			YGIBizBi.append(Byte.toString(HF7BiDFY[aBr27VTb]));
		}
		return (YGIBizBi.toString());
	}

}