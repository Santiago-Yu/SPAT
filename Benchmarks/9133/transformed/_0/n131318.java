class n131318 {
	public Vector _getSiteNames() {
		Vector ifaNqtmk = new Vector();
		boolean p8oMcPjp = false;
		while (!p8oMcPjp) {
			try {
				URL QmV1c2iA = new URL(getDocumentBase(), siteFile);
				BufferedReader iLOM4RWX = new BufferedReader(
						new InputStreamReader(new GZIPInputStream(QmV1c2iA.openStream())));
				while (true) {
					String UB6i366o = iLOM4RWX.readLine();
					if (UB6i366o == null)
						break;
					StringTokenizer hwzz1RdL = new StringTokenizer(UB6i366o);
					ifaNqtmk.addElement(hwzz1RdL.nextToken());
				}
				p8oMcPjp = true;
			} catch (IOException nyrnmGpH) {
				ifaNqtmk.removeAllElements();
				p8oMcPjp = false;
			}
		}
		return (ifaNqtmk);
	}

}