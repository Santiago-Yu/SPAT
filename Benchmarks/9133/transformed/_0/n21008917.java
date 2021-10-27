class n21008917 {
	private String determineGuardedHtml() {
		StringBuffer v7ty0prG = new StringBuffer();
		if (m_guardedButtonPresent) {
			v7ty0prG.append("\n<span id='" + getHtmlIdPrefix() + PUSH_PAGE_SUFFIX + "' style='display:none'>\n");
			String itwg3MUQ = m_guardedHtmlLocation != null ? m_guardedHtmlLocation
					: (String) Config.getProperty(Config.PROP_PRESENTATION_DEFAULT_GUARDED_HTML_LOCATION);
			String FWUnGNEr = (String) c_guardedHtmlCache.get(itwg3MUQ);
			if (FWUnGNEr == null) {
				if (log.isDebugEnabled())
					log.debug(this.NAME + ".determineGuardedHtml: Reading the Guarded Html Fragment: " + itwg3MUQ);
				URL iCoRljV4 = getUrl(itwg3MUQ);
				if (iCoRljV4 != null) {
					BufferedReader RsXP1njO = null;
					try {
						RsXP1njO = new BufferedReader(new InputStreamReader(iCoRljV4.openStream()));
						StringBuffer dr68JY5r = new StringBuffer();
						String JoVEEmrf = null;
						while ((JoVEEmrf = RsXP1njO.readLine()) != null) {
							dr68JY5r.append(JoVEEmrf);
							dr68JY5r.append('\n');
						}
						FWUnGNEr = dr68JY5r.toString();
					} catch (IOException zJh1fiH3) {
						log.warn(this.NAME + ".determineGuardedHtml: Failed to read the Guarded Html Fragment: "
								+ itwg3MUQ, zJh1fiH3);
					} finally {
						try {
							if (RsXP1njO != null)
								RsXP1njO.close();
						} catch (IOException aRtCrqmT) {
							log.warn(this.NAME + ".determineGuardedHtml: Failed to close the Guarded Html Fragment: "
									+ itwg3MUQ, aRtCrqmT);
						}
					}
				} else {
					log.warn("Failed to read the Guarded Html Fragment: " + itwg3MUQ);
				}
				if (FWUnGNEr == null)
					FWUnGNEr = "Transaction in Progress";
				c_guardedHtmlCache.put(itwg3MUQ, FWUnGNEr);
			}
			v7ty0prG.append(FWUnGNEr);
			v7ty0prG.append("\n</span>\n");
		}
		return v7ty0prG.toString();
	}

}