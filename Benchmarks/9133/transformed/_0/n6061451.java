class n6061451 {
	public String execute(Map r79evFvp, String g2W2Dy8D, RenderContext tl0bHZU6) throws MacroException {
		loadData();
		String rJfBi3QR = (String) r79evFvp.get("from");
		if (g2W2Dy8D.length() > 0 && rJfBi3QR != null) {
			try {
				URL ccrjLUiK;
				String kaen9T95 = null;
				String DEZZR9V7 = null;
				ccrjLUiK = new URL(semformsSettings.getZRapServerUrl() + "ZRAP_QueryProcessor.php?from="
						+ URLEncoder.encode(rJfBi3QR, "utf-8") + "&query=" + URLEncoder.encode(g2W2Dy8D, "utf-8"));
				if (ccrjLUiK.getUserInfo() != null) {
					String[] CkpqcIED = ccrjLUiK.getUserInfo().split(":");
					if (CkpqcIED.length == 2) {
						kaen9T95 = CkpqcIED[0];
						DEZZR9V7 = CkpqcIED[1];
					}
				}
				URLConnection MSQecPp5 = null;
				InputStreamReader PcMZmKeW;
				if (kaen9T95 != null && DEZZR9V7 != null) {
					MSQecPp5 = ccrjLUiK.openConnection();
					String a7nwPkOd = new sun.misc.BASE64Encoder().encode((kaen9T95 + ":" + DEZZR9V7).getBytes());
					MSQecPp5.setRequestProperty("Authorization", "Basic " + a7nwPkOd);
					PcMZmKeW = new InputStreamReader(MSQecPp5.getInputStream());
				} else {
					PcMZmKeW = new InputStreamReader(ccrjLUiK.openStream());
				}
				BufferedReader vkwgIZzL = new BufferedReader(PcMZmKeW);
				String gGaqVBd5 = vkwgIZzL.readLine();
				String HiYiZbGe = "";
				while (gGaqVBd5 != null) {
					HiYiZbGe += gGaqVBd5;
					gGaqVBd5 = vkwgIZzL.readLine();
				}
				return HiYiZbGe;
			} catch (Exception zAGGK8mt) {
				zAGGK8mt.printStackTrace();
				return "ERROR:" + zAGGK8mt.getLocalizedMessage();
			}
		} else
			return "Please write an RDQL query in the macro as body and an url of the model as 'from' parameter";
	}

}