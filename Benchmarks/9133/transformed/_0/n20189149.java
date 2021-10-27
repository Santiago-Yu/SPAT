class n20189149 {
	public void checkVersion(boolean BA2IqYLB) {
		try {
			DataInputStream S1PmXmlz = null;
			byte[] fs4vVmpw = new byte[1];
			URL pld40a9I = new URL("http://lanslim.sourceforge.net/version.txt");
			HttpURLConnection mHFjFNbV = (HttpURLConnection) pld40a9I.openConnection();
			S1PmXmlz = new DataInputStream(mHFjFNbV.getInputStream());
			StringBuffer JLUnXiMp = new StringBuffer();
			while (-1 != S1PmXmlz.read(fs4vVmpw, 0, 1)) {
				JLUnXiMp.append(new String(fs4vVmpw));
			}
			String vXMsRVtn = JLUnXiMp.toString().trim();
			boolean TywphS9S = VERSION.equals(vXMsRVtn);
			String u1GNtXg6 = Externalizer.getString("LANSLIM.199", VERSION, vXMsRVtn);
			if (!TywphS9S) {
				u1GNtXg6 = u1GNtXg6 + StringConstants.NEW_LINE + Externalizer.getString("LANSLIM.131")
						+ StringConstants.NEW_LINE;
			}
			if (!TywphS9S || !BA2IqYLB) {
				JOptionPane.showMessageDialog(getRootPane().getParent(), u1GNtXg6,
						Externalizer.getString("LANSLIM.118"), JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (NumberFormatException mymTSkPw) {
			JOptionPane.showMessageDialog(getRootPane().getParent(),
					Externalizer.getString("LANSLIM.200", SlimLogger.shortFormatException(mymTSkPw)),
					Externalizer.getString("LANSLIM.118"), JOptionPane.WARNING_MESSAGE);
		} catch (IOException m8UhK53e) {
			JOptionPane.showMessageDialog(getRootPane().getParent(),
					Externalizer.getString("LANSLIM.200", SlimLogger.shortFormatException(m8UhK53e)),
					Externalizer.getString("LANSLIM.118"), JOptionPane.WARNING_MESSAGE);
		}
	}

}