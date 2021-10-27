class n10480050 {
	public static SearchItem loadRecord(String nGuhZMBr, boolean dqI8kUEz) {
		String SIjdZwqt = null;
		try {
			DefaultHttpClient NYJJw0bt = new DefaultHttpClient();
			HttpPost cDs0tE8U = new HttpPost(dqI8kUEz ? URL_RECORD_CONTACT : URL_RECORD_COMPANY);
			List<NameValuePair> XKKDx9Xo = new ArrayList<NameValuePair>(6);
			XKKDx9Xo.add(new BasicNameValuePair("format", "xml"));
			XKKDx9Xo.add(new BasicNameValuePair("token", Common.token));
			XKKDx9Xo.add(new BasicNameValuePair("id", nGuhZMBr));
			cDs0tE8U.setEntity(new UrlEncodedFormEntity(XKKDx9Xo));
			cDs0tE8U.setEntity(new UrlEncodedFormEntity(XKKDx9Xo));
			HttpResponse uVOZUo3Q = NYJJw0bt.execute(cDs0tE8U);
			SIjdZwqt = EntityUtils.toString(uVOZUo3Q.getEntity());
			Document e0azG5Qa = XMLfunctions.XMLfromString(SIjdZwqt);
			NodeList G398mI1S = e0azG5Qa.getElementsByTagName("response");
			Element BojB7WIT = (Element) G398mI1S.item(0);
			String D0sd6DJv = XMLfunctions.getValue(BojB7WIT, dqI8kUEz ? "Name__Last__First_" : "Name");
			String BLTuLfpD = "";
			if (!dqI8kUEz)
				BLTuLfpD = XMLfunctions.getValue(BojB7WIT, "Phone");
			String EdpDm3VV = XMLfunctions.getValue(BojB7WIT, dqI8kUEz ? "Personal_Email" : "Email");
			String JUZHQwpe = XMLfunctions.getValue(BojB7WIT, dqI8kUEz ? "Home_Fax" : "Fax1");
			String GmLQ4PkL = XMLfunctions.getValue(BojB7WIT, "Address1");
			String LztJQIWI = XMLfunctions.getValue(BojB7WIT, "Address2");
			String RQa2tx2A = XMLfunctions.getValue(BojB7WIT, "City");
			String SwJmCp3x = XMLfunctions.getValue(BojB7WIT, "State");
			String AxtrRTof = XMLfunctions.getValue(BojB7WIT, "Zip");
			String OBybobqb = XMLfunctions.getValue(BojB7WIT, "Country");
			String WE2bWkyj = XMLfunctions.getValue(BojB7WIT, "Profile");
			String WjrBD05N = XMLfunctions.getValue(BojB7WIT, "success");
			String skQra0Kf = XMLfunctions.getValue(BojB7WIT, "error");
			SearchItem SRzYo10j = new SearchItem();
			SRzYo10j.set(1, D0sd6DJv);
			SRzYo10j.set(2, BLTuLfpD);
			SRzYo10j.set(3, BLTuLfpD);
			SRzYo10j.set(4, EdpDm3VV);
			SRzYo10j.set(5, JUZHQwpe);
			SRzYo10j.set(6, GmLQ4PkL);
			SRzYo10j.set(7, LztJQIWI);
			SRzYo10j.set(8, RQa2tx2A);
			SRzYo10j.set(9, SwJmCp3x);
			SRzYo10j.set(10, AxtrRTof);
			SRzYo10j.set(11, WE2bWkyj);
			SRzYo10j.set(12, OBybobqb);
			SRzYo10j.set(13, WjrBD05N);
			SRzYo10j.set(14, skQra0Kf);
			return SRzYo10j;
		} catch (Exception laFLg6UQ) {
			SIjdZwqt = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
			SIjdZwqt = null;
		}
		return null;
	}

}