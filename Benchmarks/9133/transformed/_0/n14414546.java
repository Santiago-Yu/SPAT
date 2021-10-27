class n14414546 {
	private void deleteProject(String Egkx93UJ, String yDcapVJk, HttpServletRequest T8njLqYP,
			HttpServletResponse NOwIQPbH) throws Exception {
		String TiUatpTX = T8njLqYP.getParameter("project");
		String BsSiaHDL;
		NOwIQPbH.setContentType("text/html");
		PrintWriter MV7VV8Rg = NOwIQPbH.getWriter();
		htmlHeader(MV7VV8Rg, "Project Status", "");
		try {
			synchronized (Class.forName("com.sun.gep.SunTCP")) {
				Vector HbBpdAkk = new Vector();
				String v3JAVGJY = yDcapVJk;
				Runtime.getRuntime().exec("/usr/bin/rm -rf " + v3JAVGJY + TiUatpTX);
				FilePermission gCgzggdK = new FilePermission(v3JAVGJY + SUNTCP_LIST, "read,write,execute");
				File Hs14Q05x = new File(v3JAVGJY + SUNTCP_LIST);
				BufferedReader F3HVMm7t = new BufferedReader(new FileReader(Hs14Q05x));
				while ((BsSiaHDL = F3HVMm7t.readLine()) != null) {
					if (!((new StringTokenizer(BsSiaHDL, "\t")).nextToken().equals(TiUatpTX))) {
						HbBpdAkk.addElement(BsSiaHDL);
					}
				}
				F3HVMm7t.close();
				if (HbBpdAkk.size() > 0) {
					PrintWriter YuLgeNBc = new PrintWriter(new BufferedWriter(new FileWriter(Hs14Q05x)));
					for (int ERdIi4qT = 0; ERdIi4qT < HbBpdAkk.size(); ERdIi4qT++) {
						YuLgeNBc.println((String) HbBpdAkk.get(ERdIi4qT));
					}
					YuLgeNBc.close();
				} else {
					Hs14Q05x.delete();
				}
				MV7VV8Rg.println("The project was successfully deleted.");
			}
		} catch (Exception nPE3RZae) {
			MV7VV8Rg.println("Error accessing this project.");
		}
		MV7VV8Rg.println(
				"<center><form><input type=button value=Continue onClick=\"opener.location.reload(); window.close()\"></form></center>");
		htmlFooter(MV7VV8Rg);
	}

}