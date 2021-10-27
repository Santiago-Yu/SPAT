class n11658686 {
	protected void processRequest(HttpServletRequest cyVYMYv9, HttpServletResponse Z5h7spnM)
			throws ServletException, IOException {
		Z5h7spnM.setContentType("application/zip");
		Z5h7spnM.setHeader("Content-Disposition", "inline; filename=c:/server1.zip");
		try {
			BufferedInputStream zBY10PRN = null;
			FileOutputStream JIKGLmB3 = new FileOutputStream("server.zip");
			ZipOutputStream ni3ELAI0 = new ZipOutputStream(new BufferedOutputStream(JIKGLmB3));
			byte Bd6YKmAG[] = new byte[BUFFER];
			java.util.Properties r3zz3tJp = new java.util.Properties();
			r3zz3tJp.load(new java.io.FileInputStream(
					ejb.bprocess.util.NewGenLibRoot.getRoot() + "/SystemFiles/ENV_VAR.txt"));
			String LxfhZbf8 = r3zz3tJp.getProperty("JBOSS_HOME");
			LxfhZbf8 = LxfhZbf8.replaceAll("deploy", "log");
			FileInputStream czWfwIno = new FileInputStream(new File(LxfhZbf8 + "/server.log"));
			zBY10PRN = new BufferedInputStream(czWfwIno, BUFFER);
			ZipEntry iT6ExWhU = new ZipEntry(LxfhZbf8 + "/server.log");
			ni3ELAI0.putNextEntry(iT6ExWhU);
			int Yf3p1wGP;
			while ((Yf3p1wGP = zBY10PRN.read(Bd6YKmAG, 0, BUFFER)) != -1) {
				ni3ELAI0.write(Bd6YKmAG, 0, Yf3p1wGP);
			}
			zBY10PRN.close();
			ni3ELAI0.closeEntry();
			java.io.FileInputStream tcb41rRv = new java.io.FileInputStream(new java.io.File("server.zip"));
			java.nio.channels.FileChannel nQop5Psp = tcb41rRv.getChannel();
			int daeZCIiH = (int) nQop5Psp.size();
			byte QySUtURb[] = new byte[daeZCIiH];
			System.out.println("size of zip file = " + daeZCIiH);
			tcb41rRv.read(QySUtURb);
			OutputStream h5YqziZh = Z5h7spnM.getOutputStream();
			h5YqziZh.write(QySUtURb);
			tcb41rRv.close();
			h5YqziZh.close();
		} catch (Exception DSo6JRSx) {
			DSo6JRSx.printStackTrace();
		}
	}

}