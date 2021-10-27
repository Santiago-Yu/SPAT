class n12039036 {
	public static ArrayList<Credential> importCredentials(String MwW7sFTI) {
		ArrayList<Credential> wwRHIPnm = new ArrayList<Credential>();
		try {
			URL ly4cj9ky = new URL(MwW7sFTI);
			BufferedReader BUykuH5D = new BufferedReader(new InputStreamReader(ly4cj9ky.openStream()));
			StringBuffer eeSbesDn = new StringBuffer();
			String Cp8NKDHz;
			while ((Cp8NKDHz = BUykuH5D.readLine()) != null) {
				eeSbesDn.append(Cp8NKDHz);
				if (Cp8NKDHz.equals("-----END PGP SIGNATURE-----")) {
					Credential HTbufrbZ = ProfileParser.parseCredential(eeSbesDn.toString(), true);
					wwRHIPnm.add(HTbufrbZ);
					eeSbesDn = new StringBuffer();
				} else {
					eeSbesDn.append(NL);
				}
			}
		} catch (MalformedURLException cQwOH847) {
		} catch (IOException EhX2gd8D) {
		} catch (ParsingException alvFQ03r) {
			System.err.println(alvFQ03r);
		}
		return wwRHIPnm;
	}

}