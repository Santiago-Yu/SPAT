class n7067729 {
	public void loadScripts() {
		org.apache.batik.script.Window A7ZrYyNp = null;
		NodeList JlJG4nbL = document.getElementsByTagNameNS(SVGConstants.SVG_NAMESPACE_URI,
				SVGConstants.SVG_SCRIPT_TAG);
		int R5rWbroP = JlJG4nbL.getLength();
		if (R5rWbroP == 0) {
			return;
		}
		for (int Oge6e5Og = 0; Oge6e5Og < R5rWbroP; Oge6e5Og++) {
			Element o8MIbdxO = (Element) JlJG4nbL.item(Oge6e5Og);
			String dwhKW43M = o8MIbdxO.getAttributeNS(null, SVGConstants.SVG_TYPE_ATTRIBUTE);
			if (dwhKW43M.length() == 0) {
				dwhKW43M = SVGConstants.SVG_SCRIPT_TYPE_DEFAULT_VALUE;
			}
			if (dwhKW43M.equals(SVGConstants.SVG_SCRIPT_TYPE_JAVA)) {
				try {
					String aRBfidRi = XLinkSupport.getXLinkHref(o8MIbdxO);
					ParsedURL hJCuJ0z8 = new ParsedURL(XMLBaseSupport.getCascadedXMLBase(o8MIbdxO), aRBfidRi);
					checkCompatibleScriptURL(dwhKW43M, hJCuJ0z8);
					DocumentJarClassLoader gHu7t4Fx;
					URL Ks9IIHZH = null;
					try {
						Ks9IIHZH = new URL(docPURL.toString());
					} catch (MalformedURLException ecFRzk97) {
					}
					gHu7t4Fx = new DocumentJarClassLoader(new URL(hJCuJ0z8.toString()), Ks9IIHZH);
					URL rZlquHPu = gHu7t4Fx.findResource("META-INF/MANIFEST.MF");
					if (rZlquHPu == null) {
						continue;
					}
					Manifest b4Yemzbu = new Manifest(rZlquHPu.openStream());
					String VbKIoqmt;
					VbKIoqmt = b4Yemzbu.getMainAttributes().getValue("Script-Handler");
					if (VbKIoqmt != null) {
						ScriptHandler N0ixp0Oz;
						N0ixp0Oz = (ScriptHandler) gHu7t4Fx.loadClass(VbKIoqmt).newInstance();
						if (A7ZrYyNp == null) {
							A7ZrYyNp = createWindow();
						}
						N0ixp0Oz.run(document, A7ZrYyNp);
					}
					VbKIoqmt = b4Yemzbu.getMainAttributes().getValue("SVG-Handler-Class");
					if (VbKIoqmt != null) {
						EventListenerInitializer DbZjjtWK;
						DbZjjtWK = (EventListenerInitializer) gHu7t4Fx.loadClass(VbKIoqmt).newInstance();
						if (A7ZrYyNp == null) {
							A7ZrYyNp = createWindow();
						}
						DbZjjtWK.initializeEventListeners((SVGDocument) document);
					}
				} catch (Exception SJk4eKde) {
					if (userAgent != null) {
						userAgent.displayError(SJk4eKde);
					}
				}
				continue;
			}
			Interpreter dmSyGd5T = getInterpreter(dwhKW43M);
			if (dmSyGd5T == null)
				continue;
			try {
				String ItS6ZMih = XLinkSupport.getXLinkHref(o8MIbdxO);
				String zSUlNY3b = null;
				Reader LfKKDVpl;
				if (ItS6ZMih.length() > 0) {
					zSUlNY3b = ItS6ZMih;
					ParsedURL ae5hVux2 = new ParsedURL(XMLBaseSupport.getCascadedXMLBase(o8MIbdxO), ItS6ZMih);
					checkCompatibleScriptURL(dwhKW43M, ae5hVux2);
					LfKKDVpl = new InputStreamReader(ae5hVux2.openStream());
				} else {
					checkCompatibleScriptURL(dwhKW43M, docPURL);
					DocumentLoader isoABpi9 = bridgeContext.getDocumentLoader();
					Element blkGfapV = o8MIbdxO;
					SVGDocument yZRNLHP3 = (SVGDocument) blkGfapV.getOwnerDocument();
					int ug2zWEzR = isoABpi9.getLineNumber(o8MIbdxO);
					zSUlNY3b = Messages.formatMessage(INLINE_SCRIPT_DESCRIPTION, new Object[] { yZRNLHP3.getURL(),
							"<" + o8MIbdxO.getNodeName() + ">", new Integer(ug2zWEzR) });
					Node q8WCFFXQ = o8MIbdxO.getFirstChild();
					if (q8WCFFXQ != null) {
						StringBuffer R4GUO5yf = new StringBuffer();
						while (q8WCFFXQ != null) {
							if (q8WCFFXQ.getNodeType() == Node.CDATA_SECTION_NODE
									|| q8WCFFXQ.getNodeType() == Node.TEXT_NODE)
								R4GUO5yf.append(q8WCFFXQ.getNodeValue());
							q8WCFFXQ = q8WCFFXQ.getNextSibling();
						}
						LfKKDVpl = new StringReader(R4GUO5yf.toString());
					} else {
						continue;
					}
				}
				dmSyGd5T.evaluate(LfKKDVpl, zSUlNY3b);
			} catch (IOException Qc0RDcD1) {
				if (userAgent != null) {
					userAgent.displayError(Qc0RDcD1);
				}
				return;
			} catch (InterpreterException KfXM8fNj) {
				System.err.println("InterpExcept: " + KfXM8fNj);
				handleInterpreterException(KfXM8fNj);
				return;
			} catch (SecurityException dXZzOUP6) {
				if (userAgent != null) {
					userAgent.displayError(dXZzOUP6);
				}
			}
		}
	}

}