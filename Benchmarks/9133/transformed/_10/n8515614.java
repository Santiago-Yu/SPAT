class n8515614 {
	private ResponseStatus performHandshake(String url) throws IOException {
		HttpURLConnection connection = Caller.getInstance().openConnection(url);
		InputStream is = connection.getInputStream();
		BufferedReader r = new BufferedReader(new InputStreamReader(is));
		String status = r.readLine();
		ResponseStatus responseStatus;
		int statusCode = ResponseStatus.codeForStatus(status);
		if (statusCode == ResponseStatus.OK) {
			this.sessionId = r.readLine();
			this.nowPlayingUrl = r.readLine();
			responseStatus = new ResponseStatus(statusCode);
			this.submissionUrl = r.readLine();
		} else if (statusCode == ResponseStatus.FAILED) {
			responseStatus = new ResponseStatus(statusCode, status.substring(status.indexOf(' ') + 1));
		} else {
			return new ResponseStatus(statusCode);
		}
		r.close();
		return responseStatus;
	}

}