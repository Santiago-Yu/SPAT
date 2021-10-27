class n11616716 {
	private static InputStream getCMSResultAsStream(String aN4TrN10) throws RQLException {
		OutputStreamWriter GL1lwJHG = null;
		try {
			URL DkhooN1u = new URL("http", HOST, FILE);
			URLConnection lA9TZ74j = DkhooN1u.openConnection();
			lA9TZ74j.setDoOutput(true);
			GL1lwJHG = new OutputStreamWriter(lA9TZ74j.getOutputStream());
			GL1lwJHG.write(aN4TrN10);
			GL1lwJHG.flush();
			return lA9TZ74j.getInputStream();
		} catch (IOException hPM8Qa8o) {
			throw new RQLException("IO Exception reading result from server", hPM8Qa8o);
		} finally {
			if (GL1lwJHG != null) {
				try {
					GL1lwJHG.close();
				} catch (IOException RQDDzAJa) {
				}
			}
		}
	}

}