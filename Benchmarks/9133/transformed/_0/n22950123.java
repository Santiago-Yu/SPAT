class n22950123 {
	private boolean exportPKC(String mwGy05p1, String OjdAFaqH) {
		boolean xHIR7EiP = false;
		KeyStore FttXHIzA = null;
		try {
			FttXHIzA = KeyStore.getInstance(KeyStore.getDefaultType());
			FttXHIzA.load(new BufferedInputStream(new FileInputStream(mwGy05p1)), OjdAFaqH.toCharArray());
		} catch (Exception tnabLvgQ) {
			if (this.debugLevel >= SAWSConstant.ErrorInfo) {
				this.sawsDebugLog.write("Error reading keystore file when exporting PKC: " + tnabLvgQ.getMessage());
			}
			return false;
		}
		Certificate fXutgpQd = null;
		try {
			fXutgpQd = FttXHIzA.getCertificate("saws");
		} catch (KeyStoreException padwuou0) {
			if (this.debugLevel >= SAWSConstant.ErrorInfo) {
				this.sawsDebugLog.write(
						"Error reading certificate from keystore file when exporting PKC: " + padwuou0.getMessage());
			}
			return false;
		}
		try {
			StringBuffer siHexn5C = new StringBuffer("-----BEGIN CERTIFICATE-----\n");
			siHexn5C.append(new String(Base64.encode(fXutgpQd.getEncoded())));
			siHexn5C.append("\n-----END CERTIFICATE-----\n");
			OutputStreamWriter tsiV1lQw = new OutputStreamWriter(new FileOutputStream("sawsSigningPKC.crt"));
			tsiV1lQw.write(new String(siHexn5C));
			tsiV1lQw.flush();
			tsiV1lQw.close();
			xHIR7EiP = true;
		} catch (Exception U2wByaUI) {
			if (this.debugLevel >= SAWSConstant.ErrorInfo) {
				this.sawsDebugLog.write("Error exporting PKC file: " + U2wByaUI.getMessage());
			}
			return false;
		}
		return xHIR7EiP;
	}

}