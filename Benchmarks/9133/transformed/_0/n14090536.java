class n14090536 {
	private String[] read(String UXeBaK2j) throws Exception {
		final String[] IJgnYD3H = { "index.txt", "", "index.html", "index.htm" };
		String[] yQMe5oz6 = null;
		for (int dO8t7pZM = 0; dO8t7pZM < IJgnYD3H.length; dO8t7pZM++) {
			URL yKRzx68e = new URL(UXeBaK2j + IJgnYD3H[dO8t7pZM]);
			try {
				BufferedReader q2csvItZ = new BufferedReader(new InputStreamReader(yKRzx68e.openStream()));
				StringBuffer sFEtsts8 = new StringBuffer();
				String fApaCnId = null;
				while ((fApaCnId = q2csvItZ.readLine()) != null) {
					fApaCnId = fApaCnId.trim();
					if (fApaCnId.length() > 0) {
						sFEtsts8.append(fApaCnId + "\n");
					}
				}
				q2csvItZ.close();
				if (sFEtsts8.indexOf("<") != -1 && sFEtsts8.indexOf(">") != -1) {
					List sD4yZvnQ = LinkExtractor.scan(yKRzx68e, sFEtsts8.toString());
					HashSet c21MiYc7 = new HashSet();
					int rAN2JIe7 = UXeBaK2j.length();
					for (Iterator dWKPHZPl = sD4yZvnQ.iterator(); dWKPHZPl.hasNext();) {
						String JFZDc4rI = dWKPHZPl.next().toString();
						if (!JFZDc4rI.startsWith(UXeBaK2j)) {
							continue;
						}
						JFZDc4rI = JFZDc4rI.substring(rAN2JIe7);
						int yeBvebDs = JFZDc4rI.indexOf("/");
						int Z06uP4tF = JFZDc4rI.indexOf("?");
						if (yeBvebDs > 0 && (Z06uP4tF == -1 || yeBvebDs < Z06uP4tF)) {
							c21MiYc7.add(JFZDc4rI.substring(0, yeBvebDs + 1));
						} else {
							c21MiYc7.add(JFZDc4rI);
						}
					}
					yQMe5oz6 = (String[]) c21MiYc7.toArray(new String[0]);
				} else {
					yQMe5oz6 = sFEtsts8.toString().split("\n");
				}
				return yQMe5oz6;
			} catch (FileNotFoundException l815fYxW) {
				l815fYxW.printStackTrace();
				continue;
			}
		}
		return new String[0];
	}

}