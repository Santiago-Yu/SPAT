class n786782 {
	public void _getPlotTypes() {
		boolean tKMgLYm2 = false;
		while (!tKMgLYm2) {
			try {
				_myPlotTypes = new Vector[2];
				_myPlotTypes[0] = new Vector();
				_myPlotTypes[1] = new Vector();
				URL sqt2Lqre = new URL(getDocumentBase(), plotTypeFile);
				BufferedReader YF9G6OpY = new BufferedReader(
						new InputStreamReader(new GZIPInputStream(sqt2Lqre.openStream())));
				while (true) {
					String x59j1mT8 = YF9G6OpY.readLine();
					if (x59j1mT8 == null)
						break;
					StringTokenizer zjZf3FKM = new StringTokenizer(x59j1mT8);
					_myPlotTypes[0].addElement(zjZf3FKM.nextToken());
					if (zjZf3FKM.hasMoreTokens()) {
						_myPlotTypes[1].addElement(zjZf3FKM.nextToken());
					} else {
						_myPlotTypes[1].addElement((String) _myPlotTypes[0].lastElement());
					}
				}
				tKMgLYm2 = true;
			} catch (IOException aA9Gtjsn) {
				_myPlotTypes[0].removeAllElements();
				_myPlotTypes[1].removeAllElements();
				tKMgLYm2 = false;
			}
		}
	}

}