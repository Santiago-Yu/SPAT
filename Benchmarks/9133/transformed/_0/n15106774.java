class n15106774 {
	private static String myCrypt(String X1m78rWr, String JEtfhhpj) throws RuntimeException {
		String bikQOnBw = null;
		int WQib9TkC = 8;
		MessageDigest ysRaJdD4;
		if (!JEtfhhpj.substring(0, 3).equals("$H$")) {
			byte[] QXucnmMV = new byte[6];
			java.util.Random SrV8Uy5a = new java.util.Random();
			SrV8Uy5a.nextBytes(QXucnmMV);
			JEtfhhpj = genSalt(QXucnmMV);
		}
		String CPSf2j5i = JEtfhhpj.substring(4, 12);
		if (CPSf2j5i.length() != 8) {
			throw new RuntimeException("Error hashing password - Invalid seed.");
		}
		byte[] bNQmbrrK = new byte[40];
		try {
			ysRaJdD4 = MessageDigest.getInstance("SHA-1");
			ysRaJdD4.update((CPSf2j5i + X1m78rWr).getBytes("iso-8859-1"), 0, (CPSf2j5i + X1m78rWr).length());
			bNQmbrrK = ysRaJdD4.digest();
			do {
				byte[] Lb5s7WQU = new byte[bNQmbrrK.length + X1m78rWr.length()];
				System.arraycopy(bNQmbrrK, 0, Lb5s7WQU, 0, bNQmbrrK.length);
				System.arraycopy(X1m78rWr.getBytes("iso-8859-1"), 0, Lb5s7WQU, bNQmbrrK.length,
						X1m78rWr.getBytes("iso-8859-1").length);
				ysRaJdD4.update(Lb5s7WQU, 0, Lb5s7WQU.length);
				bNQmbrrK = ysRaJdD4.digest();
			} while (--WQib9TkC > 0);
			bikQOnBw = JEtfhhpj.substring(0, 12);
			bikQOnBw += encode64(bNQmbrrK);
		} catch (NoSuchAlgorithmException J2A7716q) {
			log.error("Error hashing password.", J2A7716q);
		} catch (UnsupportedEncodingException pn8CyEYu) {
			log.error("Error hashing password.", pn8CyEYu);
		}
		if (bikQOnBw == null) {
			throw new RuntimeException("Error hashing password - out = null");
		}
		return bikQOnBw;
	}

}