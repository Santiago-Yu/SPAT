class n20024612 {
	private void parse() throws Exception {
		BufferedReader yY2ffqLu = null;
		InputStream Z6wRTd7S = null;
		URL sX5WRFba = new URL(url);
		URLConnection PnLmzl56 = sX5WRFba.openConnection();
		Z6wRTd7S = PnLmzl56.getInputStream();
		yY2ffqLu = new BufferedReader(new InputStreamReader(Z6wRTd7S, "UTF-8"));
		String hMOwWdR6;
		String IoADYGvK;
		String GnBrxdaf;
		String Xp7CWrCx;
		String eTEgqmXX;
		String pzvKPaQn;
		while ((hMOwWdR6 = yY2ffqLu.readLine()) != null) {
			if (hMOwWdR6.indexOf("div class=\"post\" id=\"post") != -1) {
				IoADYGvK = null;
				GnBrxdaf = null;
				Xp7CWrCx = null;
				try {
					IoADYGvK = hMOwWdR6.substring(hMOwWdR6.indexOf("post-") + 5,
							hMOwWdR6.indexOf("\"", hMOwWdR6.indexOf("post-")));
					hMOwWdR6 = yY2ffqLu.readLine();
					GnBrxdaf = hMOwWdR6.substring(hMOwWdR6.indexOf("<div class=\"date\"><span>") + 24);
					GnBrxdaf = GnBrxdaf.replaceAll("</span>", "").replaceAll("</div>", "").trim();
					log.info("Post   : " + IoADYGvK + " du " + GnBrxdaf);
					hMOwWdR6 = yY2ffqLu.readLine();
					hMOwWdR6 = yY2ffqLu.readLine();
					Xp7CWrCx = hMOwWdR6.substring(hMOwWdR6.indexOf(">", hMOwWdR6.indexOf("title")) + 1,
							hMOwWdR6.indexOf("</a>"));
					Xp7CWrCx = Xp7CWrCx.replaceAll("&#8217;", "'").replaceAll("&#8220;", "\"").replaceAll("&#8221;",
							"\"");
					pzvKPaQn = hMOwWdR6.substring(hMOwWdR6.indexOf("<a href=\"") + 9, hMOwWdR6.indexOf("/\"")).trim();
					pzvKPaQn = pzvKPaQn.replace("mega-films.net", "mega-protect.com") + ".php";
					log.info("Titre  : " + Xp7CWrCx);
					log.info("To DL  : " + pzvKPaQn);
					hMOwWdR6 = yY2ffqLu.readLine();
					hMOwWdR6 = yY2ffqLu.readLine();
					hMOwWdR6 = yY2ffqLu.readLine();
					hMOwWdR6 = yY2ffqLu.readLine();
					hMOwWdR6 = yY2ffqLu.readLine();
					hMOwWdR6 = yY2ffqLu.readLine();
					hMOwWdR6 = yY2ffqLu.readLine();
					eTEgqmXX = hMOwWdR6.substring(hMOwWdR6.indexOf("<em>") + 4, hMOwWdR6.indexOf("</em>"));
					eTEgqmXX = eTEgqmXX.replaceAll("&#8217;", "'").replaceAll("&#8220;", "\"").replaceAll("&#8221;",
							"\"");
					log.info("Resume : " + eTEgqmXX);
				} catch (Exception PAJlOzwG) {
					log.error("ERREUR : Le film n'a pas pu etre parse...");
				}
				log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			}
		}
	}

}