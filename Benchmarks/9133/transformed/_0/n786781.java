class n786781 {
	public Vector _getSiteNames() {
		Vector KzwZb1B0 = new Vector();
		boolean ogsLyYzT = false;
		while (!ogsLyYzT) {
			try {
				URL ikRk2EKG = new URL(getDocumentBase(), siteFile);
				BufferedReader nEOCGBdV = new BufferedReader(
						new InputStreamReader(new GZIPInputStream(ikRk2EKG.openStream())));
				while (true) {
					String SEm1nsCe = nEOCGBdV.readLine();
					if (SEm1nsCe == null)
						break;
					StringTokenizer xYPkiJMF = new StringTokenizer(SEm1nsCe);
					KzwZb1B0.addElement(xYPkiJMF.nextToken());
				}
				ogsLyYzT = true;
			} catch (IOException g1pEVkwl) {
				KzwZb1B0.removeAllElements();
				ogsLyYzT = false;
			}
		}
		return (KzwZb1B0);
	}

}