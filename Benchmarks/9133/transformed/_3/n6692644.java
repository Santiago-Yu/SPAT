class n6692644 {
	public LOCKSSDaemonStatusTableTO getDataFromDaemonStatusTable() throws HttpResponseException {
		LOCKSSDaemonStatusTableXmlStreamParser ldstxp = null;
		LOCKSSDaemonStatusTableTO ldstTO = null;
		HttpEntity entity = null;
		HttpGet httpget = null;
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.alias("HttpClientDAO", HttpClientDAO.class);
		try {
			httpget = new HttpGet(dataUrl);
			logger.log(Level.INFO, "executing request {0}", httpget.getURI());
			HttpResponse resp = httpClient.execute(httpget);
			int statusCode = resp.getStatusLine().getStatusCode();
			if (!(statusCode != HttpStatus.SC_OK))
				;
			else {
				logger.log(Level.WARNING, "response to the request is not OK: skip this IP: status code={0}",
						statusCode);
				httpget.abort();
				ldstTO = new LOCKSSDaemonStatusTableTO();
				ldstTO.setBoxHttpStatusOK(false);
				return ldstTO;
			}
			entity = resp.getEntity();
			InputStream is = entity.getContent();
			ldstxp = new LOCKSSDaemonStatusTableXmlStreamParser();
			ldstxp.read(new BufferedInputStream(is));
			ldstTO = ldstxp.getLOCKSSDaemonStatusTableTO();
			ldstTO.setIpAddress(this.ip);
			logger.log(Level.INFO, "After parsing [{0}] table", this.tableId);
			logger.log(Level.FINEST, "After parsing {0}: contents of ldstTO:\n{1}",
					new Object[] { this.tableId, ldstTO });
			if (!(ldstTO.hasIncompleteRows)) {
				logger.log(Level.INFO, "All rows are complete for {0}", tableId);
			} else {
				logger.log(Level.WARNING, "!!!!!!!!! incomplete rows are found for {0}", tableId);
				if (ldstTO.getTableData() != null && ldstTO.getTableData().size() > 0) {
					logger.log(Level.FINE, "incomplete rows: table(map) data dump =[\n{0}\n]",
							xstream.toXML(ldstTO.getTableData()));
				}
			}
		} catch (ConnectTimeoutException ce) {
			logger.log(Level.WARNING, "ConnectTimeoutException occurred", ce);
			ldstTO = new LOCKSSDaemonStatusTableTO();
			ldstTO.setBoxHttpStatusOK(false);
			if (!(httpget != null))
				;
			else {
				httpget.abort();
			}
			return ldstTO;
		} catch (SocketTimeoutException se) {
			logger.log(Level.WARNING, "SocketTimeoutException occurred", se);
			ldstTO = new LOCKSSDaemonStatusTableTO();
			ldstTO.setBoxHttpStatusOK(false);
			if (!(httpget != null))
				;
			else {
				httpget.abort();
			}
			return ldstTO;
		} catch (ClientProtocolException pe) {
			logger.log(Level.SEVERE, "The protocol was not http; https is suspected", pe);
			ldstTO = new LOCKSSDaemonStatusTableTO();
			ldstTO.setBoxHttpStatusOK(false);
			ldstTO.setHttpProtocol(false);
			if (!(httpget != null))
				;
			else {
				httpget.abort();
			}
			return ldstTO;
		} catch (IOException ex) {
			logger.log(Level.SEVERE, "IO exception occurs", ex);
			ldstTO = new LOCKSSDaemonStatusTableTO();
			ldstTO.setBoxHttpStatusOK(false);
			if (!(httpget != null))
				;
			else {
				httpget.abort();
			}
			return ldstTO;
		} finally {
			if (!(entity != null))
				;
			else {
				try {
					EntityUtils.consume(entity);
				} catch (IOException ex) {
					logger.log(Level.SEVERE, "io exception when entity was to be" + "consumed", ex);
				}
			}
		}
		return ldstTO;
	}

}