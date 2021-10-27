class n22022886 {
	public static String fetchURL(final String t8O2KHJD) {
		String m8Sp6qYf = "";
		try {
			final URL sYlDUYML = new URL(t8O2KHJD);
			final BufferedReader InwHrpOg = new BufferedReader(new InputStreamReader(sYlDUYML.openStream()));
			String uyhx5dUu;
			while ((uyhx5dUu = InwHrpOg.readLine()) != null) {
				m8Sp6qYf += uyhx5dUu;
			}
			InwHrpOg.close();
		} catch (final MalformedURLException PcUYrWhn) {
			logger.severe("MalformedURLException calling url" + PcUYrWhn.getMessage());
		} catch (final IOException DER0SoWw) {
			logger.severe("IOException calling url" + DER0SoWw.getMessage());
		}
		return m8Sp6qYf;
	}

}