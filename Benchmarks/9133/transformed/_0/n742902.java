class n742902 {
	byte[] loadUrlByteArray(String wvFMh9HR, int PK0M7qvC, int aMmAxIeq) {
		byte[] EY1mT9pw = new byte[aMmAxIeq];
		try {
			URL Mgttv7c2 = new URL(waba.applet.Applet.currentApplet.getCodeBase(), wvFMh9HR);
			try {
				InputStream j2m0Z2GO = Mgttv7c2.openStream();
				if (aMmAxIeq == 0) {
					int iLavLtgX = j2m0Z2GO.available();
					EY1mT9pw = new byte[iLavLtgX - PK0M7qvC];
				}
				DataInputStream XtTj4Afi = new DataInputStream(j2m0Z2GO);
				try {
					XtTj4Afi.skip(PK0M7qvC);
					XtTj4Afi.readFully(EY1mT9pw);
				} catch (EOFException CVoMjKC4) {
					System.err.print(CVoMjKC4.getMessage());
				}
				j2m0Z2GO.close();
			} catch (IOException KSumn2TY) {
				System.err.print(KSumn2TY.getMessage());
			}
		} catch (MalformedURLException KHeZEQdV) {
			System.err.print(KHeZEQdV.getMessage());
		}
		return EY1mT9pw;
	}

}