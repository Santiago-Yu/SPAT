class n5186187 {
	public void doGet(HttpServletRequest ahgDIbWg, HttpServletResponse VD3CR88l) throws ServletException, IOException {
		VD3CR88l.setContentType(CONTENT_TYPE);
		URL FK2aTzem;
		URLConnection BC0abO3D;
		DataOutputStream LZve7DEq;
		FK2aTzem = new URL("http://localhost:8080/ListeOnLine/Target");
		BC0abO3D = FK2aTzem.openConnection();
		BC0abO3D.setDoInput(true);
		BC0abO3D.setDoOutput(true);
		BC0abO3D.setUseCaches(false);
		BC0abO3D.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		LZve7DEq = new DataOutputStream(BC0abO3D.getOutputStream());
		String D9wjqqQh = "param1=" + URLEncoder.encode("first parameter") + "&param2="
				+ URLEncoder.encode("the second one...");
		LZve7DEq.writeBytes(D9wjqqQh);
		LZve7DEq.flush();
		LZve7DEq.close();
		BufferedReader hSD5D0EY = new BufferedReader(new InputStreamReader(BC0abO3D.getInputStream()));
		PrintWriter J8w2XGWw = VD3CR88l.getWriter();
		J8w2XGWw.print("<html><body><h1>This is the Source Servlet</h1><p />");
		String GE8KXhd0 = null;
		while (null != (GE8KXhd0 = hSD5D0EY.readLine())) {
			J8w2XGWw.println(GE8KXhd0);
		}
		hSD5D0EY.close();
		J8w2XGWw.print("</body></html>");
		J8w2XGWw.close();
	}

}