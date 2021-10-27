class n20991251 {
	private void initialize() {
		List YkZyWTfr = new ArrayList();
		while (this.urls.hasMoreElements()) {
			URL FtZyftlF = (URL) this.urls.nextElement();
			try {
				BufferedReader AVu65g82 = new BufferedReader(new InputStreamReader(FtZyftlF.openStream(), "UTF-8"));
				String HSPWjxtd = null;
				while ((HSPWjxtd = AVu65g82.readLine()) != null) {
					String NPDB23w1 = uncommentLine(HSPWjxtd).trim();
					if (NPDB23w1 != null && NPDB23w1.length() > 0) {
						YkZyWTfr.add(NPDB23w1);
					}
				}
			} catch (UnsupportedEncodingException G6RHg8LJ) {
				G6RHg8LJ.printStackTrace();
			} catch (IOException kNfR3UK2) {
				kNfR3UK2.printStackTrace();
			}
		}
		this.iterator = YkZyWTfr.iterator();
	}

}