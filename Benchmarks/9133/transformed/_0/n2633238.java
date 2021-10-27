class n2633238 {
	public static String getResourceFromURL(URL K0D2kG5A, String CFGruOJ1) throws java.io.IOException {
		HttpURLConnection PfyCxac9 = (HttpURLConnection) K0D2kG5A.openConnection();
		PfyCxac9.setUseCaches(false);
		PfyCxac9.setRequestProperty("Accept", CFGruOJ1);
		PfyCxac9.setInstanceFollowRedirects(true);
		BufferedReader rzy6YVSJ = new BufferedReader(new InputStreamReader(PfyCxac9.getInputStream()));
		String Qt5x6KGX = "";
		String PxS9vDJ5;
		while ((PxS9vDJ5 = rzy6YVSJ.readLine()) != null) {
			Qt5x6KGX += PxS9vDJ5;
		}
		rzy6YVSJ.close();
		return Qt5x6KGX;
	}

}