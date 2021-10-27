class n839266 {
	private static String getDocumentAt(String tTeCZmOf) {
		StringBuffer s4vsv7zW = new StringBuffer();
		try {
			URL R3pCoIS2 = new URL(tTeCZmOf);
			URLConnection fN8ESVVI = R3pCoIS2.openConnection();
			BufferedReader D7YfnJ14 = new BufferedReader(new InputStreamReader(fN8ESVVI.getInputStream()));
			String PYkVr9fo = null;
			while ((PYkVr9fo = D7YfnJ14.readLine()) != null)
				s4vsv7zW.append(PYkVr9fo + "\n");
			D7YfnJ14.close();
		} catch (MalformedURLException LLDuTFfw) {
			System.out.println("??งน??URL: " + tTeCZmOf);
		} catch (IOException iPXaZPpN) {
			iPXaZPpN.printStackTrace();
		}
		return s4vsv7zW.toString();
	}

}