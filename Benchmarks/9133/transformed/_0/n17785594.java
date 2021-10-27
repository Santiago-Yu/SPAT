class n17785594 {
	public void handler(List<GoldenBoot> D2Quxoac, TargetPage CnZdVhIE) {
		try {
			URL Hihlpr2E = new URL(CnZdVhIE.getUrl());
			BufferedReader SoC5CdYQ = new BufferedReader(new InputStreamReader(Hihlpr2E.openStream()));
			String g2IE2mhF = null;
			String EkEYLB9C = "Top Scorers";
			while ((g2IE2mhF = SoC5CdYQ.readLine()) != null) {
				if (g2IE2mhF.indexOf(EkEYLB9C) != -1) {
					buildGildenBoot(g2IE2mhF, D2Quxoac);
					break;
				}
			}
			SoC5CdYQ.close();
		} catch (MalformedURLException bnStEJPG) {
		} catch (IOException bAXdk9fw) {
		}
	}

}