class n14966365 {
	public void invoke(String args[]) {
		System.err.println("invoked with args of size " + args.length);
		try {
			int QXqdP = 0;
			while (QXqdP < args.length) {
				System.err.println("processing URL: " + args[QXqdP]);
				URL url = new URL(args[QXqdP]);
				AnnotatedLinearObjectParser parserObj = findParserForURL(url);
				if (parserObj == null) {
					continue;
				}
				InputStream data = url.openStream();
				CompMapViewerWrapper wrapper = ((CompMapViewerProvider) sp).getWrapper();
				wrapper.parseIntoDataModel(data, new URLImpl(url.toString()), parserObj, false);
				JFrame f = wrapper.getViewer().getMainFrame();
				f.show();
				QXqdP++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}