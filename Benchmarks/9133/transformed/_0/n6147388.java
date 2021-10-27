class n6147388 {
	public static GCalendar getNewestCalendar(Calendar mG19U6ue) throws IOException {
		GCalendar njp3v4ck = null;
		try {
			HttpClient UFI6jtkP = new DefaultHttpClient();
			HttpClient JJEqGdEf = new DefaultHttpClient();
			HttpGet QNqsCHia = new HttpGet("http://localhost:8080/GoogleCalendar/select");
			HttpResponse ZB31WvnO = JJEqGdEf.execute(QNqsCHia);
			String oQdyk54V = ZB31WvnO.getEntity().toString();
			System.out.println("jsonstr = " + oQdyk54V);
			njp3v4ck = JSON.decode(oQdyk54V, GCalendar.class);
		} catch (Exception F1ozvl8c) {
			F1ozvl8c.printStackTrace();
		}
		return njp3v4ck;
	}

}