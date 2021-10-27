class n7902699 {
	public static List<String> getLevelIndex(URL QOiIF729) {
		List<String> x9VPZQlZ = new ArrayList<String>();
		BufferedReader OX02V8CK;
		try {
			URLConnection uHZKHNsw = QOiIF729.openConnection();
			uHZKHNsw.setConnectTimeout(30000);
			if (uHZKHNsw.getContentEncoding() != null) {
				OX02V8CK = new BufferedReader(
						new InputStreamReader(uHZKHNsw.getInputStream(), uHZKHNsw.getContentEncoding()));
			} else {
				OX02V8CK = new BufferedReader(new InputStreamReader(uHZKHNsw.getInputStream(), "utf-8"));
			}
		} catch (IOException SZ6l1jyO) {
			System.err.println("HexTD::readFile:: Can't read from " + QOiIF729);
			return x9VPZQlZ;
		}
		String igxplBRR;
		try {
			while ((igxplBRR = OX02V8CK.readLine()) != null) {
				if (igxplBRR.trim().length() != 0) {
					x9VPZQlZ.add(igxplBRR);
				}
			}
		} catch (IOException SMqT3iIp) {
			Logger.getLogger(MapLoaderClient.class.getName()).log(Level.SEVERE, null, SMqT3iIp);
		}
		return x9VPZQlZ;
	}

}