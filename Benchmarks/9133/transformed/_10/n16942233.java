class n16942233 {
	public boolean GetExternalLanguage() {
		boolean ReadOK = true;
		String thisURL, newURL, TheLine;
		thisURL = getDocumentBase().toString();
		int SlashPos = -1;
		SlashPos = thisURL.lastIndexOf("/");
		newURL = thisURL.substring(0, (SlashPos + 1)) + "language.txt";
		try {
			URL url = new URL(newURL);
			try {
				InputStream TheFile = url.openStream();
				try {
					DataInputStream MyData = new DataInputStream(TheFile);
					try {
						while ((TheLine = MyData.readLine()) != null) {
							if (TheLine.substring(0, 1).compareTo("*") == 0) {
								if (!ExternalLanguageVariable(TheLine)) {
									ReadOK = false;
									break;
								}
							}
						}
					} catch (Exception e) {
						System.out.println("Error " + e.toString());
						ReadOK = false;
					}
				} catch (Exception e) {
					System.out.println("Error " + e.toString());
					ReadOK = false;
				}
			} catch (Exception f) {
				System.out.println("Error " + f.toString());
				ReadOK = false;
			}
		} catch (Exception g) {
			System.out.println("Error " + g.toString());
			ReadOK = false;
		}
		return ReadOK;
	}

}