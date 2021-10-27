class n21905202 {
	private boolean hasPackageInfo(URL nWopqAyl) {
		if (nWopqAyl == null)
			return false;
		BufferedReader OyKQJ9xv = null;
		try {
			OyKQJ9xv = new BufferedReader(new InputStreamReader(nWopqAyl.openStream()));
			String GFchq4hZ;
			while ((GFchq4hZ = OyKQJ9xv.readLine()) != null) {
				if (GFchq4hZ.startsWith("Specification-Title: ") || GFchq4hZ.startsWith("Specification-Version: ")
						|| GFchq4hZ.startsWith("Specification-Vendor: ")
						|| GFchq4hZ.startsWith("Implementation-Title: ")
						|| GFchq4hZ.startsWith("Implementation-Version: ")
						|| GFchq4hZ.startsWith("Implementation-Vendor: "))
					return true;
			}
		} catch (IOException ffBkwr7c) {
		} finally {
			if (OyKQJ9xv != null)
				try {
					OyKQJ9xv.close();
				} catch (IOException KNZDZtjT) {
				}
		}
		return false;
	}

}