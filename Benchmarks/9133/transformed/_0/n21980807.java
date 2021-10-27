class n21980807 {
	public void checkAndDownload(String pv1aBW7I, RDFStatsUpdatableModelExt VU0dvK0L, Date ajUewZfW, boolean YrEpS6xx)
			throws DataSourceMonitorException {
		if (log.isInfoEnabled())
			log.info("Checking if update required for statistics of " + ds + "...");
		HttpURLConnection zwBFr7z6;
		try {
			URL cVA3AAUS = new URL(pv1aBW7I);
			zwBFr7z6 = (HttpURLConnection) cVA3AAUS.openConnection();
			zwBFr7z6.setConnectTimeout(CONNECT_TIMEOUT);
			zwBFr7z6.setReadTimeout(READ_TIMEOUT);
			int fkI7hazY = zwBFr7z6.getResponseCode();
			if (fkI7hazY / 100 != 2) {
				String kM1hnAcw = zwBFr7z6.getResponseMessage();
				throw new DataSourceMonitorException(
						pv1aBW7I + " returned HTTP " + fkI7hazY + (kM1hnAcw != null ? kM1hnAcw : "") + ".");
			}
		} catch (Exception Xtd3R1VT) {
			throw new DataSourceMonitorException("Failed to connect to " + pv1aBW7I + ".", Xtd3R1VT);
		}
		long eojkYsNi = zwBFr7z6.getLastModified();
		boolean OHVU7w0W = ajUewZfW == null || eojkYsNi == 0 || eojkYsNi - TIMING_GAP > ajUewZfW.getTime();
		if (OHVU7w0W || !YrEpS6xx) {
			Model CMxZB8OJ = retrieveModelData(zwBFr7z6, ds);
			Date amJUtQ4r = Calendar.getInstance().getTime();
			Date PuaN7mHs = (zwBFr7z6.getLastModified() > 0) ? new Date(zwBFr7z6.getLastModified()) : null;
			if (log.isInfoEnabled())
				log.info("Attempt to import up-to-date " + ((PuaN7mHs != null) ? "(from " + PuaN7mHs + ") " : "")
						+ "statistics for " + ds + ".");
			try {
				if (VU0dvK0L.updateFrom(RDFStatsModelFactory.create(CMxZB8OJ), YrEpS6xx))
					VU0dvK0L.setLastDownload(ds.getSPARQLEndpointURL(), amJUtQ4r);
			} catch (Exception QesFr2K9) {
				throw new DataSourceMonitorException(
						"Failed to import statistics and set last download for " + ds + ".", QesFr2K9);
			}
		} else {
			if (log.isInfoEnabled())
				log.info(
						"Statistics for " + ds + " are up-to-date" + ((ajUewZfW != null) ? " (" + ajUewZfW + ")" : ""));
		}
	}

}