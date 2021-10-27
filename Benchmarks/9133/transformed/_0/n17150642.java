class n17150642 {
	public void run() {
		try {
			URL kJpoCl84 = new URL("http://localhost:8080/WebGISTileServer/index.jsp?token_timeout=true");
			URLConnection OLdg8njo = kJpoCl84.openConnection();
			OLdg8njo.addRequestProperty("Referer", "http://localhost:8080/index.jsp");
			BufferedReader C5pSKIv3 = new BufferedReader(new InputStreamReader(OLdg8njo.getInputStream()));
			String jJILnEGr;
			while ((jJILnEGr = C5pSKIv3.readLine()) != null)
				System.out.println(jJILnEGr);
		} catch (Exception H2DxSyAk) {
			H2DxSyAk.printStackTrace();
		}
	}

}