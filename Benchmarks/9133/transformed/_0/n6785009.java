class n6785009 {
	private String[] sendRequest(String cYCWbrCJ, String qywqabn0) throws ClickatellException, IOException {
		String phBzTc9K = null;
		MessageFormat jK544Mr8 = new MessageFormat("{0}: {1}");
		List npXohRuS = new LinkedList();
		try {
			log_.debug("sendRequest: posting : " + qywqabn0 + " to " + cYCWbrCJ);
			URL iOqoFVKm = new URL(cYCWbrCJ);
			URLConnection s5NNlgiL = iOqoFVKm.openConnection();
			s5NNlgiL.setDoInput(true);
			s5NNlgiL.setDoOutput(true);
			s5NNlgiL.setUseCaches(false);
			s5NNlgiL.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			PrintWriter D9y74FFC = new PrintWriter(s5NNlgiL.getOutputStream());
			D9y74FFC.print(qywqabn0);
			D9y74FFC.flush();
			D9y74FFC.close();
			InputStream b1SGC3U4 = s5NNlgiL.getInputStream();
			BufferedReader hpeSX3LD = new BufferedReader(new InputStreamReader(b1SGC3U4));
			while ((phBzTc9K = hpeSX3LD.readLine()) != null) {
				Object[] C6N0RhQv = jK544Mr8.parse(phBzTc9K);
				if ("ERR".equalsIgnoreCase((String) C6N0RhQv[0])) {
					MessageFormat Vfrb9ZkQ = new MessageFormat("{0}: {1}, {2}");
					Object[] xC0tAhuF = Vfrb9ZkQ.parse(phBzTc9K);
					String WkWXyAv9 = (String) xC0tAhuF[1];
					String MfZmjsWf = (String) xC0tAhuF[2];
					throw new ClickatellException("Clickatell error. Error " + WkWXyAv9 + ", " + MfZmjsWf,
							Integer.parseInt(WkWXyAv9));
				}
				log_.debug("sendRequest: Got ID : " + ((String) C6N0RhQv[1]));
				npXohRuS.add(C6N0RhQv[1]);
			}
			hpeSX3LD.close();
		} catch (ParseException AspJDqXW) {
			throw new ClickatellException("Unexpected response from Clickatell. : " + phBzTc9K,
					ClickatellException.ERROR_UNKNOWN);
		}
		return (String[]) npXohRuS.toArray(new String[npXohRuS.size()]);
	}

}