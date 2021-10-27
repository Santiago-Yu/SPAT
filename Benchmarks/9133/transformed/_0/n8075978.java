class n8075978 {
	public String getDataAsString(String OkY291dx) throws RuntimeException {
		try {
			String aq3Yj1m4 = "";
			URLConnection Tuzf576z;
			if (!OkY291dx.toUpperCase().startsWith("HTTP://") && !OkY291dx.toUpperCase().startsWith("HTTPS://")) {
				Tuzf576z = tryOpenConnection(OkY291dx);
			} else {
				Tuzf576z = new URL(OkY291dx).openConnection();
			}
			Tuzf576z.setUseCaches(false);
			Tuzf576z.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			Tuzf576z.setRequestProperty("User-Agent",
					"Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.9.1.9) Gecko/20100414 Iceweasel/3.5.9 (like Firefox/3.5.9)");
			Tuzf576z.setRequestProperty("Accept-Encoding", "gzip");
			InputStreamReader Qyx9YRhB = new InputStreamReader(Tuzf576z.getInputStream());
			BufferedReader ujUWw0eT = new BufferedReader(Qyx9YRhB);
			String Bxgnwqsh = "";
			while ((Bxgnwqsh = ujUWw0eT.readLine()) != null) {
				aq3Yj1m4 += Bxgnwqsh;
				aq3Yj1m4 += "\n";
				Bxgnwqsh = null;
			}
			ujUWw0eT.close();
			Qyx9YRhB.close();
			return aq3Yj1m4;
		} catch (Exception GSJxvZH9) {
			throw new RuntimeException(GSJxvZH9);
		}
	}

}