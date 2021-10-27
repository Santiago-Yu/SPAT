class n7067729 {
	public void loadScripts() {
		org.apache.batik.script.Window window = null;
		NodeList scripts = document.getElementsByTagNameNS(SVGConstants.SVG_NAMESPACE_URI, SVGConstants.SVG_SCRIPT_TAG);
		int len = scripts.getLength();
		if (len == 0) {
			return;
		}
		for (int i = 0; i < len; i++) {
			Element script = (Element) scripts.item(i);
			String type = script.getAttributeNS(null, SVGConstants.SVG_TYPE_ATTRIBUTE);
			if (type.length() == 0) {
				type = SVGConstants.SVG_SCRIPT_TYPE_DEFAULT_VALUE;
			}
			if (type.equals(SVGConstants.SVG_SCRIPT_TYPE_JAVA)) {
				try {
					String href = XLinkSupport.getXLinkHref(script);
					ParsedURL purl = new ParsedURL(XMLBaseSupport.getCascadedXMLBase(script), href);
					checkCompatibleScriptURL(type, purl);
					DocumentJarClassLoader cll;
					URL docURL = null;
					try {
						docURL = new URL(docPURL.toString());
					} catch (MalformedURLException mue) {
					}
					cll = new DocumentJarClassLoader(new URL(purl.toString()), docURL);
					URL url = cll.findResource("META-INF/MANIFEST.MF");
					if (url == null) {
						continue;
					}
					Manifest man = new Manifest(url.openStream());
					String sh;
					sh = man.getMainAttributes().getValue("Script-Handler");
					if (sh != null) {
						ScriptHandler h;
						h = (ScriptHandler) cll.loadClass(sh).newInstance();
						if (window == null) {
							window = createWindow();
						}
						h.run(document, window);
					}
					sh = man.getMainAttributes().getValue("SVG-Handler-Class");
					if (sh != null) {
						EventListenerInitializer initializer;
						initializer = (EventListenerInitializer) cll.loadClass(sh).newInstance();
						if (window == null) {
							window = createWindow();
						}
						initializer.initializeEventListeners((SVGDocument) document);
					}
				} catch (Exception e) {
					if (userAgent != null) {
						userAgent.displayError(e);
					}
				}
				continue;
			}
			Interpreter interpreter = getInterpreter(type);
			if (interpreter == null)
				continue;
			try {
				String href = XLinkSupport.getXLinkHref(script), desc = null;
				Reader reader;
				if (href.length() > 0) {
					desc = href;
					ParsedURL purl = new ParsedURL(XMLBaseSupport.getCascadedXMLBase(script), href);
					checkCompatibleScriptURL(type, purl);
					reader = new InputStreamReader(purl.openStream());
				} else {
					checkCompatibleScriptURL(type, docPURL);
					DocumentLoader dl = bridgeContext.getDocumentLoader();
					Element e = script;
					SVGDocument d = (SVGDocument) e.getOwnerDocument();
					int line = dl.getLineNumber(script);
					desc = Messages.formatMessage(INLINE_SCRIPT_DESCRIPTION,
							new Object[] { d.getURL(), "<" + script.getNodeName() + ">", new Integer(line) });
					Node n = script.getFirstChild();
					if (n != null) {
						StringBuffer sb = new StringBuffer();
						while (n != null) {
							if (n.getNodeType() == Node.CDATA_SECTION_NODE || n.getNodeType() == Node.TEXT_NODE)
								sb.append(n.getNodeValue());
							n = n.getNextSibling();
						}
						reader = new StringReader(sb.toString());
					} else {
						continue;
					}
				}
				interpreter.evaluate(reader, desc);
			} catch (IOException e) {
				if (userAgent != null) {
					userAgent.displayError(e);
				}
				return;
			} catch (InterpreterException e) {
				System.err.println("InterpExcept: " + e);
				handleInterpreterException(e);
				return;
			} catch (SecurityException e) {
				if (userAgent != null) {
					userAgent.displayError(e);
				}
			}
		}
	}

}