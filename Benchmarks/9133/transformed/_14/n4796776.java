class n4796776 {
	public HttpURLConnection execute(S3Bucket pBucket, S3Object pObject, S3OperationParameters pOpParams)
			throws S3Exception {
		S3OperationParameters opParams = pOpParams;
		if (null == opParams)
			opParams = new S3OperationParameters();
		HttpURLConnection result = null;
		URL url = getURL(pBucket, pObject, opParams.getQueryParameters());
		mLogger.log(Level.FINEST, "URL: " + url.toString());
		opParams.addDateHeader();
		switch (mStyle) {
		case Path:
			opParams.addHostHeader(BASE_DOMAIN);
			break;
		case Subdomain:
			if (null == pBucket)
				opParams.addHostHeader(BASE_DOMAIN);
			else
				opParams.addHostHeader(pBucket.getName() + "." + BASE_DOMAIN);
			break;
		case VirtualHost:
			if (null == pBucket)
				opParams.addHostHeader(BASE_DOMAIN);
			else
				opParams.addHostHeader(pBucket.getName());
			break;
		}
		if (opParams.isSign()) {
			StringBuilder sb = new StringBuilder();
			sb.append(opParams.getVerb().toString());
			sb.append(NEWLINE);
			sb.append(posHeader(MD5, opParams.getRequestHeaders()));
			sb.append(posHeader(TYPE, opParams.getRequestHeaders()));
			if (opParams.getQueryParameters().has(EXPIRES)) {
				sb.append(opParams.getQueryParameters().get(EXPIRES).getValue());
				sb.append(NEWLINE);
			} else {
				sb.append(posHeader(DATE, opParams.getRequestHeaders()));
			}
			sb.append(canonicalizeAmazonHeaders(opParams.getRequestHeaders()));
			try {
				sb.append("/");
				if (pBucket != null) {
					sb.append(URLEncoder.encode(pBucket.getName(), URL_ENCODING));
					sb.append("/");
					if (pObject != null) {
						sb.append(URLEncoder.encode(pObject.getKey(), URL_ENCODING));
					}
				}
				sb.append(opParams.getQueryParameters().getAmazonSubresources().toQueryString());
				String signThis = sb.toString();
				mLogger.log(Level.FINEST, "String being signed: " + signThis);
				String sig = encode(mCredential.getMSecretAccessKey(), signThis, false);
				sb = new StringBuilder();
				sb.append("AWS ");
				sb.append(mCredential.getMAccessKeyID());
				sb.append(":");
				sb.append(sig);
				opParams.addAuthorizationHeader(sb.toString());
			} catch (UnsupportedEncodingException e) {
				throw new S3Exception("URL encoding not supported: " + URL_ENCODING, e);
			}
		}
		try {
			killHostVerifier();
			URLConnection urlConn = url.openConnection();
			if (!(urlConn instanceof HttpURLConnection))
				throw new S3Exception("URLConnection is not instance of HttpURLConnection!");
			result = (HttpURLConnection) urlConn;
			result.setRequestMethod(opParams.getVerb().toString());
			mLogger.log(Level.FINEST, "HTTP Operation: " + opParams.getVerb().toString());
			if (HttpVerb.PUT == opParams.getVerb()) {
				result.setDoOutput(true);
			}
			result.setRequestProperty(TYPE, "");
			for (AWSParameter param : opParams.getRequestHeaders()) {
				result.setRequestProperty(param.getName(), param.getValue());
				mLogger.log(Level.FINEST, "Header " + param.getName() + ": " + param.getValue());
			}
		} catch (IOException e) {
			throw new S3Exception("Problem opening connection to URL: " + url.toString(), e);
		}
		return result;
	}

}