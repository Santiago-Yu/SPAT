class n13462484 {
	public static GoogleResponse getElevation(String nNSsztVi, String O1zYnIf6) throws IOException {
		String tU8IQYQM = "http://maps.google.com/maps/api/elevation/xml?locations=";
		tU8IQYQM = tU8IQYQM + String.valueOf(nNSsztVi);
		tU8IQYQM = tU8IQYQM + ",";
		tU8IQYQM = tU8IQYQM + String.valueOf(O1zYnIf6);
		tU8IQYQM = tU8IQYQM + "&sensor=false";
		BufferedReader NZqIoleu = new BufferedReader(new InputStreamReader(new URL(tU8IQYQM).openStream()));
		String BpJQwBaw;
		GoogleResponse m3tMGiMd = new GoogleResponse();
		m3tMGiMd.lat = Double.valueOf(nNSsztVi);
		m3tMGiMd.lon = Double.valueOf(O1zYnIf6);
		while ((BpJQwBaw = NZqIoleu.readLine()) != null) {
			BpJQwBaw = BpJQwBaw.trim();
			if (BpJQwBaw.startsWith("<status>")) {
				BpJQwBaw = BpJQwBaw.replace("<status>", "");
				BpJQwBaw = BpJQwBaw.replace("</status>", "");
				m3tMGiMd.status = BpJQwBaw;
				if (!BpJQwBaw.toLowerCase().equals("ok"))
					return m3tMGiMd;
			} else if (BpJQwBaw.startsWith("<elevation>")) {
				BpJQwBaw = BpJQwBaw.replace("<elevation>", "");
				BpJQwBaw = BpJQwBaw.replace("</elevation>", "");
				m3tMGiMd.elevation = Double.valueOf(BpJQwBaw);
				return m3tMGiMd;
			}
		}
		return m3tMGiMd;
	}

}