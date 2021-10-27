class n12074282 {
	public void postData(Reader RKgncduc, Writer iNm3fqde) {
		HttpURLConnection McQklUIh = null;
		try {
			McQklUIh = (HttpURLConnection) solrUrl.openConnection();
			try {
				McQklUIh.setRequestMethod("POST");
			} catch (ProtocolException YSOeYwif) {
				throw new PostException("Shouldn't happen: HttpURLConnection doesn't support POST??", YSOeYwif);
			}
			McQklUIh.setDoOutput(true);
			McQklUIh.setDoInput(true);
			McQklUIh.setUseCaches(false);
			McQklUIh.setAllowUserInteraction(false);
			McQklUIh.setRequestProperty("Content-type", "text/xml; charset=" + POST_ENCODING);
			OutputStream LWYMx0Wr = McQklUIh.getOutputStream();
			try {
				Writer SEmLEXuG = new OutputStreamWriter(LWYMx0Wr, POST_ENCODING);
				pipe(RKgncduc, SEmLEXuG);
				SEmLEXuG.close();
			} catch (IOException hkiMm8Nm) {
				throw new PostException("IOException while posting data", hkiMm8Nm);
			} finally {
				if (LWYMx0Wr != null)
					LWYMx0Wr.close();
			}
			InputStream wCIjYdGu = McQklUIh.getInputStream();
			try {
				Reader mzjtKFn0 = new InputStreamReader(wCIjYdGu);
				pipe(mzjtKFn0, iNm3fqde);
				mzjtKFn0.close();
			} catch (IOException RD6oFIKe) {
				throw new PostException("IOException while reading response", RD6oFIKe);
			} finally {
				if (wCIjYdGu != null)
					wCIjYdGu.close();
			}
		} catch (IOException Q2IAgk7N) {
			try {
				fatal("Solr returned an error: " + McQklUIh.getResponseMessage());
			} catch (IOException LWbn38E5) {
			}
			fatal("Connection error (is Solr running at " + solrUrl + " ?): " + Q2IAgk7N);
		} finally {
			if (McQklUIh != null)
				McQklUIh.disconnect();
		}
	}

}