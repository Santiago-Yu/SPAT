class n9511759 {
	protected void doGet(HttpServletRequest LNbRDNXv, HttpServletResponse nlnkYDXQ)
			throws ServletException, IOException {
		nlnkYDXQ.setCharacterEncoding("UTF-8");
		try {
			String JFVGDDLV = "";
			URL FyEBAgOH = new URL(LNbRDNXv.getParameter("url"));
			URLConnection f5l0exwr = FyEBAgOH.openConnection();
			BufferedReader Z2LqYCzj = new BufferedReader(new InputStreamReader(f5l0exwr.getInputStream()));
			String cCphgrvU;
			while ((cCphgrvU = Z2LqYCzj.readLine()) != null) {
				JFVGDDLV += cCphgrvU + "\n";
			}
			Z2LqYCzj.close();
			String crfVPUFf = getResult(JFVGDDLV);
			nlnkYDXQ.setContentType("text/plain");
			PrintWriter OLljKfVh = nlnkYDXQ.getWriter();
			OLljKfVh.println(crfVPUFf);
		} catch (Exception CRpHZsS1) {
			nlnkYDXQ.setContentType("text/html");
			PrintWriter Kkl68gOY = nlnkYDXQ.getWriter();
			Kkl68gOY.println(getErrorPage(CRpHZsS1));
		}
	}

}