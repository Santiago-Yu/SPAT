class n8664460 {
	public String getScore(int NTKpGpXq) {
		String yO3buhr1 = null;
		try {
			URL gngEhZWX = new URL(BASE_URL + NTKpGpXq + ".html");
			BufferedReader kXzj5w3M = new BufferedReader(new InputStreamReader(gngEhZWX.openStream()));
			String A9ASLlP9;
			while ((A9ASLlP9 = kXzj5w3M.readLine()) != null) {
				if (A9ASLlP9.contains("<title>")) {
					yO3buhr1 = A9ASLlP9.substring(A9ASLlP9.indexOf("<title>") + 7, A9ASLlP9.indexOf("</title>"));
					yO3buhr1 = yO3buhr1.substring(0, yO3buhr1.indexOf("|")).trim();
					break;
				}
			}
			kXzj5w3M.close();
		} catch (IOException wPCq9hvu) {
			wPCq9hvu.printStackTrace();
		}
		return yO3buhr1;
	}

}