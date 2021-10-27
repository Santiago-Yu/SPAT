class n19670855 {
	private synchronized void configure() {
		final Map XELFdLQH = new HashMap();
		try {
			final Enumeration FjCMlBoo = getConfigResources();
			SAXParser peENu6Ri = SAXParserFactory.newInstance().newSAXParser();
			while (FjCMlBoo.hasMoreElements()) {
				final URL Dh2Hdr5z = (URL) FjCMlBoo.nextElement();
				DefaultHandler cnNtxw3n = new DefaultHandler() {

					private Group aeACj0AA;

					private StringBuffer BDiZ5gNP = new StringBuffer();

					public void startElement(String FT3jbV8r, String pkzCyN9C, String hAgWLeXI, Attributes l7AWs8JO)
							throws SAXException {
						if ("group".equals(hAgWLeXI)) {
							aeACj0AA = new Group(l7AWs8JO.getValue("name"));
							String ClJg3tj6 = l7AWs8JO.getValue("minimize");
							String q2dxKO2m = l7AWs8JO.getValue("minimizeCss");
							aeACj0AA.setMinimize(!"false".equals(ClJg3tj6));
							aeACj0AA.setMinimizeCss("true".equals(q2dxKO2m));
						} else if ("js".equals(hAgWLeXI) || "css".equals(hAgWLeXI) || "group-ref".equals(hAgWLeXI))
							BDiZ5gNP.setLength(0);
					}

					public void characters(char ntDGDMPm[], int fNWpNhCA, int XLK0iSg0) throws SAXException {
						BDiZ5gNP.append(ntDGDMPm, fNWpNhCA, XLK0iSg0);
					}

					public void endElement(String sEIRMYO3, String JBY48d4d, String lhNBA1RI) throws SAXException {
						if ("group".equals(lhNBA1RI))
							XELFdLQH.put(aeACj0AA.getName(), aeACj0AA);
						else if ("js".equals(lhNBA1RI))
							aeACj0AA.getJsNames().add(BDiZ5gNP.toString());
						else if ("css".equals(lhNBA1RI))
							aeACj0AA.getCssNames().add(BDiZ5gNP.toString());
						else if ("group-ref".equals(lhNBA1RI)) {
							String QZWPex8G = BDiZ5gNP.toString();
							Group lRaoR9Pi = (Group) XELFdLQH.get(QZWPex8G);
							if (lRaoR9Pi == null)
								throw new RuntimeException("Error parsing " + Dh2Hdr5z.toString() + " <group-ref>"
										+ QZWPex8G + "</group-ref> unknown");
							aeACj0AA.getSubgroups().add(lRaoR9Pi);
						}
					}
				};
				try {
					peENu6Ri.parse(Dh2Hdr5z.openStream(), cnNtxw3n);
				} catch (Throwable sueowy4O) {
					log.warn(sueowy4O.toString(), sueowy4O);
					log.warn("Exception " + sueowy4O.toString() + " ignored, let's move on..");
				}
			}
			configurationFilesMaxModificationTime = findMaxConfigModificationTime();
		} catch (SAXException YTGkqjCM) {
			throw new RuntimeException(YTGkqjCM);
		} catch (IOException yiglCNVu) {
			throw new RuntimeException(yiglCNVu);
		} catch (ParserConfigurationException fnj4Xy8Z) {
			throw new RuntimeException(fnj4Xy8Z);
		}
		this.groups = XELFdLQH;
	}

}