class n4159104 {
	public String GetUserPage(String rruOpxBX, int apDJ8Efi) {
		int Ra4g27Wb = apDJ8Efi;
		URL GQvQWrvP;
		String szPgmwmO, dJpsQCmI;
		StringBuffer h01cOy2j = new StringBuffer();
		setStatus("Start moling....");
		startTimer();
		try {
			GQvQWrvP = new URL(HTMLuserpage + rruOpxBX + "?setcount=100&page=" + Ra4g27Wb);
			HttpURLConnection zdZL7tAp = (HttpURLConnection) GQvQWrvP.openConnection();
			zdZL7tAp.addRequestProperty("User-Agent", userAgent);
			System.out.println("moling: page " + Ra4g27Wb + " of " + rruOpxBX);
			BufferedReader EDf22rZR = new BufferedReader(new InputStreamReader(zdZL7tAp.getInputStream()));
			while ((szPgmwmO = EDf22rZR.readLine()) != null) {
				h01cOy2j.append(szPgmwmO);
				h01cOy2j.append("\n");
			}
			EDf22rZR.close();
			zdZL7tAp.disconnect();
			stopTimer();
			setStatus("Dauer : " + dauerMs() + " ms");
			dJpsQCmI = h01cOy2j.toString();
			return dJpsQCmI;
		} catch (MalformedURLException rBcGfw6Z) {
			System.err.println("Bad URL: " + rBcGfw6Z);
			return null;
		} catch (IOException nff3l1qI) {
			System.err.println("IOException: " + nff3l1qI);
			return null;
		}
	}

}