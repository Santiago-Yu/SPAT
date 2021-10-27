class n16343568 {
	public static void doGet(HttpServletRequest hidBcRxK, HttpServletResponse UfysyY8b, CollOPort BfGRyRo1,
			PrintStream aixkVJwg) throws ServletException, IOException {
		UfysyY8b.addDateHeader("Expires", System.currentTimeMillis() - 86400);
		String LU73mE2M = hidBcRxK.getParameter("id");
		String cgYQY32c = hidBcRxK.getParameter("url_index");
		int Xc0fpi8g;
		try {
			Xc0fpi8g = Integer.parseInt(cgYQY32c);
		} catch (NumberFormatException z3B71gAf) {
			Xc0fpi8g = 0;
		}
		Summary FcKa05QA = BfGRyRo1.getSummary(LU73mE2M);
		String Y0nfqjyn = hidBcRxK.getPathInfo();
		if (Y0nfqjyn != null && Y0nfqjyn.length() > 0) {
			Y0nfqjyn = Y0nfqjyn.substring(1);
		}
		String BCmq64u1 = FcKa05QA.getIncludeURL();
		String I6eLP24x[] = BCmq64u1.split(" ");
		String gOvfX45V = I6eLP24x[Xc0fpi8g];
		if (gOvfX45V != null && gOvfX45V.length() > 0) {
			if (Y0nfqjyn.indexOf(":") > 0) {
				gOvfX45V = "";
			} else if (Y0nfqjyn.startsWith("/")) {
				gOvfX45V = gOvfX45V.substring(0, gOvfX45V.indexOf("/"));
			} else if (!gOvfX45V.endsWith("/") && gOvfX45V.indexOf(".") > 0) {
				gOvfX45V = gOvfX45V.substring(0, gOvfX45V.lastIndexOf("/") + 1);
			}
			URL CF695qmX = null;
			try {
				CF695qmX = new URL(gOvfX45V + UfysyY8b.encodeURL(Y0nfqjyn));
			} catch (MalformedURLException hc78nTGb) {
				System.out.println(hc78nTGb);
			}
			URLConnection GrwtXfNU = null;
			if (CF695qmX != null) {
				try {
					GrwtXfNU = CF695qmX.openConnection();
				} catch (IOException LZ4ICdPt) {
					System.out.println(LZ4ICdPt);
				}
			}
			if (GrwtXfNU != null) {
				String r6QuRDqN = GrwtXfNU.getContentType();
				String IQ2SdfVx;
				if (r6QuRDqN == null) {
					r6QuRDqN = "application/x-java-serialized-object";
					IQ2SdfVx = "attachment;filename=\"" + Y0nfqjyn + "\"";
				} else {
					IQ2SdfVx = "inline;filename=\"" + Y0nfqjyn + "\"";
				}
				UfysyY8b.setHeader("content-disposition", IQ2SdfVx);
				UfysyY8b.setContentType(r6QuRDqN);
				try {
					InputStream i5orz7D7 = GrwtXfNU.getInputStream();
					byte[] KrUigG6n = new byte[4096];
					int vsk11UxS;
					while ((vsk11UxS = i5orz7D7.read(KrUigG6n)) >= 0) {
						UfysyY8b.getOutputStream().write(KrUigG6n, 0, vsk11UxS);
					}
					i5orz7D7.close();
				} catch (IOException byOHoksT) {
					UfysyY8b.setContentType("text/plain");
					byOHoksT.printStackTrace(aixkVJwg);
				}
				if (GrwtXfNU instanceof HttpURLConnection) {
					((HttpURLConnection) GrwtXfNU).disconnect();
				}
			}
		}
	}

}