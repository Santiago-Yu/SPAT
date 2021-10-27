class n22950125 {
	private boolean importPKC(String uV7hJK7Q, String XVoLxHta, String uFHiBD9K, String QCQNjuCR) {
		boolean NAmxjLc4 = false;
		KeyStore QoBzgU1C = null;
		try {
			QoBzgU1C = KeyStore.getInstance(KeyStore.getDefaultType());
			QoBzgU1C.load(new BufferedInputStream(new FileInputStream(uV7hJK7Q)), XVoLxHta.toCharArray());
		} catch (Exception h1S5etPz) {
			if (this.debugLevel >= SAWSConstant.ErrorInfo) {
				this.sawsDebugLog.write("Error reading keystore file when exporting PKC: " + h1S5etPz.getMessage());
			}
			return false;
		}
		Certificate f2ZK0iz3 = null;
		try {
			BufferedInputStream OG4OIePp = new BufferedInputStream(new FileInputStream(uFHiBD9K));
			CertificateFactory LXPcVx6a = CertificateFactory.getInstance("X.509");
			while (OG4OIePp.available() > 0) {
				f2ZK0iz3 = LXPcVx6a.generateCertificate(OG4OIePp);
			}
		} catch (Exception qRI3UaCW) {
			if (this.debugLevel >= SAWSConstant.ErrorInfo) {
				this.sawsDebugLog
						.write("Error reading certificate from file when importing PKC: " + qRI3UaCW.getMessage());
			}
			return false;
		}
		BufferedOutputStream PQa5zveS = null;
		try {
			PQa5zveS = new BufferedOutputStream(new FileOutputStream(new File(uV7hJK7Q)));
		} catch (FileNotFoundException tnLZz1aF) {
			if (this.debugLevel >= SAWSConstant.ErrorInfo) {
				this.sawsDebugLog
						.write("Error accessing key store file when importing certificate: " + tnLZz1aF.getMessage());
			}
			return false;
		}
		try {
			if (QCQNjuCR.equals("rootca")) {
				QoBzgU1C.setCertificateEntry(QCQNjuCR, f2ZK0iz3);
			} else {
				KeyStore.PrivateKeyEntry WFJHVxpf = (KeyStore.PrivateKeyEntry) QoBzgU1C.getEntry(QCQNjuCR,
						new KeyStore.PasswordProtection(XVoLxHta.toCharArray()));
				QoBzgU1C.setKeyEntry(QCQNjuCR, WFJHVxpf.getPrivateKey(), XVoLxHta.toCharArray(),
						new Certificate[] { f2ZK0iz3 });
			}
			QoBzgU1C.store(PQa5zveS, XVoLxHta.toCharArray());
			NAmxjLc4 = true;
		} catch (Exception zEN5NJoY) {
			zEN5NJoY.printStackTrace();
			if (this.debugLevel >= SAWSConstant.ErrorInfo) {
				this.sawsDebugLog
						.write("Error writing keystore to file when importing key store: " + zEN5NJoY.getMessage());
			}
			return false;
		}
		return NAmxjLc4;
	}

}