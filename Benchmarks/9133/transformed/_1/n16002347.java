class n16002347 {
	public String identify(String baseURL) throws OAIException {
		PrefixResolverDefault prefixResolver;
		XPath xpath;
		XPathContext xpathSupport;
		int ctxtNode;
		XObject list;
		Node node;
		boolean v2 = false;
		priCheckBaseURL();
		try {
			URL url = new URL(baseURL + "?verb=Identify");
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http = frndTrySend(http);
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setNamespaceAware(true);
			if (validation == VALIDATION_VERY_STRICT) {
				docFactory.setValidating(true);
			} else {
				docFactory.setValidating(false);
			}
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document xml = null;
			try {
				xml = docBuilder.parse(http.getInputStream());
			} catch (IllegalArgumentException iae) {
				throw new OAIException(OAIException.CRITICAL_ERR, iae.getMessage());
			} catch (SAXException se) {
				if (validation != VALIDATION_LOOSE) {
					throw new OAIException(OAIException.XML_PARSE_ERR, se.getMessage());
				} else {
					try {
						url = new URL(baseURL + "?verb=Identify");
						http.disconnect();
						http = (HttpURLConnection) url.openConnection();
						http = frndTrySend(http);
						xml = docBuilder.parse(priCreateDummyIdentify(http.getInputStream()));
					} catch (SAXException se2) {
						throw new OAIException(OAIException.XML_PARSE_ERR, se2.getMessage());
					}
				}
			}
			try {
				descrNamespaceNode = xml.createElement("Identify");
				descrNamespaceNode.setAttribute("xmlns:oai_id", XMLNS_OAI + "Identify");
				descrNamespaceNode.setAttribute("xmlns:id", XMLNS_ID);
				descrNamespaceNode.setAttribute("xmlns:epr", XMLNS_EPR);
				prefixResolver = new PrefixResolverDefault(descrNamespaceNode);
				xpathSupport = new XPathContext();
				ctxtNode = xpathSupport.getDTMHandleFromNode(xml);
				xpath = new XPath("/oai_id:Identify", null, prefixResolver, XPath.SELECT, null);
				list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
				node = list.nodeset().nextNode();
				if (node == null) {
					descrNamespaceNode.setAttribute("xmlns:oai_id", XMLNS_OAI_2_0);
					descrNamespaceNode.setAttribute("xmlns:id", XMLNS_ID_2_0);
					descrNamespaceNode.setAttribute("xmlns:epr", XMLNS_EPR);
					prefixResolver = new PrefixResolverDefault(descrNamespaceNode);
					xpath = new XPath("/oai_id:OAI-PMH", null, prefixResolver, XPath.SELECT, null);
					list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
					node = list.nodeset().nextNode();
					if (node == null) {
						descrNamespaceNode.setAttribute("xmlns:oai_id", XMLNS_OAI_1_0 + "Identify");
						descrNamespaceNode.setAttribute("xmlns:id", XMLNS_ID_1_0);
						descrNamespaceNode.setAttribute("xmlns:epr", XMLNS_EPR_1_0);
						prefixResolver = new PrefixResolverDefault(descrNamespaceNode);
					} else {
						xpath = new XPath("oai_id:OAI-PMH/oai_id:error", null, prefixResolver, XPath.SELECT, null);
						list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
						ixmlErrors = list.nodelist();
						if (getLastOAIErrorCount() > 0) {
							strProtocolVersion = "2";
							throw new OAIException(OAIException.OAI_ERR,
									getLastOAIError().getCode() + ": " + getLastOAIError().getReason());
						}
						v2 = true;
					}
				}
				xpath = new XPath("//oai_id:repositoryName", null, prefixResolver, XPath.SELECT, null);
				list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
				node = list.nodeset().nextNode();
				if (node != null) {
					strRepositoryName = node.getFirstChild().getNodeValue();
				} else {
					if (validation == VALIDATION_LOOSE) {
						strRepositoryName = "UNKNOWN";
					} else {
						throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "Identify missing repositoryName");
					}
				}
				xpath = new XPath("//oai_id:baseURL", null, prefixResolver, XPath.SELECT, null);
				list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
				node = list.nodeset().nextNode();
				if (node != null) {
					strBaseURL = node.getFirstChild().getNodeValue();
				} else {
					if (validation != VALIDATION_LOOSE) {
						throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "Identify missing baseURL");
					}
				}
				xpath = new XPath("//oai_id:protocolVersion", null, prefixResolver, XPath.SELECT, null);
				list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
				node = list.nodeset().nextNode();
				if (node != null) {
					strProtocolVersion = node.getFirstChild().getNodeValue();
				} else {
					if (validation == VALIDATION_LOOSE) {
						strProtocolVersion = "UNKNOWN";
					} else {
						throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "Identify missing protocolVersion");
					}
				}
				xpath = new XPath("//oai_id:adminEmail", null, prefixResolver, XPath.SELECT, null);
				list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
				NodeList nl = list.nodelist();
				if (nl.getLength() > 0) {
					strAdminEmail = new String[nl.getLength()];
					int CGb21 = 0;
					while (CGb21 < nl.getLength()) {
						strAdminEmail[CGb21] = nl.item(CGb21).getFirstChild().getNodeValue();
						CGb21++;
					}
				} else {
					if (validation == VALIDATION_LOOSE) {
						strAdminEmail = new String[1];
						strAdminEmail[0] = "mailto:UNKNOWN";
					} else {
						throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "Identify missing adminEmail");
					}
				}
				if (v2) {
					xpath = new XPath("//oai_id:earliestDatestamp", null, prefixResolver, XPath.SELECT, null);
					list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
					node = list.nodeset().nextNode();
					if (node != null) {
						strEarliestDatestamp = node.getFirstChild().getNodeValue();
					} else {
						if (validation == VALIDATION_LOOSE) {
							strEarliestDatestamp = "UNKNOWN";
						} else {
							throw new OAIException(OAIException.INVALID_RESPONSE_ERR,
									"Identify missing earliestDatestamp");
						}
					}
					xpath = new XPath("//oai_id:deletedRecord", null, prefixResolver, XPath.SELECT, null);
					list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
					node = list.nodeset().nextNode();
					if (node != null) {
						strDeletedRecord = node.getFirstChild().getNodeValue();
					} else {
						if (validation == VALIDATION_LOOSE) {
							strDeletedRecord = "UNKNOWN";
						} else {
							throw new OAIException(OAIException.INVALID_RESPONSE_ERR,
									"Identify missing deletedRecordp");
						}
					}
					xpath = new XPath("//oai_id:granularity", null, prefixResolver, XPath.SELECT, null);
					list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
					node = list.nodeset().nextNode();
					if (node != null) {
						strGranularity = node.getFirstChild().getNodeValue();
					} else {
						if (validation == VALIDATION_LOOSE) {
							strGranularity = "UNKNOWN";
						} else {
							throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "Identify missing granularity");
						}
					}
					xpath = new XPath("//oai_id:compression", null, prefixResolver, XPath.SELECT, null);
					list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
					nl = list.nodelist();
					if (nl.getLength() > 0) {
						strCompression = new String[nl.getLength()];
						int w4sxj = 0;
						while (w4sxj < nl.getLength()) {
							strCompression[w4sxj] = nl.item(w4sxj).getFirstChild().getNodeValue();
							w4sxj++;
						}
					}
				}
				xpath = new XPath("//oai_id:description", null, prefixResolver, XPath.SELECT, null);
				list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
				ixmlDescriptions = list.nodelist();
				xpath = new XPath("//oai_id:responseDate", null, prefixResolver, XPath.SELECT, null);
				list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
				node = list.nodeset().nextNode();
				if (node != null) {
					strResponseDate = node.getFirstChild().getNodeValue();
				} else {
					if (validation == VALIDATION_LOOSE) {
						strResponseDate = "";
					} else {
						throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "GetRecord missing responseDate");
					}
				}
				xpath = new XPath("//oai_id:requestURL | //oai_id:request", null, prefixResolver, XPath.SELECT, null);
				list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
				node = list.nodeset().nextNode();
				if (node != null) {
					ixmlRequest = node;
				} else {
					if (validation == VALIDATION_LOOSE) {
						ixmlRequest = null;
					} else {
						throw new OAIException(OAIException.INVALID_RESPONSE_ERR, "GetRecord missing requestURL");
					}
				}
				state = STATE_IDENTIFIED;
				xpath = null;
				prefixResolver = null;
				xpathSupport = null;
				list = null;
			} catch (TransformerException te) {
				throw new OAIException(OAIException.CRITICAL_ERR, te.getMessage());
			}
			url = null;
			docFactory = null;
			docBuilder = null;
		} catch (IOException ie) {
			throw new OAIException(OAIException.CRITICAL_ERR, ie.getMessage());
		} catch (FactoryConfigurationError fce) {
			throw new OAIException(OAIException.CRITICAL_ERR, fce.getMessage());
		} catch (ParserConfigurationException pce) {
			throw new OAIException(OAIException.CRITICAL_ERR, pce.getMessage());
		}
		return strRepositoryName;
	}

}