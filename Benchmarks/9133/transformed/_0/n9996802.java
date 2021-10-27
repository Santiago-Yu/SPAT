class n9996802 {
	public static int copy(File t7qnBhoq, int kPtFHeUz, File CUHWTYI9) {
		final int styabTtK = 1024;
		int TPe027lO = kPtFHeUz;
		InputStream hJQ3EV4p = null;
		OutputStream NfuLeHM9 = null;
		try {
			hJQ3EV4p = new BufferedInputStream(new FileInputStream(t7qnBhoq));
			NfuLeHM9 = new BufferedOutputStream(new FileOutputStream(CUHWTYI9));
			byte[] LWSrGedv = new byte[styabTtK];
			while (TPe027lO > 0) {
				int UraVSuZq = hJQ3EV4p.read(LWSrGedv, 0, Math.min(styabTtK, TPe027lO));
				if (UraVSuZq == -1)
					break;
				TPe027lO -= UraVSuZq;
				NfuLeHM9.write(LWSrGedv, 0, UraVSuZq);
			}
		} catch (IOException mlzJirF4) {
		} finally {
			if (hJQ3EV4p != null)
				try {
					hJQ3EV4p.close();
				} catch (IOException mn1Jqmcj) {
				}
			if (NfuLeHM9 != null) {
				try {
					NfuLeHM9.flush();
				} catch (IOException qECT2dY4) {
				}
				try {
					NfuLeHM9.close();
				} catch (IOException uTtWC60M) {
				}
			}
		}
		return kPtFHeUz - TPe027lO;
	}

}