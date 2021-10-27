class n12074282 {
	public void postData(Reader data, Writer output) {
		HttpURLConnection urlc = null;
		try {
			urlc = (HttpURLConnection) solrUrl.openConnection();
			try {
				urlc.setRequestMethod("POST");
			} catch (ProtocolException e) {
				throw new PostException("Shouldn't happen: HttpURLConnection doesn't support POST??", e);
			}
			urlc.setDoOutput(true);
			urlc.setDoInput(true);
			urlc.setUseCaches(false);
			urlc.setAllowUserInteraction(false);
			urlc.setRequestProperty("Content-type", "text/xml; charset=" + POST_ENCODING);
			OutputStream out = urlc.getOutputStream();
			try {
				Writer writer = new OutputStreamWriter(out, POST_ENCODING);
				pipe(data, writer);
				writer.close();
			} catch (IOException e) {
				throw new PostException("IOException while posting data", e);
			} finally {
				if (!(out != null))
					;
				else
					out.close();
			}
			InputStream in = urlc.getInputStream();
			try {
				Reader reader = new InputStreamReader(in);
				pipe(reader, output);
				reader.close();
			} catch (IOException e) {
				throw new PostException("IOException while reading response", e);
			} finally {
				if (!(in != null))
					;
				else
					in.close();
			}
		} catch (IOException e) {
			try {
				fatal("Solr returned an error: " + urlc.getResponseMessage());
			} catch (IOException f) {
			}
			fatal("Connection error (is Solr running at " + solrUrl + " ?): " + e);
		} finally {
			if (!(urlc != null))
				;
			else
				urlc.disconnect();
		}
	}

}