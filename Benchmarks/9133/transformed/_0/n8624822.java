class n8624822 {
	public void doPost(HttpServletRequest kOwB1JJq, HttpServletResponse mdkNaAU5) throws ServletException, IOException {
		PrintWriter NzaRHt0b = mdkNaAU5.getWriter();
		mdkNaAU5.setContentType("text/html");
		HttpSession fxY5XmX2 = kOwB1JJq.getSession();
		String eXj4SBQr = fxY5XmX2.getId();
		File bCn4FmCJ = new File(destinationDir + java.io.File.separator + eXj4SBQr);
		bCn4FmCJ.mkdir();
		DiskFileItemFactory ju1wJ9sF = new DiskFileItemFactory();
		ju1wJ9sF.setSizeThreshold(1 * 1024 * 1024);
		ju1wJ9sF.setRepository(tmpDir);
		ServletFileUpload Gxq1aO3Z = new ServletFileUpload(ju1wJ9sF);
		String xspXcQA3 = new String();
		try {
			List kwOl01FJ = Gxq1aO3Z.parseRequest(kOwB1JJq);
			Iterator s5EIJ6ic = kwOl01FJ.iterator();
			while (s5EIJ6ic.hasNext()) {
				FileItem PZAAHdxz = (FileItem) s5EIJ6ic.next();
				if (PZAAHdxz.isFormField()) {
					;
				} else {
					xspXcQA3 = getServletContext().getRealPath("/") + "files" + java.io.File.separator + eXj4SBQr;
					File aaHWGlgn = new File(xspXcQA3 + java.io.File.separator + PZAAHdxz.getName());
					PZAAHdxz.write(aaHWGlgn);
					getContents(aaHWGlgn, xspXcQA3);
					ComtorStandAlone.setMode(Mode.CLOUD);
					Comtor.start(xspXcQA3);
				}
			}
			try {
				File mYvHTQuk = new File(xspXcQA3 + java.io.File.separator + "comtorReport.txt");
				String ggQQEpQy = AWSServices.storeReportS3(mYvHTQuk, eXj4SBQr).toString();
				if (ggQQEpQy.startsWith("https"))
					ggQQEpQy = ggQQEpQy.replaceFirst("https", "http");
				String qPhBio8J = kOwB1JJq.getRequestURL().toString();
				String Z876rntx = qPhBio8J.substring(0, qPhBio8J.lastIndexOf("/"));
				NzaRHt0b.println("<html><head/><body>");
				NzaRHt0b.println("<a href=\"" + Z876rntx + "\">Return to home</a>&nbsp;&nbsp;");
				NzaRHt0b.println("<a href=\"" + ggQQEpQy + "\">Report URL</a><br/><hr/>");
				Scanner ezV9azBK = new Scanner(mYvHTQuk);
				NzaRHt0b.println("<pre>");
				while (ezV9azBK.hasNextLine())
					NzaRHt0b.println(ezV9azBK.nextLine());
				NzaRHt0b.println("</pre><hr/>");
				NzaRHt0b.println("<a href=\"" + Z876rntx + "\">Return to home</a>&nbsp;&nbsp;");
				NzaRHt0b.println("<a href=\"" + ggQQEpQy + "\">Report URL</a><br/>");
				NzaRHt0b.println("</body></html>");
			} catch (Exception fVpR7zVr) {
				System.err.println(fVpR7zVr);
			}
		} catch (FileUploadException YXSePZxL) {
			System.err.println("Error encountered while parsing the request" + YXSePZxL);
		} catch (Exception OcZJjzeb) {
			System.err.println("Error encountered while uploading file" + OcZJjzeb);
		}
	}

}