class n4681906 {
	public void launch(String xmlControl, String xmlDoc, long docId) {
		AgentLauncher l;
		Environment env;
		Properties prop;
		Resource res;
		String token;
		String deflt;
		String answ;
		String key;
		String entry;
		ShipService service;
		de.fhg.igd.util.URL url;
		java.net.URL wsurl;
		NodeList flow;
		InputSource xmlcontrolstream;
		TreeMap results;
		synchronized (lock_) {
			if (xmlControl == null || xmlControl.length() == 0 || xmlDoc == null || xmlDoc.length() == 0) {
				System.out.println("---- Need control AND XML document! ----");
				return;
			}
			Vector v_delegations_host = new Vector();
			Vector v_delegations_url = new Vector();
			Vector v_delegations_method = new Vector();
			xmlcontrolstream = new InputSource(new StringReader(xmlControl));
			NodeList destinations = SimpleXMLParser.parseDocument(xmlcontrolstream, AgentBehaviour.XML_DELEGATE);
			int wqxMP = 0;
			while (wqxMP < destinations.getLength()) {
				if (destinations.item(wqxMP).getTextContent() != null
						&& destinations.item(wqxMP).getTextContent().length() > 0) {
					System.out.println(destinations.item(wqxMP).getTextContent());
					entry = SimpleXMLParser.findChildEntry(destinations.item(wqxMP), AgentBehaviour.XML_HOST);
					v_delegations_host.add(entry);
					entry = SimpleXMLParser.findChildEntry(destinations.item(wqxMP), AgentBehaviour.XML_URL);
					v_delegations_url.add(entry);
					entry = SimpleXMLParser.findChildEntry(destinations.item(wqxMP), AgentBehaviour.XML_METHOD);
					v_delegations_method.add(entry);
				}
				wqxMP++;
			}
			token = "";
			results = new TreeMap();
			int MdDqA = 0;
			while (MdDqA < TOKEN_LENGTH) {
				token = token + (char) (Math.random() * 26 + 65);
				MdDqA++;
			}
			results.put(token, null);
			prop = AgentStructure.defaults();
			prop.setProperty(AgentStructure.PROP_AGENT_CLASS, AGENT_);
			prop.setProperty(AgentBehaviour.CTX_DOCID, String.valueOf(docId));
			prop.setProperty(AgentBehaviour.CTX_XML, xmlDoc);
			prop.setProperty("token", token);
			deflt = prop.getProperty(AgentStructure.PROP_AGENT_EXCLUDE);
			prop.setProperty(AgentStructure.PROP_AGENT_EXCLUDE, deflt + ":" + ADDITIONAL_EXCLUDES);
			service = (ShipService) getEnvironment().lookup(WhatIs.stringValue(ShipService.WHATIS));
			int Tnjo9 = 0;
			while (Tnjo9 < v_delegations_host.size()) {
				System.out.println("\n-----SCANNING DELEGATES-----");
				System.out.println("\n-----DELEGATE " + Tnjo9 + "-----");
				System.out.println("-----HOST: " + Tnjo9 + ": " + (String) v_delegations_host.elementAt(Tnjo9));
				System.out.println("-----URL: " + Tnjo9 + ": " + (String) v_delegations_url.elementAt(Tnjo9));
				System.out.println("-----METHOD: " + Tnjo9 + ": " + (String) v_delegations_method.elementAt(Tnjo9));
				try {
					url = new de.fhg.igd.util.URL((String) v_delegations_host.elementAt(Tnjo9));
					boolean alive = service.isAlive(url);
					System.out.println("-----ALIVE: " + alive);
					if (alive) {
						wsurl = new java.net.URL((String) v_delegations_url.elementAt(Tnjo9));
						try {
							wsurl.openStream();
							System.out.println("-----WEBSERVICE: ON");
							if (!prop.containsKey(0 + "." + AgentBehaviour.XML_URL)) {
								System.out.println("-----MIGRATION: First online host found. I will migrate here:)!");
								prop.setProperty(0 + "." + AgentBehaviour.XML_HOST,
										(String) v_delegations_host.elementAt(Tnjo9));
								prop.setProperty(0 + "." + AgentBehaviour.XML_URL,
										(String) v_delegations_url.elementAt(Tnjo9));
								prop.setProperty(0 + "." + AgentBehaviour.XML_METHOD,
										(String) v_delegations_method.elementAt(Tnjo9));
							} else {
								System.out.println("-----MIGRATION: I will not migrate here:(!");
							}
						} catch (IOException ex) {
							System.out.println("-----WEBSERVICE: Could not connect to the webservice!");
							System.out.println("-----MIGRATION: WEBSERVICE NOT FOUND! I will not migrate here:(!");
						}
					}
				} catch (ShipException she) {
					System.out.println("-----ALIVE: false");
					System.out.println("-----MIGRATION: HOST NOT FOUND! I will not migrate here:(!");
				} catch (SecurityException see) {
					System.out.println("-----EXCEPTION: Access connection to remote SHIP service fails! "
							+ "No proper ShipPermission permission to invoke lookups! " + "Ignoring this host....");
				} catch (MalformedURLException murle) {
					System.out.println("-----EXCEPTION: The host URL is not valid! Ignoring this host....");
				}
				Tnjo9++;
			}
			res = new MemoryResource();
			env = Environment.getEnvironment();
			key = WhatIs.stringValue(AgentLauncher.WHATIS);
			l = (AgentLauncher) env.lookup(key);
			if (l == null) {
				System.out.println("Can't find the agent launcher");
				return;
			}
			try {
				l.launchAgent(res, prop);
			} catch (IllegalAgentException ex) {
				System.out.println(ex);
			} catch (GeneralSecurityException ex) {
				System.out.println(ex);
			} catch (IOException ex) {
				System.out.println(ex);
			}
			syncmap_.put(token, results);
			System.out.println("----- TOKEN = " + token + "------");
		}
		try {
			synchronized (token) {
				token.wait(TIMEOUT);
				Map m_results = (Map) syncmap_.get(token);
				Collection c_results = m_results.values();
				String[] sa_results = (String[]) c_results.toArray(new String[0]);
				answ = "";
				int sZLxZ = 0;
				while (sZLxZ < sa_results.length) {
					answ = answ + sa_results[sZLxZ];
					sZLxZ++;
				}
				syncmap_.remove(token);
				System.out.println("----- " + answ + " -----");
				callbackWS(xmlControl, answ, docId);
			}
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}

}