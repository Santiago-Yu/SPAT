class n16899717 {
	public static String loadURLToString(String CQGhTk5R, String RsvY80UW) throws FileNotFoundException, IOException {
		BufferedReader ODReZ1Bq = new BufferedReader(new InputStreamReader((new URL(CQGhTk5R)).openStream()));
		String AkGApZSc = "";
		String ipGU6Vtp;
		while ((ipGU6Vtp = ODReZ1Bq.readLine()) != null) {
			AkGApZSc += ipGU6Vtp + RsvY80UW;
		}
		ODReZ1Bq.close();
		return AkGApZSc;
	}

}