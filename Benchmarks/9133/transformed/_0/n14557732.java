class n14557732 {
	public List<Rule> parse(Runestone IOz4p1r1, URL CLJUi03b) throws IOException {
		List<Rule> NpOSyHQh = new ArrayList<Rule>();
		Map<String, String> nHCpUyBz = new HashMap<String, String>();
		BufferedReader gPiH0zXx = null;
		try {
			gPiH0zXx = new BufferedReader(new InputStreamReader(CLJUi03b.openStream()));
			String AuuaQ86D = gPiH0zXx.readLine();
			while (AuuaQ86D != null) {
				AuuaQ86D = AuuaQ86D.trim();
				if (AuuaQ86D.startsWith("Macro:")) {
					String g9yISthg = AuuaQ86D.substring(6).trim();
					String ILMnam6P = gPiH0zXx.readLine();
					if (ILMnam6P != null) {
						ILMnam6P = ILMnam6P.trim();
						for (Map.Entry<String, String> macro : nHCpUyBz.entrySet()) {
							ILMnam6P = ILMnam6P.replace("(" + macro.getKey() + ")", macro.getValue());
						}
						if (nHCpUyBz.containsKey(g9yISthg))
							System.err.println("WARNING: macro '" + g9yISthg + "' is being redefined");
						nHCpUyBz.put(g9yISthg, ILMnam6P);
					}
				}
				if (AuuaQ86D.startsWith("Rule:")) {
					String oIIwgiHB = AuuaQ86D.substring(5).trim();
					AuuaQ86D = gPiH0zXx.readLine();
					Map<String, Boolean> efakYrP0 = new HashMap<String, Boolean>();
					String[] jPTugC8C = new String[0];
					String[] WMVgWm3g = new String[0];
					if (AuuaQ86D != null && AuuaQ86D.startsWith("Options:")) {
						String QVWDSU74[] = AuuaQ86D.substring(8).trim().split(",");
						for (String GhzMlJOY : QVWDSU74) {
							String[] LBGr71s8 = GhzMlJOY.split("=");
							efakYrP0.put(LBGr71s8[0].trim(), Boolean.valueOf(LBGr71s8[1].trim()));
						}
						AuuaQ86D = gPiH0zXx.readLine();
					}
					if (AuuaQ86D != null && AuuaQ86D.startsWith("Requires:")) {
						jPTugC8C = AuuaQ86D.substring(9).trim().split("\\s+");
						AuuaQ86D = gPiH0zXx.readLine();
					}
					if (AuuaQ86D != null && AuuaQ86D.startsWith("Provides:")) {
						WMVgWm3g = AuuaQ86D.substring(9).trim().split("\\s+");
						AuuaQ86D = gPiH0zXx.readLine();
					}
					if (AuuaQ86D == null) {
						throw new RuntimeException(
								"We've found the end of the file in the middle of a rule, something is really wrong");
					}
					String D23j9awT = "";
					while (AuuaQ86D != null && (!AuuaQ86D.trim().equals("=>") && !AuuaQ86D.startsWith("Rule:"))) {
						D23j9awT += AuuaQ86D.trim();
						AuuaQ86D = gPiH0zXx.readLine();
					}
					for (Map.Entry<String, String> macro : nHCpUyBz.entrySet()) {
						D23j9awT = D23j9awT.replace("(" + macro.getKey() + ")", macro.getValue());
					}
					Transition FfnZvjgb = null;
					if (D23j9awT.length() > 0)
						FfnZvjgb = parse(IOz4p1r1, D23j9awT);
					String X2VpX91x = "";
					if (AuuaQ86D != null && !AuuaQ86D.startsWith("Rule:"))
						AuuaQ86D = gPiH0zXx.readLine();
					while (AuuaQ86D != null && !AuuaQ86D.trim().startsWith("Rule:")) {
						X2VpX91x += AuuaQ86D + "\n";
						AuuaQ86D = gPiH0zXx.readLine();
					}
					X2VpX91x = X2VpX91x.trim();
					Rule JQfT8wHm = null;
					if (X2VpX91x.equals("")) {
						JQfT8wHm = new RuleSimpleImpl(oIIwgiHB, FfnZvjgb, efakYrP0, oIIwgiHB);
					} else if (X2VpX91x.startsWith("[")) {
						String HMSt1hmO = X2VpX91x.substring(1, X2VpX91x.length() - 1).trim();
						if (HMSt1hmO.equals(""))
							HMSt1hmO = oIIwgiHB;
						JQfT8wHm = new RuleSimpleImpl(oIIwgiHB, FfnZvjgb, efakYrP0, HMSt1hmO);
					} else if (X2VpX91x.startsWith("{")) {
						X2VpX91x = X2VpX91x.substring(1, X2VpX91x.length() - 1);
						try {
							JQfT8wHm = compiler.compile(oIIwgiHB, efakYrP0, FfnZvjgb, X2VpX91x);
						} catch (Throwable kEGCH6AA) {
							System.out.println("\nSomething wicked this way comes...");
							kEGCH6AA.printStackTrace();
							kEGCH6AA.getCause().printStackTrace();
						}
					} else {
						System.err.println(
								"Unsupported type of RHS for rule '" + oIIwgiHB + "', rule will not be compiled");
					}
					if (JQfT8wHm != null) {
						JQfT8wHm.addRequired(jPTugC8C);
						JQfT8wHm.addProvided(WMVgWm3g);
						NpOSyHQh.add(JQfT8wHm);
					} else {
						System.err.println("No idea what happend but the rule instance is null!");
					}
				} else if (AuuaQ86D.startsWith("Import:")) {
					NpOSyHQh.addAll(parse(IOz4p1r1, new URL(CLJUi03b, AuuaQ86D.substring(7).trim())));
				}
				if (AuuaQ86D == null || !AuuaQ86D.trim().startsWith("Rule:"))
					AuuaQ86D = gPiH0zXx.readLine();
			}
		} finally {
			if (gPiH0zXx != null) {
				try {
					gPiH0zXx.close();
				} catch (IOException QVwzv8wO) {
				}
			}
		}
		return NpOSyHQh;
	}

}