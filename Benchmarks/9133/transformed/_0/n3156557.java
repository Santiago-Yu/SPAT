class n3156557 {
	public boolean checkWebsite(String P7EeHXq8, String Uak745YH) {
		boolean Q8ZQd14y = false;
		try {
			URL vRkOuS67 = new URL(P7EeHXq8 + "?a=" + Math.random());
			BufferedReader bppu2i3x = new BufferedReader(new InputStreamReader(vRkOuS67.openStream()));
			String PVoeLt09 = "";
			while ((PVoeLt09 = bppu2i3x.readLine()) != null) {
				if (PVoeLt09.contains(Uak745YH)) {
					Q8ZQd14y = true;
				}
			}
		} catch (Exception Eb2Z20ME) {
			Q8ZQd14y = false;
		}
		return Q8ZQd14y;
	}

}