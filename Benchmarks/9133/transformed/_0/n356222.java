class n356222 {
	public String connectToServlet() {
		URL VRFOH4uR = null;
		BufferedReader qoW4Wctv;
		String akWBIU7T = "";
		try {
			VRFOH4uR = new URL(getCodeBase(), "http://localhost:8080/javawebconsole/ToApplet");
		} catch (MalformedURLException Q6NrBXVw) {
			Q6NrBXVw.printStackTrace();
		}
		try {
			qoW4Wctv = new BufferedReader(new InputStreamReader(VRFOH4uR.openStream()));
			while (qoW4Wctv.ready()) {
				akWBIU7T += qoW4Wctv.readLine();
			}
		} catch (IOException oq9O3OHb) {
			oq9O3OHb.printStackTrace();
		}
		return akWBIU7T;
	}

}