class n131318 {
	public Vector _getSiteNames() {
		boolean gotSites = false;
		Vector _mySites = new Vector();
		while (!gotSites) {
			try {
				URL dataurl = new URL(getDocumentBase(), siteFile);
				BufferedReader readme = new BufferedReader(
						new InputStreamReader(new GZIPInputStream(dataurl.openStream())));
				gotSites = true;
				while (true) {
					String S = readme.readLine();
					if (S == null)
						break;
					StringTokenizer st = new StringTokenizer(S);
					_mySites.addElement(st.nextToken());
				}
			} catch (IOException e) {
				_mySites.removeAllElements();
				gotSites = false;
			}
		}
		return (_mySites);
	}

}