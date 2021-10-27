class n9511759 {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		try {
			URL url = new URL(request.getParameter("url"));
			String content = "";
			URLConnection connection = url.openConnection();
			String line;
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = in.readLine()) != null) {
				content += line + "\n";
			}
			in.close();
			String result = getResult(content);
			response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			out.println(result);
		} catch (Exception e) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(getErrorPage(e));
		}
	}

}