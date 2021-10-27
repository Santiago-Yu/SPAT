class n16002345 {
	public OAIRecord getRecord(String identifier, String metadataPrefix) throws OAIException {
		XPath xpath;
		PrefixResolverDefault prefixResolver;
		int ctxtNode;
		XPathContext xpathSupport;
		Node node;
		XObject list;
		OAIRecord rec = new OAIRecord();
		priCheckBaseURL();
		String params = priBuildParamString("", "", "", identifier, metadataPrefix);
		try {
			URL url = new URL(strBaseURL + "?verb=GetRecord" + params);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http = frndTrySend(http);
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setNamespaceAware(true);
			if (validation == VALIDATION_VERY_STRICT) {
				docFactory.setValidating(true);
			} else {
				docFactory.setValidating(false);
			}
			Document xml = null;
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			try {
				xml = docBuilder.parse(http.getInputStream());
				rec.frndSetValid(true);
			} catch (IllegalArgumentException iae) {
				throw new OAIException(OAIException.CRITICAL_ERR, iae.getMessage());
			} catch (SAXException se) {
				if (validation != VALIDATION_LOOSE) {
					throw new OAIException(OAIException.XML_PARSE_ERR, se.getMessage());
				} else {
					try {
						url = new URL(strBaseURL + "?verb=GetRecord" + params);
						http.disconnect();
						http = (HttpURLConnection) url.openConnection();
						http = frndTrySend(http);
						xml = docBuilder.parse(priCreateDummyGetRecord(identifier, http.getInputStream()));
						rec.frndSetValid(false);
					} catch (SAXException se2) {
						throw new OAIException(OAIException.XML_PARSE_ERR, se2.getMessage());
					}
				}
			}
			url = null;
			try {
				namespaceNode = xml.createElement("GetRecord");
				namespaceNode.setAttribute("xmlns:oai", XMLNS_OAI + "GetRecord");
				namespaceNode.setAttribute("xmlns:dc", XMLNS_DC);
				prefixResolver = new PrefixResolverDefault(namespaceNode);
				xpath = new XPath("/oai:GetRecord/oai:record", null, prefixResolver, XPath.SELECT, null);
				xpathSupport = new XPathContext();
				ctxtNode = xpathSupport.getDTMHandleFromNode(xml);
				list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
				node = list.nodeset().nextNode();
				if (node == null) {
					namespaceNode.setAttribute("xmlns:oai", XMLNS_OAI_2_0);
					prefixResolver = new PrefixResolverDefault(namespaceNode);
					xpath = new XPath("/oai:OAI-PMH/oai:GetRecord/oai:record", null, prefixResolver, XPath.SELECT,
							null);
					list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
					node = list.nodeset().nextNode();
					if (node == null) {
						namespaceNode.setAttribute("xmlns:oai", XMLNS_OAI_1_0 + "GetRecord");
						prefixResolver = new PrefixResolverDefault(namespaceNode);
						xpath = new XPath("/oai:GetRecord/oai:record", null, prefixResolver, XPath.SELECT, null);
						list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
						node = list.nodeset().nextNode();
					} else {
						xpath = new XPath("oai:OAI-PMH/oai:error", null, prefixResolver, XPath.SELECT, null);
						list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
						ixmlErrors = list.nodelist();
						if (ixmlErrors.getLength() > 0) {
							strProtocolVersion = "2";
							throw new OAIException(OAIException.OAI_ERR,
									getLastOAIError().getCode() + ": " + getLastOAIError().getReason());
						}
					}
				}
				if (node != null) {
					rec.frndSetRepository(this);
					rec.frndSetMetadataPrefix(metadataPrefix);
					rec.frndSetIdOnly(false);
					ctxtNode = xpathSupport.getDTMHandleFromNode(node);
					xpath = new XPath("//oai:header/oai:identifier", null, prefixResolver, XPath.SELECT, null);
					list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
					rec.frndSetIdentifier(list.nodeset().nextNode().getFirstChild().getNodeValue());
					xpath = new XPath("//oai:header/oai:datestamp", null, prefixResolver, XPath.SELECT, null);
					list = xpath.execute(xpathSupport, ctxtNode, prefixResolver);
					rec.frndSetDatestamp(list.nodeset().nextNode().getFirstChild().getNodeValue());
					rec.frndSetRecord(node);
					NamedNodeMap nmap = node.getAttributes();
					if (nmap != null) {
						if (nmap.getNamedItem("status") != null) {
							rec.frndSetStatus(nmap.getNamedItem("status").getFirstChild().getNodeValue());
						}
					}
				} else {
					rec = null;
				}
				xpath = new XPath("//oai:responseDate", null, prefixResolver, XPath.SELECT, null);
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
				xpath = new XPath("//oai:requestURL | //oai:request", null, prefixResolver, XPath.SELECT, null);
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
				xpath = null;
				prefixResolver = null;
				xpathSupport = null;
				list = null;
			} catch (TransformerException te) {
				throw new OAIException(OAIException.CRITICAL_ERR, te.getMessage());
			}
			docBuilder = null;
			docFactory = null;
		} catch (MalformedURLException mue) {
			throw new OAIException(OAIException.CRITICAL_ERR, mue.getMessage());
		} catch (FactoryConfigurationError fce) {
			throw new OAIException(OAIException.CRITICAL_ERR, fce.getMessage());
		} catch (ParserConfigurationException pce) {
			throw new OAIException(OAIException.CRITICAL_ERR, pce.getMessage());
		} catch (IOException ie) {
			throw new OAIException(OAIException.CRITICAL_ERR, ie.getMessage());
		}
		return rec;
	}

}