class n17200624 {
	public void run() {
		runCounter++;
		try {
			LOGGER.info("Fetching feed [" + runCounter + "] " + _feedInfo);
			DefaultHttpClient WHPtYbwe = new DefaultHttpClient();
			HttpContext Ut9g9QX4 = new BasicHttpContext();
			disableSSLCertificateChecking(WHPtYbwe);
			if (_proxy != null && _feedInfo.getUseProxy()) {
				LOGGER.info("Configuring proxy " + _proxy);
				WHPtYbwe.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, _proxy);
			}
			if (_feedInfo.getUsername() != null) {
				Credentials bFW2vLXM;
				if (_feedInfo.getUsername().contains("/")) {
					String G0tfia8Z = _feedInfo.getUsername().substring(_feedInfo.getUsername().indexOf("/") + 1);
					String FhM3eJQP = _feedInfo.getUsername().substring(0, _feedInfo.getUsername().indexOf("/"));
					String UE9Ydd0M = InetAddress.getLocalHost().getHostName();
					LOGGER.info("Configuring NT credentials : username=[" + G0tfia8Z + "] domain=[" + FhM3eJQP
							+ "] workstation=[" + UE9Ydd0M + "]");
					bFW2vLXM = new NTCredentials(G0tfia8Z, _feedInfo.getPassword(), UE9Ydd0M, FhM3eJQP);
					WHPtYbwe.getAuthSchemes().register("ntlm", new NTLMSchemeFactory());
					WHPtYbwe.getCredentialsProvider().setCredentials(AuthScope.ANY, bFW2vLXM);
				} else {
					bFW2vLXM = new UsernamePasswordCredentials(_feedInfo.getUsername(), _feedInfo.getPassword());
					LOGGER.info("Configuring Basic credentials " + bFW2vLXM);
					WHPtYbwe.getCredentialsProvider().setCredentials(AuthScope.ANY, bFW2vLXM);
				}
			}
			if (_feedInfo.getCookie() != null) {
				BasicClientCookie nAnqFFwF = new BasicClientCookie(_feedInfo.getCookie().getName(),
						_feedInfo.getCookie().getValue());
				nAnqFFwF.setVersion(0);
				if (_feedInfo.getCookie().getDomain() != null)
					nAnqFFwF.setDomain(_feedInfo.getCookie().getDomain());
				if (_feedInfo.getCookie().getPath() != null)
					nAnqFFwF.setPath(_feedInfo.getCookie().getPath());
				LOGGER.info("Adding cookie " + nAnqFFwF);
				CookieStore rLOC7TmH = new BasicCookieStore();
				rLOC7TmH.addCookie(nAnqFFwF);
				Ut9g9QX4.setAttribute(ClientContext.COOKIE_STORE, rLOC7TmH);
			}
			HttpGet Ad5VGjeg = new HttpGet(_feedInfo.getUrl());
			HttpResponse LcVLRi1u = WHPtYbwe.execute(Ad5VGjeg, Ut9g9QX4);
			LOGGER.info("Response Status : " + LcVLRi1u.getStatusLine());
			LOGGER.debug("Headers : " + Arrays.toString(LcVLRi1u.getAllHeaders()));
			if (LcVLRi1u.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				LOGGER.error("Request was unsuccessful for " + _feedInfo + " : " + LcVLRi1u.getStatusLine());
			} else {
				SyndFeedInput cBvpGAlr = new SyndFeedInput();
				XmlReader IUGxgEth = new XmlReader(LcVLRi1u.getEntity().getContent());
				SyndFeed ZJeIttJR = cBvpGAlr.build(IUGxgEth);
				if (ZJeIttJR.getTitle() != null)
					_feedInfo.setTitle(ZJeIttJR.getTitle());
				LOGGER.debug("Feed : " + new SyndFeedOutput().outputString(ZJeIttJR));
				LOGGER.info("Feed [" + ZJeIttJR.getTitle() + "] contains " + ZJeIttJR.getEntries().size() + " entries");
				@SuppressWarnings("unchecked")
				List<SyndEntry> dvcQWBfn = ZJeIttJR.getEntries();
				Collections.sort(dvcQWBfn, new SyndEntryPublishedDateComparator());
				for (SyndEntry XkaGLdk3 : dvcQWBfn) {
					if (VisitedEntries.getInstance().isAlreadyVisited(XkaGLdk3.getUri())) {
						LOGGER.debug("Already received " + XkaGLdk3.getUri());
					} else {
						_feedInfo.addEntry(XkaGLdk3);
						LOGGER.debug("New entry " + XkaGLdk3.toString());
						_entryDisplay.displayEntry(ZJeIttJR, XkaGLdk3, firstRun);
					}
				}
				LOGGER.info("Completing entries for feed " + ZJeIttJR.getTitle());
				if (firstRun)
					firstRun = false;
			}
		} catch (IllegalArgumentException JRs923Nj) {
			LOGGER.error(JRs923Nj.getMessage(), JRs923Nj);
		} catch (FeedException OAGE9NzB) {
			LOGGER.error(OAGE9NzB.getMessage(), OAGE9NzB);
		} catch (IOException Z7RdIu7v) {
			LOGGER.error(Z7RdIu7v.getMessage(), Z7RdIu7v);
		} catch (KeyManagementException RLTHfHUu) {
			LOGGER.error(RLTHfHUu.getMessage(), RLTHfHUu);
		} catch (NoSuchAlgorithmException s9jkxXyK) {
			LOGGER.error(s9jkxXyK.getMessage(), s9jkxXyK);
		}
	}

}