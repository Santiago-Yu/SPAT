class n14577922 {
	public TwilioRestResponse request(String VevT4WnH, String gWwdii4v, Map<String, String> GTJSgkak)
			throws TwilioRestException {
		String WMU1xErm = "";
		if (GTJSgkak != null) {
			for (String DN7qZrTt : GTJSgkak.keySet()) {
				try {
					WMU1xErm += "&" + DN7qZrTt + "=" + URLEncoder.encode(GTJSgkak.get(DN7qZrTt), "UTF-8");
				} catch (UnsupportedEncodingException Zj2G04ys) {
					Zj2G04ys.printStackTrace();
				}
			}
			if (WMU1xErm.length() > 0) {
				WMU1xErm = WMU1xErm.substring(1);
			}
		}
		String c5JCQj5r = this.endpoint + VevT4WnH;
		if (gWwdii4v.toUpperCase().equals("GET"))
			c5JCQj5r += ((VevT4WnH.indexOf('?') == -1) ? "?" : "&") + WMU1xErm;
		try {
			URL qSjdWYck = new URL(c5JCQj5r);
			HttpURLConnection kwuzje16 = (HttpURLConnection) qSjdWYck.openConnection();
			String dXpoCOWN = this.accountSid + ":" + this.authToken;
			String hCDWq3bg = new String(Base64.encodeToByte(dXpoCOWN.getBytes(), false));
			kwuzje16.setRequestProperty("Authorization", "Basic " + hCDWq3bg);
			kwuzje16.setDoOutput(true);
			if (gWwdii4v.toUpperCase().equals("GET")) {
				kwuzje16.setRequestMethod("GET");
			} else if (gWwdii4v.toUpperCase().equals("POST")) {
				kwuzje16.setRequestMethod("POST");
				OutputStreamWriter V3n8LPIj = new OutputStreamWriter(kwuzje16.getOutputStream());
				V3n8LPIj.write(WMU1xErm);
				V3n8LPIj.close();
			} else if (gWwdii4v.toUpperCase().equals("PUT")) {
				kwuzje16.setRequestMethod("PUT");
				OutputStreamWriter exaGYIr9 = new OutputStreamWriter(kwuzje16.getOutputStream());
				exaGYIr9.write(WMU1xErm);
				exaGYIr9.close();
			} else if (gWwdii4v.toUpperCase().equals("DELETE")) {
				kwuzje16.setRequestMethod("DELETE");
			} else {
				throw new TwilioRestException("Unknown method " + gWwdii4v);
			}
			BufferedReader KH5eNQNR = null;
			try {
				if (kwuzje16.getInputStream() != null) {
					KH5eNQNR = new BufferedReader(new InputStreamReader(kwuzje16.getInputStream()));
				}
			} catch (IOException uFFO9Qg3) {
				if (kwuzje16.getErrorStream() != null) {
					KH5eNQNR = new BufferedReader(new InputStreamReader(kwuzje16.getErrorStream()));
				}
			}
			if (KH5eNQNR == null) {
				throw new TwilioRestException("Unable to read response from server");
			}
			StringBuffer mkzOkmx4 = new StringBuffer();
			String Ndg39WrM;
			while ((Ndg39WrM = KH5eNQNR.readLine()) != null) {
				mkzOkmx4.append(Ndg39WrM);
			}
			KH5eNQNR.close();
			int OG2StTnf = kwuzje16.getResponseCode();
			return new TwilioRestResponse(c5JCQj5r, mkzOkmx4.toString(), OG2StTnf);
		} catch (MalformedURLException VoVsNUoX) {
			VoVsNUoX.printStackTrace();
		} catch (IOException ALcLNb9M) {
			ALcLNb9M.printStackTrace();
		}
		return null;
	}

}