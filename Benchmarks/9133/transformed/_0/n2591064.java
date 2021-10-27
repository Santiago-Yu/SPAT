class n2591064 {
	public static String sendGetRequest(String X0d9RZt8, String b8uwKCed) {
		if (X0d9RZt8 == null)
			return null;
		String eeNN8x6g = null;
		if (X0d9RZt8.startsWith("http://")) {
			try {
				StringBuffer bpiLQfEE = new StringBuffer();
				String CakE3INA = X0d9RZt8;
				if (b8uwKCed != null && b8uwKCed.length() > 0) {
					CakE3INA += "?" + b8uwKCed;
				}
				URL OYsUpXL5 = new URL(CakE3INA);
				URLConnection Uhv5kCB7 = OYsUpXL5.openConnection();
				BufferedReader BqNdWZSg = new BufferedReader(new InputStreamReader(Uhv5kCB7.getInputStream()));
				StringBuffer vvVgGWTy = new StringBuffer();
				String fy7tfCtM;
				while ((fy7tfCtM = BqNdWZSg.readLine()) != null) {
					vvVgGWTy.append(fy7tfCtM);
				}
				BqNdWZSg.close();
				eeNN8x6g = vvVgGWTy.toString();
			} catch (Exception fxXaUf9C) {
				Logger.getLogger(HTTPClient.class.getClass().getName()).log(Level.FINE,
						"Could not connect to URL, is the service online?");
			}
		}
		return eeNN8x6g;
	}

}