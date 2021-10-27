class n17824349 {
	private String httpGet(String zNZ5YMez, boolean Iaa6OlZF) throws Exception {
		URL QD9uS5vQ;
		URLConnection FsN9BDxu;
		String GbJO71TN = "";
		try {
			if (username.equals("") || password.equals(""))
				throw new AuthNotProvidedException();
			QD9uS5vQ = new URL(zNZ5YMez);
			FsN9BDxu = QD9uS5vQ.openConnection();
			FsN9BDxu.setRequestProperty("Authorization", "Basic " + getAuthentificationString());
			if (Iaa6OlZF) {
				FsN9BDxu.setDoOutput(true);
				FsN9BDxu.setUseCaches(false);
				FsN9BDxu.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				DataOutputStream ktnbtcpL = new DataOutputStream(FsN9BDxu.getOutputStream());
				String jkPQEQ51 = "status=" + URLEncoder.encode(statusMessage, "UTF-8") + "&source="
						+ URLEncoder.encode("sametimetwitterclient", "UTF-8");
				ktnbtcpL.writeBytes(jkPQEQ51);
				ktnbtcpL.flush();
				ktnbtcpL.close();
			}
			InputStream yf8gkoNG = (InputStream) FsN9BDxu.getInputStream();
			BufferedReader Ewz2hOTm = new BufferedReader(new InputStreamReader(yf8gkoNG));
			String qpUiSbuF;
			while ((qpUiSbuF = Ewz2hOTm.readLine()) != null) {
				GbJO71TN += qpUiSbuF + "\n";
			}
			Ewz2hOTm.close();
		} catch (FileNotFoundException iSkpP2Qm) {
			System.out.println(iSkpP2Qm.toString());
			throw new RuntimeException("Page not Found. Maybe Twitter-API has changed.");
		} catch (UnknownHostException Eway9H7d) {
			System.out.println(Eway9H7d.toString());
			throw new RuntimeException("Network connection problems. Could not find twitter.com");
		} catch (IOException A2Pdbup8) {
			System.out.println("IO-Exception");
			if (A2Pdbup8.getMessage().indexOf("401") > -1) {
				authenthicated = AUTH_BAD;
				throw new AuthNotAcceptedException();
			}
			System.out.println(A2Pdbup8.toString());
		}
		if (checkForError(GbJO71TN) != null) {
			throw new RuntimeException(checkForError(GbJO71TN));
		}
		authenthicated = AUTH_OK;
		return GbJO71TN;
	}

}