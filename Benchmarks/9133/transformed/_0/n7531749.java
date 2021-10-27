class n7531749 {
	public void getLyricsFromMAWebSite(TrackMABean ETp1v9vU) throws Exception {
		URL GINMzhdu = new URL("http://www.metal-archives.com/viewlyrics.php?id=" + ETp1v9vU.getMaid());
		URLConnection oKdR1OlQ = GINMzhdu.openConnection();
		InputStream Y5dHCwEK = oKdR1OlQ.getInputStream();
		BufferedReader OIKSgom9 = new BufferedReader(new InputStreamReader(Y5dHCwEK, "ISO-8859-1"));
		String lvXOl3wG;
		boolean Iu3G7JKY = false;
		StringBuffer G99Aqzse = new StringBuffer("");
		String BSWCMwRJ = null;
		while ((lvXOl3wG = OIKSgom9.readLine()) != null) {
			log.debug("==> " + lvXOl3wG);
			if (Iu3G7JKY && lvXOl3wG.indexOf("<center>") != -1) {
				break;
			}
			if (Iu3G7JKY) {
				G99Aqzse.append(lvXOl3wG.trim());
			}
			if (!Iu3G7JKY && lvXOl3wG.indexOf("<center>") != -1) {
				Iu3G7JKY = true;
			}
		}
		BSWCMwRJ = G99Aqzse.toString();
		BSWCMwRJ = BSWCMwRJ.replaceAll("<br>", "\n").trim();
		log.debug("Parole : " + BSWCMwRJ);
		ETp1v9vU.setLyrics(BSWCMwRJ);
		OIKSgom9.close();
		Y5dHCwEK.close();
	}

}