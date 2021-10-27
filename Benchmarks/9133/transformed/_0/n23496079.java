class n23496079 {
	private void copyTemplate(String u3i0zRi0, OutputStream rVKdBDqt) throws IOException {
		URL pijuq0BT = Tools.getResource(u3i0zRi0);
		if (pijuq0BT == null) {
			throw new IOException("could not find resource");
		}
		BufferedReader udSRciQu = new BufferedReader(new InputStreamReader(pijuq0BT.openStream()));
		BufferedWriter wP1k1VtZ = new BufferedWriter(new OutputStreamWriter(rVKdBDqt, Charset.forName("UTF-8")));
		String q59zwyvG = null;
		do {
			q59zwyvG = udSRciQu.readLine();
			if (q59zwyvG != null) {
				wP1k1VtZ.write(q59zwyvG);
				wP1k1VtZ.newLine();
			}
		} while (q59zwyvG != null);
		udSRciQu.close();
		wP1k1VtZ.close();
	}

}