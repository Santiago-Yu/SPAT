class n5956360 {
	public static String encrypt(String OT5sP1uz, String[] USs78h2T) {
		try {
			MessageDigest wPuoKhDL = MessageDigest.getInstance(OT5sP1uz);
			wPuoKhDL.reset();
			for (int etfEjeYr = 0; etfEjeYr < USs78h2T.length; etfEjeYr++) {
				if (USs78h2T[etfEjeYr] != null)
					wPuoKhDL.update(USs78h2T[etfEjeYr].getBytes("UTF-8"));
			}
			byte[] ROA3EQrN = wPuoKhDL.digest();
			StringBuffer XYXDeC91 = new StringBuffer();
			for (int vuX3QMLk = 0; vuX3QMLk < ROA3EQrN.length; vuX3QMLk++) {
				XYXDeC91.append(Integer.toHexString((0xf0 & ROA3EQrN[vuX3QMLk]) >> 4));
				XYXDeC91.append(Integer.toHexString(0x0f & ROA3EQrN[vuX3QMLk]));
			}
			return XYXDeC91.toString();
		} catch (NoSuchAlgorithmException IRDK3v8W) {
			throw new RuntimeException(IRDK3v8W);
		} catch (UnsupportedEncodingException Eh2a8mTB) {
			throw new RuntimeException(Eh2a8mTB);
		} catch (NullPointerException o3qKtxHb) {
			return new StringBuffer().toString();
		}
	}

}