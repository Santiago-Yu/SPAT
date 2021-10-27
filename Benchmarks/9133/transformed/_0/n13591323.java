class n13591323 {
	private void downloadFiles() throws SocketException, IOException {
		HashSet<String> W8WU6VOR = new HashSet<String>();
		boolean pMAIWMim = false;
		FTPClient Egf3J3PJ = new FTPClient();
		for (String UtUnUEli : downloadFiles) {
			W8WU6VOR.add(UtUnUEli);
			if (UtUnUEli.contains(WILDCARD_WORD) || UtUnUEli.contains(WILDCARD_DIGIT))
				pMAIWMim = true;
		}
		Egf3J3PJ.connect(source.getHost());
		Egf3J3PJ.login(username, password);
		FTPFile[] IecOxZvb = Egf3J3PJ.listFiles(source.getPath());
		if (!pMAIWMim) {
			for (FTPFile a5aF2KMN : IecOxZvb) {
				String iwF234dt = a5aF2KMN.getName();
				if (W8WU6VOR.contains(iwF234dt)) {
					long AZlpDAVu = a5aF2KMN.getSize() / 1024;
					Calendar Att8cnyk = a5aF2KMN.getTimestamp();
					URL iWS0Us74 = new File(source + a5aF2KMN.getName()).toURI().toURL();
					DownloadQueue.add(new Download(projectName, parser.getParserID(), iWS0Us74, AZlpDAVu, Att8cnyk,
							target + a5aF2KMN.getName()));
				}
			}
		} else {
			for (FTPFile Z57cHFmV : IecOxZvb) {
				String gWGCNS9F = Z57cHFmV.getName();
				boolean zrMVWuAK = false;
				for (String CsCsV22a : downloadFiles) {
					CsCsV22a = CsCsV22a.replaceAll("\\" + WILDCARD_WORD, WILDCARD_WORD_PATTERN);
					CsCsV22a = CsCsV22a.replaceAll("\\" + WILDCARD_DIGIT, WILDCARD_DIGIT_PATTERN);
					Pattern ucou0XOm = Pattern.compile(CsCsV22a);
					Matcher sLYt1JYG = ucou0XOm.matcher(gWGCNS9F);
					zrMVWuAK = sLYt1JYG.matches();
				}
				if (zrMVWuAK) {
					long Q9sib67q = Z57cHFmV.getSize() / 1024;
					Calendar Y5TnIfee = Z57cHFmV.getTimestamp();
					URL rBieD3VV = new File(source + Z57cHFmV.getName()).toURI().toURL();
					DownloadQueue.add(new Download(projectName, parser.getParserID(), rBieD3VV, Q9sib67q, Y5TnIfee,
							target + Z57cHFmV.getName()));
				}
			}
		}
	}

}