class n16002347 {
	public String identify(String VH2i1EFP) throws OAIException {
		PrefixResolverDefault topwWRG0;
		XPath R6Q34CaZ;
		XPathContext iq53EFIS;
		int rYQd0zUK;
		XObject WPx5LMid;
		Node QA8Nfjc0;
		boolean cAxqB5P5 = false;
		priCheckBaseURL();
		try {
			URL AeGSGmTo = new URL(VH2i1EFP + "?verb=Identify");
			HttpURLConnection bvaOpnh9 = (HttpURLConnection) AeGSGmTo.openConnection();
			bvaOpnh9 = frndTrySend(bvaOpnh9);
			DocumentBuilderFactory UCXLVq2k = DocumentBuilderFactory.newInstance();
			UCXLVq2k.setNamespaceAware(true);
			if (validation == VALIDATION_VERY_STRICT) {
				UCXLVq2k.setValidating(true);
			} else {
				UCXLVq2k.setValidating(false);
			}
			DocumentBuilder iwrhnTis = UCXLVq2k.newDocumentBuilder();
			Document hJBDbyoQ = null;
			try {
				hJBDbyoQ = iwrhnTis.parse(bvaOpnh9.getInputStream());
			} catch (IllegalArgumentException PVy4EuAG) {
				throw new OAIException(OAIException.CRITICAL_ERR, PVy4EuAG.getMessage());
			} catch (SAXException F7azjroo) {
				if (validation != VALIDATION_LOOSE) {
					throw new OAIException(OAIException.XML_PARSE_ERR, F7azjroo.getMessage());
				} else {
					try {
						AeGSGmTo = new URL(VH2i1EFP + "?verb=Identify");
						bvaOpnh9.disconnect();
						bvaOpnh9 = (HttpURLConnection) AeGSGmTo.openConnection();
						bvaOpnh9 = frndTrySend(bvaOpnh9);
						hJBDbyoQ = iwrhnTis.parse(priCreateDummyIdentify(bvaOpnh9.getInputStream()));
					} catch (SAXException KLU2vaJD) {
						throw new OAIException(OAIException.XML_PARSE_ERR, KLU2vaJD.getMessage());
					}
				}
			}
			try {
				descrNamespaceNode = hJBDbyoQ.createElement("Identify");
				descrNamespaceNode.setAttribute("xmlns:oai_id", XMLNS_OAI + "Identify");
				descrNamespaceNode.setAttribute("xmlns:id", XMLNS_ID);
				descrNamespaceNode.setAttribute("xmlns:epr", XMLNS_EPR);
				topwWRG0 = new PrefixResolverDefault(descrNamespaceNode);
				iq53EFIS = new XPathContext();
				rYQd0zUK = iq53EFIS.getDTMHandleFromNode(hJBDbyoQ);
				R6Q34CaZ = new XPath("/oai_id:Identify", null, topwWRG0, XPath.SELECT, null);
				WPx5LMid = R6Q34CaZ.execute(iq53EFIS, rYQd0zUK, topwWRG0);
				QA8Nfjc0 = WPx5LMid.nodeset().nextNode();
				if (QA8Nfjc0 == null) {
					descrNamespaceNode.setAttribute("xmlns:oai_id", XMLNS_OAI_2_0);
					descrNamespaceNode.setAttribute("xmlns:id", XMLNS_ID_2_0);
					descrNamespaceNode.setAttribute("xmlns:epr", XMLNS_EPR);
					topwWRG0 = new PrefixResolverDefault(descrNamespaceNode);
					R6Q34CaZ = new XPath("/oai_id:OAI-PMH", null, topwWRG0, XPath.SELECT, null);
					WPx5LMid = R6Q34CaZ.execute(iq53EFIS, rYQd0zUK, topwWRG0);
					QA8Nfjc0 = WPx5LMid.nodeset().nextNode();
					if (QA8Nfjc0 == null) {
						descrNamespaceNode.setAttribute("xmlns:oai_id", XMLNS_OAI_1_0 + "Identify");
						descrNamespaceNode.setAttribute("xmlns:id", XMLNS_ID_1_0);
						descrNamespaceNode.setAttribute("xmlns:epr", XMLNS_EPR_1_0);
						topwWRG0 = new PrefixResolverDefault(descrNamespaceNode);
					} else {
						R6Q34CaZ = new XPath("oai_id:OAI-PMH/oai_id:error", null, topwWRG0, XPath.SELECT, null);
						WPx5LMid = R6Q34CaZ.execute(iq53EFIS, rYQd0zUK, topwWRG0);
						ixmlErrors = WPx5LMid.nodelist();
						if (getLastOAIErrorCount() > 0) {
							strProtocolVersion = "2";
							throw new OAIException(OAIException.OAI_ERR,
									getLastOAIError().getCode() + ": " + getLastOAIError().getReason());
						}
						cAxqB5P5 = true;
					}
				}
				R6Q34CaZ = new XPath("//oai_id:repositoryName", null, topwWRG0, XPath.SELECT, null);
				WPx5LMid = R6Q34CaZ.execute(iq53EFIS, rYQd0zUK, topwWRG0);
				QA8Nfjc0 = WPx5LMid.nodeset().nextNode();
				if (QA8Nfjc0 != null) {
					strRepositoryName = QA8Nfjc0.getFirstChild().getNodeValue();
				} else {
					if (validation == VALIDATION_LOOSE) {
						strRepositoryName = "UNKNOWN";
					} else {
						throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "Identify missing repositoryName");
					}
				}
				R6Q34CaZ = new XPath("//oai_id:baseURL", null, topwWRG0, XPath.SELECT, null);
				WPx5LMid = R6Q34CaZ.execute(iq53EFIS, rYQd0zUK, topwWRG0);
				QA8Nfjc0 = WPx5LMid.nodeset().nextNode();
				if (QA8Nfjc0 != null) {
					strBaseURL = QA8Nfjc0.getFirstChild().getNodeValue();
				} else {
					if (validation != VALIDATION_LOOSE) {
						throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "Identify missing baseURL");
					}
				}
				R6Q34CaZ = new XPath("//oai_id:protocolVersion", null, topwWRG0, XPath.SELECT, null);
				WPx5LMid = R6Q34CaZ.execute(iq53EFIS, rYQd0zUK, topwWRG0);
				QA8Nfjc0 = WPx5LMid.nodeset().nextNode();
				if (QA8Nfjc0 != null) {
					strProtocolVersion = QA8Nfjc0.getFirstChild().getNodeValue();
				} else {
					if (validation == VALIDATION_LOOSE) {
						strProtocolVersion = "UNKNOWN";
					} else {
						throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "Identify missing protocolVersion");
					}
				}
				R6Q34CaZ = new XPath("//oai_id:adminEmail", null, topwWRG0, XPath.SELECT, null);
				WPx5LMid = R6Q34CaZ.execute(iq53EFIS, rYQd0zUK, topwWRG0);
				NodeList QAl1Mq8y = WPx5LMid.nodelist();
				if (QAl1Mq8y.getLength() > 0) {
					strAdminEmail = new String[QAl1Mq8y.getLength()];
					for (int vHf7LDSi = 0; vHf7LDSi < QAl1Mq8y.getLength(); vHf7LDSi++) {
						strAdminEmail[vHf7LDSi] = QAl1Mq8y.item(vHf7LDSi).getFirstChild().getNodeValue();
					}
				} else {
					if (validation == VALIDATION_LOOSE) {
						strAdminEmail = new String[1];
						strAdminEmail[0] = "mailto:UNKNOWN";
					} else {
						throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "Identify missing adminEmail");
					}
				}
				if (cAxqB5P5) {
					R6Q34CaZ = new XPath("//oai_id:earliestDatestamp", null, topwWRG0, XPath.SELECT, null);
					WPx5LMid = R6Q34CaZ.execute(iq53EFIS, rYQd0zUK, topwWRG0);
					QA8Nfjc0 = WPx5LMid.nodeset().nextNode();
					if (QA8Nfjc0 != null) {
						strEarliestDatestamp = QA8Nfjc0.getFirstChild().getNodeValue();
					} else {
						if (validation == VALIDATION_LOOSE) {
							strEarliestDatestamp = "UNKNOWN";
						} else {
							throw new OAIException(OAIException.INVALID_RESPONSE_ERR,
									"Identify missing earliestDatestamp");
						}
					}
					R6Q34CaZ = new XPath("//oai_id:deletedRecord", null, topwWRG0, XPath.SELECT, null);
					WPx5LMid = R6Q34CaZ.execute(iq53EFIS, rYQd0zUK, topwWRG0);
					QA8Nfjc0 = WPx5LMid.nodeset().nextNode();
					if (QA8Nfjc0 != null) {
						strDeletedRecord = QA8Nfjc0.getFirstChild().getNodeValue();
					} else {
						if (validation == VALIDATION_LOOSE) {
							strDeletedRecord = "UNKNOWN";
						} else {
							throw new OAIException(OAIException.INVALID_RESPONSE_ERR,
									"Identify missing deletedRecordp");
						}
					}
					R6Q34CaZ = new XPath("//oai_id:granularity", null, topwWRG0, XPath.SELECT, null);
					WPx5LMid = R6Q34CaZ.execute(iq53EFIS, rYQd0zUK, topwWRG0);
					QA8Nfjc0 = WPx5LMid.nodeset().nextNode();
					if (QA8Nfjc0 != null) {
						strGranularity = QA8Nfjc0.getFirstChild().getNodeValue();
					} else {
						if (validation == VALIDATION_LOOSE) {
							strGranularity = "UNKNOWN";
						} else {
							throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "Identify missing granularity");
						}
					}
					R6Q34CaZ = new XPath("//oai_id:compression", null, topwWRG0, XPath.SELECT, null);
					WPx5LMid = R6Q34CaZ.execute(iq53EFIS, rYQd0zUK, topwWRG0);
					QAl1Mq8y = WPx5LMid.nodelist();
					if (QAl1Mq8y.getLength() > 0) {
						strCompression = new String[QAl1Mq8y.getLength()];
						for (int Rbeap0eY = 0; Rbeap0eY < QAl1Mq8y.getLength(); Rbeap0eY++) {
							strCompression[Rbeap0eY] = QAl1Mq8y.item(Rbeap0eY).getFirstChild().getNodeValue();
						}
					}
				}
				R6Q34CaZ = new XPath("//oai_id:description", null, topwWRG0, XPath.SELECT, null);
				WPx5LMid = R6Q34CaZ.execute(iq53EFIS, rYQd0zUK, topwWRG0);
				ixmlDescriptions = WPx5LMid.nodelist();
				R6Q34CaZ = new XPath("//oai_id:responseDate", null, topwWRG0, XPath.SELECT, null);
				WPx5LMid = R6Q34CaZ.execute(iq53EFIS, rYQd0zUK, topwWRG0);
				QA8Nfjc0 = WPx5LMid.nodeset().nextNode();
				if (QA8Nfjc0 != null) {
					strResponseDate = QA8Nfjc0.getFirstChild().getNodeValue();
				} else {
					if (validation == VALIDATION_LOOSE) {
						strResponseDate = "";
					} else {
						throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "GetRecord missing responseDate");
					}
				}
				R6Q34CaZ = new XPath("//oai_id:requestURL | //oai_id:request", null, topwWRG0, XPath.SELECT, null);
				WPx5LMid = R6Q34CaZ.execute(iq53EFIS, rYQd0zUK, topwWRG0);
				QA8Nfjc0 = WPx5LMid.nodeset().nextNode();
				if (QA8Nfjc0 != null) {
					ixmlRequest = QA8Nfjc0;
				} else {
					if (validation == VALIDATION_LOOSE) {
						ixmlRequest = null;
					} else {
						throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "GetRecord missing requestURL");
					}
				}
				state = STATE_IDENTIFIED;
				R6Q34CaZ = null;
				topwWRG0 = null;
				iq53EFIS = null;
				WPx5LMid = null;
			} catch (TransformerException ae1vAmmk) {
				throw new OAIException(OAIException.CRITICAL_ERR, ae1vAmmk.getMessage());
			}
			AeGSGmTo = null;
			UCXLVq2k = null;
			iwrhnTis = null;
		} catch (IOException a9VqIhfR) {
			throw new OAIException(OAIException.CRITICAL_ERR, a9VqIhfR.getMessage());
		} catch (FactoryConfigurationError qoZNYUoP) {
			throw new OAIException(OAIException.CRITICAL_ERR, qoZNYUoP.getMessage());
		} catch (ParserConfigurationException SwOIw2fy) {
			throw new OAIException(OAIException.CRITICAL_ERR, SwOIw2fy.getMessage());
		}
		return strRepositoryName;
	}

}