class n786782 {
	public void _getPlotTypes() {
		boolean gotPlots = false;
		while (!gotPlots) {
			try {
				_myPlotTypes = new Vector[2];
				_myPlotTypes[0] = new Vector();
				_myPlotTypes[1] = new Vector();
				URL dataurl = new URL(getDocumentBase(), plotTypeFile);
				BufferedReader readme = new BufferedReader(
						new InputStreamReader(new GZIPInputStream(dataurl.openStream())));
				gotPlots = true;
				while (true) {
					String S = readme.readLine();
					if (S == null)
						break;
					StringTokenizer st = new StringTokenizer(S);
					_myPlotTypes[0].addElement(st.nextToken());
					if (st.hasMoreTokens()) {
						_myPlotTypes[1].addElement(st.nextToken());
					} else {
						_myPlotTypes[1].addElement((String) _myPlotTypes[0].lastElement());
					}
				}
			} catch (IOException e) {
				_myPlotTypes[0].removeAllElements();
				_myPlotTypes[1].removeAllElements();
				gotPlots = false;
			}
		}
	}

}