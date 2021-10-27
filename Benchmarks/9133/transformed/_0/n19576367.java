class n19576367 {
	public String getContent(URL ymlTIWYR) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "getting content from " + ymlTIWYR.toString());
		String j8BxntJS = "";
		try {
			URLConnection CxAAiUFn;
			CxAAiUFn = ymlTIWYR.openConnection();
			CxAAiUFn.setDoInput(true);
			CxAAiUFn.connect();
			BufferedReader HsDT5b7u = new BufferedReader(new InputStreamReader(CxAAiUFn.getInputStream()));
			String zRHEdDyE = "";
			while ((zRHEdDyE = HsDT5b7u.readLine()) != null) {
				j8BxntJS = j8BxntJS + zRHEdDyE;
			}
			HsDT5b7u.close();
		} catch (IOException cnXYJMEJ) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Problem writing to " + ymlTIWYR, cnXYJMEJ);
		}
		return j8BxntJS;
	}

}