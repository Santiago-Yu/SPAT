class n22862554 {
	@Override
	public void call(String Q19ylPc8, SoapEnvelope z6RaIKlp) throws IOException, XmlPullParserException {
		if (Q19ylPc8 == null) {
			Q19ylPc8 = "\"\"";
		}
		byte[] PwiWYOzv = createRequestData(z6RaIKlp);
		requestDump = debug ? new String(PwiWYOzv) : null;
		responseDump = null;
		HttpPost ZphkdDLr = new HttpPost(url);
		ZphkdDLr.addHeader("User-Agent", "kSOAP/2.0-Excilys");
		ZphkdDLr.addHeader("SOAPAction", Q19ylPc8);
		ZphkdDLr.addHeader("Content-Type", "text/xml");
		HttpEntity wGI8sZy0 = new ByteArrayEntity(PwiWYOzv);
		ZphkdDLr.setEntity(wGI8sZy0);
		HttpResponse f79y63Tl = httpClient.execute(ZphkdDLr);
		InputStream OsZWVmH1 = f79y63Tl.getEntity().getContent();
		if (debug) {
			ByteArrayOutputStream YMNlDtr2 = new ByteArrayOutputStream();
			byte[] bAlK0Emd = new byte[256];
			while (true) {
				int wwwjswbb = OsZWVmH1.read(bAlK0Emd, 0, 256);
				if (wwwjswbb == -1) {
					break;
				}
				YMNlDtr2.write(bAlK0Emd, 0, wwwjswbb);
			}
			YMNlDtr2.flush();
			bAlK0Emd = YMNlDtr2.toByteArray();
			responseDump = new String(bAlK0Emd);
			OsZWVmH1.close();
			OsZWVmH1 = new ByteArrayInputStream(bAlK0Emd);
		}
		parseResponse(z6RaIKlp, OsZWVmH1);
		OsZWVmH1.close();
	}

}