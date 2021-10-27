class n1618640 {
	private void initialize(OAIRepository qw8uaJET, String pXLem6E9, String JA4dsb7T, String GCvVkdIc)
			throws OAIException {
		oParent = qw8uaJET;
		strVerb = JA4dsb7T;
		strBaseURL = pXLem6E9;
		strParams = GCvVkdIc;
		strResumptionToken = "";
		iResumptionCount = 0;
		boolInitialized = false;
		boolValidResponse = false;
		iIndex = 1;
		iCount = -1;
		iCursor = -1;
		iRealCursor = -1;
		iCompleteListSize = -1;
		if (!strVerb.equals("ListIdentifiers") && !strVerb.equals("ListMetadataFormats")
				&& !strVerb.equals("ListRecords") && !strVerb.equals("ListSets")) {
			throw new OAIException(OAIException.INVALID_VERB_ERR, "Invalid verb");
		}
		if (strBaseURL.length() == 0) {
			throw new OAIException(OAIException.NO_BASE_URL_ERR, "No baseURL");
		}
		if (GCvVkdIc.length() > 0) {
			if (GCvVkdIc.charAt(0) != '&') {
				GCvVkdIc = "&" + GCvVkdIc;
			}
		}
		try {
			URL hYy6cvT5 = new URL(strBaseURL + "?verb=" + strVerb + GCvVkdIc);
			HttpURLConnection RYrTwkkR = (HttpURLConnection) hYy6cvT5.openConnection();
			RYrTwkkR = oParent.frndTrySend(RYrTwkkR);
			DocumentBuilderFactory DKPwiwtg = DocumentBuilderFactory.newInstance();
			DKPwiwtg.setNamespaceAware(true);
			if (oParent.getValidation() == OAIRepository.VALIDATION_VERY_STRICT) {
				DKPwiwtg.setValidating(true);
			} else {
				DKPwiwtg.setValidating(false);
			}
			DocumentBuilder q2TtUMW6 = DKPwiwtg.newDocumentBuilder();
			try {
				xml = q2TtUMW6.parse(RYrTwkkR.getInputStream());
				boolValidResponse = true;
			} catch (IllegalArgumentException NSQmp3PR) {
				throw new OAIException(OAIException.CRITICAL_ERR, NSQmp3PR.getMessage());
			} catch (SAXException To7D7dcP) {
				if (oParent.getValidation() != OAIRepository.VALIDATION_LOOSE) {
					throw new OAIException(OAIException.XML_PARSE_ERR,
							To7D7dcP.getMessage() + " Try loose validation.");
				} else {
					try {
						RYrTwkkR.disconnect();
						hYy6cvT5 = new URL(strBaseURL + "?verb=" + strVerb + GCvVkdIc);
						RYrTwkkR = (HttpURLConnection) hYy6cvT5.openConnection();
						RYrTwkkR = oParent.frndTrySend(RYrTwkkR);
						xml = q2TtUMW6.parse(priCreateDummyResponse(RYrTwkkR.getInputStream()));
					} catch (SAXException YWuMusCt) {
						throw new OAIException(OAIException.XML_PARSE_ERR, YWuMusCt.getMessage());
					}
				}
			}
			namespaceNode = xml.createElement(strVerb);
			namespaceNode.setAttribute("xmlns:oai", OAIRepository.XMLNS_OAI + strVerb);
			namespaceNode.setAttribute("xmlns:dc", OAIRepository.XMLNS_DC);
			PrefixResolverDefault hH7yTtxD = new PrefixResolverDefault(namespaceNode);
			XPath C7y3zuaL = new XPath("//oai:" + strVerb + "/oai:" + priGetMainNodeName(), null, hH7yTtxD,
					XPath.SELECT, null);
			XPathContext DjzOgALd = new XPathContext();
			int wz3e3UP3 = DjzOgALd.getDTMHandleFromNode(xml);
			XObject OoZ2FhJj = C7y3zuaL.execute(DjzOgALd, wz3e3UP3, hH7yTtxD);
			Node d9ZwFzKd = OoZ2FhJj.nodeset().nextNode();
			if (d9ZwFzKd == null) {
				namespaceNode.setAttribute("xmlns:oai", OAIRepository.XMLNS_OAI_2_0);
				hH7yTtxD = new PrefixResolverDefault(namespaceNode);
				C7y3zuaL = new XPath("/oai:OAI-PMH", null, hH7yTtxD, XPath.SELECT, null);
				OoZ2FhJj = C7y3zuaL.execute(DjzOgALd, wz3e3UP3, hH7yTtxD);
				d9ZwFzKd = OoZ2FhJj.nodeset().nextNode();
				if (d9ZwFzKd == null) {
					namespaceNode.setAttribute("xmlns:oai", OAIRepository.XMLNS_OAI_1_0 + strVerb);
				} else {
					C7y3zuaL = new XPath("oai:OAI-PMH/oai:error", null, hH7yTtxD, XPath.SELECT, null);
					OoZ2FhJj = C7y3zuaL.execute(DjzOgALd, wz3e3UP3, hH7yTtxD);
					NodeList KHUrIyKq = OoZ2FhJj.nodelist();
					if (KHUrIyKq.getLength() > 0) {
						oParent.frndSetErrors(KHUrIyKq);
						throw new OAIException(OAIException.OAI_ERR,
								oParent.getLastOAIError().getCode() + ": " + oParent.getLastOAIError().getReason());
					}
				}
			}
			C7y3zuaL = new XPath("//oai:" + strVerb + "/oai:" + priGetMainNodeName(), null, hH7yTtxD, XPath.SELECT,
					null);
			OoZ2FhJj = C7y3zuaL.execute(DjzOgALd, wz3e3UP3, hH7yTtxD);
			nodeList = OoZ2FhJj.nodelist();
			boolInitialized = true;
			oParent.frndSetNamespaceNode(namespaceNode);
			C7y3zuaL = new XPath("//oai:requestURL | //oai:request", null, hH7yTtxD, XPath.SELECT, null);
			d9ZwFzKd = C7y3zuaL.execute(DjzOgALd, wz3e3UP3, hH7yTtxD).nodeset().nextNode();
			if (d9ZwFzKd != null) {
				oParent.frndSetRequest(d9ZwFzKd);
			}
			oParent.frndSetResponseDate(getResponseDate());
			DKPwiwtg = null;
			q2TtUMW6 = null;
			hYy6cvT5 = null;
			hH7yTtxD = null;
			DjzOgALd = null;
			C7y3zuaL = null;
		} catch (TransformerException wWgSTVdS) {
			throw new OAIException(OAIException.CRITICAL_ERR, wWgSTVdS.getMessage());
		} catch (MalformedURLException dcLGHCNY) {
			throw new OAIException(OAIException.CRITICAL_ERR, dcLGHCNY.getMessage());
		} catch (FactoryConfigurationError bPuxdXAM) {
			throw new OAIException(OAIException.CRITICAL_ERR, bPuxdXAM.getMessage());
		} catch (ParserConfigurationException XynCijZq) {
			throw new OAIException(OAIException.CRITICAL_ERR, XynCijZq.getMessage());
		} catch (IOException Q57Gvep0) {
			throw new OAIException(OAIException.CRITICAL_ERR, Q57Gvep0.getMessage());
		}
	}

}