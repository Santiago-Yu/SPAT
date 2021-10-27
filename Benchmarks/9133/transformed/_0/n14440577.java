class n14440577 {
	@Override
	protected void doGet(HttpServletRequest QcbVyIef, HttpServletResponse kPzyO4UP)
			throws ServletException, IOException {
		String g2egk7P0 = QcbVyIef.getParameter("cacheName");
		if (g2egk7P0 == null || g2egk7P0.equals("")) {
			kPzyO4UP.getWriter().println("parameter cacheName required");
			return;
		} else {
			StringBuffer a4eV8ffr = new StringBuffer();
			a4eV8ffr.append(BASE_URL);
			a4eV8ffr.append("?");
			a4eV8ffr.append("cacheName=");
			a4eV8ffr.append("rpcwc.bo.cache.");
			a4eV8ffr.append(g2egk7P0);
			URL Ryhd7dOk = new URL(a4eV8ffr.toString());
			BufferedReader FsknGQ3V = new BufferedReader(new InputStreamReader(Ryhd7dOk.openStream()));
			String RMjGdUVb = null;
			StringBuffer t84pH6RD = new StringBuffer();
			while ((RMjGdUVb = FsknGQ3V.readLine()) != null) {
				t84pH6RD.append(RMjGdUVb);
				t84pH6RD.append(System.getProperty("line.separator"));
			}
			FsknGQ3V.close();
			kPzyO4UP.getWriter().println(t84pH6RD.toString());
		}
	}

}