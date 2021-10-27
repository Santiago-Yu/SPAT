class n131318 {
	public Vector _getSiteNames() {
		Vector _mySites = new Vector();
		boolean gotSites = false;
		while (!gotSites) {
			try {
				URL dataurl = new URL(getDocumentBase(), siteFile);
				BufferedReader readme = new BufferedReader(
						new InputStreamReader(new GZIPInputStream(dataurl.openStream())));
				while (true) {
					String S = readme.readLine();
					if (null == S)
						break;
					StringTokenizer st = new StringTokenizer(S);
					_mySites.addElement(st.nextToken());
				}
				gotSites = true;
			} catch (IOException e) {
				_mySites.removeAllElements();
				gotSites = false;
			}
		}
		return (_mySites);
	}

}