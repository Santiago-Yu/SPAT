class n6692644 {
	public LOCKSSDaemonStatusTableTO getDataFromDaemonStatusTable() throws HttpResponseException {
		LOCKSSDaemonStatusTableXmlStreamParser r4dyNbDr = null;
		LOCKSSDaemonStatusTableTO IZZZBZdH = null;
		HttpEntity RVOJhah5 = null;
		HttpGet BxmpdoZn = null;
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.alias("HttpClientDAO", HttpClientDAO.class);
		try {
			BxmpdoZn = new HttpGet(dataUrl);
			logger.log(Level.INFO, "executing request {0}", BxmpdoZn.getURI());
			HttpResponse Unl9WkQv = httpClient.execute(BxmpdoZn);
			int voQdmldY = Unl9WkQv.getStatusLine().getStatusCode();
			if (voQdmldY != HttpStatus.SC_OK) {
				logger.log(Level.WARNING, "response to the request is not OK: skip this IP: status code={0}", voQdmldY);
				BxmpdoZn.abort();
				IZZZBZdH = new LOCKSSDaemonStatusTableTO();
				IZZZBZdH.setBoxHttpStatusOK(false);
				return IZZZBZdH;
			}
			RVOJhah5 = Unl9WkQv.getEntity();
			InputStream RVnplS0M = RVOJhah5.getContent();
			r4dyNbDr = new LOCKSSDaemonStatusTableXmlStreamParser();
			r4dyNbDr.read(new BufferedInputStream(RVnplS0M));
			IZZZBZdH = r4dyNbDr.getLOCKSSDaemonStatusTableTO();
			IZZZBZdH.setIpAddress(this.ip);
			logger.log(Level.INFO, "After parsing [{0}] table", this.tableId);
			logger.log(Level.FINEST, "After parsing {0}: contents of ldstTO:\n{1}",
					new Object[] { this.tableId, IZZZBZdH });
			if (IZZZBZdH.hasIncompleteRows) {
				logger.log(Level.WARNING, "!!!!!!!!! incomplete rows are found for {0}", tableId);
				if (IZZZBZdH.getTableData() != null && IZZZBZdH.getTableData().size() > 0) {
					logger.log(Level.FINE, "incomplete rows: table(map) data dump =[\n{0}\n]",
							xstream.toXML(IZZZBZdH.getTableData()));
				}
			} else {
				logger.log(Level.INFO, "All rows are complete for {0}", tableId);
			}
		} catch (ConnectTimeoutException RJNDYFw3) {
			logger.log(Level.WARNING, "ConnectTimeoutException occurred", RJNDYFw3);
			IZZZBZdH = new LOCKSSDaemonStatusTableTO();
			IZZZBZdH.setBoxHttpStatusOK(false);
			if (BxmpdoZn != null) {
				BxmpdoZn.abort();
			}
			return IZZZBZdH;
		} catch (SocketTimeoutException RAnlKt1X) {
			logger.log(Level.WARNING, "SocketTimeoutException occurred", RAnlKt1X);
			IZZZBZdH = new LOCKSSDaemonStatusTableTO();
			IZZZBZdH.setBoxHttpStatusOK(false);
			if (BxmpdoZn != null) {
				BxmpdoZn.abort();
			}
			return IZZZBZdH;
		} catch (ClientProtocolException DSG1DTuC) {
			logger.log(Level.SEVERE, "The protocol was not http; https is suspected", DSG1DTuC);
			IZZZBZdH = new LOCKSSDaemonStatusTableTO();
			IZZZBZdH.setBoxHttpStatusOK(false);
			IZZZBZdH.setHttpProtocol(false);
			if (BxmpdoZn != null) {
				BxmpdoZn.abort();
			}
			return IZZZBZdH;
		} catch (IOException Fe65s0R8) {
			logger.log(Level.SEVERE, "IO exception occurs", Fe65s0R8);
			IZZZBZdH = new LOCKSSDaemonStatusTableTO();
			IZZZBZdH.setBoxHttpStatusOK(false);
			if (BxmpdoZn != null) {
				BxmpdoZn.abort();
			}
			return IZZZBZdH;
		} finally {
			if (RVOJhah5 != null) {
				try {
					EntityUtils.consume(RVOJhah5);
				} catch (IOException d2VEqK2M) {
					logger.log(Level.SEVERE, "io exception when entity was to be" + "consumed", d2VEqK2M);
				}
			}
		}
		return IZZZBZdH;
	}

}