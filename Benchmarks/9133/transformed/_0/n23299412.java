class n23299412 {
	public List<String> getLinks(String yZqb2FDJ) {
		List<String> iHdkFuQV = new ArrayList<String>();
		try {
			BufferedReader Tg6FUlu7 = new BufferedReader(new InputStreamReader(new URL(yZqb2FDJ).openStream()));
			String BxmYLeXb;
			StringBuilder cvaWflqu = new StringBuilder();
			while ((BxmYLeXb = Tg6FUlu7.readLine()) != null) {
				cvaWflqu.append(BxmYLeXb);
			}
			Matcher cojKgHnm = htmltag.matcher(cvaWflqu.toString());
			while (cojKgHnm.find()) {
				Matcher nN6X7DbD = link.matcher(cojKgHnm.group());
				nN6X7DbD.find();
				String cguVRPPK = nN6X7DbD.group().replaceFirst("href=\"", "").replaceFirst("\">", "");
				if (valid(cguVRPPK)) {
					iHdkFuQV.add(makeAbsolute(yZqb2FDJ, cguVRPPK));
				}
			}
		} catch (MalformedURLException Pkn0S5N6) {
			Pkn0S5N6.printStackTrace();
		} catch (IOException C3rXbtsa) {
			C3rXbtsa.printStackTrace();
		}
		return iHdkFuQV;
	}

}