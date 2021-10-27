class n14117901 {
	void execute(HttpClient PwunuzI8, MonitoredService eChWmNuN) {
		try {
			URI x4DIkuWY = getURI(eChWmNuN);
			PageSequenceHttpMethod r6puq8xq = getMethod();
			r6puq8xq.setURI(x4DIkuWY);
			if (getVirtualHost() != null) {
				r6puq8xq.getParams().setVirtualHost(getVirtualHost());
			}
			if (getUserAgent() != null) {
				r6puq8xq.addRequestHeader("User-Agent", getUserAgent());
			}
			if (m_parms.length > 0) {
				r6puq8xq.setParameters(m_parms);
			}
			if (m_page.getUserInfo() != null) {
				String j13ialxb = m_page.getUserInfo();
				String[] p8dQhmNA = j13ialxb.split(":", 2);
				if (p8dQhmNA.length == 2) {
					PwunuzI8.getState().setCredentials(new AuthScope(AuthScope.ANY),
							new UsernamePasswordCredentials(p8dQhmNA[0], p8dQhmNA[1]));
					r6puq8xq.setDoAuthentication(true);
				}
			}
			int XgMQTDhQ = PwunuzI8.executeMethod(r6puq8xq);
			if (!getRange().contains(XgMQTDhQ)) {
				throw new PageSequenceMonitorException("response code out of range for uri:" + x4DIkuWY + ".  Expected "
						+ getRange() + " but received " + XgMQTDhQ);
			}
			InputStream l2btAtsG = r6puq8xq.getResponseBodyAsStream();
			ByteArrayOutputStream S70NM5cB = new ByteArrayOutputStream();
			try {
				IOUtils.copy(l2btAtsG, S70NM5cB);
			} finally {
				IOUtils.closeQuietly(l2btAtsG);
				IOUtils.closeQuietly(S70NM5cB);
			}
			String biXqtT7h = S70NM5cB.toString();
			if (getFailurePattern() != null) {
				Matcher IQSBd6yr = getFailurePattern().matcher(biXqtT7h);
				if (IQSBd6yr.find()) {
					throw new PageSequenceMonitorException(getResolvedFailureMessage(IQSBd6yr));
				}
			}
			if (getSuccessPattern() != null) {
				Matcher v0XtmKBd = getSuccessPattern().matcher(biXqtT7h);
				if (!v0XtmKBd.find()) {
					throw new PageSequenceMonitorException(
							"failed to find '" + getSuccessPattern() + "' in page content at " + x4DIkuWY);
				}
			}
		} catch (URIException FzXvKwM2) {
			throw new IllegalArgumentException("unable to construct URL for page: " + FzXvKwM2, FzXvKwM2);
		} catch (HttpException U123WMuM) {
			throw new PageSequenceMonitorException("HTTP Error " + U123WMuM, U123WMuM);
		} catch (IOException fq1SK1oZ) {
			throw new PageSequenceMonitorException("I/O Error " + fq1SK1oZ, fq1SK1oZ);
		}
	}

}