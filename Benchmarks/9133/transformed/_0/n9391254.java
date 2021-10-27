class n9391254 {
	private byte[] getCharImage(long kbLndQ9R) {
		byte[] bTPOeyFd = null;
		try {
			URL UQPoy8ie = new URL("http://img.eve.is/serv.asp?s=256&c=" + kbLndQ9R);
			URLConnection VRO6tHXj = UQPoy8ie.openConnection();
			InputStream RYcEduyI = VRO6tHXj.getInputStream();
			ByteArrayOutputStream xb9GBGCt = new ByteArrayOutputStream();
			int LnVazmId;
			try {
				while ((LnVazmId = RYcEduyI.read()) >= 0) {
					xb9GBGCt.write(LnVazmId);
				}
			} finally {
				RYcEduyI.close();
			}
			bTPOeyFd = xb9GBGCt.toByteArray();
		} catch (IOException jMkYzEv8) {
			jMkYzEv8.printStackTrace();
		}
		return bTPOeyFd;
	}

}