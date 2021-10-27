class n10151623 {
	public void signAndSend() throws Exception {
		SSLContext Uo7HmbAp = null;
		try {
			Uo7HmbAp = SSLContext.getInstance("TLS");
			X509TrustManager[] m6YWnhd7 = new X509TrustManager[] { xtm };
			Uo7HmbAp.init(null, m6YWnhd7, new java.security.SecureRandom());
		} catch (GeneralSecurityException cvTYnNhT) {
			this.addException("GeneralSecurityException", cvTYnNhT);
		}
		if (Uo7HmbAp != null) {
			HttpsURLConnection.setDefaultSSLSocketFactory(Uo7HmbAp.getSocketFactory());
		}
		HttpsURLConnection.setDefaultHostnameVerifier(hnv);
		String f9DJ5vYy = System.getProperty("jsr105Provider", "org.jcp.xml.dsig.internal.dom.XMLDSigRI");
		XMLSignatureFactory bHOkTiNo = XMLSignatureFactory.getInstance("DOM",
				(Provider) Class.forName(f9DJ5vYy).newInstance());
		DigestMethod IRKzvkVa = bHOkTiNo.newDigestMethod(DigestMethod.SHA1, null);
		List wPmazuEe = new Vector(2);
		wPmazuEe.add(bHOkTiNo.newTransform("http://www.w3.org/2000/09/xmldsig#enveloped-signature",
				(TransformParameterSpec) null));
		List rUuIZGpE = new Vector(1);
		rUuIZGpE.add("xsd");
		wPmazuEe.add(
				bHOkTiNo.newTransform("http://www.w3.org/2001/10/xml-exc-c14n#", new ExcC14NParameterSpec(rUuIZGpE)));
		Random emL0GPhw = new Random();
		byte[] dllFtctA = new byte[20];
		emL0GPhw.nextBytes(dllFtctA);
		String Vk0BOSly = "i" + new String(Hex.encodeHex(dllFtctA));
		Reference WM9aWQu4 = bHOkTiNo.newReference("#" + Vk0BOSly, IRKzvkVa, wPmazuEe, null, null);
		CanonicalizationMethod IboNsd0J = bHOkTiNo.newCanonicalizationMethod(CanonicalizationMethod.EXCLUSIVE,
				(C14NMethodParameterSpec) null);
		SignatureMethod rUdBS17l = bHOkTiNo.newSignatureMethod(SignatureMethod.RSA_SHA1, null);
		SignedInfo CK1hLDde = bHOkTiNo.newSignedInfo(IboNsd0J, rUdBS17l, Collections.singletonList(WM9aWQu4));
		KeyStore MuKg29kL = KeyStore.getInstance("JKS");
		FileInputStream CrajD6an = null;
		if (TEST_SIGNED_WITH_WRONG_CERT == testNumber) {
			CrajD6an = new FileInputStream(resourceFolder + "z-xtra-sign.jks");
		} else {
			CrajD6an = new FileInputStream(resourceFolder + "z-idp-sign.jks");
		}
		MuKg29kL.load(CrajD6an, "changeit".toCharArray());
		{
			Enumeration Be4n5CM8 = MuKg29kL.aliases();
			for (; Be4n5CM8.hasMoreElements();) {
				String Ip92o652 = (String) Be4n5CM8.nextElement();
				boolean iZFSHuVl = MuKg29kL.isKeyEntry(Ip92o652);
				iZFSHuVl = MuKg29kL.isCertificateEntry(Ip92o652);
				System.out.println(iZFSHuVl + " " + Ip92o652);
			}
		}
		PrivateKey FRIHaw7g = (PrivateKey) MuKg29kL.getKey("tomcat", "changeit".toCharArray());
		XMLSignature VU7czfN6 = bHOkTiNo.newXMLSignature(CK1hLDde, null);
		DocumentBuilderFactory idCmBpJF = DocumentBuilderFactory.newInstance();
		idCmBpJF.setNamespaceAware(true);
		DocumentBuilder SRQJtqM0 = idCmBpJF.newDocumentBuilder();
		File d9agZqoE = new File(resourceFolder + "BaseRequest.xml");
		Document RHEZUZqk = SRQJtqM0.parse(d9agZqoE);
		Element Q4qPtnQi = RHEZUZqk.getDocumentElement();
		NamedNodeMap A2P1JdFm = Q4qPtnQi.getAttributes();
		SimpleDateFormat XCGm3ESJ = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		XCGm3ESJ.setTimeZone(TimeZone.getTimeZone("GMT"));
		GregorianCalendar nOxassRZ = new GregorianCalendar();
		if (TEST_NOT_ON_OR_AFTER_EXPIRED == testNumber) {
			nOxassRZ.add(Calendar.MINUTE, alterNowDateBy);
		}
		Date myA76q50 = nOxassRZ.getTime();
		nOxassRZ.add(Calendar.MINUTE, -10);
		Date B5HzIvb0 = nOxassRZ.getTime();
		nOxassRZ.add(Calendar.MINUTE, 20);
		Date PBOBrsA4 = nOxassRZ.getTime();
		System.out.println("Not on or after 1: " + XCGm3ESJ.format(nOxassRZ.getTime()));
		Node KnzMJsWd = A2P1JdFm.getNamedItem("ID");
		emL0GPhw.nextBytes(dllFtctA);
		KnzMJsWd.setNodeValue("i" + new String(Hex.encodeHex(dllFtctA)));
		Node GajS6pYP = A2P1JdFm.getNamedItem("IssueInstant");
		GajS6pYP.setNodeValue(XCGm3ESJ.format(myA76q50));
		NodeList sSoJYSld = Q4qPtnQi.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "Assertion");
		Element N2iXdB5y = (Element) sSoJYSld.item(0);
		NamedNodeMap riYXF8Jw = N2iXdB5y.getAttributes();
		Node aqdUXaSB = riYXF8Jw.getNamedItem("ID");
		aqdUXaSB.setNodeValue(Vk0BOSly);
		Node RXGJn4jo = riYXF8Jw.getNamedItem("IssueInstant");
		RXGJn4jo.setNodeValue(XCGm3ESJ.format(myA76q50));
		sSoJYSld = N2iXdB5y.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "Subject");
		Element Ar0TclBJ = (Element) sSoJYSld.item(0);
		if (TEST_UNKNOWN_CONFIRMATION == testNumber) {
			sSoJYSld = Ar0TclBJ.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "SubjectConfirmation");
			Element UywIrJ4p = (Element) sSoJYSld.item(0);
			NamedNodeMap eDuawqnZ = UywIrJ4p.getAttributes();
			Node jNC5rrRu = eDuawqnZ.getNamedItem("Method");
			jNC5rrRu.setNodeValue(badConfirmationMethod);
		}
		sSoJYSld = Ar0TclBJ.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "NameID");
		Element ZAeEHL6H = (Element) sSoJYSld.item(0);
		NamedNodeMap xlIysqAM = ZAeEHL6H.getAttributes();
		Node DDnWuGzZ = xlIysqAM.getNamedItem("SPNameQualifier");
		DDnWuGzZ.setNodeValue(sPEntityId);
		Node iFXZ3hEa = ZAeEHL6H.getFirstChild();
		emL0GPhw.nextBytes(dllFtctA);
		iFXZ3hEa.setNodeValue(new String(Hex.encodeHex(dllFtctA)));
		sSoJYSld = Ar0TclBJ.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "SubjectConfirmationData");
		Element waylCoEH = (Element) sSoJYSld.item(0);
		NamedNodeMap a0bl6yo6 = waylCoEH.getAttributes();
		Node Ibr99gBc = a0bl6yo6.getNamedItem("NotOnOrAfter");
		Ibr99gBc.setNodeValue(XCGm3ESJ.format(PBOBrsA4));
		Node RUyYIRbZ = a0bl6yo6.getNamedItem("Recipient");
		if (TEST_WRONG_RECIPIENT == testNumber) {
			RUyYIRbZ.setNodeValue(badRecipientValue);
		} else {
			RUyYIRbZ.setNodeValue(sPAssertionConsumerService);
		}
		sSoJYSld = N2iXdB5y.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "Audience");
		Element ScmFyoQx = (Element) sSoJYSld.item(0);
		Node Sj2TYhmD = ScmFyoQx.getFirstChild();
		if (TEST_WRONG_AUDIENCE == testNumber) {
			Sj2TYhmD.setNodeValue(badAudienceValue);
		} else {
			Sj2TYhmD.setNodeValue(sPEntityId);
		}
		sSoJYSld = N2iXdB5y.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "AuthnStatement");
		Element vPceufEl = (Element) sSoJYSld.item(0);
		NamedNodeMap bRanhLlf = vPceufEl.getAttributes();
		Node tJFAIHya = bRanhLlf.getNamedItem("AuthnInstant");
		tJFAIHya.setNodeValue(XCGm3ESJ.format(B5HzIvb0));
		Node eOVCtqSe = bRanhLlf.getNamedItem("SessionIndex");
		eOVCtqSe.setNodeValue(Vk0BOSly);
		DOMSignContext CZrXnaG6 = new DOMSignContext(FRIHaw7g, N2iXdB5y, Ar0TclBJ);
		CZrXnaG6.putNamespacePrefix("http://www.w3.org/2000/09/xmldsig#", "ds");
		CZrXnaG6.putNamespacePrefix("http://www.w3.org/2001/10/xml-exc-c14n#", "ec");
		VU7czfN6.sign(CZrXnaG6);
		TransformerFactory WAj4CaUh = TransformerFactory.newInstance();
		Transformer otba8OQu;
		if (TEST_DATA_ALTERED_AFTER_SIG == testNumber) {
			nOxassRZ.add(Calendar.MINUTE, 10);
			System.out.println("Not on or after: " + XCGm3ESJ.format(nOxassRZ.getTime()));
			Ibr99gBc.setNodeValue(XCGm3ESJ.format(nOxassRZ.getTime()));
		}
		otba8OQu = WAj4CaUh.newTransformer();
		StringWriter KfDz26sk = new StringWriter();
		PrintWriter gAzfUSV7 = new PrintWriter(KfDz26sk);
		otba8OQu.transform(new DOMSource(RHEZUZqk), new StreamResult(gAzfUSV7));
		if (useJavaPOST) {
			try {
				URL ncvEhivH = new URL(sPAssertionConsumerService);
				HttpURLConnection mUbI4WVs = (HttpURLConnection) ncvEhivH.openConnection();
				mUbI4WVs.setDoOutput(true);
				mUbI4WVs.setDoInput(true);
				mUbI4WVs.setRequestMethod("POST");
				mUbI4WVs.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				mUbI4WVs.setInstanceFollowRedirects(false);
				mUbI4WVs.setUseCaches(false);
				String pAA0DxQf = Base64.encode(KfDz26sk.toString().getBytes());
				DataOutputStream aAyg9d8f = new DataOutputStream(mUbI4WVs.getOutputStream());
				String nA4Ool8O = "SAMLResponse=" + URLEncoder.encode(pAA0DxQf, "UTF-8");
				aAyg9d8f.writeBytes(nA4Ool8O);
				aAyg9d8f.flush();
				aAyg9d8f.close();
				if (TEST_GOOD_REPLAY == testNumber) {
					base64Assertion = Base64.encode(KfDz26sk.toString().getBytes());
					replay = true;
				}
				BufferedReader Zqm9l5qh = new BufferedReader(new InputStreamReader(mUbI4WVs.getInputStream()));
				String DLLeroWm = mUbI4WVs.getHeaderField("Location");
				if (DLLeroWm != null) {
					Zqm9l5qh.close();
					URL nqhr4Nmv = new URL(DLLeroWm);
					URLConnection Rm7HWolr = nqhr4Nmv.openConnection();
					String cYPVbxUz = mUbI4WVs.getHeaderField("Set-Cookie");
					if (cYPVbxUz != null) {
						int hXLGAfgU = cYPVbxUz.indexOf(";");
						if (hXLGAfgU >= 0)
							cYPVbxUz = cYPVbxUz.substring(0, hXLGAfgU);
						Rm7HWolr.setRequestProperty("Cookie", cYPVbxUz);
					}
					Zqm9l5qh = new BufferedReader(new InputStreamReader(Rm7HWolr.getInputStream()));
				}
				StringBuffer VV2AdJXa = new StringBuffer();
				String fWi8mNod;
				while (null != ((fWi8mNod = Zqm9l5qh.readLine()))) {
					VV2AdJXa.append(fWi8mNod);
				}
				Zqm9l5qh.close();
				result = VV2AdJXa.toString();
				success = true;
			} catch (MalformedURLException sWrQLJwc) {
				this.addException("MalformedURLException", sWrQLJwc);
			} catch (IOException wjsZWd6V) {
				this.addException("IOException", wjsZWd6V);
			}
		} else {
			base64Assertion = Base64.encode(KfDz26sk.toString().getBytes());
			Transformer bhISCKbW = WAj4CaUh.newTransformer(new StreamSource(resourceFolder + "PrettyPrint.xslt"));
			StringWriter MNtDqZFi = new StringWriter();
			PrintWriter y0wk9KXP = new PrintWriter(KfDz26sk);
			otba8OQu.transform(new DOMSource(RHEZUZqk), new StreamResult(y0wk9KXP));
			prettyAssertion = KfDz26sk.toString();
			System.out.println(XMLHelper.prettyPrintXML(RHEZUZqk.getFirstChild()));
			success = true;
		}
	}

}