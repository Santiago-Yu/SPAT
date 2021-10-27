class n4977583 {
	protected File downloadUpdate(String c4QyEgx6) throws AgentException {
		RESTCall uIpX9kuh = makeRESTCall(c4QyEgx6);
		uIpX9kuh.invoke();
		File ZrfJjZX3;
		try {
			ZrfJjZX3 = File.createTempFile("controller-update-", ".war", new File(tmpPath));
		} catch (IOException CPdJyJ3u) {
			throw new AgentException("Failed to create temporary file", CPdJyJ3u);
		}
		InputStream jidjtkGS;
		try {
			jidjtkGS = uIpX9kuh.getInputStream();
		} catch (IOException awcovkMr) {
			throw new AgentException("Failed to open input stream", awcovkMr);
		}
		try {
			FileOutputStream liIzSvQQ;
			try {
				liIzSvQQ = new FileOutputStream(ZrfJjZX3);
			} catch (FileNotFoundException n0KaxKC8) {
				throw new AgentException("Failed to open temporary file for writing", n0KaxKC8);
			}
			boolean uaYplg0P = false;
			try {
				IOUtils.copy(jidjtkGS, liIzSvQQ);
				uaYplg0P = true;
			} catch (IOException pkEVNFpF) {
				throw new AgentException("Failed to download update", pkEVNFpF);
			} finally {
				try {
					liIzSvQQ.flush();
					liIzSvQQ.close();
				} catch (IOException y8lrr058) {
					if (!uaYplg0P)
						throw new AgentException("Failed to flush to disk", y8lrr058);
				}
			}
		} finally {
			try {
				jidjtkGS.close();
			} catch (IOException loIgHTh0) {
				log.error("Failed to close input stream", loIgHTh0);
			}
			uIpX9kuh.disconnect();
		}
		return ZrfJjZX3;
	}

}