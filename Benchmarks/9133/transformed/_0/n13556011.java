class n13556011 {
	public static String[] getHints(String BVWnxFO4) {
		try {
			URL WipvwtIc = new URL(
					"http://www.ebi.ac.uk/integr8/OrganismSearch.do?action=orgNames&orgName=" + BVWnxFO4);
			BufferedReader OyQkCAnR = new BufferedReader(new InputStreamReader(WipvwtIc.openStream()));
			String Rog0eUcI;
			String p5GrYnSi = new String();
			while ((Rog0eUcI = OyQkCAnR.readLine()) != null)
				p5GrYnSi = p5GrYnSi.concat(Rog0eUcI);
			OyQkCAnR.close();
			Matcher jko6R0Jv = taxonPattern.matcher(p5GrYnSi);
			ArrayList<String> AWSdNjFY = new ArrayList<String>();
			while (jko6R0Jv.find()) {
				AWSdNjFY.add(jko6R0Jv.group(1));
			}
			return AWSdNjFY.toArray(new String[] {});
		} catch (MalformedURLException cNIQUrni) {
			cNIQUrni.printStackTrace();
		} catch (IOException SIjTDEX6) {
			SIjTDEX6.printStackTrace();
		}
		return new String[0];
	}

}