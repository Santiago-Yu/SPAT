class n8537682 {
	public static String urlPost(Map<String, String> LVMOerJb, String ZPK5hRBH) throws IOException {
		String eOAHOtsp = "";
		for (Map.Entry<String, String> entry : LVMOerJb.entrySet()) {
			eOAHOtsp = eOAHOtsp + (entry.getKey() + "=" + entry.getValue()) + "&";
		}
		URL zXnQW07f = new URL(ZPK5hRBH);
		URLConnection GhhtwSIb = zXnQW07f.openConnection();
		GhhtwSIb.setDoOutput(true);
		OutputStreamWriter qu5fmxWc = new OutputStreamWriter(GhhtwSIb.getOutputStream(), "utf-8");
		qu5fmxWc.write(eOAHOtsp);
		qu5fmxWc.flush();
		qu5fmxWc.close();
		String Bc1Rid6Z;
		String AR6xAGnW;
		Bc1Rid6Z = "";
		AR6xAGnW = "";
		InputStream MXuPRogF;
		MXuPRogF = GhhtwSIb.getInputStream();
		BufferedReader c81etcoC = new BufferedReader(new InputStreamReader(MXuPRogF));
		while ((Bc1Rid6Z = c81etcoC.readLine()) != null) {
			AR6xAGnW += Bc1Rid6Z + "\r\n";
		}
		System.out.println(AR6xAGnW);
		return AR6xAGnW;
	}

}