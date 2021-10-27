class n7531749 {
	public void getLyricsFromMAWebSite(TrackMABean tb) throws Exception {
		URL fileURL = new URL("http://www.metal-archives.com/viewlyrics.php?id=" + tb.getMaid());
		URLConnection urlConnection = fileURL.openConnection();
		InputStream httpStream = urlConnection.getInputStream();
		String ligne;
		BufferedReader br = new BufferedReader(new InputStreamReader(httpStream, "ISO-8859-1"));
		StringBuffer sb = new StringBuffer("");
		boolean chargerLyrics = false;
		while ((ligne = br.readLine()) != null) {
			log.debug("==> " + ligne);
			if (chargerLyrics && ligne.indexOf("<center>") != -1) {
				break;
			}
			if (chargerLyrics) {
				sb.append(ligne.trim());
			}
			if (!chargerLyrics && ligne.indexOf("<center>") != -1) {
				chargerLyrics = true;
			}
		}
		String lyrics = null;
		lyrics = sb.toString();
		lyrics = lyrics.replaceAll("<br>", "\n").trim();
		log.debug("Parole : " + lyrics);
		tb.setLyrics(lyrics);
		br.close();
		httpStream.close();
	}

}