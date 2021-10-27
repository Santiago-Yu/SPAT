class n22950121 {
	private boolean createPKCReqest(String AaxCwpu1, String FHJCQ2il) {
		boolean KayoDgbM = false;
		Security.addProvider(new BouncyCastleProvider());
		KeyStore cLe1BFf6 = null;
		try {
			cLe1BFf6 = KeyStore.getInstance(KeyStore.getDefaultType());
			cLe1BFf6.load(new BufferedInputStream(new FileInputStream(AaxCwpu1)), FHJCQ2il.toCharArray());
		} catch (Exception sjMrqV8n) {
			if (this.debugLevel >= SAWSConstant.ErrorInfo) {
				this.sawsDebugLog
						.write("Error reading keystore file when creating PKC request: " + sjMrqV8n.getMessage());
			}
			return false;
		}
		Certificate xydYmvym = null;
		try {
			xydYmvym = cLe1BFf6.getCertificate("saws");
		} catch (KeyStoreException Ro0aSvZg) {
			if (this.debugLevel >= SAWSConstant.ErrorInfo) {
				this.sawsDebugLog.write("Error reading certificate from keystore file when creating PKC request: "
						+ Ro0aSvZg.getMessage());
			}
			return false;
		}
		PKCS10CertificationRequest iMOITRma = null;
		PublicKey AGVhUl62 = xydYmvym.getPublicKey();
		try {
			iMOITRma = new PKCS10CertificationRequest("SHA1with" + AGVhUl62.getAlgorithm(),
					new X500Principal(((X509Certificate) xydYmvym).getSubjectDN().toString()), AGVhUl62, new DERSet(),
					(PrivateKey) cLe1BFf6.getKey("saws", FHJCQ2il.toCharArray()));
			PEMWriter oC9BRexl = new PEMWriter(new OutputStreamWriter(new FileOutputStream("sawsRequest.csr")));
			oC9BRexl.writeObject(iMOITRma);
			oC9BRexl.close();
			KayoDgbM = true;
		} catch (Exception qpFpAmV1) {
			if (this.debugLevel >= SAWSConstant.ErrorInfo) {
				this.sawsDebugLog.write("Error creating PKC request file: " + qpFpAmV1.getMessage());
			}
			return false;
		}
		return KayoDgbM;
	}

}