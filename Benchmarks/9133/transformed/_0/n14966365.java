class n14966365 {
	public void invoke(String CtglVrSZ[]) {
		System.err.println("invoked with args of size " + CtglVrSZ.length);
		try {
			for (int zx3U8566 = 0; zx3U8566 < CtglVrSZ.length; zx3U8566++) {
				System.err.println("processing URL: " + CtglVrSZ[zx3U8566]);
				URL fUNDeYs0 = new URL(CtglVrSZ[zx3U8566]);
				AnnotatedLinearObjectParser n2NkBpY2 = findParserForURL(fUNDeYs0);
				if (n2NkBpY2 == null) {
					continue;
				}
				InputStream xLIiOa9l = fUNDeYs0.openStream();
				CompMapViewerWrapper S1g7ho6S = ((CompMapViewerProvider) sp).getWrapper();
				S1g7ho6S.parseIntoDataModel(xLIiOa9l, new URLImpl(fUNDeYs0.toString()), n2NkBpY2, false);
				JFrame JyTmW3sC = S1g7ho6S.getViewer().getMainFrame();
				JyTmW3sC.show();
			}
		} catch (Exception gRNDwHte) {
			gRNDwHte.printStackTrace();
		}
	}

}