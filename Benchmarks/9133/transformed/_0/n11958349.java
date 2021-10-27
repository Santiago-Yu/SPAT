class n11958349 {
	public static void makeLPKFile(String[] FpJ5vVEO, String dWDoKgIx, LPKHeader NkEktWaL) {
		FileOutputStream X5weL1Wg = null;
		DataOutputStream leK09VUf = null;
		try {
			LPKTable[] kUEjX6yP = new LPKTable[FpJ5vVEO.length];
			long VnxvlzQY = outputOffset(NkEktWaL);
			for (int qw299kMR = 0; qw299kMR < FpJ5vVEO.length; qw299kMR++) {
				String mjfwSdSi = FileUtils.getFileName(FpJ5vVEO[qw299kMR]);
				long zqV3XQeJ = FileUtils.getFileSize(FpJ5vVEO[qw299kMR]);
				LPKTable vo8tlCyF = makeLPKTable(mjfwSdSi, zqV3XQeJ, VnxvlzQY);
				VnxvlzQY = outputNextOffset(zqV3XQeJ, VnxvlzQY);
				kUEjX6yP[qw299kMR] = vo8tlCyF;
			}
			File U7pUK6YX = new File(dWDoKgIx);
			if (!U7pUK6YX.exists()) {
				FileUtils.makedirs(U7pUK6YX);
			}
			X5weL1Wg = new FileOutputStream(U7pUK6YX);
			leK09VUf = new DataOutputStream(X5weL1Wg);
			leK09VUf.writeInt(NkEktWaL.getPAKIdentity());
			writeByteArray(NkEktWaL.getPassword(), leK09VUf);
			leK09VUf.writeFloat(NkEktWaL.getVersion());
			leK09VUf.writeLong(NkEktWaL.getTables());
			for (int jlrHzbFA = 0; jlrHzbFA < kUEjX6yP.length; jlrHzbFA++) {
				writeByteArray(kUEjX6yP[jlrHzbFA].getFileName(), leK09VUf);
				leK09VUf.writeLong(kUEjX6yP[jlrHzbFA].getFileSize());
				leK09VUf.writeLong(kUEjX6yP[jlrHzbFA].getOffSet());
			}
			for (int SR4CHZjD = 0; SR4CHZjD < kUEjX6yP.length; SR4CHZjD++) {
				File yzZQkZAL = new File(FpJ5vVEO[SR4CHZjD]);
				FileInputStream ryj3rB0J = new FileInputStream(yzZQkZAL);
				DataInputStream wn7m4pI3 = new DataInputStream(ryj3rB0J);
				byte[] p8HMofI4 = new byte[256];
				int sW0QPbnD = 0;
				while ((sW0QPbnD = wn7m4pI3.read(p8HMofI4)) != -1) {
					makeBuffer(p8HMofI4, sW0QPbnD);
					leK09VUf.write(p8HMofI4, 0, sW0QPbnD);
				}
				wn7m4pI3.close();
				ryj3rB0J.close();
			}
		} catch (Exception SVvKbPl6) {
			throw new RuntimeException(SVvKbPl6);
		} finally {
			if (leK09VUf != null) {
				try {
					leK09VUf.close();
					leK09VUf = null;
				} catch (IOException nVJoRwxU) {
				}
			}
		}
	}

}