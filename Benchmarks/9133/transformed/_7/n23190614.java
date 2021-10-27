class n23190614 {
	public void _jspService(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException, ServletException {
		PageContext pageContext = null;
		HttpSession session = null;
		ServletContext application = null;
		ServletConfig config = null;
		JspWriter out = null;
		Object page = this;
		JspWriter _jspx_out = null;
		PageContext _jspx_page_context = null;
		try {
			response.setContentType("text/html;charset=UTF-8");
			pageContext = _jspxFactory.getPageContext(this, request, response, null, true, 8192, true);
			_jspx_page_context = pageContext;
			application = pageContext.getServletContext();
			config = pageContext.getServletConfig();
			session = pageContext.getSession();
			out = pageContext.getOut();
			_jspx_out = out;
			_jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application
					.getAttribute("com.sun.appserv.jsp.resource.injector");
			out.write("\n");
			out.write("\n");
			out.write("\n");
			String username = "test";
			String password = "test";
			int providerId = 1;
			if (request.getParameter("providerId") != null)
				providerId = Integer.parseInt(request.getParameter("providerId"));
			String thisPageContextAddress = "http://localhost:8080/" + request.getContextPath();
			String thisPageServingAddress = thisPageContextAddress + "/index.jsp";
			String token = "";
			String token_timeout = (String) request.getParameter("token_timeout");
			String referer = request.getHeader("Referer");
			if (token_timeout != null && token_timeout.equals("true")) {
				System.out.println("token timeout for referer" + referer);
				if (referer != null) {
					if (request.getSession().getServletContext()
							.getAttribute("token_timeout_processing_lock") == null) {
						request.getSession().getServletContext().setAttribute("token_timeout_processing_lock", true);
						byte[] buff = null;
						BufferedInputStream bis = null;
						URL url = new URL(thisPageContextAddress + "/ServerAdminServlet?action=login&username="
								+ username + "&password=" + password);
						URLConnection urlc = url.openConnection();
						int length = urlc.getContentLength();
						InputStream in = urlc.getInputStream();
						buff = new byte[length];
						int bytesRead = 0;
						while (bytesRead < length) {
							bytesRead = bytesRead + (in.read(buff, bytesRead, in.available()));
						}
						token = new String(buff);
						token = token.replaceAll("[\\r\\f]", "");
						token = token.trim();
						request.getSession().getServletContext().setAttribute("token", token);
						out.println(token);
						request.getSession().getServletContext().removeAttribute("token_timeout_processing_lock");
					} else
						out.println("token_timeout_processing_lock");
				}
			} else {
				if (request.getSession().getServletContext().getAttribute("token") == null
						|| request.getSession().getServletContext().getAttribute("token").equals("")) {
					byte[] buff = null;
					BufferedInputStream bis = null;
					URL url = new URL(thisPageContextAddress + "/ServerAdminServlet?action=login&username=" + username
							+ "&password=" + password);
					URLConnection urlc = url.openConnection();
					int length = urlc.getContentLength();
					InputStream in = urlc.getInputStream();
					buff = new byte[length];
					int bytesRead = 0;
					while (bytesRead < length) {
						bytesRead = bytesRead + (in.read(buff, bytesRead, in.available()));
					}
					token = new String(buff);
					token = token.replaceAll("[\\r\\f]", "");
					token = token.trim();
					request.getSession().getServletContext().setAttribute("token", token);
				}
				out.write("<html>\n");
				out.write("  <head>\n");
				out.write("    <title>AJAX test </title>\n");
				out.write("    <script type=\"text/javascript\" src=\"OpenLayers-2.8/OpenLayers.js\"></script>\n");
				out.write("    <script type=\"text/javascript\">\n");
				out.write("\n");
				out.write("        function init(){\n");
				out.write("\n");
				out.write("            var token = \"");
				out.print(request.getSession().getServletContext().getAttribute("token"));
				out.write("\";\n");
				out.write("\n");
				out.write("            var options = {\n");
				out.write("                            maxExtent: new OpenLayers.Bounds(-600, -300, 0, 400),\n");
				out.write(
						"                            maxResolution: 4.77730, minRezolution: 78271.517, numZoomLevels: 15, units: 'm'\n");
				out.write("                          }\n");
				out.write("\n");
				out.write("\n");
				out.write("            var map = new OpenLayers.Map('map', options);\n");
				out.write(
						"            var layer = new OpenLayers.Layer.TMS(\"TMS\", \"/WebGISTileServer/TMSServletProxy/\" + token + \"/7/\",\n");
				out.write("                                                { layername: 'TMS', type: 'png' });\n");
				out.write("            map.addLayer(layer);\n");
				out.write("            map.addControl(new OpenLayers.Control.MousePosition());\n");
				out.write("            map.setCenter(new OpenLayers.LonLat(-300, 120), 4);\n");
				out.write("        }\n");
				out.write("    </script>\n");
				out.write("  </head>\n");
				out.write("  <body onload=\"init()\">\n");
				out.write("      <H1>TeleAtlas map with TMS</H1>\n");
				out.write("      <div id=\"map\" style=\"width:100%; height:90%\"></div>\n");
				out.write("  </body>\n");
				out.write("</html>");
			}
		} catch (Throwable t) {
			if (!(t instanceof SkipPageException)) {
				out = _jspx_out;
				if (out != null && out.getBufferSize() != 0)
					out.clearBuffer();
				if (_jspx_page_context != null)
					_jspx_page_context.handlePageException(t);
			}
		} finally {
			_jspxFactory.releasePageContext(_jspx_page_context);
		}
	}

}