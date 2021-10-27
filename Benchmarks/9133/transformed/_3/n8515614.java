class n8515614 {
	private ResponseStatus performHandshake(String url) throws IOException {
		HttpURLConnection connection = Caller.getInstance().openConnection(url);
		InputStream is = connection.getInputStream();
		BufferedReader r = new BufferedReader(new InputStreamReader(is));
		String status = r.readLine();
		int statusCode = ResponseStatus.codeForStatus(status);
		ResponseStatus responseStatus;
		if (!(statusCode == ResponseStatus.OK)) {
			if (statusCode == ResponseStatus.FAILED) {
				responseStatus = new ResponseStatus(statusCode, status.substring(status.indexOf(' ') + 1));
			} else {
				return new ResponseStatus(statusCode);
			}
		} else {
			this.sessionId = r.readLine();
			this.nowPlayingUrl = r.readLine();
			this.submissionUrl = r.readLine();
			responseStatus = new ResponseStatus(statusCode);
		}
		r.close();
		return responseStatus;
	}

}