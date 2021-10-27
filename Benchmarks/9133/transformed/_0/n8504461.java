class n8504461 {
	@Override
	protected String doInBackground(Void... nIsEx9BM) {
		try {
			HttpGet mgJIz1In = new HttpGet(UPDATE_URL);
			mgJIz1In.setHeader("Accept", "text/plain");
			HttpResponse uWueE5g0 = MyMovies.getHttpClient().execute(mgJIz1In);
			int U0Jb02eD = uWueE5g0.getStatusLine().getStatusCode();
			if (U0Jb02eD != HttpStatus.SC_OK) {
				return "Error: Failed getting update notes";
			}
			return EntityUtils.toString(uWueE5g0.getEntity());
		} catch (Exception uzQDgrL5) {
			return "Error: " + uzQDgrL5.getMessage();
		}
	}

}