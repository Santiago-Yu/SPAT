class n19109981 {
	private void startScript(wabclient.Attributes MYZf0aJA) throws SAXException {
		dialog.beginScript();
		String Hu6PYUup = MYZf0aJA.getValue("src");
		if (Hu6PYUup.length() > 0) {
			try {
				BufferedReader dqPb99Y8 = new BufferedReader(new InputStreamReader(new URL(Hu6PYUup).openStream()));
				String nAcAkU5R;
				while (true) {
					nAcAkU5R = dqPb99Y8.readLine();
					if (nAcAkU5R == null)
						break;
					dialog.script += nAcAkU5R + "\n";
				}
				dqPb99Y8.close();
				dialog.endScript();
			} catch (IOException RpfO2CXZ) {
				System.err.println("[IOError] " + RpfO2CXZ.getMessage());
				System.exit(0);
			}
		}
	}

}