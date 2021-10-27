class n8973505 {
	public static void writeFileType(String uriFile, String outputfile, int num) {
		String uri = null;
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(outputfile));
			int counter = 1;
			uri = null;
			BufferedReader reader = new BufferedReader(new FileReader(uriFile));
			while (counter < num) {
				counter++;
				uri = reader.readLine();
			}
			while ((uri = reader.readLine()) != null) {
				try {
					System.err.println("working on the [" + counter + "]th document.");
					URL url = new URL(uri);
					counter++;
					URLConnection myConnection = url.openConnection();
					String line = null;
					BufferedReader myReader = new BufferedReader(new InputStreamReader(myConnection.getInputStream()));
					boolean hasRDFS = false;
					boolean hasOWL = false;
					int linecount = 0;
					boolean hasRDF = false;
					while ((line = myReader.readLine()) != null) {
						linecount++;
						if (line.indexOf("http://www.w3.org/2002/07/owl") != -1)
							hasOWL = true;
						else if (line.indexOf("http://www.w3.org/2000/01/rdf-schema") != -1)
							hasRDFS = true;
						else if (line.indexOf("http://www.w3.org/1999/02/22-rdf-syntax-ns") != -1)
							hasRDF = true;
						if (linecount > 100)
							break;
					}
					if (hasOWL)
						writer.write(uri + "\t" + OWL);
					else if (hasRDFS)
						writer.write(uri + "\t" + RDFS);
					else if (hasRDF)
						writer.write(uri + "\t" + RDF);
					else
						writer.write(uri + "\t" + UNKNOWN);
					writer.newLine();
					writer.flush();
				} catch (Exception e) {
					e.printStackTrace();
					try {
						writer.write(uri + "\t" + BROKEN);
						writer.newLine();
						writer.flush();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}