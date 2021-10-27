class n11149084 {
	private void deleteProject(String VaDh3XRz, String SXUtbQCj, HttpServletRequest WDY4m7W6,
			HttpServletResponse iKzqwqnn) throws Exception {
		String pnXsW7Hv = WDY4m7W6.getParameter("project");
		String rF3stN7d;
		iKzqwqnn.setContentType("text/html");
		PrintWriter v0ODholO = iKzqwqnn.getWriter();
		htmlHeader(v0ODholO, "Project Status", "");
		try {
			synchronized (Class.forName("com.sun.gep.SunTCP")) {
				Vector UNlXyKJh = new Vector();
				String wb3PC2st = SXUtbQCj;
				Runtime.getRuntime().exec("/usr/bin/rm -rf " + wb3PC2st + pnXsW7Hv);
				FilePermission DdbFIrh6 = new FilePermission(wb3PC2st + SUNTCP_LIST, "read,write,execute");
				File Y9qjzYcQ = new File(wb3PC2st + SUNTCP_LIST);
				BufferedReader foZ5cpYI = new BufferedReader(new FileReader(Y9qjzYcQ));
				while ((rF3stN7d = foZ5cpYI.readLine()) != null) {
					if (!((new StringTokenizer(rF3stN7d, "\t")).nextToken().equals(pnXsW7Hv))) {
						UNlXyKJh.addElement(rF3stN7d);
					}
				}
				foZ5cpYI.close();
				if (UNlXyKJh.size() > 0) {
					PrintWriter wdOaf3RF = new PrintWriter(new BufferedWriter(new FileWriter(Y9qjzYcQ)));
					for (int m1H7R0kX = 0; m1H7R0kX < UNlXyKJh.size(); m1H7R0kX++) {
						wdOaf3RF.println((String) UNlXyKJh.get(m1H7R0kX));
					}
					wdOaf3RF.close();
				} else {
					Y9qjzYcQ.delete();
				}
				v0ODholO.println("The project was successfully deleted.");
			}
		} catch (Exception Uv5SmS7p) {
			v0ODholO.println("Error accessing this project.");
		}
		v0ODholO.println(
				"<center><form><input type=button value=Continue onClick=\"opener.location.reload(); window.close()\"></form></center>");
		htmlFooter(v0ODholO);
	}

}