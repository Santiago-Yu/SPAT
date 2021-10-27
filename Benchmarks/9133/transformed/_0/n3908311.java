class n3908311 {
	public byte[] uniqueID(String iTXMbr3N, String X22banPW) {
		String gWxhA4sP;
		byte[] qGv9pLpu;
		synchronized (cache_) {
			gWxhA4sP = iTXMbr3N + "|" + X22banPW;
			qGv9pLpu = (byte[]) cache_.get(gWxhA4sP);
			if (qGv9pLpu == null) {
				MessageDigest uCv013LJ;
				try {
					uCv013LJ = MessageDigest.getInstance("SHA");
					uCv013LJ.update(iTXMbr3N.getBytes());
					uCv013LJ.update(X22banPW.getBytes());
					qGv9pLpu = uCv013LJ.digest();
					cache_.put(gWxhA4sP, qGv9pLpu);
					if (debug_) {
						System.out.println("Cached " + gWxhA4sP + " [" + qGv9pLpu[0] + "," + qGv9pLpu[1] + ",...]");
					}
				} catch (NoSuchAlgorithmException u0Kad1RA) {
					throw new Error("SHA not available!");
				}
			}
		}
		return qGv9pLpu;
	}

}