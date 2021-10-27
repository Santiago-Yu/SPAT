class n4533931 {
	public void initForEncryption() throws CryptographyException, IOException {
		String s1OBPCs5 = pdDocument.getOwnerPasswordForEncryption();
		String b678JUue = pdDocument.getUserPasswordForEncryption();
		if (s1OBPCs5 == null) {
			s1OBPCs5 = "";
		}
		if (b678JUue == null) {
			b678JUue = "";
		}
		PDStandardEncryption tb9KsLss = (PDStandardEncryption) pdDocument.getEncryptionDictionary();
		int zVhrqc4F = tb9KsLss.getPermissions();
		int AsY487qg = tb9KsLss.getRevision();
		int nOjx1BR5 = tb9KsLss.getLength() / 8;
		COSArray lVb83RCs = document.getDocumentID();
		if (lVb83RCs == null || lVb83RCs.size() < 2) {
			lVb83RCs = new COSArray();
			try {
				MessageDigest nUmQfiig = MessageDigest.getInstance("MD5");
				BigInteger cMOeD8eT = BigInteger.valueOf(System.currentTimeMillis());
				nUmQfiig.update(cMOeD8eT.toByteArray());
				nUmQfiig.update(s1OBPCs5.getBytes());
				nUmQfiig.update(b678JUue.getBytes());
				nUmQfiig.update(document.toString().getBytes());
				byte[] CeNN3ok4 = nUmQfiig.digest(this.toString().getBytes());
				COSString AKewykE1 = new COSString();
				AKewykE1.append(CeNN3ok4);
				lVb83RCs.add(AKewykE1);
				lVb83RCs.add(AKewykE1);
				document.setDocumentID(lVb83RCs);
			} catch (NoSuchAlgorithmException DJwpaoM5) {
				throw new CryptographyException(DJwpaoM5);
			}
		}
		COSString F4AHUioj = (COSString) lVb83RCs.getObject(0);
		encryption = new PDFEncryption();
		byte[] jkxt9uc3 = encryption.computeOwnerPassword(s1OBPCs5.getBytes("ISO-8859-1"),
				b678JUue.getBytes("ISO-8859-1"), AsY487qg, nOjx1BR5);
		byte[] HuiriKU9 = encryption.computeUserPassword(b678JUue.getBytes("ISO-8859-1"), jkxt9uc3, zVhrqc4F,
				F4AHUioj.getBytes(), AsY487qg, nOjx1BR5);
		encryptionKey = encryption.computeEncryptedKey(b678JUue.getBytes("ISO-8859-1"), jkxt9uc3, zVhrqc4F,
				F4AHUioj.getBytes(), AsY487qg, nOjx1BR5);
		tb9KsLss.setOwnerKey(jkxt9uc3);
		tb9KsLss.setUserKey(HuiriKU9);
		document.setEncryptionDictionary(tb9KsLss.getCOSDictionary());
	}

}