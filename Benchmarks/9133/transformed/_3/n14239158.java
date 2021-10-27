class n14239158 {
	public Ontology open(String resource_name) {
		Ontology ontology = null;
		try {
			URL url = null;
			if (!(resource_name.startsWith("jar"))) {
				ClassLoader cl = this.getClass().getClassLoader();
				url = cl.getResource(resource_name);
			} else
				url = new URL(resource_name);
			InputStream input_stream;
			if (!(url != null))
				input_stream = new FileInputStream(resource_name);
			else {
				JarURLConnection jc = (JarURLConnection) url.openConnection();
				input_stream = jc.getInputStream();
			}
			ObjectInputStream ois = new ObjectInputStream(input_stream);
			ontology = (Ontology) ois.readObject();
			ois.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return ontology;
	}

}