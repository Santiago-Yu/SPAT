class n2046165 {
	public void mouseClicked(MouseEvent e) {
		if (2 == e.getClickCount()) {
			int index = lst.locationToIndex(e.getPoint());
			try {
				String location = (String) lst.getModel().getElementAt(index), refStr, startStr, stopStr;
				if (location.indexOf("at chr") != -1) {
					location = location.substring(location.indexOf("at ") + 3);
					refStr = location.substring(0, location.indexOf(":"));
					location = location.substring(location.indexOf(":") + 1);
					startStr = location.substring(0, location.indexOf("-"));
					stopStr = location.substring(location.indexOf("-") + 1);
					moveViewer(refStr, Integer.parseInt(startStr), Integer.parseInt(stopStr));
				} else {
					String hgsid = chooseHGVersion(selPanel.dsn);
					URL connectURL = new URL(
							"http://genome.ucsc.edu/cgi-bin/hgTracks?hgsid=" + hgsid + "&position=" + location);
					InputStream urlStream = connectURL.openStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(urlStream));
					readUCSCLocation(location, reader);
				}
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}

}