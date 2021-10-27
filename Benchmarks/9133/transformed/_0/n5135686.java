class n5135686 {
	private boolean loadNodeData(NodeInfo i1CXqNqm) {
		String UZifpvvY = mServer + "load.php" + ("?id=" + i1CXqNqm.getId()) + ("&mask=" + NodePropertyFlag.Data);
		boolean cVh8OMbu = false;
		try {
			URL Rq9dpNy2 = new URL(UZifpvvY);
			HttpURLConnection Od4Ndjtu = (HttpURLConnection) Rq9dpNy2.openConnection();
			Od4Ndjtu.setAllowUserInteraction(false);
			Od4Ndjtu.setRequestMethod("GET");
			setCredentials(Od4Ndjtu);
			Od4Ndjtu.connect();
			if (Od4Ndjtu.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream Ve24O0Fa = Od4Ndjtu.getInputStream();
				byte[] U4sxWbbR = new byte[0], CEmSMqj0 = new byte[1024];
				boolean V1OZ2zBR = false;
				while (!V1OZ2zBR) {
					int FAeVxIoN = Ve24O0Fa.read(CEmSMqj0);
					if (FAeVxIoN > 0) {
						byte[] z90slPMw = new byte[U4sxWbbR.length + FAeVxIoN];
						System.arraycopy(U4sxWbbR, 0, z90slPMw, 0, U4sxWbbR.length);
						System.arraycopy(CEmSMqj0, 0, z90slPMw, U4sxWbbR.length, FAeVxIoN);
						U4sxWbbR = z90slPMw;
					} else if (FAeVxIoN < 0) {
						V1OZ2zBR = true;
					}
				}
				i1CXqNqm.setData(U4sxWbbR);
				i1CXqNqm.setMIMEType(new MimeType(Od4Ndjtu.getContentType()));
				cVh8OMbu = true;
				Ve24O0Fa.close();
			}
		} catch (Exception AcWYWAPC) {
		}
		return cVh8OMbu;
	}

}