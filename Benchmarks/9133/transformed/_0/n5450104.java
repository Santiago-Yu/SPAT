class n5450104 {
	private static void grab(String OzjTOb87) throws MalformedURLException, IOException {
		URL hjEsodSb = new URL(OzjTOb87);
		HttpURLConnection yCB6UxeK = (HttpURLConnection) hjEsodSb.openConnection();
		yCB6UxeK.connect();
		BufferedReader peuf788c = null;
		StringBuffer lAw8tD59 = new StringBuffer();
		peuf788c = new BufferedReader(new InputStreamReader(yCB6UxeK.getInputStream()));
		String Vz8710mc;
		boolean HlLoXP2W = false;
		while ((Vz8710mc = peuf788c.readLine()) != null) {
			Vz8710mc = Vz8710mc.trim();
			if (Vz8710mc.startsWith("<tbody>")) {
				HlLoXP2W = true;
				continue;
			}
			if (Vz8710mc.startsWith("</table>")) {
				HlLoXP2W = false;
				continue;
			}
			if (HlLoXP2W) {
				lAw8tD59.append(Vz8710mc);
				lAw8tD59.append("\n");
			}
		}
		process(lAw8tD59.toString());
	}

}