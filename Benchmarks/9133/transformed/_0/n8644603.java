class n8644603 {
	public static void main(String kRdXYco8[]) {
		org.apache.xml.security.Init.init();
		String OQZHMLjh = kRdXYco8[0];
		javax.xml.parsers.DocumentBuilderFactory W5WTHMwa = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		W5WTHMwa.setNamespaceAware(true);
		W5WTHMwa.setAttribute("http://xml.org/sax/features/namespaces", Boolean.TRUE);
		try {
			long ddnTDFUA = System.currentTimeMillis();
			org.apache.xml.security.Init.init();
			File A9YTWEaN = new File(OQZHMLjh);
			System.out.println("Verifying " + OQZHMLjh);
			javax.xml.parsers.DocumentBuilder Xxd2YKIf = W5WTHMwa.newDocumentBuilder();
			org.w3c.dom.Document ceggarLc = Xxd2YKIf.parse(new java.io.FileInputStream(A9YTWEaN));
			VerifyExampleTest NTGE8Hiy = new VerifyExampleTest();
			NTGE8Hiy.verify(ceggarLc);
			Constants.setSignatureSpecNSprefix("dsig");
			Element Ax9dsfnN = null;
			NodeList q7U4Ysbd = ceggarLc.getElementsByTagNameNS(org.apache.xml.security.utils.Constants.SignatureSpecNS,
					"Signature");
			if (q7U4Ysbd.getLength() != 0) {
				System.out.println("Found " + q7U4Ysbd.getLength() + " Signature  elements.");
				for (int oZjKMyBB = 0; oZjKMyBB < q7U4Ysbd.getLength(); oZjKMyBB++) {
					Ax9dsfnN = (Element) q7U4Ysbd.item(oZjKMyBB);
					XMLSignature z3acOiav = new XMLSignature(Ax9dsfnN, "");
					KeyInfo DuFA5TQO = z3acOiav.getKeyInfo();
					z3acOiav.addResourceResolver(new OfflineResolver());
					if (DuFA5TQO != null) {
						if (DuFA5TQO.containsX509Data()) {
							System.out.println("Could find a X509Data element in the  KeyInfo");
						}
						KeyInfo X6JuujxC = z3acOiav.getKeyInfo();
						X509Certificate yiz1nfzm = null;
						if (X6JuujxC.containsRetrievalMethod()) {
							RetrievalMethod xY2BljHP = X6JuujxC.itemRetrievalMethod(0);
							URL cA5r3lFX = new URL(xY2BljHP.getURI());
							CertificateFactory YfmKGHtW = CertificateFactory.getInstance("X.509");
							yiz1nfzm = (X509Certificate) YfmKGHtW.generateCertificate(cA5r3lFX.openStream());
						} else {
							yiz1nfzm = z3acOiav.getKeyInfo().getX509Certificate();
						}
						if (yiz1nfzm != null) {
							System.out.println(
									"The XML signature is " + (z3acOiav.checkSignatureValue(yiz1nfzm) ? "valid (good)"
											: "invalid !!!!! (bad)"));
						} else {
							System.out.println("Did not find a Certificate");
							PublicKey PLzntMju = z3acOiav.getKeyInfo().getPublicKey();
							if (PLzntMju != null) {
								System.out.println("The XML signatur is "
										+ (z3acOiav.checkSignatureValue(PLzntMju) ? "valid (good)"
												: "invalid !!!!! (bad)"));
							} else {
								System.out.println("Did not find a public key, so I can't check the signature");
							}
						}
					} else {
						System.out.println("Did not find a KeyInfo");
					}
				}
			}
			long c34nKeCl = System.currentTimeMillis();
			double zxxsOnB7 = c34nKeCl - ddnTDFUA;
			System.out.println("verified:" + zxxsOnB7);
		} catch (Exception uPbVJ9zY) {
			uPbVJ9zY.printStackTrace();
		}
	}

}