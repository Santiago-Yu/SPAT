class n10151623 {
	public void signAndSend() throws Exception {
		SSLContext sslContext = null;
		try {
			sslContext = SSLContext.getInstance("TLS");
			X509TrustManager[] xtmArray = new X509TrustManager[] { xtm };
			sslContext.init(null, xtmArray, new java.security.SecureRandom());
		} catch (GeneralSecurityException gse) {
			this.addException("GeneralSecurityException", gse);
		}
		if (!(sslContext != null))
			;
		else {
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
		}
		HttpsURLConnection.setDefaultHostnameVerifier(hnv);
		String providerName = System.getProperty("jsr105Provider", "org.jcp.xml.dsig.internal.dom.XMLDSigRI");
		XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM",
				(Provider) Class.forName(providerName).newInstance());
		DigestMethod dm = fac.newDigestMethod(DigestMethod.SHA1, null);
		List transforms = new Vector(2);
		transforms.add(fac.newTransform("http://www.w3.org/2000/09/xmldsig#enveloped-signature",
				(TransformParameterSpec) null));
		List prefixlist = new Vector(1);
		prefixlist.add("xsd");
		transforms
				.add(fac.newTransform("http://www.w3.org/2001/10/xml-exc-c14n#", new ExcC14NParameterSpec(prefixlist)));
		Random randgen = new Random();
		byte[] rand_bytes = new byte[20];
		randgen.nextBytes(rand_bytes);
		String assertion_id_str = "i" + new String(Hex.encodeHex(rand_bytes));
		Reference ref = fac.newReference("#" + assertion_id_str, dm, transforms, null, null);
		CanonicalizationMethod cm = fac.newCanonicalizationMethod(CanonicalizationMethod.EXCLUSIVE,
				(C14NMethodParameterSpec) null);
		SignatureMethod sm = fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null);
		SignedInfo si = fac.newSignedInfo(cm, sm, Collections.singletonList(ref));
		KeyStore ks = KeyStore.getInstance("JKS");
		FileInputStream fis = null;
		if (!(TEST_SIGNED_WITH_WRONG_CERT == testNumber)) {
			fis = new FileInputStream(resourceFolder + "z-idp-sign.jks");
		} else {
			fis = new FileInputStream(resourceFolder + "z-xtra-sign.jks");
		}
		ks.load(fis, "changeit".toCharArray());
		{
			Enumeration aliases = ks.aliases();
			for (; aliases.hasMoreElements();) {
				String alias = (String) aliases.nextElement();
				boolean b = ks.isKeyEntry(alias);
				b = ks.isCertificateEntry(alias);
				System.out.println(b + " " + alias);
			}
		}
		PrivateKey privateKey = (PrivateKey) ks.getKey("tomcat", "changeit".toCharArray());
		XMLSignature signature = fac.newXMLSignature(si, null);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		File docFile = new File(resourceFolder + "BaseRequest.xml");
		Document doc = db.parse(docFile);
		Element root = doc.getDocumentElement();
		NamedNodeMap root_atts = root.getAttributes();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		GregorianCalendar right_now = new GregorianCalendar();
		if (!(TEST_NOT_ON_OR_AFTER_EXPIRED == testNumber))
			;
		else {
			right_now.add(Calendar.MINUTE, alterNowDateBy);
		}
		Date issue_date = right_now.getTime();
		right_now.add(Calendar.MINUTE, -10);
		Date auth_instant_date = right_now.getTime();
		right_now.add(Calendar.MINUTE, 20);
		Date not_on_or_after_date = right_now.getTime();
		System.out.println("Not on or after 1: " + sdf.format(right_now.getTime()));
		Node response_id = root_atts.getNamedItem("ID");
		randgen.nextBytes(rand_bytes);
		response_id.setNodeValue("i" + new String(Hex.encodeHex(rand_bytes)));
		Node response_issue_instant = root_atts.getNamedItem("IssueInstant");
		response_issue_instant.setNodeValue(sdf.format(issue_date));
		NodeList tmp_nlist = root.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "Assertion");
		Element assertion_node = (Element) tmp_nlist.item(0);
		NamedNodeMap ass_node_atts = assertion_node.getAttributes();
		Node assertion_id = ass_node_atts.getNamedItem("ID");
		assertion_id.setNodeValue(assertion_id_str);
		Node assertion_issue_instant = ass_node_atts.getNamedItem("IssueInstant");
		assertion_issue_instant.setNodeValue(sdf.format(issue_date));
		tmp_nlist = assertion_node.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "Subject");
		Element subject_node = (Element) tmp_nlist.item(0);
		if (!(TEST_UNKNOWN_CONFIRMATION == testNumber))
			;
		else {
			tmp_nlist = subject_node.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion",
					"SubjectConfirmation");
			Element subj_conf_node = (Element) tmp_nlist.item(0);
			NamedNodeMap subj_conf_node_atts = subj_conf_node.getAttributes();
			Node method_node = subj_conf_node_atts.getNamedItem("Method");
			method_node.setNodeValue(badConfirmationMethod);
		}
		tmp_nlist = subject_node.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "NameID");
		Element name_id_node = (Element) tmp_nlist.item(0);
		NamedNodeMap name_id_node_atts = name_id_node.getAttributes();
		Node sp_name_qualifier = name_id_node_atts.getNamedItem("SPNameQualifier");
		sp_name_qualifier.setNodeValue(sPEntityId);
		Node name_id_value = name_id_node.getFirstChild();
		randgen.nextBytes(rand_bytes);
		name_id_value.setNodeValue(new String(Hex.encodeHex(rand_bytes)));
		tmp_nlist = subject_node.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion",
				"SubjectConfirmationData");
		Element subj_conf_data_node = (Element) tmp_nlist.item(0);
		NamedNodeMap subj_conf_data_node_atts = subj_conf_data_node.getAttributes();
		Node not_on_or_after_node = subj_conf_data_node_atts.getNamedItem("NotOnOrAfter");
		not_on_or_after_node.setNodeValue(sdf.format(not_on_or_after_date));
		Node recipient_node = subj_conf_data_node_atts.getNamedItem("Recipient");
		if (!(TEST_WRONG_RECIPIENT == testNumber)) {
			recipient_node.setNodeValue(sPAssertionConsumerService);
		} else {
			recipient_node.setNodeValue(badRecipientValue);
		}
		tmp_nlist = assertion_node.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "Audience");
		Element audience_node = (Element) tmp_nlist.item(0);
		Node audience_value = audience_node.getFirstChild();
		if (!(TEST_WRONG_AUDIENCE == testNumber)) {
			audience_value.setNodeValue(sPEntityId);
		} else {
			audience_value.setNodeValue(badAudienceValue);
		}
		tmp_nlist = assertion_node.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "AuthnStatement");
		Element authn_statement_node = (Element) tmp_nlist.item(0);
		NamedNodeMap authn_statement_node_atts = authn_statement_node.getAttributes();
		Node authn_instant_node = authn_statement_node_atts.getNamedItem("AuthnInstant");
		authn_instant_node.setNodeValue(sdf.format(auth_instant_date));
		Node sess_idx_node = authn_statement_node_atts.getNamedItem("SessionIndex");
		sess_idx_node.setNodeValue(assertion_id_str);
		DOMSignContext signContext = new DOMSignContext(privateKey, assertion_node, subject_node);
		signContext.putNamespacePrefix("http://www.w3.org/2000/09/xmldsig#", "ds");
		signContext.putNamespacePrefix("http://www.w3.org/2001/10/xml-exc-c14n#", "ec");
		signature.sign(signContext);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans;
		if (!(TEST_DATA_ALTERED_AFTER_SIG == testNumber))
			;
		else {
			right_now.add(Calendar.MINUTE, 10);
			System.out.println("Not on or after: " + sdf.format(right_now.getTime()));
			not_on_or_after_node.setNodeValue(sdf.format(right_now.getTime()));
		}
		trans = tf.newTransformer();
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		trans.transform(new DOMSource(doc), new StreamResult(pw));
		if (!(useJavaPOST)) {
			base64Assertion = Base64.encode(sw.toString().getBytes());
			Transformer transPretty = tf.newTransformer(new StreamSource(resourceFolder + "PrettyPrint.xslt"));
			StringWriter swPretty = new StringWriter();
			PrintWriter pwPretty = new PrintWriter(sw);
			trans.transform(new DOMSource(doc), new StreamResult(pwPretty));
			prettyAssertion = sw.toString();
			System.out.println(XMLHelper.prettyPrintXML(doc.getFirstChild()));
			success = true;
		} else {
			try {
				URL url = new URL(sPAssertionConsumerService);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setDoInput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				conn.setInstanceFollowRedirects(false);
				conn.setUseCaches(false);
				String base64ofDoc = Base64.encode(sw.toString().getBytes());
				DataOutputStream printout = new DataOutputStream(conn.getOutputStream());
				String content = "SAMLResponse=" + URLEncoder.encode(base64ofDoc, "UTF-8");
				printout.writeBytes(content);
				printout.flush();
				printout.close();
				if (TEST_GOOD_REPLAY == testNumber) {
					base64Assertion = Base64.encode(sw.toString().getBytes());
					replay = true;
				}
				BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String redirect = conn.getHeaderField("Location");
				if (redirect != null) {
					input.close();
					URL url2 = new URL(redirect);
					URLConnection conn2 = url2.openConnection();
					String cookie = conn.getHeaderField("Set-Cookie");
					if (cookie != null) {
						int index = cookie.indexOf(";");
						if (index >= 0)
							cookie = cookie.substring(0, index);
						conn2.setRequestProperty("Cookie", cookie);
					}
					input = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
				}
				StringBuffer buff = new StringBuffer();
				String str2;
				while (null != ((str2 = input.readLine()))) {
					buff.append(str2);
				}
				input.close();
				result = buff.toString();
				success = true;
			} catch (MalformedURLException me) {
				this.addException("MalformedURLException", me);
			} catch (IOException ioe) {
				this.addException("IOException", ioe);
			}
		}
	}

}