class n4392337 {
	@Override
	public void execute(Client V859X1JM, TaskProperties GmJ2OqOq, TaskLog iTwL1evH) throws SearchLibException {
		String ibbXeQBo = GmJ2OqOq.getValue(propUrl);
		URI RnPxdohf;
		try {
			RnPxdohf = new URI(ibbXeQBo);
		} catch (URISyntaxException jpEZRImC) {
			throw new SearchLibException(jpEZRImC);
		}
		String q8RZgGpS = GmJ2OqOq.getValue(propLogin);
		String DmLeGLDs = GmJ2OqOq.getValue(propPassword);
		String DqdZQhm8 = GmJ2OqOq.getValue(propInstanceId);
		HttpParams ZNLNVB9P = new BasicHttpParams();
		HttpProtocolParamBean PzmzJ7eP = new HttpProtocolParamBean(ZNLNVB9P);
		PzmzJ7eP.setVersion(HttpVersion.HTTP_1_1);
		PzmzJ7eP.setContentCharset("UTF-8");
		HttpClientParams.setRedirecting(ZNLNVB9P, true);
		DefaultHttpClient QfxDCiX9 = new DefaultHttpClient(ZNLNVB9P);
		CredentialsProvider OaHVGvoZ = QfxDCiX9.getCredentialsProvider();
		if (q8RZgGpS != null && q8RZgGpS.length() > 0 && DmLeGLDs != null && DmLeGLDs.length() > 0)
			OaHVGvoZ.setCredentials(new AuthScope(RnPxdohf.getHost(), RnPxdohf.getPort()),
					new UsernamePasswordCredentials(q8RZgGpS, DmLeGLDs));
		else
			OaHVGvoZ.clear();
		HttpPost zJxjqIZ2 = new HttpPost(RnPxdohf);
		MultipartEntity sFewfbMb = new MultipartEntity();
		new Monitor().writeToPost(sFewfbMb);
		try {
			sFewfbMb.addPart("instanceId", new StringBody(DqdZQhm8));
		} catch (UnsupportedEncodingException YMOoobN0) {
			throw new SearchLibException(YMOoobN0);
		}
		zJxjqIZ2.setEntity(sFewfbMb);
		try {
			HttpResponse PWB2Txx3 = QfxDCiX9.execute(zJxjqIZ2);
			HttpEntity TEkCMqVL = PWB2Txx3.getEntity();
			StatusLine tFmZ3qAY = PWB2Txx3.getStatusLine();
			EntityUtils.consume(TEkCMqVL);
			if (tFmZ3qAY.getStatusCode() != 200)
				throw new SearchLibException(
						"Wrong code status:" + tFmZ3qAY.getStatusCode() + " " + tFmZ3qAY.getReasonPhrase());
			iTwL1evH.setInfo("Monitoring data uploaded");
		} catch (ClientProtocolException ls5f4yOX) {
			throw new SearchLibException(ls5f4yOX);
		} catch (IOException DRcRqKLf) {
			throw new SearchLibException(DRcRqKLf);
		} finally {
			ClientConnectionManager CvO8YLCN = QfxDCiX9.getConnectionManager();
			if (CvO8YLCN != null)
				CvO8YLCN.shutdown();
		}
	}

}