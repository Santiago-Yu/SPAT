class n7614574 {
	protected void doGet(HttpServletRequest rESNqGY8, HttpServletResponse XqnFIetw)
			throws ServletException, IOException {
		String FgQNsXon = getInitParameter("zOntoJsonApiServletUrl");
		URL KUN5fBTR = new URL(FgQNsXon + "?" + rESNqGY8.getQueryString());
		XqnFIetw.setContentType("text/html");
		InputStreamReader eGkLLMQY = new InputStreamReader(KUN5fBTR.openStream());
		BufferedReader sCtY777M = new BufferedReader(eGkLLMQY);
		String PZSUiVYR = "";
		String C9gUU5Q7 = sCtY777M.readLine();
		PrintWriter u9lk4XsS = XqnFIetw.getWriter();
		while (C9gUU5Q7 != null) {
			PZSUiVYR += C9gUU5Q7;
			C9gUU5Q7 = sCtY777M.readLine();
		}
		u9lk4XsS.print(PZSUiVYR);
		u9lk4XsS.close();
	}

}