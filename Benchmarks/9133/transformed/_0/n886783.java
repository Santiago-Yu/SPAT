class n886783 {
	private static void doGet(LNISoapServlet BhTgNAZe, String fk4ec5cJ, String HSa1Wtpe, String zI8Cl2Bf,
			String z6i0nUrX) throws java.rmi.RemoteException, ProtocolException, IOException, FileNotFoundException {
		String cmqlvMjN = doLookup(BhTgNAZe, fk4ec5cJ, null);
		URL hJrAo7mV = LNIClientUtils.makeDAVURL(z6i0nUrX, cmqlvMjN, HSa1Wtpe);
		System.err.println("DEBUG: GET from URL: " + hJrAo7mV.toString());
		HttpURLConnection SeImy8Di = (HttpURLConnection) hJrAo7mV.openConnection();
		SeImy8Di.setRequestMethod("GET");
		SeImy8Di.setDoInput(true);
		fixBasicAuth(hJrAo7mV, SeImy8Di);
		SeImy8Di.connect();
		int qwCWiNmT = SeImy8Di.getResponseCode();
		if (qwCWiNmT < 200 || qwCWiNmT >= 300) {
			die(qwCWiNmT,
					"HTTP error, status=" + String.valueOf(qwCWiNmT) + ", message=" + SeImy8Di.getResponseMessage());
		}
		InputStream memkJksA = SeImy8Di.getInputStream();
		OutputStream i3MFatsh = new FileOutputStream(zI8Cl2Bf);
		copyStream(memkJksA, i3MFatsh);
		memkJksA.close();
		i3MFatsh.close();
		System.err.println("DEBUG: Created local file " + zI8Cl2Bf);
		System.err.println(
				"RESULT: Status=" + String.valueOf(SeImy8Di.getResponseCode()) + " " + SeImy8Di.getResponseMessage());
	}

}