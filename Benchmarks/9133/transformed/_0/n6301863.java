class n6301863 {
	protected String doRawRequest(String qxWLZVjD) throws IOException {
		URL ZKmpzf0n = new URL(SERVICE_URL);
		URLConnection TDaXZOdL = ZKmpzf0n.openConnection();
		TDaXZOdL.setDoOutput(true);
		OutputStreamWriter QeW000wR = new OutputStreamWriter(TDaXZOdL.getOutputStream());
		QeW000wR.write(qxWLZVjD);
		QeW000wR.flush();
		BufferedReader h0MjNBs6 = new BufferedReader(new InputStreamReader(TDaXZOdL.getInputStream()));
		StringBuffer wOMr65Vg = new StringBuffer();
		String rhXC1tsu;
		while ((rhXC1tsu = h0MjNBs6.readLine()) != null) {
			wOMr65Vg.append(rhXC1tsu);
		}
		QeW000wR.close();
		h0MjNBs6.close();
		return wOMr65Vg.toString();
	}

}