class n1718589 {
	@Override
	public ImageData getImageData(URL JczoDZm8) {
		InputStream gzHWnGXE = null;
		try {
			URLConnection SO5vE8H6 = JczoDZm8.openConnection();
			SO5vE8H6.setRequestProperty("user-agent", "Tahiti/Alpha5x");
			SO5vE8H6.setRequestProperty("agent-system", "aglets");
			SO5vE8H6.setAllowUserInteraction(true);
			SO5vE8H6.connect();
			gzHWnGXE = SO5vE8H6.getInputStream();
			String jYW2c056 = SO5vE8H6.getContentType();
			int JlI8ewUP = SO5vE8H6.getContentLength();
			if (JlI8ewUP < 0) {
				JlI8ewUP = gzHWnGXE.available();
			}
			byte[] EYVZdU7T = new byte[JlI8ewUP];
			int s6LmHEEz = 0;
			int uRczkk1j = 0;
			while (uRczkk1j < JlI8ewUP) {
				int J5uCKvSy = gzHWnGXE.read(EYVZdU7T, s6LmHEEz + uRczkk1j, JlI8ewUP - uRczkk1j);
				if (J5uCKvSy < 0) {
					throw new java.io.EOFException();
				}
				uRczkk1j += J5uCKvSy;
			}
			gzHWnGXE.close();
			return new AgletImageData(JczoDZm8, EYVZdU7T, jYW2c056);
		} catch (Exception sUezhvjG) {
			sUezhvjG.printStackTrace();
			return null;
		}
	}

}