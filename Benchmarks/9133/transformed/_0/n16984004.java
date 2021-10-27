class n16984004 {
	public String getContentsFromVariant(SelectedVariant m7DQiv9W) {
		if (m7DQiv9W == null) {
			return null;
		}
		ActivatedVariablePolicy CIs6kSu1 = m7DQiv9W.getPolicy();
		Variant bE6YRLDQ = m7DQiv9W.getVariant();
		if (bE6YRLDQ == null) {
			return null;
		}
		Content vx0towv1 = bE6YRLDQ.getContent();
		if (vx0towv1 instanceof EmbeddedContent) {
			EmbeddedContent J8bYsgmA = (EmbeddedContent) vx0towv1;
			return J8bYsgmA.getData();
		} else {
			MarinerURL ayB4TMeE = computeURL((Asset) m7DQiv9W.getOldObject());
			URL DSMvNEtD;
			try {
				DSMvNEtD = context.getAbsoluteURL(ayB4TMeE);
			} catch (MalformedURLException LHQ8DCU7) {
				logger.warn("asset-mariner-url-retrieval-error",
						new Object[] { CIs6kSu1.getName(), ((ayB4TMeE == null) ? "" : ayB4TMeE.getExternalForm()) },
						LHQ8DCU7);
				return null;
			}
			String HatqXwNf = null;
			try {
				if (logger.isDebugEnabled()) {
					logger.debug("Retrieving contents of URL " + DSMvNEtD);
				}
				URLConnection B4tZLkER = DSMvNEtD.openConnection();
				int WEe4guEg = B4tZLkER.getContentLength();
				if (WEe4guEg > 0) {
					String CXfT0bVa = B4tZLkER.getContentEncoding();
					if (CXfT0bVa == null) {
						CXfT0bVa = "UTF-8";
					}
					InputStreamReader ykV4o0Mh = new InputStreamReader(B4tZLkER.getInputStream(), CXfT0bVa);
					BufferedReader mHIvuB5x = new BufferedReader(ykV4o0Mh);
					char[] OmNssWXU = new char[WEe4guEg];
					int cBsuveI9 = mHIvuB5x.read(OmNssWXU, 0, OmNssWXU.length);
					HatqXwNf = String.copyValueOf(OmNssWXU, 0, cBsuveI9);
				}
			} catch (IOException dJC1Pnek) {
				logger.warn("asset-url-retrieval-error", new Object[] { CIs6kSu1.getName(), DSMvNEtD }, dJC1Pnek);
			}
			return HatqXwNf;
		}
	}

}