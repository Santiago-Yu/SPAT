class n16002345 {
	public OAIRecord getRecord(String SdyuJ3pK, String CnstgdRj) throws OAIException {
		PrefixResolverDefault pThmoTXR;
		XPath hfRlcAdE;
		XPathContext Xh9pOPwX;
		int eV0sM1Yx;
		XObject z9Caus4y;
		Node LQVsTRBJ;
		OAIRecord tJjIKyPZ = new OAIRecord();
		priCheckBaseURL();
		String kYaQSBoW = priBuildParamString("", "", "", SdyuJ3pK, CnstgdRj);
		try {
			URL UoNvUvua = new URL(strBaseURL + "?verb=GetRecord" + kYaQSBoW);
			HttpURLConnection zyJHLB6T = (HttpURLConnection) UoNvUvua.openConnection();
			zyJHLB6T = frndTrySend(zyJHLB6T);
			DocumentBuilderFactory DGoLwQ2q = DocumentBuilderFactory.newInstance();
			DGoLwQ2q.setNamespaceAware(true);
			if (validation == VALIDATION_VERY_STRICT) {
				DGoLwQ2q.setValidating(true);
			} else {
				DGoLwQ2q.setValidating(false);
			}
			DocumentBuilder B6AvA8xW = DGoLwQ2q.newDocumentBuilder();
			Document ks4Iuaws = null;
			try {
				ks4Iuaws = B6AvA8xW.parse(zyJHLB6T.getInputStream());
				tJjIKyPZ.frndSetValid(true);
			} catch (IllegalArgumentException thvaipMB) {
				throw new OAIException(OAIException.CRITICAL_ERR, thvaipMB.getMessage());
			} catch (SAXException OhdeLYtt) {
				if (validation != VALIDATION_LOOSE) {
					throw new OAIException(OAIException.XML_PARSE_ERR, OhdeLYtt.getMessage());
				} else {
					try {
						UoNvUvua = new URL(strBaseURL + "?verb=GetRecord" + kYaQSBoW);
						zyJHLB6T.disconnect();
						zyJHLB6T = (HttpURLConnection) UoNvUvua.openConnection();
						zyJHLB6T = frndTrySend(zyJHLB6T);
						ks4Iuaws = B6AvA8xW.parse(priCreateDummyGetRecord(SdyuJ3pK, zyJHLB6T.getInputStream()));
						tJjIKyPZ.frndSetValid(false);
					} catch (SAXException UB66PyWK) {
						throw new OAIException(OAIException.XML_PARSE_ERR, UB66PyWK.getMessage());
					}
				}
			}
			try {
				namespaceNode = ks4Iuaws.createElement("GetRecord");
				namespaceNode.setAttribute("xmlns:oai", XMLNS_OAI + "GetRecord");
				namespaceNode.setAttribute("xmlns:dc", XMLNS_DC);
				pThmoTXR = new PrefixResolverDefault(namespaceNode);
				hfRlcAdE = new XPath("/oai:GetRecord/oai:record", null, pThmoTXR, XPath.SELECT, null);
				Xh9pOPwX = new XPathContext();
				eV0sM1Yx = Xh9pOPwX.getDTMHandleFromNode(ks4Iuaws);
				z9Caus4y = hfRlcAdE.execute(Xh9pOPwX, eV0sM1Yx, pThmoTXR);
				LQVsTRBJ = z9Caus4y.nodeset().nextNode();
				if (LQVsTRBJ == null) {
					namespaceNode.setAttribute("xmlns:oai", XMLNS_OAI_2_0);
					pThmoTXR = new PrefixResolverDefault(namespaceNode);
					hfRlcAdE = new XPath("/oai:OAI-PMH/oai:GetRecord/oai:record", null, pThmoTXR, XPath.SELECT, null);
					z9Caus4y = hfRlcAdE.execute(Xh9pOPwX, eV0sM1Yx, pThmoTXR);
					LQVsTRBJ = z9Caus4y.nodeset().nextNode();
					if (LQVsTRBJ == null) {
						namespaceNode.setAttribute("xmlns:oai", XMLNS_OAI_1_0 + "GetRecord");
						pThmoTXR = new PrefixResolverDefault(namespaceNode);
						hfRlcAdE = new XPath("/oai:GetRecord/oai:record", null, pThmoTXR, XPath.SELECT, null);
						z9Caus4y = hfRlcAdE.execute(Xh9pOPwX, eV0sM1Yx, pThmoTXR);
						LQVsTRBJ = z9Caus4y.nodeset().nextNode();
					} else {
						hfRlcAdE = new XPath("oai:OAI-PMH/oai:error", null, pThmoTXR, XPath.SELECT, null);
						z9Caus4y = hfRlcAdE.execute(Xh9pOPwX, eV0sM1Yx, pThmoTXR);
						ixmlErrors = z9Caus4y.nodelist();
						if (ixmlErrors.getLength() > 0) {
							strProtocolVersion = "2";
							throw new OAIException(OAIException.OAI_ERR,
									getLastOAIError().getCode() + ": " + getLastOAIError().getReason());
						}
					}
				}
				if (LQVsTRBJ != null) {
					tJjIKyPZ.frndSetRepository(this);
					tJjIKyPZ.frndSetMetadataPrefix(CnstgdRj);
					tJjIKyPZ.frndSetIdOnly(false);
					eV0sM1Yx = Xh9pOPwX.getDTMHandleFromNode(LQVsTRBJ);
					hfRlcAdE = new XPath("//oai:header/oai:identifier", null, pThmoTXR, XPath.SELECT, null);
					z9Caus4y = hfRlcAdE.execute(Xh9pOPwX, eV0sM1Yx, pThmoTXR);
					tJjIKyPZ.frndSetIdentifier(z9Caus4y.nodeset().nextNode().getFirstChild().getNodeValue());
					hfRlcAdE = new XPath("//oai:header/oai:datestamp", null, pThmoTXR, XPath.SELECT, null);
					z9Caus4y = hfRlcAdE.execute(Xh9pOPwX, eV0sM1Yx, pThmoTXR);
					tJjIKyPZ.frndSetDatestamp(z9Caus4y.nodeset().nextNode().getFirstChild().getNodeValue());
					tJjIKyPZ.frndSetRecord(LQVsTRBJ);
					NamedNodeMap S4ZSqE98 = LQVsTRBJ.getAttributes();
					if (S4ZSqE98 != null) {
						if (S4ZSqE98.getNamedItem("status") != null) {
							tJjIKyPZ.frndSetStatus(S4ZSqE98.getNamedItem("status").getFirstChild().getNodeValue());
						}
					}
				} else {
					tJjIKyPZ = null;
				}
				hfRlcAdE = new XPath("//oai:responseDate", null, pThmoTXR, XPath.SELECT, null);
				z9Caus4y = hfRlcAdE.execute(Xh9pOPwX, eV0sM1Yx, pThmoTXR);
				LQVsTRBJ = z9Caus4y.nodeset().nextNode();
				if (LQVsTRBJ != null) {
					strResponseDate = LQVsTRBJ.getFirstChild().getNodeValue();
				} else {
					if (validation == VALIDATION_LOOSE) {
						strResponseDate = "";
					} else {
						throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "GetRecord missing responseDate");
					}
				}
				hfRlcAdE = new XPath("//oai:requestURL | //oai:request", null, pThmoTXR, XPath.SELECT, null);
				z9Caus4y = hfRlcAdE.execute(Xh9pOPwX, eV0sM1Yx, pThmoTXR);
				LQVsTRBJ = z9Caus4y.nodeset().nextNode();
				if (LQVsTRBJ != null) {
					ixmlRequest = LQVsTRBJ;
				} else {
					if (validation == VALIDATION_LOOSE) {
						ixmlRequest = null;
					} else {
						throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "GetRecord missing requestURL");
					}
				}
				hfRlcAdE = null;
				pThmoTXR = null;
				Xh9pOPwX = null;
				z9Caus4y = null;
			} catch (TransformerException AWPUdo5D) {
				throw new OAIException(OAIException.CRITICAL_ERR, AWPUdo5D.getMessage());
			}
			UoNvUvua = null;
			DGoLwQ2q = null;
			B6AvA8xW = null;
		} catch (MalformedURLException cCz5vada) {
			throw new OAIException(OAIException.CRITICAL_ERR, cCz5vada.getMessage());
		} catch (FactoryConfigurationError SftioC7D) {
			throw new OAIException(OAIException.CRITICAL_ERR, SftioC7D.getMessage());
		} catch (ParserConfigurationException kyl4AAM2) {
			throw new OAIException(OAIException.CRITICAL_ERR, kyl4AAM2.getMessage());
		} catch (IOException UfQ3h2qp) {
			throw new OAIException(OAIException.CRITICAL_ERR, UfQ3h2qp.getMessage());
		}
		return tJjIKyPZ;
	}

}