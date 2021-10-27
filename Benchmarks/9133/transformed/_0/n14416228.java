class n14416228 {
	private static String sendRPC(String k4RCnOOY) throws MalformedURLException, IOException {
		String Mjbz26K1 = "";
		String TOkycM3F = OSdbServer;
		String h3mTuIy4 = k4RCnOOY;
		URL VZH7drD5 = new URL(TOkycM3F);
		URLConnection MOYvrRqi = VZH7drD5.openConnection();
		MOYvrRqi.setRequestProperty("Connection", "Close");
		MOYvrRqi.setRequestProperty("Content-Type", "text/xml");
		MOYvrRqi.setDoOutput(true);
		MOYvrRqi.getOutputStream().write(h3mTuIy4.getBytes("UTF-8"));
		Scanner MrcroitS;
		MrcroitS = new Scanner(MOYvrRqi.getInputStream());
		while (MrcroitS.hasNextLine()) {
			Mjbz26K1 += MrcroitS.nextLine();
		}
		;
		return Mjbz26K1;
	}

}