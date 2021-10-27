class n13192161 {
	protected List<String[]> execute(String OjDCMBlS, String hpKGClJJ, String ptherXnA, String hhE1fb1q)
			throws Exception {
		String rprpJr5C = URLEncoder.encode(OjDCMBlS, "UTF-8");
		String KqRHSUt5 = "http://sparql.bibleontology.com/sparql.jsp?sparql=" + rprpJr5C + "&type1=xml";
		URL ESvxbat2;
		BufferedReader wLXpwpsH = null;
		ArrayList<String[]> eb0HALMi = new ArrayList<String[]>();
		try {
			ESvxbat2 = new URL(KqRHSUt5);
			URLConnection sas1l2lE = ESvxbat2.openConnection();
			wLXpwpsH = new BufferedReader(new InputStreamReader(sas1l2lE.getInputStream()));
			StringBuffer KKM7g3KZ = new StringBuffer();
			String NlpylR9o;
			String sLxoac0n = null;
			String V3AjHQJg = null;
			boolean Gy5VV3C8 = false;
			boolean BZ9Q2R80 = false;
			while ((NlpylR9o = wLXpwpsH.readLine()) != null) {
				if (NlpylR9o.indexOf("</result>") != -1) {
					if (sLxoac0n != null && V3AjHQJg != null) {
						String tFdXcIQH[] = { sLxoac0n, V3AjHQJg };
						eb0HALMi.add(tFdXcIQH);
					}
					sLxoac0n = null;
					V3AjHQJg = null;
					Gy5VV3C8 = false;
					BZ9Q2R80 = false;
				}
				if (NlpylR9o.indexOf("binding name=\"" + hpKGClJJ + "\"") != -1) {
					Gy5VV3C8 = true;
					continue;
				} else if (Gy5VV3C8) {
					String J4tXl2wI = getURI(NlpylR9o);
					if (J4tXl2wI != null) {
						J4tXl2wI = checkURISyntax(J4tXl2wI);
						if (hhE1fb1q == null || J4tXl2wI.startsWith(hhE1fb1q)) {
							sLxoac0n = J4tXl2wI;
						}
					}
					Gy5VV3C8 = false;
					continue;
				}
				if (NlpylR9o.indexOf("binding name=\"" + ptherXnA + "\"") != -1) {
					BZ9Q2R80 = true;
					continue;
				} else if (BZ9Q2R80) {
					String zD2TErn1 = getURI(NlpylR9o);
					if (zD2TErn1 != null) {
						zD2TErn1 = checkURISyntax(zD2TErn1);
						if (hhE1fb1q == null || zD2TErn1.startsWith(hhE1fb1q)) {
							V3AjHQJg = zD2TErn1;
						}
					}
					BZ9Q2R80 = false;
					continue;
				}
			}
		} catch (MalformedURLException m4IFpF8d) {
			m4IFpF8d.printStackTrace();
		} catch (IOException yPEpjqbg) {
			yPEpjqbg.printStackTrace();
		} finally {
			wLXpwpsH.close();
		}
		return eb0HALMi;
	}

}