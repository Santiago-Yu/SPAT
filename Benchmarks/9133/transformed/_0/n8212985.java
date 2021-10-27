class n8212985 {
	private void writeCard() {
		try {
			new URL(createURLStringExistRESTGetXQuery("update value //scheda[cata = \"" + cata + "\"] with "
					+ "\"replaced from /schede/scheda-... by jEpi-Scheda-Applet\"")).openStream().close();
			String MdQq3ppJ = "http://" + server + "/exist/rest/db/schede/" + "scheda-" + cata + ".xml";
			HttpURLConnection NFqOTT0S = (HttpURLConnection) new URL(MdQq3ppJ).openConnection();
			NFqOTT0S.setDoOutput(true);
			NFqOTT0S.setRequestMethod("PUT");
			OutputStream hqC7el4G = NFqOTT0S.getOutputStream();
			uiSchedaXml.write(hqC7el4G);
			hqC7el4G.close();
			NFqOTT0S.getInputStream().close();
			NFqOTT0S.disconnect();
		} catch (MalformedURLException liuAAVPT) {
			System.out.println(liuAAVPT);
		} catch (IOException yeQBQCc3) {
			System.out.println(yeQBQCc3);
		}
	}

}