class n5430189 {
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
			String thisPageContextAddress = "http://localhost:8080" + request.getContextPath();
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
						for (; bytesRead < length;) {
							bytesRead += in.read(buff, bytesRead, in.available());
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
					for (; bytesRead < length;) {
						bytesRead += in.read(buff, bytesRead, in.available());
					}
					token = new String(buff);
					token = token.replaceAll("[\\r\\f]", "");
					token = token.trim();
					request.getSession().getServletContext().setAttribute("token", token);
				}
				out.write("\n");
				out.write("<html>\n");
				out.write("  <head>\n");
				out.write("    <title>AJAX test </title>\n");
				out.write("    <link rel=\"stylesheet\" href=\"css/default.css\" type=\"text/css\" />\n");
				out.write("\n");
				out.write("    <script type=\"text/javascript\" src=\"../OpenLayers-2.8/OpenLayers.js\"></script>\n");
				out.write("    <script type=\"text/javascript\">\n");
				out.write("\n");
				out.write("        var map, layer;\n");
				out.write("\n");
				out.write("        var token = \"");
				out.print(request.getSession().getServletContext().getAttribute("token"));
				out.write("\";\n");
				out.write("\n");
				out.write("\n");
				out.write("        function init(){\n");
				out.write("\n");
				out.write("            OpenLayers.IMAGE_RELOAD_ATTEMPTS = 5;\n");
				out.write("\n");
				out.write("            var options = {\n");
				out.write("                maxExtent: new OpenLayers.Bounds(0, 0, 3000000, 9000000),\n");
				out.write("                tileSize :new OpenLayers.Size(250, 250),\n");
				out.write("                units: 'm',\n");
				out.write("                projection: 'EPSG:3006',\n");
				out.write(
						"                resolutions : [1.3,2.6,4,6.6,13.2,26.5,66.1,132.3,264.6,793.8,1322.9,2645.8,13229.2,26458.3]\n");
				out.write("            }\n");
				out.write("\n");
				out.write("            map = new OpenLayers.Map('swedenMap', options);\n");
				out.write("\n");
				out.write(
						"            layer = new OpenLayers.Layer.TMS(\"TMS\", \"http://localhost:8080/WebGISTileServer/TMSServletProxy/\",\n");
				out.write("                                            { layername: token + '/7', type: 'png' });\n");
				out.write("\n");
				out.write("            map.addLayer(layer);\n");
				out.write("\n");
				out.write("            map.addControl( new OpenLayers.Control.PanZoom() );\n");
				out.write("            map.addControl( new OpenLayers.Control.PanZoomBar() );\n");
				out.write("            map.addControl( new OpenLayers.Control.MouseDefaults());\n");
				out.write("            map.addControl( new OpenLayers.Control.MousePosition());\n");
				out.write("\n");
				out.write("            map.setCenter(new OpenLayers.LonLat(555555, 6846027), 2);\n");
				out.write("        }\n");
				out.write("    </script>\n");
				out.write("  </head>\n");
				out.write("  <body onload=\"init()\">\n");
				out.write("\n");
				out.write("        <div id=\"container\">\n");
				out.write("\n");
				out.write("            <div id=\"header\">\n");
				out.write("                <h1 id=\"logo\">\n");
				out.write("                    <span>ASP</span> MapServices\n");
				out.write("                    <small>Web mapping.  <span>EASY</span></small>\n");
				out.write("                </h1>\n");
				out.write("\n");
				out.write("                <ul id=\"menu\">\n");
				out.write("                    <li><a href=\"default.html\">Home</a></li>\n");
				out.write("                    <li><a href=\"demo_world.jsp\">Demonstration</a></li>\n");
				out.write(
						"                    <li style=\"border-right: none;\"><a href=\"contact.html\">Contact</a></li>\n");
				out.write("                </ul>\n");
				out.write("            </div>\n");
				out.write("\n");
				out.write("            <div id=\"body\">\n");
				out.write("                <ul id=\"maps-menu\">\n");
				out.write("                    <li><a href=\"demo_world.jsp\">World</a></li>\n");
				out.write("                    <li><a href=\"demo_sweden_rt90.jsp\">Sweden RT90</a></li>\n");
				out.write("                    <li><a href=\"demo_sweden_sweref99.jsp\">Sweden SWEREF99</a></li>\n");
				out.write("                </ul>\n");
				out.write("\n");
				out.write("                <div id=\"swedenMap\" style=\"height:600px\"></div>\n");
				out.write("            </div>\n");
				out.write("        </div>\n");
				out.write("    </body>\n");
				out.write("\n");
				out.write("\n");
				out.write("  </head>\n");
				out.write("\n");
				out.write("</html>");
			}
			out.write('\n');
			out.write('\n');
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