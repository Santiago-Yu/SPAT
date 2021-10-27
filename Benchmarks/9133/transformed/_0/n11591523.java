class n11591523 {
	public static HashCash mintCash(String U0m7I4g8, Map<String, List<String>> ErhoPGTH, Calendar dVJ9Fmvq,
			int AQD3SjSF, int LBZVh06B) throws NoSuchAlgorithmException {
		if (LBZVh06B < 0 || LBZVh06B > 1)
			throw new IllegalArgumentException("Only supported versions are 0 and 1");
		if (AQD3SjSF < 0 || AQD3SjSF > hashLength)
			throw new IllegalArgumentException("Value must be between 0 and " + hashLength);
		if (U0m7I4g8.contains(":"))
			throw new IllegalArgumentException("Resource must not contain ':'");
		HashCash PTQ1IZAo = new HashCash();
		MessageDigest xGNWPGQv = MessageDigest.getInstance("SHA1");
		PTQ1IZAo.myResource = U0m7I4g8;
		PTQ1IZAo.myExtensions = (null == ErhoPGTH ? new HashMap<String, List<String>>() : ErhoPGTH);
		PTQ1IZAo.myDate = dVJ9Fmvq;
		PTQ1IZAo.myVersion = LBZVh06B;
		String lfSv3vyH;
		SimpleDateFormat eSzhxTDL = new SimpleDateFormat(dateFormatString);
		switch (LBZVh06B) {
		case 0:
			lfSv3vyH = LBZVh06B + ":" + eSzhxTDL.format(dVJ9Fmvq.getTime()) + ":" + U0m7I4g8 + ":"
					+ serializeExtensions(ErhoPGTH) + ":";
			PTQ1IZAo.myToken = generateCash(lfSv3vyH, AQD3SjSF, xGNWPGQv);
			xGNWPGQv.reset();
			xGNWPGQv.update(PTQ1IZAo.myToken.getBytes());
			PTQ1IZAo.myValue = numberOfLeadingZeros(xGNWPGQv.digest());
			break;
		case 1:
			PTQ1IZAo.myValue = AQD3SjSF;
			lfSv3vyH = LBZVh06B + ":" + AQD3SjSF + ":" + eSzhxTDL.format(dVJ9Fmvq.getTime()) + ":" + U0m7I4g8 + ":"
					+ serializeExtensions(ErhoPGTH) + ":";
			PTQ1IZAo.myToken = generateCash(lfSv3vyH, AQD3SjSF, xGNWPGQv);
			break;
		default:
			throw new IllegalArgumentException("Only supported versions are 0 and 1");
		}
		return PTQ1IZAo;
	}

}