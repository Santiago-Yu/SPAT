class n8075979 {
	private URLConnection tryOpenConnection(String JIlkamA1) throws RuntimeException {
		URLConnection JoGi9z6H = null;
		try {
			JoGi9z6H = new URL("https://" + JIlkamA1).openConnection();
			JoGi9z6H.getInputStream();
			JoGi9z6H = new URL("https://" + JIlkamA1).openConnection();
			return JoGi9z6H;
		} catch (Exception hWqZEsOD) {
			Log.w("ERROR", " " + hWqZEsOD.getStackTrace()[0]);
		}
		try {
			JoGi9z6H = new URL("http://" + JIlkamA1).openConnection();
			JoGi9z6H.getInputStream();
			JoGi9z6H = new URL("http://" + JIlkamA1).openConnection();
			return JoGi9z6H;
		} catch (Exception Y2gPaoVa) {
			Log.w("ERROR", " " + Y2gPaoVa.getStackTrace()[0]);
		}
		return null;
	}

}