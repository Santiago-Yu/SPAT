class n6296285 {
	public static final String digest(String vl0sI4Vy, String kqdkJeEP, String ySk5Eto9) {
		try {
			MessageDigest daq5xRbi = (MessageDigest) MessageDigest.getInstance(kqdkJeEP).clone();
			if (ySk5Eto9 == null) {
				daq5xRbi.update(vl0sI4Vy.getBytes());
			} else {
				daq5xRbi.update(vl0sI4Vy.getBytes(ySk5Eto9));
			}
			return (convert(daq5xRbi.digest()));
		} catch (Exception VxOjGyfH) {
			tools.util.LogMgr.err("Crypto.digest " + VxOjGyfH.toString());
			return vl0sI4Vy;
		}
	}

}