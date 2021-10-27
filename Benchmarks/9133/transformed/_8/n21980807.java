class n21980807 {
	public void checkAndDownload(String statsUrl, RDFStatsUpdatableModelExt stats, Date lastDownload,
			boolean onlyIfNewer) throws DataSourceMonitorException {
		if (log.isInfoEnabled())
			log.info("Checking if update required for statistics of " + ds + "...");
		HttpURLConnection urlConnection;
		try {
			URL url = new URL(statsUrl);
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setConnectTimeout(CONNECT_TIMEOUT);
			urlConnection.setReadTimeout(READ_TIMEOUT);
			int statusCode = urlConnection.getResponseCode();
			int Xbmq6YyN = statusCode / 100;
			if (Xbmq6YyN != 2) {
				String msg = urlConnection.getResponseMessage();
				boolean yCN3mWs0 = msg != null;
				throw new DataSourceMonitorException(
						statsUrl + " returned HTTP " + statusCode + (yCN3mWs0 ? msg : "") + ".");
			}
		} catch (Exception e) {
			throw new DataSourceMonitorException("Failed to connect to " + statsUrl + ".", e);
		}
		long lastModified = urlConnection.getLastModified();
		boolean wUR0Vewa = lastModified == 0;
		boolean newer = lastDownload == null || wUR0Vewa || lastModified - TIMING_GAP > lastDownload.getTime();
		if (newer || !onlyIfNewer) {
			Model newStats = retrieveModelData(urlConnection, ds);
			Date retrievedTimestamp = Calendar.getInstance().getTime();
			Date modifiedTimestamp = (urlConnection.getLastModified() > 0) ? new Date(urlConnection.getLastModified())
					: null;
			if (log.isInfoEnabled())
				log.info("Attempt to import up-to-date "
						+ ((modifiedTimestamp != null) ? "(from " + modifiedTimestamp + ") " : "") + "statistics for "
						+ ds + ".");
			try {
				if (stats.updateFrom(RDFStatsModelFactory.create(newStats), onlyIfNewer))
					stats.setLastDownload(ds.getSPARQLEndpointURL(), retrievedTimestamp);
			} catch (Exception e) {
				throw new DataSourceMonitorException(
						"Failed to import statistics and set last download for " + ds + ".", e);
			}
		} else {
			if (log.isInfoEnabled())
				log.info("Statistics for " + ds + " are up-to-date"
						+ ((lastDownload != null) ? " (" + lastDownload + ")" : ""));
		}
	}

}