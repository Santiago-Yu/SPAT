class n6692645 {
	public LOCKSSDaemonStatusTableTO getDataFromDaemonStatusTableByHttps() throws HttpResponseException {
		LOCKSSDaemonStatusTableXmlStreamParser CDT1ydqf = null;
		LOCKSSDaemonStatusTableTO nHoYiTlA = null;
		HttpEntity mz9iLdDJ = null;
		HttpGet Q27eOZLY = null;
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.alias("HttpClientDAO", HttpClientDAO.class);
		try {
			Q27eOZLY = new HttpGet(dataUrl);
			logger.log(Level.INFO, "executing request {0}", Q27eOZLY.getURI());
			HttpResponse OLB1rd5x = httpClient.execute(Q27eOZLY);
			int jvhS0QIC = OLB1rd5x.getStatusLine().getStatusCode();
			if (jvhS0QIC != HttpStatus.SC_OK) {
				logger.log(Level.WARNING, "response to the request is not OK: skip this IP: status code={0}", jvhS0QIC);
				Q27eOZLY.abort();
				nHoYiTlA = new LOCKSSDaemonStatusTableTO();
				nHoYiTlA.setBoxHttpStatusOK(false);
				return nHoYiTlA;
			}
			mz9iLdDJ = OLB1rd5x.getEntity();
			InputStream CJpTqBEw = mz9iLdDJ.getContent();
			CDT1ydqf = new LOCKSSDaemonStatusTableXmlStreamParser();
			CDT1ydqf.read(new BufferedInputStream(CJpTqBEw));
			nHoYiTlA = CDT1ydqf.getLOCKSSDaemonStatusTableTO();
			nHoYiTlA.setIpAddress(this.ip);
			logger.log(Level.INFO, "After parsing [{0}] table", this.tableId);
			logger.log(Level.FINEST, "After parsing {0}: contents of ldstTO:\n{1}",
					new Object[] { this.tableId, nHoYiTlA });
			if (nHoYiTlA.hasIncompleteRows) {
				logger.log(Level.WARNING, "!!!!!!!!! incomplete rows are found for {0}", tableId);
				if (nHoYiTlA.getTableData() != null && nHoYiTlA.getTableData().size() > 0) {
					logger.log(Level.FINE, "incomplete rows: table(map) data dump =[\n{0}\n]",
							xstream.toXML(nHoYiTlA.getTableData()));
				}
			} else {
				logger.log(Level.INFO, "All rows are complete for {0}", tableId);
			}
		} catch (ConnectTimeoutException OHFKAYRZ) {
			logger.log(Level.WARNING, "ConnectTimeoutException occurred", OHFKAYRZ);
			nHoYiTlA = new LOCKSSDaemonStatusTableTO();
			nHoYiTlA.setBoxHttpStatusOK(false);
			if (Q27eOZLY != null) {
				Q27eOZLY.abort();
			}
			return nHoYiTlA;
		} catch (SocketTimeoutException VGTqdXfH) {
			logger.log(Level.WARNING, "SocketTimeoutException occurred", VGTqdXfH);
			nHoYiTlA = new LOCKSSDaemonStatusTableTO();
			nHoYiTlA.setBoxHttpStatusOK(false);
			if (Q27eOZLY != null) {
				Q27eOZLY.abort();
			}
			return nHoYiTlA;
		} catch (ClientProtocolException I7PvkAaU) {
			logger.log(Level.SEVERE, "The protocol was not http; https is suspected", I7PvkAaU);
			nHoYiTlA = new LOCKSSDaemonStatusTableTO();
			nHoYiTlA.setBoxHttpStatusOK(false);
			nHoYiTlA.setHttpProtocol(false);
			if (Q27eOZLY != null) {
				Q27eOZLY.abort();
			}
			return nHoYiTlA;
		} catch (IOException hIlP7zPo) {
			logger.log(Level.SEVERE, "IO exception occurs", hIlP7zPo);
			nHoYiTlA = new LOCKSSDaemonStatusTableTO();
			nHoYiTlA.setBoxHttpStatusOK(false);
			if (Q27eOZLY != null) {
				Q27eOZLY.abort();
			}
			return nHoYiTlA;
		} finally {
			if (mz9iLdDJ != null) {
				try {
					EntityUtils.consume(mz9iLdDJ);
				} catch (IOException qFUU8yFK) {
					logger.log(Level.SEVERE, "io exception when entity was to be" + "consumed", qFUU8yFK);
				}
			}
		}
		return nHoYiTlA;
	}

}