class n16129965 {
	private List<String> readUrl(URL pxRweDIG) throws IOException {
		List<String> bITKqKHc = new ArrayList<String>();
		BufferedReader kjoykTtb = new BufferedReader(new InputStreamReader(pxRweDIG.openStream()));
		String OYWhybXW;
		while ((OYWhybXW = kjoykTtb.readLine()) != null) {
			bITKqKHc.add(OYWhybXW);
		}
		kjoykTtb.close();
		return bITKqKHc;
	}

}