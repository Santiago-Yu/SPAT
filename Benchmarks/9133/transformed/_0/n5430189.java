class n5430189 {
	public void _jspService(HttpServletRequest p47i5TbR, HttpServletResponse wzdETPB2)
			throws java.io.IOException, ServletException {
		PageContext SuIbptbl = null;
		HttpSession KzYvXXnU = null;
		ServletContext MRrDbLMq = null;
		ServletConfig mHmu9pCP = null;
		JspWriter k7rPZVdy = null;
		Object caxnVX3k = this;
		JspWriter PD6ojkUB = null;
		PageContext r2GGwqFv = null;
		try {
			wzdETPB2.setContentType("text/html;charset=UTF-8");
			SuIbptbl = _jspxFactory.getPageContext(this, p47i5TbR, wzdETPB2, null, true, 8192, true);
			r2GGwqFv = SuIbptbl;
			MRrDbLMq = SuIbptbl.getServletContext();
			mHmu9pCP = SuIbptbl.getServletConfig();
			KzYvXXnU = SuIbptbl.getSession();
			k7rPZVdy = SuIbptbl.getOut();
			PD6ojkUB = k7rPZVdy;
			_jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) MRrDbLMq
					.getAttribute("com.sun.appserv.jsp.resource.injector");
			k7rPZVdy.write("\n");
			k7rPZVdy.write("\n");
			k7rPZVdy.write("\n");
			String Sqg4MbD2 = "test";
			String VdOgZL3f = "test";
			int Z1PyHYUz = 1;
			if (p47i5TbR.getParameter("providerId") != null)
				Z1PyHYUz = Integer.parseInt(p47i5TbR.getParameter("providerId"));
			String nZLxgPDU = "http://localhost:8080" + p47i5TbR.getContextPath();
			String BFuYq2z2 = nZLxgPDU + "/index.jsp";
			String O13uFbsg = "";
			String pFZKOaLm = (String) p47i5TbR.getParameter("token_timeout");
			String XmF9hn52 = p47i5TbR.getHeader("Referer");
			if (pFZKOaLm != null && pFZKOaLm.equals("true")) {
				System.out.println("token timeout for referer" + XmF9hn52);
				if (XmF9hn52 != null) {
					if (p47i5TbR.getSession().getServletContext()
							.getAttribute("token_timeout_processing_lock") == null) {
						p47i5TbR.getSession().getServletContext().setAttribute("token_timeout_processing_lock", true);
						byte[] vkj1yFgh = null;
						BufferedInputStream foJHo1gh = null;
						URL pzlwHTQU = new URL(nZLxgPDU + "/ServerAdminServlet?action=login&username=" + Sqg4MbD2
								+ "&password=" + VdOgZL3f);
						URLConnection TGaKOcsk = pzlwHTQU.openConnection();
						int Va0Th4dF = TGaKOcsk.getContentLength();
						InputStream UIA9iuxg = TGaKOcsk.getInputStream();
						vkj1yFgh = new byte[Va0Th4dF];
						int PpaPg3CJ = 0;
						while (PpaPg3CJ < Va0Th4dF) {
							PpaPg3CJ += UIA9iuxg.read(vkj1yFgh, PpaPg3CJ, UIA9iuxg.available());
						}
						O13uFbsg = new String(vkj1yFgh);
						O13uFbsg = O13uFbsg.replaceAll("[\\r\\f]", "");
						O13uFbsg = O13uFbsg.trim();
						p47i5TbR.getSession().getServletContext().setAttribute("token", O13uFbsg);
						k7rPZVdy.println(O13uFbsg);
						p47i5TbR.getSession().getServletContext().removeAttribute("token_timeout_processing_lock");
					} else
						k7rPZVdy.println("token_timeout_processing_lock");
				}
			} else {
				if (p47i5TbR.getSession().getServletContext().getAttribute("token") == null
						|| p47i5TbR.getSession().getServletContext().getAttribute("token").equals("")) {
					byte[] A1yIRWXw = null;
					BufferedInputStream UkZPaT4Y = null;
					URL zDKJ7iEK = new URL(nZLxgPDU + "/ServerAdminServlet?action=login&username=" + Sqg4MbD2
							+ "&password=" + VdOgZL3f);
					URLConnection GqKXljPi = zDKJ7iEK.openConnection();
					int apDrRWlG = GqKXljPi.getContentLength();
					InputStream DDJHJO8W = GqKXljPi.getInputStream();
					A1yIRWXw = new byte[apDrRWlG];
					int x5KSzktL = 0;
					while (x5KSzktL < apDrRWlG) {
						x5KSzktL += DDJHJO8W.read(A1yIRWXw, x5KSzktL, DDJHJO8W.available());
					}
					O13uFbsg = new String(A1yIRWXw);
					O13uFbsg = O13uFbsg.replaceAll("[\\r\\f]", "");
					O13uFbsg = O13uFbsg.trim();
					p47i5TbR.getSession().getServletContext().setAttribute("token", O13uFbsg);
				}
				k7rPZVdy.write("\n");
				k7rPZVdy.write("<html>\n");
				k7rPZVdy.write("  <head>\n");
				k7rPZVdy.write("    <title>AJAX test </title>\n");
				k7rPZVdy.write("    <link rel=\"stylesheet\" href=\"css/default.css\" type=\"text/css\" />\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write(
						"    <script type=\"text/javascript\" src=\"../OpenLayers-2.8/OpenLayers.js\"></script>\n");
				k7rPZVdy.write("    <script type=\"text/javascript\">\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("        var map, layer;\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("        var token = \"");
				k7rPZVdy.print(p47i5TbR.getSession().getServletContext().getAttribute("token"));
				k7rPZVdy.write("\";\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("        function init(){\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("            OpenLayers.IMAGE_RELOAD_ATTEMPTS = 5;\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("            var options = {\n");
				k7rPZVdy.write("                maxExtent: new OpenLayers.Bounds(0, 0, 3000000, 9000000),\n");
				k7rPZVdy.write("                tileSize :new OpenLayers.Size(250, 250),\n");
				k7rPZVdy.write("                units: 'm',\n");
				k7rPZVdy.write("                projection: 'EPSG:3006',\n");
				k7rPZVdy.write(
						"                resolutions : [1.3,2.6,4,6.6,13.2,26.5,66.1,132.3,264.6,793.8,1322.9,2645.8,13229.2,26458.3]\n");
				k7rPZVdy.write("            }\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("            map = new OpenLayers.Map('swedenMap', options);\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write(
						"            layer = new OpenLayers.Layer.TMS(\"TMS\", \"http://localhost:8080/WebGISTileServer/TMSServletProxy/\",\n");
				k7rPZVdy.write(
						"                                            { layername: token + '/7', type: 'png' });\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("            map.addLayer(layer);\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("            map.addControl( new OpenLayers.Control.PanZoom() );\n");
				k7rPZVdy.write("            map.addControl( new OpenLayers.Control.PanZoomBar() );\n");
				k7rPZVdy.write("            map.addControl( new OpenLayers.Control.MouseDefaults());\n");
				k7rPZVdy.write("            map.addControl( new OpenLayers.Control.MousePosition());\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("            map.setCenter(new OpenLayers.LonLat(555555, 6846027), 2);\n");
				k7rPZVdy.write("        }\n");
				k7rPZVdy.write("    </script>\n");
				k7rPZVdy.write("  </head>\n");
				k7rPZVdy.write("  <body onload=\"init()\">\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("        <div id=\"container\">\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("            <div id=\"header\">\n");
				k7rPZVdy.write("                <h1 id=\"logo\">\n");
				k7rPZVdy.write("                    <span>ASP</span> MapServices\n");
				k7rPZVdy.write("                    <small>Web mapping.  <span>EASY</span></small>\n");
				k7rPZVdy.write("                </h1>\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("                <ul id=\"menu\">\n");
				k7rPZVdy.write("                    <li><a href=\"default.html\">Home</a></li>\n");
				k7rPZVdy.write("                    <li><a href=\"demo_world.jsp\">Demonstration</a></li>\n");
				k7rPZVdy.write(
						"                    <li style=\"border-right: none;\"><a href=\"contact.html\">Contact</a></li>\n");
				k7rPZVdy.write("                </ul>\n");
				k7rPZVdy.write("            </div>\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("            <div id=\"body\">\n");
				k7rPZVdy.write("                <ul id=\"maps-menu\">\n");
				k7rPZVdy.write("                    <li><a href=\"demo_world.jsp\">World</a></li>\n");
				k7rPZVdy.write("                    <li><a href=\"demo_sweden_rt90.jsp\">Sweden RT90</a></li>\n");
				k7rPZVdy.write(
						"                    <li><a href=\"demo_sweden_sweref99.jsp\">Sweden SWEREF99</a></li>\n");
				k7rPZVdy.write("                </ul>\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("                <div id=\"swedenMap\" style=\"height:600px\"></div>\n");
				k7rPZVdy.write("            </div>\n");
				k7rPZVdy.write("        </div>\n");
				k7rPZVdy.write("    </body>\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("  </head>\n");
				k7rPZVdy.write("\n");
				k7rPZVdy.write("</html>");
			}
			k7rPZVdy.write('\n');
			k7rPZVdy.write('\n');
		} catch (Throwable okA8n56Q) {
			if (!(okA8n56Q instanceof SkipPageException)) {
				k7rPZVdy = PD6ojkUB;
				if (k7rPZVdy != null && k7rPZVdy.getBufferSize() != 0)
					k7rPZVdy.clearBuffer();
				if (r2GGwqFv != null)
					r2GGwqFv.handlePageException(okA8n56Q);
			}
		} finally {
			_jspxFactory.releasePageContext(r2GGwqFv);
		}
	}

}