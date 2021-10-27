class n13522884 {
	private void processRequest(HttpServletRequest opweIIFo, HttpServletResponse jHyF4Jcr) throws IOException {
		jHyF4Jcr.setContentType("text/html");
		ServletContext or75G5u1 = getServletContext();
		RequestDispatcher Nguk5nr2 = or75G5u1.getRequestDispatcher(SETUP_JSP);
		HttpSession sBFrkmQU = opweIIFo.getSession(false);
		if (sBFrkmQU == null) {
			sBFrkmQU = opweIIFo.getSession(true);
			sBFrkmQU.setAttribute(ERROR_TAG, "You need to have run the Sniffer before running "
					+ "the Grinder. Go to <a href=\"/index.jsp\">the start page</a> " + " to run the Sniffer.");
			Nguk5nr2 = or75G5u1.getRequestDispatcher(ERROR_JSP);
		} else {
			sBFrkmQU.setMaxInactiveInterval(-1);
			String koXINkjM = opweIIFo.getParameter(ACTION_TAG);
			if (koXINkjM != null && koXINkjM.equals(START_TAG)) {
				Nguk5nr2 = or75G5u1.getRequestDispatcher(WAIT_JSP);
				int o761lTQd = 1;
				int jbePa4VR = 1;
				int PBgU9284 = 1;
				try {
					o761lTQd = Integer.parseInt(opweIIFo.getParameter("procs"));
					o761lTQd = o761lTQd > MAX_PROCS ? MAX_PROCS : o761lTQd;
				} catch (NumberFormatException nPIhC5SD) {
				}
				try {
					jbePa4VR = Integer.parseInt(opweIIFo.getParameter("threads"));
					jbePa4VR = jbePa4VR > MAX_THREADS ? MAX_THREADS : jbePa4VR;
				} catch (NumberFormatException bIhBs0C5) {
				}
				try {
					PBgU9284 = Integer.parseInt(opweIIFo.getParameter("cycles"));
					PBgU9284 = PBgU9284 > MAX_CYCLES ? MAX_CYCLES : PBgU9284;
				} catch (NumberFormatException ksPZsY8M) {
				}
				try {
					String OzFsGmYB = (String) sBFrkmQU.getAttribute(OUTPUT_TAG);
					File TJLx8Po9 = new File(OzFsGmYB);
					(new File(OzFsGmYB + File.separator + LOG_DIR)).mkdir();
					FileInputStream ttbOzPUY = new FileInputStream(GPROPS);
					FileOutputStream uj2E89VK = new FileOutputStream(OzFsGmYB + File.separator + GPROPS);
					copyBytes(ttbOzPUY, uj2E89VK);
					ttbOzPUY.close();
					InitialContext xg17GrEp = new InitialContext();
					Boolean lJf6ulcb = (Boolean) sBFrkmQU.getAttribute(SECURE_TAG);
					if (lJf6ulcb.booleanValue()) {
						uj2E89VK.write(("grinder.plugin=" + "net.grinder.plugin.http.HttpsPlugin" + "\n").getBytes());
						String KnREKTqq = (String) xg17GrEp.lookup(CERTIFICATE);
						String Cec96yQE = (String) xg17GrEp.lookup(PASSWORD);
						uj2E89VK.write(("grinder.plugin.parameter.clientCert=" + KnREKTqq + "\n").getBytes());
						uj2E89VK.write(("grinder.plugin.parameter.clientCertPassword=" + Cec96yQE + "\n").getBytes());
					} else {
						uj2E89VK.write(("grinder.plugin=" + "net.grinder.plugin.http.HttpPlugin\n").getBytes());
					}
					uj2E89VK.write(("grinder.processes=" + o761lTQd + "\n").getBytes());
					uj2E89VK.write(("grinder.threads=" + jbePa4VR + "\n").getBytes());
					uj2E89VK.write(("grinder.cycles=" + PBgU9284 + "\n").getBytes());
					ttbOzPUY = new FileInputStream(OzFsGmYB + File.separator + SNIFFOUT);
					copyBytes(ttbOzPUY, uj2E89VK);
					ttbOzPUY.close();
					uj2E89VK.close();
					String l5UKls4S = (String) xg17GrEp.lookup(CLASSPATH);
					String WRWkqrwj[] = new String[JAVA_PROCESS.length + 1 + GRINDER_PROCESS.length];
					int qfvipuaY = 0;
					int CdNeRjYj = JAVA_PROCESS.length;
					System.arraycopy(JAVA_PROCESS, 0, WRWkqrwj, qfvipuaY, CdNeRjYj);
					WRWkqrwj[CdNeRjYj] = l5UKls4S;
					qfvipuaY = CdNeRjYj + 1;
					CdNeRjYj = GRINDER_PROCESS.length;
					System.arraycopy(GRINDER_PROCESS, 0, WRWkqrwj, qfvipuaY, CdNeRjYj);
					for (int Fb9m4tLA = 0; Fb9m4tLA < WRWkqrwj.length; ++Fb9m4tLA) {
						System.out.print(WRWkqrwj[Fb9m4tLA] + " ");
					}
					Process eU1dBDqH = Runtime.getRuntime().exec(WRWkqrwj, null, TJLx8Po9);
					sBFrkmQU.setAttribute(PROCESS_TAG, eU1dBDqH);
				} catch (NamingException OX2XezDH) {
					OX2XezDH.printStackTrace();
					sBFrkmQU.setAttribute(ERROR_MSG_TAG, OX2XezDH.toString());
					sBFrkmQU.setMaxInactiveInterval(TIMEOUT);
					Nguk5nr2 = or75G5u1.getRequestDispatcher(ERROR_JSP);
				} catch (Throwable XIIUegAB) {
					XIIUegAB.printStackTrace(jHyF4Jcr.getWriter());
					throw new IOException(XIIUegAB.getMessage());
				}
			} else if (koXINkjM != null && koXINkjM.equals(CHECK_TAG)) {
				boolean jdAy2C8q = true;
				try {
					Process hGQoaQlr = (Process) sBFrkmQU.getAttribute(PROCESS_TAG);
					int rhOjpBXG = hGQoaQlr.exitValue();
				} catch (IllegalThreadStateException SzL17JAY) {
					jdAy2C8q = false;
				}
				if (jdAy2C8q) {
					sBFrkmQU.setMaxInactiveInterval(TIMEOUT);
					Nguk5nr2 = or75G5u1.getRequestDispatcher(RESULTS_JSP);
				} else {
					Nguk5nr2 = or75G5u1.getRequestDispatcher(WAIT_JSP);
				}
			}
			try {
				Nguk5nr2.forward(opweIIFo, jHyF4Jcr);
			} catch (ServletException iHyqLrmc) {
				iHyqLrmc.printStackTrace(jHyF4Jcr.getWriter());
				throw new IOException(iHyqLrmc.getMessage());
			}
		}
	}

}