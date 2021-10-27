class n22932987 {
	protected String readContent(URL joLHrP5R, int tAnTcqLq) {
		StringBuffer q9FcKMZ7 = new StringBuffer("");
		String vA9EImSJ = "";
		try {
			BufferedReader POoF61dd = new BufferedReader(new InputStreamReader(joLHrP5R.openStream()));
			while ((vA9EImSJ = POoF61dd.readLine()) != null)
				q9FcKMZ7.append(vA9EImSJ + "\n");
			POoF61dd.close();
		} catch (IOException me5AhWGs) {
			me5AhWGs.printStackTrace();
		}
		if (tAnTcqLq >= 0) {
			String vj6eUKFu = "width=\"xxx\"";
			String GpBafpKi = "width=\"" + tAnTcqLq + "\"";
			int qlfPx18U = q9FcKMZ7.indexOf(vj6eUKFu);
			int euMqtC6o = qlfPx18U + vj6eUKFu.length();
			q9FcKMZ7.replace(qlfPx18U, euMqtC6o, GpBafpKi);
		}
		return q9FcKMZ7.toString();
	}

}