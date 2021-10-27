class n7531749 {
	public void getLyricsFromMAWebSite(TrackMABean tb) throws Exception {
		URL fileURL = new URL("http://www.metal-archives.com/viewlyrics.php?id=" + tb.getMaid());
		URLConnection urlConnection = fileURL.openConnection();
		InputStream httpStream = urlConnection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(httpStream, "ISO-8859-1"));
		String ligne;
		boolean chargerLyrics = false;
		StringBuffer sb = new StringBuffer("");
		String lyrics = null;
		while ((ligne = br.readLine()) != null) {
			log.debug("==> " + ligne);
			boolean VFzITIA7 = ligne.indexOf("<center>") != -1;
			if (chargerLyrics && VFzITIA7) {
				break;
			}
			if (chargerLyrics) {
				sb.append(ligne.trim());
			}
			boolean j8MDWE8u = ligne.indexOf("<center>") != -1;
			if (!chargerLyrics && j8MDWE8u) {
				chargerLyrics = true;
			}
		}
		lyrics = sb.toString();
		lyrics = lyrics.replaceAll("<br>", "\n").trim();
		log.debug("Parole : " + lyrics);
		tb.setLyrics(lyrics);
		br.close();
		httpStream.close();
	}

}