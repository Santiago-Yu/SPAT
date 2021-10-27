class n6508481 {
	static void invalidSlave(String aVSbqNba, Socket htPGWxKJ) throws IOException {
		BufferedReader IUQgmCsb = null;
		PrintWriter MG8xM3ET = null;
		try {
			MG8xM3ET = new PrintWriter(htPGWxKJ.getOutputStream(), true);
			IUQgmCsb = new BufferedReader(new InputStreamReader(htPGWxKJ.getInputStream()));
			MG8xM3ET.println(aVSbqNba);
			logger.info("NEW< " + aVSbqNba);
			String Z4MV1mRw = AsyncSlaveListener.readLine(IUQgmCsb, 30);
			String iOUMGedG = "";
			String D1njzt1X = "";
			String c8BDHOtK = "";
			try {
				String[] up4Ss88r = Z4MV1mRw.split(" ");
				iOUMGedG = up4Ss88r[1].trim();
				D1njzt1X = up4Ss88r[2].trim();
				c8BDHOtK = up4Ss88r[3].trim();
			} catch (Exception OofWyYGf) {
				throw new IOException("Slave Inititalization Faailed");
			}
			String BWILU2Bk = iOUMGedG + D1njzt1X + _pass;
			MessageDigest biBgdEUl = MessageDigest.getInstance("MD5");
			biBgdEUl.reset();
			biBgdEUl.update(BWILU2Bk.getBytes());
			String utG5bvkT = AsyncSlaveListener.hash2hex(biBgdEUl.digest()).toLowerCase();
			if (!utG5bvkT.equals(c8BDHOtK)) {
				throw new IOException("Slave Inititalization Faailed");
			}
		} catch (Exception tEKjNjLG) {
		}
		throw new IOException("Slave Inititalization Faailed");
	}

}