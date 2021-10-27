class n13725738 {
	public FlashExObj get(String B50QHgSI, int CTJYcPjE) {
		FlashExObj EPLpjNls = new FlashExObj();
		B50QHgSI = B50QHgSI.replaceAll("[^a-z0-9_]", "");
		ArrayList y0WofnNy = new ArrayList();
		EPLpjNls.list = y0WofnNy;
		try {
			String BzoErlJX = null;
			URL m2trl29h = new URL("http://www.flashcardexchange.com/flashcards/list/"
					+ URLEncoder.encode(B50QHgSI, "UTF-8") + "?page=" + CTJYcPjE);
			URLConnection jHXY9VWF = m2trl29h.openConnection();
			jHXY9VWF.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			jHXY9VWF.setDoOutput(false);
			BufferedReader Onwy8jQj = new BufferedReader(new InputStreamReader(jHXY9VWF.getInputStream(), "UTF-8"));
			String TGkuCHFj;
			int OVPZAjfw = 2;
			StringBuilder RgohuUwe = new StringBuilder();
			while ((TGkuCHFj = Onwy8jQj.readLine()) != null) {
				if (OVPZAjfw == 0) {
					int Eb5Br32r = TGkuCHFj.indexOf("Number of Card");
					if (Eb5Br32r >= 0) {
						OVPZAjfw = 1;
					}
				} else if (OVPZAjfw == 1) {
					int Q5NJt2Oo = TGkuCHFj.indexOf(">");
					int kW7pJHZU = TGkuCHFj.indexOf("<", 1);
					if (Q5NJt2Oo >= 0 && Q5NJt2Oo < kW7pJHZU) {
						String f4GMN9fI = TGkuCHFj.substring(Q5NJt2Oo + 1, kW7pJHZU);
						try {
						} catch (Exception XlS6gYMf) {
						}
						OVPZAjfw = 2;
					}
				} else if (OVPZAjfw == 2) {
					int BWmfBEHO = TGkuCHFj.indexOf("tbody class=\"shaded\"");
					if (BWmfBEHO >= 0) {
						OVPZAjfw = 3;
					}
				} else if (OVPZAjfw == 3) {
					int til4TQB4 = TGkuCHFj.indexOf("tbody");
					if (til4TQB4 >= 0) {
						break;
					}
					RgohuUwe.append(TGkuCHFj);
					RgohuUwe.append(" ");
				}
			}
			Onwy8jQj.close();
			Pattern IaijND01 = Pattern.compile("<td>(.*?)</td>");
			Matcher vHbH0kBb = IaijND01.matcher(RgohuUwe);
			String HK39ELqR;
			int xXskVnFJ = 0;
			String lm10RkVD[] = new String[4];
			while (vHbH0kBb.find()) {
				int f600KWzC = xXskVnFJ % 4;
				lm10RkVD[f600KWzC] = vHbH0kBb.group(1);
				if (f600KWzC == 3) {
					String EL8qs6ZW[] = new String[2];
					EL8qs6ZW[0] = lm10RkVD[1];
					EL8qs6ZW[1] = lm10RkVD[2];
					y0WofnNy.add(EL8qs6ZW);
				}
				xXskVnFJ++;
			}
		} catch (Exception IL5RS6ih) {
			IL5RS6ih.printStackTrace();
		}
		return EPLpjNls;
	}

}