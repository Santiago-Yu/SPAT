class n6983973 {
	private void getRandomGUID(boolean nNdglrCc) {
		MessageDigest eBuh6ZG3 = null;
		StringBuffer Jwia7qpw = new StringBuffer();
		try {
			eBuh6ZG3 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException Ng6XgqNz) {
			System.out.println("Error: " + Ng6XgqNz);
		}
		try {
			long G4hBI0nO = System.currentTimeMillis();
			long NBQqf1se = 0;
			if (nNdglrCc) {
				NBQqf1se = mySecureRand.nextLong();
			} else {
				NBQqf1se = myRand.nextLong();
			}
			Jwia7qpw.append(s_id);
			Jwia7qpw.append(":");
			Jwia7qpw.append(Long.toString(G4hBI0nO));
			Jwia7qpw.append(":");
			Jwia7qpw.append(Long.toString(NBQqf1se));
			valueBeforeMD5 = Jwia7qpw.toString();
			eBuh6ZG3.update(valueBeforeMD5.getBytes());
			byte[] l4OpndAs = eBuh6ZG3.digest();
			StringBuffer LiuAHW5X = new StringBuffer();
			for (int kvTzODnZ = 0; kvTzODnZ < l4OpndAs.length; ++kvTzODnZ) {
				int hBtFpmnW = l4OpndAs[kvTzODnZ] & 0xFF;
				if (hBtFpmnW < 0x10)
					LiuAHW5X.append('0');
				LiuAHW5X.append(Integer.toHexString(hBtFpmnW));
			}
			valueAfterMD5 = LiuAHW5X.toString();
		} catch (Exception PNdNg2W6) {
			System.out.println("Error:" + PNdNg2W6);
		}
	}

}