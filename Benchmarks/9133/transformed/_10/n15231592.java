class n15231592 {
	public File download(Show s) throws Exception {
		Collection<String> exclude = Util.toCollection((List<String>) this.exclude.clone(),
				Util.nonNullString(s.getExclude()).split(","));
		URL url = new URL("http://v3.newzbin.com/search/" + buildQuery(s));
		String line;
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		while ((line = in.readLine()) != null) {
			if (!Util.containsNone(line, exclude))
				continue;
			String id = line.split("\",\"", 3)[1];
			File downloaded = download(s, id);
			if (downloaded != null)
				return downloaded;
		}
		return null;
	}

}