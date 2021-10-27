class n8515619 {
	public ResponseStatus submit(Collection<SubmissionData> data) throws IOException {
		if (sessionId == null)
			throw new IllegalStateException("Perform successful handshake first.");
		if (data.size() > 50)
			throw new IllegalArgumentException("Max 50 submissions at once");
		int index = 0;
		StringBuilder builder = new StringBuilder(data.size() * 100);
		for (SubmissionData submissionData : data) {
			builder.append(submissionData.toString(sessionId, index));
			builder.append('\n');
			index++;
		}
		String body = builder.toString();
		if (Caller.getInstance().isDebugMode())
			System.out.println("submit: " + body);
		HttpURLConnection urlConnection = Caller.getInstance().openConnection(submissionUrl);
		urlConnection.setRequestMethod("POST");
		urlConnection.setDoOutput(true);
		OutputStream outputStream = urlConnection.getOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		writer.write(body);
		writer.close();
		InputStream is = urlConnection.getInputStream();
		BufferedReader r = new BufferedReader(new InputStreamReader(is));
		String status = r.readLine();
		r.close();
		int statusCode = ResponseStatus.codeForStatus(status);
		if (statusCode == ResponseStatus.FAILED) {
			return new ResponseStatus(statusCode, status.substring(status.indexOf(' ') + 1));
		}
		return new ResponseStatus(statusCode);
	}

}