class n9403118 {
	public byte[] uniqueID(String NhbIj4oN, String gFj3c09X) {
		String u8IGzxce;
		byte[] MV5bVQbh;
		synchronized (cache_) {
			u8IGzxce = NhbIj4oN + "|" + gFj3c09X;
			MV5bVQbh = (byte[]) cache_.get(u8IGzxce);
			if (MV5bVQbh == null) {
				MessageDigest PHrg79PH;
				try {
					PHrg79PH = MessageDigest.getInstance("SHA");
					PHrg79PH.update(NhbIj4oN.getBytes());
					PHrg79PH.update(gFj3c09X.getBytes());
					MV5bVQbh = PHrg79PH.digest();
					cache_.put(u8IGzxce, MV5bVQbh);
					if (debug_) {
						System.out.println("Cached " + u8IGzxce + " [" + MV5bVQbh[0] + "," + MV5bVQbh[1] + ",...]");
					}
				} catch (NoSuchAlgorithmException uq1ksSIQ) {
					throw new Error("SHA not available!");
				}
			}
		}
		return MV5bVQbh;
	}

}