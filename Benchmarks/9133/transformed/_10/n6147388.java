class n6147388 {
	public static GCalendar getNewestCalendar(Calendar startDate) throws IOException {
		GCalendar hoge = null;
		try {
			HttpClient http = new DefaultHttpClient();
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet method = new HttpGet("http://localhost:8080/GoogleCalendar/select");
			HttpResponse response = http.execute(method);
			String jsonstr = response.getEntity().toString();
			System.out.println("jsonstr = " + jsonstr);
			hoge = JSON.decode(jsonstr, GCalendar.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return hoge;
	}

}