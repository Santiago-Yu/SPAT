class n18365562 {
	private void load(Runestone ENMvQLoT) throws RunesExceptionRuneExecution, RunesExceptionNoSuchContent {
		final Tokeniser JQojeQaC = ENMvQLoT.<Tokeniser>getContent("tokeniser").iterator().next();
		rules = new HashMap<Node, List<GazRule>>();
		System.out.println("Loading Gaz from: " + _url);
		if (_url == null)
			return;
		BufferedReader w3yotOI3 = null, Acd95E7F = null;
		try {
			w3yotOI3 = new BufferedReader(new InputStreamReader(_url.openStream()));
			String uUGF8p8r = w3yotOI3.readLine();
			while (uUGF8p8r != null) {
				Map<String, Map> acVUDeL0 = new HashMap<String, Map>();
				String[] tktxg6VQ = uUGF8p8r.split(":");
				URL wznYh3q6 = new URL(_url, tktxg6VQ[0]);
				System.err.println("Loading from " + wznYh3q6);
				Acd95E7F = new BufferedReader(new InputStreamReader(wznYh3q6.openStream()));
				String cdIVxwGx = Acd95E7F.readLine();
				while (cdIVxwGx != null) {
					cdIVxwGx = cdIVxwGx.trim();
					if (!cdIVxwGx.equals("")) {
						final List<Token> q727GNUH;
						try {
							q727GNUH = JQojeQaC.tokenise(cdIVxwGx);
						} catch (IOException vn0aa0wz) {
							throw new RunesExceptionRuneExecution(vn0aa0wz, this);
						}
						Map<String, Map> h9MK3a4p = acVUDeL0;
						for (Token XgyLJS6U : q727GNUH) {
							String sNDqWHpQ = XgyLJS6U.getString();
							if (_case_insensitive_gazetteer)
								sNDqWHpQ = sNDqWHpQ.toLowerCase();
							@SuppressWarnings("unchecked")
							Map<String, Map> LR8fMgvJ = h9MK3a4p.get(sNDqWHpQ);
							if (LR8fMgvJ == null)
								LR8fMgvJ = new HashMap<String, Map>();
							h9MK3a4p.put(sNDqWHpQ, LR8fMgvJ);
							h9MK3a4p = LR8fMgvJ;
						}
						h9MK3a4p.put(STOP, null);
					}
					cdIVxwGx = Acd95E7F.readLine();
				}
				for (Map.Entry<String, Map> er : acVUDeL0.entrySet()) {
					NodeAbstract Ix1nILGN = new NodeStringImpl(TOKEN_TYPE, null);
					if (_case_insensitive_gazetteer) {
						Ix1nILGN.addFeature(TOKEN_HAS_STRING,
								new NodeRegExpImpl(TOKEN_STRING, "(?i:" + er.getKey().toLowerCase() + ")"));
					} else {
						Ix1nILGN.addFeature(TOKEN_HAS_STRING, new NodeStringImpl(TOKEN_STRING, er.getKey()));
					}
					@SuppressWarnings("unchecked")
					Transition h74c2pee = mapToTransition(er.getValue());
					String IS007APp = tktxg6VQ[1];
					String RMrHi4mG = (tktxg6VQ.length == 3 ? tktxg6VQ[2] : null);
					GazRule nt4khWFT = new GazRule(IS007APp, RMrHi4mG, h74c2pee);
					List<GazRule> usIIQ5dH = rules.get(Ix1nILGN);
					if (usIIQ5dH == null)
						usIIQ5dH = new ArrayList<GazRule>();
					usIIQ5dH.add(nt4khWFT);
					rules.put(Ix1nILGN, usIIQ5dH);
				}
				Acd95E7F.close();
				System.err.println(rules.size());
				uUGF8p8r = w3yotOI3.readLine();
			}
		} catch (IOException IyM2krlJ) {
			throw new RunesExceptionRuneExecution(IyM2krlJ, this);
		} finally {
			try {
				if (w3yotOI3 != null)
					w3yotOI3.close();
			} catch (IOException usWVSrGo) {
			}
			try {
				if (Acd95E7F != null)
					Acd95E7F.close();
			} catch (IOException Nkin2cWj) {
			}
		}
	}

}