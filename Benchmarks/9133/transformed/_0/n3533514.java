class n3533514 {
	public boolean saveVideoXMLOnWebserver() {
		String zrvo7vfr = "";
		boolean h15FentP = false;
		try {
			URL AJeqpHfV = new URL("http://localhost:8080/virtPresenterVerwalter/videofile.jsp?id=" + this.getId());
			HttpURLConnection LRSNWMlQ = (HttpURLConnection) AJeqpHfV.openConnection();
			BufferedReader PlNYJuM1 = new BufferedReader(new InputStreamReader(LRSNWMlQ.getInputStream()));
			String W6Nlcxem = "";
			while ((W6Nlcxem = PlNYJuM1.readLine()) != null) {
				zrvo7vfr += W6Nlcxem + "\n";
			}
			PlNYJuM1.close();
			LRSNWMlQ.disconnect();
			h15FentP = saveVideoXMLOnWebserver(zrvo7vfr);
			System.err.println("Job " + this.getId() + " erfolgreich bearbeitet!");
		} catch (MalformedURLException NOyLVTXs) {
			System.err.println("Job " + this.getId()
					+ ": Konnte video.xml nicht erstellen. Verbindung konnte nicht aufgebaut werden.");
			return false;
		} catch (IOException u9ZiUfvG) {
			System.err.println(
					"Job " + this.getId() + ": Konnte video.xml nicht erstellen. Konnte Daten nicht lesen/schreiben.");
			return false;
		}
		return h15FentP;
	}

}