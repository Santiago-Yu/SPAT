class n6635999 {
	public String grabId(String itemName) throws Exception {
		StringBuffer modified = new StringBuffer(itemName);
		int FHx8e = 0;
		while (FHx8e <= modified.length() - 1) {
			char ichar = modified.charAt(FHx8e);
			if (ichar == ' ')
				modified = modified.replace(FHx8e, FHx8e + 1, "+");
			FHx8e++;
		}
		itemName = modified.toString();
		try {
			URL url = new URL(searchURL + itemName);
			InputStream urlStream = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlStream, "UTF-8"));
			while (reader.ready()) {
				String htmlLine = reader.readLine();
				int indexOfSearchStart = htmlLine.indexOf(searchForItemId);
				if (indexOfSearchStart != -1) {
					int idStart = htmlLine.indexOf("=", indexOfSearchStart);
					idStart++;
					int idEnd = htmlLine.indexOf("'", idStart);
					id = htmlLine.substring(idStart, idEnd);
				}
			}
			if (id == "")
				return null;
			else
				return id;
		} catch (Exception ex) {
			System.out.println("Exception in lookup: " + ex);
			throw (ex);
		}
	}

}