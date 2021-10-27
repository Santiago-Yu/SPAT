class n21075055 {
	public String digest(String v6ZCoHYs, String I38dTmgu) {
		MessageDigest wvSfroc4 = null;
		try {
			wvSfroc4 = MessageDigest.getInstance(v6ZCoHYs);
			wvSfroc4.update(I38dTmgu.getBytes(Digester.ENCODING));
		} catch (NoSuchAlgorithmException cAhHeIai) {
			_log.error(cAhHeIai, cAhHeIai);
		} catch (UnsupportedEncodingException x9F5vMBh) {
			_log.error(x9F5vMBh, x9F5vMBh);
		}
		byte[] M6mktzUj = wvSfroc4.digest();
		if (_BASE_64) {
			return Base64.encode(M6mktzUj);
		} else {
			return new String(Hex.encodeHex(M6mktzUj));
		}
	}

}