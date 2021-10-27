class n6966398 {
	public static void main(String[] HovD5fp9) {
		System.out.println("Chapter 16: example SignedPdf");
		System.out.println("-> Creates a signed PDF;");
		System.out.println("-> jars needed: iText.jar");
		System.out.println("-> files generated in /results subdirectory:");
		System.out.println("   Resource needed: .keystore");
		System.out.println("-> Resulting PDFs: unsigned_message.pdf, signed_message.pdf,");
		System.out.println("   corrupted_message.pdf, signed_message_invisible.pdf,");
		System.out.println("   double_signed_message.pdf, revision_1.pdf and revision_2.pdf");
		createPdf();
		PdfReader RMttzp6m;
		try {
			KeyStore H92goMcu = KeyStore.getInstance(KeyStore.getDefaultType());
			H92goMcu.load(new FileInputStream("resources/in_action/chapter16/.keystore"), "f00b4r".toCharArray());
			PrivateKey qn1Nrld3 = (PrivateKey) H92goMcu.getKey("foobar", "r4b00f".toCharArray());
			Certificate[] zRJJO16g = H92goMcu.getCertificateChain("foobar");
			RMttzp6m = new PdfReader("results/in_action/chapter16/unsigned_message.pdf");
			FileOutputStream YuZ0qMZE = new FileOutputStream("results/in_action/chapter16/signed_message.pdf");
			PdfStamper OfutotN0 = PdfStamper.createSignature(RMttzp6m, YuZ0qMZE, '\0');
			PdfSignatureAppearance ZkboJhA4 = OfutotN0.getSignatureAppearance();
			ZkboJhA4.setCrypto(qn1Nrld3, zRJJO16g, null, PdfSignatureAppearance.SELF_SIGNED);
			ZkboJhA4.setCertificationLevel(PdfSignatureAppearance.CERTIFIED_FORM_FILLING);
			ZkboJhA4.setReason("It's personal.");
			ZkboJhA4.setLocation("Foobar");
			ZkboJhA4.setVisibleSignature(new Rectangle(30, 750, 500, 565), 1, null);
			OfutotN0.close();
		} catch (KeyStoreException k9H4Gd0w) {
			k9H4Gd0w.printStackTrace();
		} catch (NoSuchAlgorithmException BcDGwH6Q) {
			BcDGwH6Q.printStackTrace();
		} catch (CertificateException aq5w7ZxC) {
			aq5w7ZxC.printStackTrace();
		} catch (FileNotFoundException WSmDUrj4) {
			WSmDUrj4.printStackTrace();
		} catch (IOException x2RkpoPs) {
			x2RkpoPs.printStackTrace();
		} catch (UnrecoverableKeyException XCcEEL26) {
			XCcEEL26.printStackTrace();
		} catch (DocumentException jpAs8AVt) {
			jpAs8AVt.printStackTrace();
		}
		try {
			RMttzp6m = new PdfReader("results/in_action/chapter16/signed_message.pdf");
			Document QaNKK75j = new Document(RMttzp6m.getPageSizeWithRotation(1));
			PdfCopy FskLSqrs = new PdfCopy(QaNKK75j,
					new FileOutputStream("results/in_action/chapter16/corrupted_message.pdf"));
			QaNKK75j.open();
			FskLSqrs.addPage(FskLSqrs.getImportedPage(RMttzp6m, 1));
			QaNKK75j.close();
		} catch (IOException Vz5ygfSL) {
			Vz5ygfSL.printStackTrace();
		} catch (DocumentException cc1tiN3Z) {
			cc1tiN3Z.printStackTrace();
		}
		try {
			KeyStore Du3xJBWp = KeyStore.getInstance(KeyStore.getDefaultType());
			Du3xJBWp.load(new FileInputStream("resources/in_action/chapter16/.keystore"), "f00b4r".toCharArray());
			PrivateKey vQwivaiG = (PrivateKey) Du3xJBWp.getKey("foobar", "r4b00f".toCharArray());
			Certificate[] WmTftm2O = Du3xJBWp.getCertificateChain("foobar");
			RMttzp6m = new PdfReader("results/in_action/chapter16/unsigned_message.pdf");
			FileOutputStream Lq8y0cVX = new FileOutputStream(
					"results/in_action/chapter16/signed_message_invisible.pdf");
			PdfStamper Cd39z8xc = PdfStamper.createSignature(RMttzp6m, Lq8y0cVX, '\0');
			PdfSignatureAppearance K7vUfaMH = Cd39z8xc.getSignatureAppearance();
			K7vUfaMH.setCrypto(vQwivaiG, WmTftm2O, null, PdfSignatureAppearance.SELF_SIGNED);
			K7vUfaMH.setReason("It's personal.");
			K7vUfaMH.setLocation("Foobar");
			Cd39z8xc.close();
		} catch (Exception mUyllXkq) {
			mUyllXkq.printStackTrace();
		}
		try {
			RMttzp6m = new PdfReader("results/in_action/chapter16/signed_message.pdf");
			KeyStore OFSkdNF5 = KeyStore.getInstance(KeyStore.getDefaultType());
			OFSkdNF5.load(new FileInputStream("resources/in_action/chapter16/.keystore"), "f00b4r".toCharArray());
			PrivateKey jMox5hCX = (PrivateKey) OFSkdNF5.getKey("foobar", "r4b00f".toCharArray());
			Certificate[] Fw3ihZqz = OFSkdNF5.getCertificateChain("foobar");
			FileOutputStream U2ahaUSo = new FileOutputStream("results/in_action/chapter16/double_signed_message.pdf");
			PdfStamper PhmcomDW = PdfStamper.createSignature(RMttzp6m, U2ahaUSo, '\0', null, true);
			PdfSignatureAppearance OcOkeBoz = PhmcomDW.getSignatureAppearance();
			OcOkeBoz.setCrypto(jMox5hCX, Fw3ihZqz, null, PdfSignatureAppearance.SELF_SIGNED);
			OcOkeBoz.setReason("Double signed.");
			OcOkeBoz.setLocation("Foobar");
			OcOkeBoz.setVisibleSignature(new Rectangle(300, 750, 500, 800), 1, "secondsig");
			PhmcomDW.close();
		} catch (Exception SjWeVZSo) {
			SjWeVZSo.printStackTrace();
		}
		try {
			CertificateFactory Vx8jKEHg = CertificateFactory.getInstance("X509");
			Collection iqvP74bf = Vx8jKEHg
					.generateCertificates(new FileInputStream("resources/in_action/chapter16/foobar.cer"));
			KeyStore TJUe47yP = KeyStore.getInstance(KeyStore.getDefaultType());
			TJUe47yP.load(null, null);
			for (Iterator eK8y0Fnw = iqvP74bf.iterator(); eK8y0Fnw.hasNext();) {
				X509Certificate Ghxjk1SD = (X509Certificate) eK8y0Fnw.next();
				System.out.println(Ghxjk1SD.getIssuerDN().getName());
				TJUe47yP.setCertificateEntry(Ghxjk1SD.getSerialNumber().toString(Character.MAX_RADIX), Ghxjk1SD);
			}
			RMttzp6m = new PdfReader("results/in_action/chapter16/double_signed_message.pdf");
			AcroFields b8ma3GLF = RMttzp6m.getAcroFields();
			ArrayList Wl3CqFTD = b8ma3GLF.getSignatureNames();
			String l3FQP0we;
			for (Iterator FCDMPYxX = Wl3CqFTD.iterator(); FCDMPYxX.hasNext();) {
				l3FQP0we = (String) FCDMPYxX.next();
				System.out.println("Signature name: " + l3FQP0we);
				System.out
						.println("Signature covers whole document: " + b8ma3GLF.signatureCoversWholeDocument(l3FQP0we));
				System.out.println(
						"Document revision: " + b8ma3GLF.getRevision(l3FQP0we) + " of " + b8ma3GLF.getTotalRevisions());
				FileOutputStream kzZBADsU = new FileOutputStream(
						"results/in_action/chapter16/revision_" + b8ma3GLF.getRevision(l3FQP0we) + ".pdf");
				byte jhCk0pmX[] = new byte[8192];
				InputStream XpgrPlZv = b8ma3GLF.extractRevision(l3FQP0we);
				int tYZKpCi6 = 0;
				while ((tYZKpCi6 = XpgrPlZv.read(jhCk0pmX)) > 0)
					kzZBADsU.write(jhCk0pmX, 0, tYZKpCi6);
				kzZBADsU.close();
				XpgrPlZv.close();
				PdfPKCS7 Yzyt438S = b8ma3GLF.verifySignature(l3FQP0we);
				Calendar IduCJYJC = Yzyt438S.getSignDate();
				Certificate ABr92HcI[] = Yzyt438S.getCertificates();
				System.out.println("Subject: " + PdfPKCS7.getSubjectFields(Yzyt438S.getSigningCertificate()));
				System.out.println("Document modified: " + !Yzyt438S.verify());
				Object aIhptq6n[] = PdfPKCS7.verifyCertificates(ABr92HcI, TJUe47yP, null, IduCJYJC);
				if (aIhptq6n == null)
					System.out.println("Certificates verified against the KeyStore");
				else
					System.out.println("Certificate failed: " + aIhptq6n[1]);
			}
		} catch (Exception CsWHYl15) {
			CsWHYl15.printStackTrace();
		}
	}

}