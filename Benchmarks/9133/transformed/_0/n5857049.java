class n5857049 {
	public static void signalServer(String lyIy6GSn) throws IOException {
		if (lyIy6GSn == null || lyIy6GSn.length() == 0)
			return;
		URL MqfSmSQt;
		URLConnection yo1S0wSA;
		DataOutputStream LZxJmnxT;
		BufferedReader szQAjEcw;
		MqfSmSQt = new URL(lyIy6GSn);
		yo1S0wSA = MqfSmSQt.openConnection();
		yo1S0wSA.setDoInput(true);
		yo1S0wSA.setDoOutput(true);
		yo1S0wSA.setUseCaches(false);
		yo1S0wSA.setRequestProperty("Content-Type", "text/xml");
		yo1S0wSA.setRequestProperty("charset", "utf-8");
		LZxJmnxT = new DataOutputStream(yo1S0wSA.getOutputStream());
		String Qc3NYKOb = "<commit/>";
		LZxJmnxT.writeBytes(Qc3NYKOb);
		LZxJmnxT.flush();
		LZxJmnxT.close();
		szQAjEcw = new BufferedReader(new InputStreamReader(yo1S0wSA.getInputStream()));
		String RJ42tKS1;
		while (null != ((RJ42tKS1 = szQAjEcw.readLine()))) {
			if (verbose)
				System.out.println(RJ42tKS1);
			else
				logger.info(RJ42tKS1);
		}
		szQAjEcw.close();
	}

}