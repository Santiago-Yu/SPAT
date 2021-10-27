class n5794877 {
	public void prepareDocumentForEncryption(PDDocument Eb5cxa79) throws CryptographyException, IOException {
		document = Eb5cxa79;
		PDEncryptionDictionary HR2jEOJR = document.getEncryptionDictionary();
		if (HR2jEOJR == null) {
			HR2jEOJR = new PDEncryptionDictionary();
		}
		version = computeVersionNumber();
		revision = computeRevisionNumber();
		HR2jEOJR.setFilter(FILTER);
		HR2jEOJR.setVersion(version);
		HR2jEOJR.setRevision(revision);
		HR2jEOJR.setLength(keyLength);
		String Y1ZmuuTn = policy.getOwnerPassword();
		String xn4I3SRJ = policy.getUserPassword();
		if (Y1ZmuuTn == null) {
			Y1ZmuuTn = "";
		}
		if (xn4I3SRJ == null) {
			xn4I3SRJ = "";
		}
		int p6ZgMUBR = policy.getPermissions().getPermissionBytes();
		HR2jEOJR.setPermissions(p6ZgMUBR);
		int JiAlzlJg = keyLength / 8;
		COSArray jptXiY5s = document.getDocument().getDocumentID();
		if (jptXiY5s == null || jptXiY5s.size() < 2) {
			jptXiY5s = new COSArray();
			try {
				MessageDigest tBRPsfQy = MessageDigest.getInstance("MD5");
				BigInteger rCCGTLK0 = BigInteger.valueOf(System.currentTimeMillis());
				tBRPsfQy.update(rCCGTLK0.toByteArray());
				tBRPsfQy.update(Y1ZmuuTn.getBytes());
				tBRPsfQy.update(xn4I3SRJ.getBytes());
				tBRPsfQy.update(document.getDocument().toString().getBytes());
				byte[] UaiZRqkK = tBRPsfQy.digest(this.toString().getBytes());
				COSString VpFHTk9b = new COSString();
				VpFHTk9b.append(UaiZRqkK);
				jptXiY5s.add(VpFHTk9b);
				jptXiY5s.add(VpFHTk9b);
				document.getDocument().setDocumentID(jptXiY5s);
			} catch (NoSuchAlgorithmException R6Ol2V6O) {
				throw new CryptographyException(R6Ol2V6O);
			} catch (IOException JL0Lm6JJ) {
				throw new CryptographyException(JL0Lm6JJ);
			}
		}
		COSString HC49rjXF = (COSString) jptXiY5s.getObject(0);
		byte[] K5R4nmf7 = computeOwnerPassword(Y1ZmuuTn.getBytes("ISO-8859-1"), xn4I3SRJ.getBytes("ISO-8859-1"),
				revision, JiAlzlJg);
		byte[] J0h9IJDA = computeUserPassword(xn4I3SRJ.getBytes("ISO-8859-1"), K5R4nmf7, p6ZgMUBR, HC49rjXF.getBytes(),
				revision, JiAlzlJg);
		encryptionKey = computeEncryptedKey(xn4I3SRJ.getBytes("ISO-8859-1"), K5R4nmf7, p6ZgMUBR, HC49rjXF.getBytes(),
				revision, JiAlzlJg);
		HR2jEOJR.setOwnerKey(K5R4nmf7);
		HR2jEOJR.setUserKey(J0h9IJDA);
		document.setEncryptionDictionary(HR2jEOJR);
		document.getDocument().setEncryptionDictionary(HR2jEOJR.getCOSDictionary());
	}

}