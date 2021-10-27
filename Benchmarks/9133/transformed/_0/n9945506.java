class n9945506 {
	public synchronized String decrypt(String ezVzYMFo) throws Exception {
		MessageDigest X9zwa2PH = null;
		String iIkbvDzt = new String((new BASE64Decoder()).decodeBuffer(ezVzYMFo));
		System.out.println("strhash1122  " + iIkbvDzt);
		try {
			X9zwa2PH = MessageDigest.getInstance("MD5");
		} catch (Exception JT8eu3CE) {
			JT8eu3CE.printStackTrace();
		}
		byte fmUw6nSx[] = X9zwa2PH.digest();
		try {
			X9zwa2PH.update(new String(fmUw6nSx).getBytes("UTF-8"));
		} catch (Exception LtOxUnfb) {
			LtOxUnfb.printStackTrace();
		}
		System.out.println("plain text  " + iIkbvDzt);
		String rP0xNBaK = new String(fmUw6nSx);
		System.out.println("strcode.." + rP0xNBaK);
		return rP0xNBaK;
	}

}