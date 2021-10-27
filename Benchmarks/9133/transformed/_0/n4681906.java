class n4681906 {
	public void launch(String ZA5rhKkg, String Ix2zmx9j, long xmfvlTQL) {
		AgentLauncher qQhvCpwr;
		Environment aXsPFSyn;
		Properties reMRN554;
		Resource qnf524oj;
		String SNCfTPly;
		String f3w48di5;
		String NvkdBsYj;
		String fADMjs89;
		String Sqdjx3Ia;
		ShipService o3VKQS4X;
		de.fhg.igd.util.URL k4lKB2Wt;
		java.net.URL T6YDSRMJ;
		NodeList vNvTzzxL;
		InputSource wZhHJ9pa;
		TreeMap ueiifajz;
		synchronized (lock_) {
			if (ZA5rhKkg == null || ZA5rhKkg.length() == 0 || Ix2zmx9j == null || Ix2zmx9j.length() == 0) {
				System.out.println("---- Need control AND XML document! ----");
				return;
			}
			Vector l3aFMXMR = new Vector();
			Vector L8qhaAYi = new Vector();
			Vector QxacG8Ba = new Vector();
			wZhHJ9pa = new InputSource(new StringReader(ZA5rhKkg));
			NodeList F5ufnvDR = SimpleXMLParser.parseDocument(wZhHJ9pa, AgentBehaviour.XML_DELEGATE);
			for (int meY9es0J = 0; meY9es0J < F5ufnvDR.getLength(); meY9es0J++) {
				if (F5ufnvDR.item(meY9es0J).getTextContent() != null
						&& F5ufnvDR.item(meY9es0J).getTextContent().length() > 0) {
					System.out.println(F5ufnvDR.item(meY9es0J).getTextContent());
					Sqdjx3Ia = SimpleXMLParser.findChildEntry(F5ufnvDR.item(meY9es0J), AgentBehaviour.XML_HOST);
					l3aFMXMR.add(Sqdjx3Ia);
					Sqdjx3Ia = SimpleXMLParser.findChildEntry(F5ufnvDR.item(meY9es0J), AgentBehaviour.XML_URL);
					L8qhaAYi.add(Sqdjx3Ia);
					Sqdjx3Ia = SimpleXMLParser.findChildEntry(F5ufnvDR.item(meY9es0J), AgentBehaviour.XML_METHOD);
					QxacG8Ba.add(Sqdjx3Ia);
				}
			}
			SNCfTPly = "";
			ueiifajz = new TreeMap();
			for (int cxbV0dyM = 0; cxbV0dyM < TOKEN_LENGTH; cxbV0dyM++) {
				SNCfTPly = SNCfTPly + (char) (Math.random() * 26 + 65);
			}
			ueiifajz.put(SNCfTPly, null);
			reMRN554 = AgentStructure.defaults();
			reMRN554.setProperty(AgentStructure.PROP_AGENT_CLASS, AGENT_);
			reMRN554.setProperty(AgentBehaviour.CTX_DOCID, String.valueOf(xmfvlTQL));
			reMRN554.setProperty(AgentBehaviour.CTX_XML, Ix2zmx9j);
			reMRN554.setProperty("token", SNCfTPly);
			f3w48di5 = reMRN554.getProperty(AgentStructure.PROP_AGENT_EXCLUDE);
			reMRN554.setProperty(AgentStructure.PROP_AGENT_EXCLUDE, f3w48di5 + ":" + ADDITIONAL_EXCLUDES);
			o3VKQS4X = (ShipService) getEnvironment().lookup(WhatIs.stringValue(ShipService.WHATIS));
			for (int xzeqW2lF = 0; xzeqW2lF < l3aFMXMR.size(); xzeqW2lF++) {
				System.out.println("\n-----SCANNING DELEGATES-----");
				System.out.println("\n-----DELEGATE " + xzeqW2lF + "-----");
				System.out.println("-----HOST: " + xzeqW2lF + ": " + (String) l3aFMXMR.elementAt(xzeqW2lF));
				System.out.println("-----URL: " + xzeqW2lF + ": " + (String) L8qhaAYi.elementAt(xzeqW2lF));
				System.out.println("-----METHOD: " + xzeqW2lF + ": " + (String) QxacG8Ba.elementAt(xzeqW2lF));
				try {
					k4lKB2Wt = new de.fhg.igd.util.URL((String) l3aFMXMR.elementAt(xzeqW2lF));
					boolean pElODlXB = o3VKQS4X.isAlive(k4lKB2Wt);
					System.out.println("-----ALIVE: " + pElODlXB);
					if (pElODlXB) {
						T6YDSRMJ = new java.net.URL((String) L8qhaAYi.elementAt(xzeqW2lF));
						try {
							T6YDSRMJ.openStream();
							System.out.println("-----WEBSERVICE: ON");
							if (!reMRN554.containsKey(0 + "." + AgentBehaviour.XML_URL)) {
								System.out.println("-----MIGRATION: First online host found. I will migrate here:)!");
								reMRN554.setProperty(0 + "." + AgentBehaviour.XML_HOST,
										(String) l3aFMXMR.elementAt(xzeqW2lF));
								reMRN554.setProperty(0 + "." + AgentBehaviour.XML_URL,
										(String) L8qhaAYi.elementAt(xzeqW2lF));
								reMRN554.setProperty(0 + "." + AgentBehaviour.XML_METHOD,
										(String) QxacG8Ba.elementAt(xzeqW2lF));
							} else {
								System.out.println("-----MIGRATION: I will not migrate here:(!");
							}
						} catch (IOException rzKVGAMH) {
							System.out.println("-----WEBSERVICE: Could not connect to the webservice!");
							System.out.println("-----MIGRATION: WEBSERVICE NOT FOUND! I will not migrate here:(!");
						}
					}
				} catch (ShipException eDhKbGKp) {
					System.out.println("-----ALIVE: false");
					System.out.println("-----MIGRATION: HOST NOT FOUND! I will not migrate here:(!");
				} catch (SecurityException I3ozXmtv) {
					System.out.println("-----EXCEPTION: Access connection to remote SHIP service fails! "
							+ "No proper ShipPermission permission to invoke lookups! " + "Ignoring this host....");
				} catch (MalformedURLException KEXV50eT) {
					System.out.println("-----EXCEPTION: The host URL is not valid! Ignoring this host....");
				}
			}
			qnf524oj = new MemoryResource();
			aXsPFSyn = Environment.getEnvironment();
			fADMjs89 = WhatIs.stringValue(AgentLauncher.WHATIS);
			qQhvCpwr = (AgentLauncher) aXsPFSyn.lookup(fADMjs89);
			if (qQhvCpwr == null) {
				System.out.println("Can't find the agent launcher");
				return;
			}
			try {
				qQhvCpwr.launchAgent(qnf524oj, reMRN554);
			} catch (IllegalAgentException caaMYSr5) {
				System.out.println(caaMYSr5);
			} catch (GeneralSecurityException gIAiNwrg) {
				System.out.println(gIAiNwrg);
			} catch (IOException md27z8bl) {
				System.out.println(md27z8bl);
			}
			syncmap_.put(SNCfTPly, ueiifajz);
			System.out.println("----- TOKEN = " + SNCfTPly + "------");
		}
		try {
			synchronized (SNCfTPly) {
				SNCfTPly.wait(TIMEOUT);
				Map oEtFz8R4 = (Map) syncmap_.get(SNCfTPly);
				Collection o8eaeGiX = oEtFz8R4.values();
				String[] MkOPO4Ct = (String[]) o8eaeGiX.toArray(new String[0]);
				NvkdBsYj = "";
				for (int m0XXIeT0 = 0; m0XXIeT0 < MkOPO4Ct.length; m0XXIeT0++) {
					NvkdBsYj = NvkdBsYj + MkOPO4Ct[m0XXIeT0];
				}
				syncmap_.remove(SNCfTPly);
				System.out.println("----- " + NvkdBsYj + " -----");
				callbackWS(ZA5rhKkg, NvkdBsYj, xmfvlTQL);
			}
		} catch (InterruptedException RPGKBWaP) {
			System.out.println(RPGKBWaP);
		}
	}

}