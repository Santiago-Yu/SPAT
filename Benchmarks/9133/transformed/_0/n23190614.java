class n23190614 {
	public void _jspService(HttpServletRequest CDd3bkiq, HttpServletResponse foMIHYBo)
			throws java.io.IOException, ServletException {
		PageContext mH5M47ax = null;
		HttpSession IwZVYlMj = null;
		ServletContext lnCIQSZq = null;
		ServletConfig GBSBjnrq = null;
		JspWriter mUntIYbp = null;
		Object MoIMe5zE = this;
		JspWriter YzQW6vbK = null;
		PageContext j5k5tC4o = null;
		try {
			foMIHYBo.setContentType("text/html;charset=UTF-8");
			mH5M47ax = _jspxFactory.getPageContext(this, CDd3bkiq, foMIHYBo, null, true, 8192, true);
			j5k5tC4o = mH5M47ax;
			lnCIQSZq = mH5M47ax.getServletContext();
			GBSBjnrq = mH5M47ax.getServletConfig();
			IwZVYlMj = mH5M47ax.getSession();
			mUntIYbp = mH5M47ax.getOut();
			YzQW6vbK = mUntIYbp;
			_jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) lnCIQSZq
					.getAttribute("com.sun.appserv.jsp.resource.injector");
			mUntIYbp.write("\n");
			mUntIYbp.write("\n");
			mUntIYbp.write("\n");
			String im7NvBil = "test";
			String rQ7b2vqM = "test";
			int mODKZinX = 1;
			if (CDd3bkiq.getParameter("providerId") != null)
				mODKZinX = Integer.parseInt(CDd3bkiq.getParameter("providerId"));
			String Zrl1EH4N = "http://localhost:8080/" + CDd3bkiq.getContextPath();
			String hntCuCFL = Zrl1EH4N + "/index.jsp";
			String VuO7fGqI = "";
			String P6Kx5xbM = (String) CDd3bkiq.getParameter("token_timeout");
			String iEeeWNhg = CDd3bkiq.getHeader("Referer");
			if (P6Kx5xbM != null && P6Kx5xbM.equals("true")) {
				System.out.println("token timeout for referer" + iEeeWNhg);
				if (iEeeWNhg != null) {
					if (CDd3bkiq.getSession().getServletContext()
							.getAttribute("token_timeout_processing_lock") == null) {
						CDd3bkiq.getSession().getServletContext().setAttribute("token_timeout_processing_lock", true);
						byte[] vtb9Vr0q = null;
						BufferedInputStream JMxNDFga = null;
						URL Er4HOG3J = new URL(Zrl1EH4N + "/ServerAdminServlet?action=login&username=" + im7NvBil
								+ "&password=" + rQ7b2vqM);
						URLConnection CnummdUq = Er4HOG3J.openConnection();
						int uEGCcKXi = CnummdUq.getContentLength();
						InputStream AaMbpjV7 = CnummdUq.getInputStream();
						vtb9Vr0q = new byte[uEGCcKXi];
						int F31zXS0x = 0;
						while (F31zXS0x < uEGCcKXi) {
							F31zXS0x += AaMbpjV7.read(vtb9Vr0q, F31zXS0x, AaMbpjV7.available());
						}
						VuO7fGqI = new String(vtb9Vr0q);
						VuO7fGqI = VuO7fGqI.replaceAll("[\\r\\f]", "");
						VuO7fGqI = VuO7fGqI.trim();
						CDd3bkiq.getSession().getServletContext().setAttribute("token", VuO7fGqI);
						mUntIYbp.println(VuO7fGqI);
						CDd3bkiq.getSession().getServletContext().removeAttribute("token_timeout_processing_lock");
					} else
						mUntIYbp.println("token_timeout_processing_lock");
				}
			} else {
				if (CDd3bkiq.getSession().getServletContext().getAttribute("token") == null
						|| CDd3bkiq.getSession().getServletContext().getAttribute("token").equals("")) {
					byte[] uZLEErpk = null;
					BufferedInputStream BDl4K91h = null;
					URL LuBqvwWI = new URL(Zrl1EH4N + "/ServerAdminServlet?action=login&username=" + im7NvBil
							+ "&password=" + rQ7b2vqM);
					URLConnection hGHgJhHQ = LuBqvwWI.openConnection();
					int Ngn5WLuF = hGHgJhHQ.getContentLength();
					InputStream brNiijTH = hGHgJhHQ.getInputStream();
					uZLEErpk = new byte[Ngn5WLuF];
					int VXxPbhrY = 0;
					while (VXxPbhrY < Ngn5WLuF) {
						VXxPbhrY += brNiijTH.read(uZLEErpk, VXxPbhrY, brNiijTH.available());
					}
					VuO7fGqI = new String(uZLEErpk);
					VuO7fGqI = VuO7fGqI.replaceAll("[\\r\\f]", "");
					VuO7fGqI = VuO7fGqI.trim();
					CDd3bkiq.getSession().getServletContext().setAttribute("token", VuO7fGqI);
				}
				mUntIYbp.write("<html>\n");
				mUntIYbp.write("  <head>\n");
				mUntIYbp.write("    <title>AJAX test </title>\n");
				mUntIYbp.write("    <script type=\"text/javascript\" src=\"OpenLayers-2.8/OpenLayers.js\"></script>\n");
				mUntIYbp.write("    <script type=\"text/javascript\">\n");
				mUntIYbp.write("\n");
				mUntIYbp.write("        function init(){\n");
				mUntIYbp.write("\n");
				mUntIYbp.write("            var token = \"");
				mUntIYbp.print(CDd3bkiq.getSession().getServletContext().getAttribute("token"));
				mUntIYbp.write("\";\n");
				mUntIYbp.write("\n");
				mUntIYbp.write("            var options = {\n");
				mUntIYbp.write("                            maxExtent: new OpenLayers.Bounds(-600, -300, 0, 400),\n");
				mUntIYbp.write(
						"                            maxResolution: 4.77730, minRezolution: 78271.517, numZoomLevels: 15, units: 'm'\n");
				mUntIYbp.write("                          }\n");
				mUntIYbp.write("\n");
				mUntIYbp.write("\n");
				mUntIYbp.write("            var map = new OpenLayers.Map('map', options);\n");
				mUntIYbp.write(
						"            var layer = new OpenLayers.Layer.TMS(\"TMS\", \"/WebGISTileServer/TMSServletProxy/\" + token + \"/7/\",\n");
				mUntIYbp.write("                                                { layername: 'TMS', type: 'png' });\n");
				mUntIYbp.write("            map.addLayer(layer);\n");
				mUntIYbp.write("            map.addControl(new OpenLayers.Control.MousePosition());\n");
				mUntIYbp.write("            map.setCenter(new OpenLayers.LonLat(-300, 120), 4);\n");
				mUntIYbp.write("        }\n");
				mUntIYbp.write("    </script>\n");
				mUntIYbp.write("  </head>\n");
				mUntIYbp.write("  <body onload=\"init()\">\n");
				mUntIYbp.write("      <H1>TeleAtlas map with TMS</H1>\n");
				mUntIYbp.write("      <div id=\"map\" style=\"width:100%; height:90%\"></div>\n");
				mUntIYbp.write("  </body>\n");
				mUntIYbp.write("</html>");
			}
		} catch (Throwable H5V7sAyG) {
			if (!(H5V7sAyG instanceof SkipPageException)) {
				mUntIYbp = YzQW6vbK;
				if (mUntIYbp != null && mUntIYbp.getBufferSize() != 0)
					mUntIYbp.clearBuffer();
				if (j5k5tC4o != null)
					j5k5tC4o.handlePageException(H5V7sAyG);
			}
		} finally {
			_jspxFactory.releasePageContext(j5k5tC4o);
		}
	}

}