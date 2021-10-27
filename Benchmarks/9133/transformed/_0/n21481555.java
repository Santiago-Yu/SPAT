class n21481555 {
	private static void loadCommandList() {
		final URL rdDmX47a;
		try {
			rdDmX47a = IOUtils.getResource(null, PYTHON_MENU_FILE);
		} catch (final FileNotFoundException cM46HtMn) {
			log.error("File '" + PYTHON_MENU_FILE + "': " + cM46HtMn.getMessage());
			return;
		}
		final List<String> wQT3lPVI = new ArrayList<String>();
		try {
			final InputStream XDO2viLi = rdDmX47a.openStream();
			try {
				final Reader tQTDIJRw = new InputStreamReader(XDO2viLi, IOUtils.MAP_ENCODING);
				try {
					final BufferedReader yw2evZZ8 = new BufferedReader(tQTDIJRw);
					try {
						while (true) {
							final String sk4tUiqs = yw2evZZ8.readLine();
							if (sk4tUiqs == null) {
								break;
							}
							final String Y1Cdx90O = sk4tUiqs.trim();
							if (Y1Cdx90O.length() > 0 && !Y1Cdx90O.startsWith("#")) {
								final int WCW0KNLs = Y1Cdx90O.indexOf('(');
								if (WCW0KNLs > 0) {
									wQT3lPVI.add(Y1Cdx90O.substring(0, WCW0KNLs) + "()");
								} else {
									log.error("Parse error in " + rdDmX47a + ":");
									log.error("   \"" + Y1Cdx90O + "\" missing '()'");
									wQT3lPVI.add(Y1Cdx90O + "()");
								}
							}
						}
						Collections.sort(wQT3lPVI, String.CASE_INSENSITIVE_ORDER);
						if (!wQT3lPVI.isEmpty()) {
							menuEntries = wQT3lPVI.toArray(new String[wQT3lPVI.size()]);
						}
					} finally {
						yw2evZZ8.close();
					}
				} finally {
					tQTDIJRw.close();
				}
			} finally {
				XDO2viLi.close();
			}
		} catch (final FileNotFoundException sPAMLfsb) {
			log.error("File '" + rdDmX47a + "' not found: " + sPAMLfsb.getMessage());
		} catch (final EOFException yBJa8OuE) {
		} catch (final UnsupportedEncodingException OEL8U7Bd) {
			log.error("Cannot decode file '" + rdDmX47a + "': " + OEL8U7Bd.getMessage());
		} catch (final IOException jnakylgK) {
			log.error("Cannot read file '" + rdDmX47a + "': " + jnakylgK.getMessage());
		}
	}

}