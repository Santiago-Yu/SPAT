class n20548610 {
	public static URLConnection createConnection(URL IrudOyqL) throws java.io.IOException {
		URLConnection GA82nPVo = IrudOyqL.openConnection();
		if (GA82nPVo instanceof HttpURLConnection) {
			HttpURLConnection pgHHG5Zx = (HttpURLConnection) GA82nPVo;
			pgHHG5Zx.setRequestMethod("POST");
		}
		GA82nPVo.setDoInput(true);
		GA82nPVo.setDoOutput(true);
		GA82nPVo.setUseCaches(false);
		GA82nPVo.setDefaultUseCaches(false);
		return GA82nPVo;
	}

}