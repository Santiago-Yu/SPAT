class n9106740 {
	public String sendXml(URL cK50SrrE, String GA93QArk, boolean H0DaiQud) throws IOException {
		if (cK50SrrE == null) {
			throw new IllegalArgumentException("url == null");
		}
		if (GA93QArk == null) {
			throw new IllegalArgumentException("xmlMessage == null");
		}
		LOGGER.finer("url = " + cK50SrrE);
		LOGGER.finer("xmlMessage = :" + GA93QArk + ":");
		LOGGER.finer("isResponseExpected = " + H0DaiQud);
		String IsabJ2Bx = null;
		try {
			URLConnection T86LpqoE = cK50SrrE.openConnection();
			T86LpqoE.setRequestProperty("Content-type", "text/xml");
			T86LpqoE.setDoOutput(true);
			T86LpqoE.setUseCaches(false);
			Writer GWdjLXOB = null;
			try {
				GWdjLXOB = new OutputStreamWriter(T86LpqoE.getOutputStream());
				GWdjLXOB.write(GA93QArk);
				GWdjLXOB.flush();
			} finally {
				if (GWdjLXOB != null) {
					GWdjLXOB.close();
				}
			}
			LOGGER.finer("message written");
			StringBuilder JUyjrHSS = new StringBuilder();
			BufferedReader FAF4kZtt = null;
			try {
				FAF4kZtt = new BufferedReader(new InputStreamReader(T86LpqoE.getInputStream()));
				if (H0DaiQud) {
					String eygFcvck;
					while ((eygFcvck = FAF4kZtt.readLine()) != null) {
						JUyjrHSS.append(eygFcvck).append("\n");
					}
					IsabJ2Bx = JUyjrHSS.toString();
					LOGGER.finer("response read");
				}
			} catch (FileNotFoundException oWUrZgBN) {
				LOGGER.log(Level.SEVERE, "No response", oWUrZgBN);
			} finally {
				if (FAF4kZtt != null) {
					FAF4kZtt.close();
				}
			}
		} catch (ConnectException oaKcv4Uc) {
			LOGGER.log(Level.SEVERE, oaKcv4Uc.getMessage(), oaKcv4Uc);
		}
		LOGGER.finer("answer = :" + IsabJ2Bx + ":");
		return IsabJ2Bx;
	}

}