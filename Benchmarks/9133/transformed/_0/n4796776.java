class n4796776 {
	public HttpURLConnection execute(S3Bucket wJehbkHj, S3Object ZUi8ZlpS, S3OperationParameters yDmAflLv)
			throws S3Exception {
		S3OperationParameters tDMYNzvX = yDmAflLv;
		if (tDMYNzvX == null)
			tDMYNzvX = new S3OperationParameters();
		HttpURLConnection fDSsU6Ua = null;
		URL asU5EdEv = getURL(wJehbkHj, ZUi8ZlpS, tDMYNzvX.getQueryParameters());
		mLogger.log(Level.FINEST, "URL: " + asU5EdEv.toString());
		tDMYNzvX.addDateHeader();
		switch (mStyle) {
		case Path:
			tDMYNzvX.addHostHeader(BASE_DOMAIN);
			break;
		case Subdomain:
			if (wJehbkHj == null)
				tDMYNzvX.addHostHeader(BASE_DOMAIN);
			else
				tDMYNzvX.addHostHeader(wJehbkHj.getName() + "." + BASE_DOMAIN);
			break;
		case VirtualHost:
			if (wJehbkHj == null)
				tDMYNzvX.addHostHeader(BASE_DOMAIN);
			else
				tDMYNzvX.addHostHeader(wJehbkHj.getName());
			break;
		}
		if (tDMYNzvX.isSign()) {
			StringBuilder lduuR6oA = new StringBuilder();
			lduuR6oA.append(tDMYNzvX.getVerb().toString());
			lduuR6oA.append(NEWLINE);
			lduuR6oA.append(posHeader(MD5, tDMYNzvX.getRequestHeaders()));
			lduuR6oA.append(posHeader(TYPE, tDMYNzvX.getRequestHeaders()));
			if (tDMYNzvX.getQueryParameters().has(EXPIRES)) {
				lduuR6oA.append(tDMYNzvX.getQueryParameters().get(EXPIRES).getValue());
				lduuR6oA.append(NEWLINE);
			} else {
				lduuR6oA.append(posHeader(DATE, tDMYNzvX.getRequestHeaders()));
			}
			lduuR6oA.append(canonicalizeAmazonHeaders(tDMYNzvX.getRequestHeaders()));
			try {
				lduuR6oA.append("/");
				if (wJehbkHj != null) {
					lduuR6oA.append(URLEncoder.encode(wJehbkHj.getName(), URL_ENCODING));
					lduuR6oA.append("/");
					if (ZUi8ZlpS != null) {
						lduuR6oA.append(URLEncoder.encode(ZUi8ZlpS.getKey(), URL_ENCODING));
					}
				}
				lduuR6oA.append(tDMYNzvX.getQueryParameters().getAmazonSubresources().toQueryString());
				String OQORFFM9 = lduuR6oA.toString();
				mLogger.log(Level.FINEST, "String being signed: " + OQORFFM9);
				String XoHMCYt2 = encode(mCredential.getMSecretAccessKey(), OQORFFM9, false);
				lduuR6oA = new StringBuilder();
				lduuR6oA.append("AWS ");
				lduuR6oA.append(mCredential.getMAccessKeyID());
				lduuR6oA.append(":");
				lduuR6oA.append(XoHMCYt2);
				tDMYNzvX.addAuthorizationHeader(lduuR6oA.toString());
			} catch (UnsupportedEncodingException tSnDa5v5) {
				throw new S3Exception("URL encoding not supported: " + URL_ENCODING, tSnDa5v5);
			}
		}
		try {
			killHostVerifier();
			URLConnection WZ4bsi5s = asU5EdEv.openConnection();
			if (!(WZ4bsi5s instanceof HttpURLConnection))
				throw new S3Exception("URLConnection is not instance of HttpURLConnection!");
			fDSsU6Ua = (HttpURLConnection) WZ4bsi5s;
			fDSsU6Ua.setRequestMethod(tDMYNzvX.getVerb().toString());
			mLogger.log(Level.FINEST, "HTTP Operation: " + tDMYNzvX.getVerb().toString());
			if (tDMYNzvX.getVerb() == HttpVerb.PUT) {
				fDSsU6Ua.setDoOutput(true);
			}
			fDSsU6Ua.setRequestProperty(TYPE, "");
			for (AWSParameter UuWFwUNL : tDMYNzvX.getRequestHeaders()) {
				fDSsU6Ua.setRequestProperty(UuWFwUNL.getName(), UuWFwUNL.getValue());
				mLogger.log(Level.FINEST, "Header " + UuWFwUNL.getName() + ": " + UuWFwUNL.getValue());
			}
		} catch (IOException nGMvOXfF) {
			throw new S3Exception("Problem opening connection to URL: " + asU5EdEv.toString(), nGMvOXfF);
		}
		return fDSsU6Ua;
	}

}