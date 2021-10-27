class n16495170 {
	@Override
	public HostRecord addressForHost(String shDmcgkk) throws Exception {
		String qtt70JJq = requestUrlStub + shDmcgkk;
		URL BCxtX151 = new URL(qtt70JJq);
		HttpURLConnection h4hpjFcz = null;
		h4hpjFcz = null;
		h4hpjFcz = (HttpURLConnection) BCxtX151.openConnection();
		h4hpjFcz.setRequestMethod("GET");
		h4hpjFcz.setDoOutput(true);
		h4hpjFcz.setReadTimeout(10000);
		h4hpjFcz.connect();
		BufferedReader MlatGQMQ = new BufferedReader(new InputStreamReader(h4hpjFcz.getInputStream()));
		String tPl5zk7D;
		HostRecord TeZ4TGaC = new HostRecord(shDmcgkk);
		byte HBGte15d[] = new byte[4];
		while ((tPl5zk7D = MlatGQMQ.readLine()) != null) {
			String ySThuX6e = "<span class='orange'>";
			String mmHYHt9P = "</span>";
			int UmuJXcJh = tPl5zk7D.indexOf(ySThuX6e);
			int c0wsZdvf = tPl5zk7D.indexOf(mmHYHt9P);
			if ((UmuJXcJh > 0) && (c0wsZdvf > 0)) {
				String sPWPv8VR = tPl5zk7D.substring(UmuJXcJh + ySThuX6e.length(), c0wsZdvf);
				String[] j6xnkgqy = sPWPv8VR.split("\\.");
				for (int U18v01bd = 0; U18v01bd < j6xnkgqy.length; U18v01bd++)
					HBGte15d[U18v01bd] = (byte) Integer.parseInt(j6xnkgqy[U18v01bd]);
			}
		}
		IPAddress pg3igQb6 = new IPAddress(HBGte15d);
		TeZ4TGaC.addIpAddress(pg3igQb6);
		MlatGQMQ.close();
		return TeZ4TGaC;
	}

}