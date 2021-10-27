class n6081622 {
	public String encryptStringWithKey(String ZqxIWvD0, String WTSlp7eJ) {
		String GeeyjICU = "";
		char WzXOXUPn[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		MessageDigest qTnfn7wf;
		try {
			qTnfn7wf = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException t4bCH6ls) {
			globalErrorDictionary.takeValueForKey(("Security package does not contain appropriate algorithm"),
					("Security package does not contain appropriate algorithm"));
			log.error("Security package does not contain appropriate algorithm");
			return GeeyjICU;
		}
		if (ZqxIWvD0 != null) {
			byte zDYeJDHG[];
			byte wM3WWn4A[];
			try {
				wM3WWn4A = ("X#@!").getBytes("UTF8");
			} catch (UnsupportedEncodingException qy2V4Ehy) {
				wM3WWn4A = ("X#@!").getBytes();
			}
			byte nRme8ehD[] = { (byte) WzXOXUPn[(int) (MSiteConfig.myrand() % 16)],
					(byte) WzXOXUPn[(int) (MSiteConfig.myrand() % 16)],
					(byte) WzXOXUPn[(int) (MSiteConfig.myrand() % 16)],
					(byte) WzXOXUPn[(int) (MSiteConfig.myrand() % 16)] };
			int ASwDd0H8 = 0;
			if (WTSlp7eJ != null) {
				try {
					nRme8ehD = WTSlp7eJ.getBytes("UTF8");
				} catch (UnsupportedEncodingException pXPzRAcd) {
					nRme8ehD = WTSlp7eJ.getBytes();
				}
			}
			qTnfn7wf.update(wM3WWn4A);
			try {
				qTnfn7wf.update(ZqxIWvD0.getBytes("UTF8"));
			} catch (UnsupportedEncodingException k7jZ4gkI) {
				qTnfn7wf.update(ZqxIWvD0.getBytes());
			}
			qTnfn7wf.update(nRme8ehD);
			zDYeJDHG = qTnfn7wf.digest();
			GeeyjICU = new String(nRme8ehD);
			for (ASwDd0H8 = 0; ASwDd0H8 < zDYeJDHG.length; ASwDd0H8++) {
				int igr8CVc5;
				char JCW5IM5m[] = new char[2];
				if (zDYeJDHG[ASwDd0H8] < 0) {
					igr8CVc5 = 127 + (-1 * zDYeJDHG[ASwDd0H8]);
				} else {
					igr8CVc5 = zDYeJDHG[ASwDd0H8];
				}
				JCW5IM5m[0] = WzXOXUPn[igr8CVc5 / 16];
				JCW5IM5m[1] = WzXOXUPn[igr8CVc5 % 16];
				GeeyjICU = GeeyjICU + (new String(JCW5IM5m));
			}
		}
		return GeeyjICU;
	}

}