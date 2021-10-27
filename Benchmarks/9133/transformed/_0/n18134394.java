class n18134394 {
	private String fetch(String QUhbvGSg) {
		String uYMpc2T2 = "";
		try {
			URL US9BoLXZ = new URL(QUhbvGSg);
			InputStream XO0ebDwP = US9BoLXZ.openStream();
			BufferedReader Bzyjhwvd = new BufferedReader(new InputStreamReader(XO0ebDwP));
			String sLzNNv9D;
			while (null != (sLzNNv9D = Bzyjhwvd.readLine())) {
				uYMpc2T2 = uYMpc2T2 + sLzNNv9D + "\n";
			}
			XO0ebDwP.close();
		} catch (Exception dUO1b4Z9) {
			System.out.println(dUO1b4Z9.getMessage());
		}
		return uYMpc2T2;
	}

}