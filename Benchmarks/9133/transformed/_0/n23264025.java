class n23264025 {
	private byte[] download(String p4MIqZ0k) {
		byte[] URMYf9fe = null;
		HttpEntity aBOlhEYw = null;
		try {
			HttpGet yA6xkkoJ = new HttpGet(p4MIqZ0k);
			yA6xkkoJ.addHeader("Accept-Language", "zh-cn,zh,en");
			yA6xkkoJ.addHeader("Accept-Encoding", "gzip,deflate");
			HttpResponse cxdryjZW = httpClient.execute(yA6xkkoJ);
			if (cxdryjZW.getStatusLine().getStatusCode() != 200) {
				return null;
			}
			Header dvPvFHvX = cxdryjZW.getFirstHeader("content-type");
			if (dvPvFHvX == null || dvPvFHvX.getValue().indexOf("text/html") < 0) {
				return null;
			}
			int NrevMu5d = dvPvFHvX.getValue().indexOf("charset=");
			if (NrevMu5d >= 0) {
				detectedEncoding = dvPvFHvX.getValue().substring(NrevMu5d + 8);
			}
			aBOlhEYw = cxdryjZW.getEntity();
			InputStream fCPLDlzT = null;
			fCPLDlzT = aBOlhEYw.getContent();
			dvPvFHvX = cxdryjZW.getFirstHeader("Content-Encoding");
			if (null != dvPvFHvX) {
				if (dvPvFHvX.getValue().indexOf("gzip") >= 0) {
					fCPLDlzT = new GZIPInputStream(fCPLDlzT);
				} else if (dvPvFHvX.getValue().indexOf("deflate") >= 0) {
					fCPLDlzT = new InflaterInputStream(fCPLDlzT, new Inflater(true));
				}
			}
			ByteArrayOutputStream sZ65ezmw = new ByteArrayOutputStream();
			byte[] jHT92jew = new byte[1024];
			int zIKmdPSa = 0;
			while ((zIKmdPSa = fCPLDlzT.read(jHT92jew)) != -1) {
				sZ65ezmw.write(jHT92jew, 0, zIKmdPSa);
			}
			URMYf9fe = sZ65ezmw.toByteArray();
		} catch (IOException XRzhVdYu) {
			LOG.warn("downloading error,abandon");
			URMYf9fe = null;
		}
		return URMYf9fe;
	}

}