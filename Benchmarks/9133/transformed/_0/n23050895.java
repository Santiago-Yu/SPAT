class n23050895 {
	protected void saveResponse(final WebResponse VvAOSI6F, final WebRequest Fwd9WF8d) throws IOException {
		counter_++;
		final String ocKQFgo9 = chooseExtension(VvAOSI6F.getContentType());
		final File Ofpw1OqQ = createFile(Fwd9WF8d.getUrl(), ocKQFgo9);
		final InputStream MBMfU20T = VvAOSI6F.getContentAsStream();
		final OutputStream MlXlrTUJ = new FileOutputStream(Ofpw1OqQ);
		try {
			IOUtils.copy(VvAOSI6F.getContentAsStream(), MlXlrTUJ);
		} finally {
			IOUtils.closeQuietly(MBMfU20T);
			IOUtils.closeQuietly(MlXlrTUJ);
		}
		final URL AvSNv3dw = VvAOSI6F.getWebRequest().getUrl();
		LOG.info("Created file " + Ofpw1OqQ.getAbsolutePath() + " for response " + counter_ + ": " + AvSNv3dw);
		final StringBuilder mTxOq1G2 = new StringBuilder();
		mTxOq1G2.append("tab[tab.length] = {code: " + VvAOSI6F.getStatusCode() + ", ");
		mTxOq1G2.append("fileName: '" + Ofpw1OqQ.getName() + "', ");
		mTxOq1G2.append("contentType: '" + VvAOSI6F.getContentType() + "', ");
		mTxOq1G2.append("method: '" + Fwd9WF8d.getHttpMethod().name() + "', ");
		if (Fwd9WF8d.getHttpMethod() == HttpMethod.POST && Fwd9WF8d.getEncodingType() == FormEncodingType.URL_ENCODED) {
			mTxOq1G2.append("postParameters: " + nameValueListToJsMap(Fwd9WF8d.getRequestParameters()) + ", ");
		}
		mTxOq1G2.append("url: '" + escapeJSString(AvSNv3dw.toString()) + "', ");
		mTxOq1G2.append("loadTime: " + VvAOSI6F.getLoadTime() + ", ");
		final byte[] GappYbej = IOUtils.toByteArray(VvAOSI6F.getContentAsStream());
		mTxOq1G2.append("responseSize: " + ((GappYbej == null) ? 0 : GappYbej.length) + ", ");
		mTxOq1G2.append("responseHeaders: " + nameValueListToJsMap(VvAOSI6F.getResponseHeaders()));
		mTxOq1G2.append("};\n");
		appendToJSFile(mTxOq1G2.toString());
	}

}