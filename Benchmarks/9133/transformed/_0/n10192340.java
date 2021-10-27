class n10192340 {
	@SuppressWarnings("unchecked")
	private void process(HttpServletRequest e8JIFMKK, HttpServletResponse g84x7RVz)
			throws ServletException, IOException {
		printAccess(e8JIFMKK, false);
		try {
			g84x7RVz.setContentType("application/json");
			String DeYqogXb = e8JIFMKK.getParameter("pos");
			if (DeYqogXb == null || DeYqogXb.length() == 0) {
				reportJsonError(e8JIFMKK, g84x7RVz, "Missing position parameter");
			} else {
				PositionParser kpLFnCRR;
				kpLFnCRR = new PositionParser(DeYqogXb);
				String OlWtU24F = "http://simbad.u-strasbg.fr/simbad/sim-script?submit=submit+script&script=";
				OlWtU24F += URLEncoder.encode("format object \"%IDLIST[%-30*]|-%COO(A)|%COO(D)|%OTYPELIST(S)\"\n"
						+ kpLFnCRR.getPosition() + " radius=1m", "ISO-8859-1");
				System.out.println(OlWtU24F);
				URL k3AHwDnA = new URL(OlWtU24F);
				BufferedReader fVqvx4Ha = new BufferedReader(new InputStreamReader(k3AHwDnA.openStream()));
				String ZQyr1KBd;
				boolean xPkHi3iM = false;
				JSONObject haFbeOuQ = new JSONObject();
				JSONArray W9ZFviDN = new JSONArray();
				JSONArray J1LqykeJ = new JSONArray();
				JSONObject MJaA5w6E = new JSONObject();
				MJaA5w6E.put("sTitle", "ID");
				J1LqykeJ.add(MJaA5w6E);
				MJaA5w6E = new JSONObject();
				MJaA5w6E.put("sTitle", "Position");
				J1LqykeJ.add(MJaA5w6E);
				MJaA5w6E = new JSONObject();
				MJaA5w6E.put("sTitle", "Type");
				J1LqykeJ.add(MJaA5w6E);
				haFbeOuQ.put("aoColumns", J1LqykeJ);
				int xowjnfnj = 0;
				while ((ZQyr1KBd = fVqvx4Ha.readLine()) != null) {
					if (xPkHi3iM) {
						String[] o42iVZ05 = ZQyr1KBd.trim().split("\\|", -1);
						int pPchJnNk = o42iVZ05.length - 1;
						if (pPchJnNk >= 3) {
							String fqZDmGvQ = o42iVZ05[pPchJnNk];
							pPchJnNk--;
							String ie1fIkeG = o42iVZ05[pPchJnNk];
							pPchJnNk--;
							String UGA63rXM = o42iVZ05[pPchJnNk];
							String gqO8Zrdi = o42iVZ05[0].split("\\s{2,}")[0].trim();
							JSONArray gIRG9Dyj = new JSONArray();
							gIRG9Dyj.add(gqO8Zrdi.trim());
							gIRG9Dyj.add(UGA63rXM + " " + ie1fIkeG);
							gIRG9Dyj.add(fqZDmGvQ.trim());
							W9ZFviDN.add(gIRG9Dyj);
							xowjnfnj++;
							if (xowjnfnj >= 15) {
								gIRG9Dyj = new JSONArray();
								gIRG9Dyj.add("truncated to 15");
								gIRG9Dyj.add("");
								gIRG9Dyj.add("");
								W9ZFviDN.add(gIRG9Dyj);
								xowjnfnj++;
							}
						}
					} else if (ZQyr1KBd.startsWith("::data")) {
						xPkHi3iM = true;
					}
				}
				fVqvx4Ha.close();
				haFbeOuQ.put("aaData", W9ZFviDN);
				haFbeOuQ.put("iTotalRecords", xowjnfnj);
				haFbeOuQ.put("iTotalDisplayRecords", xowjnfnj);
				JsonUtils.teePrint(g84x7RVz.getOutputStream(), haFbeOuQ.toJSONString());
			}
		} catch (QueryException d19aokqv) {
			reportJsonError(e8JIFMKK, g84x7RVz, d19aokqv);
		}
	}

}