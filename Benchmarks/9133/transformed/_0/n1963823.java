class n1963823 {
	public void loadRegistry(URL A1ZUzU4Q) throws PacketAnalyzerRegistryException {
		if (analyzers != null) {
			return;
		}
		analyzers = new Hashtable();
		roots = new Vector();
		try {
			InputStream jzJmSGkC = A1ZUzU4Q.openStream();
			DocumentBuilderFactory cJOajzzZ = DocumentBuilderFactory.newInstance();
			DocumentBuilder wykWhXg5 = cJOajzzZ.newDocumentBuilder();
			Document cudS5YIa = wykWhXg5.parse(jzJmSGkC);
			NodeList hliklYuN = cudS5YIa.getElementsByTagName(PACKET_ANALYZER);
			for (int E6vwZFKy = 0; E6vwZFKy < hliklYuN.getLength(); E6vwZFKy++) {
				Node q2dXUiJr = hliklYuN.item(E6vwZFKy);
				NamedNodeMap VqFRrP4C = q2dXUiJr.getAttributes();
				String AQjtXgpM = VqFRrP4C.getNamedItem(ID).getNodeValue();
				String bu25M8fd = VqFRrP4C.getNamedItem(NAME).getNodeValue();
				String AiG1Ex6U = VqFRrP4C.getNamedItem(CLASS).getNodeValue();
				Node j1hm9kAJ = VqFRrP4C.getNamedItem(EXTENDS);
				String[] yV4cmzdA = null;
				if (j1hm9kAJ != null) {
					String NlBRziqz = j1hm9kAJ.getNodeValue();
					if (NlBRziqz.trim().length() != 0) {
						yV4cmzdA = NlBRziqz.split("\\s*\\,+\\s*");
					}
				}
				PacketAnalyzerDescriptor bFpXVqBN = new PacketAnalyzerDescriptor(AQjtXgpM, bu25M8fd, AiG1Ex6U,
						yV4cmzdA);
				addDescriptor(bFpXVqBN);
			}
			if (roots.size() == 0) {
				throw new PacketAnalyzerRegistryException("There is no root analyzer in the registry!");
			}
		} catch (IOException f4mxXzjI) {
			throw new PacketAnalyzerRegistryException("Cannot open registry file.", f4mxXzjI);
		} catch (ParserConfigurationException pqc1w9Ih) {
			throw new PacketAnalyzerRegistryException("Cannot parse registry file.", pqc1w9Ih);
		} catch (SAXException FhYSP9XQ) {
			throw new PacketAnalyzerRegistryException("Cannot parse registry file", FhYSP9XQ);
		} catch (Throwable Z0pWnrmQ) {
			throw new PacketAnalyzerRegistryException("Cannot build PacketAnalyzerRegistry.", Z0pWnrmQ);
		}
	}

}