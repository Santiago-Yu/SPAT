class n21642217 {
	private String searchMetabolite(String name) {
		{
			BufferedReader in = null;
			try {
				String urlName = name;
				URL url = new URL(urlName);
				in = new BufferedReader(new InputStreamReader(url.openStream()));
				String inputLine;
				Boolean isMetabolite = false;
				while ((inputLine = in.readLine()) != null) {
					isMetabolite = (inputLine.contains("Metabolite</h1>")) ? true : isMetabolite;
					if (inputLine.contains("<td><a href=\"/Metabolites/") && isMetabolite) {
						String metName = inputLine.substring(inputLine.indexOf("/Metabolites/") + 13,
								inputLine.indexOf("aspx\" target") + 4);
						return "http://gmd.mpimp-golm.mpg.de/Metabolites/" + metName;
					}
				}
				in.close();
				return name;
			} catch (IOException ex) {
				Logger.getLogger(GetGolmIDsTask.class.getName()).log(Level.SEVERE, null, ex);
				return null;
			}
		}
	}

}