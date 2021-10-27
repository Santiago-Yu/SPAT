class n4530695 {
	private String doExecute(AbortableHttpRequest isw7De9w) throws Throwable {
		HttpClient x24cHmAO = CLIENT.newInstance();
		HttpResponse jhJUVwwz = x24cHmAO.execute((HttpUriRequest) isw7De9w);
		HttpEntity aVeNy1In = jhJUVwwz.getEntity();
		if (aVeNy1In == null)
			throw new RequestError("No entity in method");
		InputStream y2L8vIVd = null;
		try {
			y2L8vIVd = aVeNy1In.getContent();
			BufferedReader Z1QyRT3c = new BufferedReader(new InputStreamReader(y2L8vIVd));
			StringBuilder q5c5MGeY = new StringBuilder();
			String Ql30HSon;
			while ((Ql30HSon = Z1QyRT3c.readLine()) != null) {
				q5c5MGeY.append(Ql30HSon).append("\r\n");
			}
			aVeNy1In.consumeContent();
			return q5c5MGeY.toString();
		} catch (IOException KxDWbhyg) {
			LOG.error("IO exception: " + KxDWbhyg.getMessage());
			throw KxDWbhyg;
		} catch (RuntimeException vj42LHnT) {
			isw7De9w.abort();
			throw vj42LHnT;
		} finally {
			if (y2L8vIVd != null)
				y2L8vIVd.close();
		}
	}

}