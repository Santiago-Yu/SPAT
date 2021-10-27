class n233637 {
	public void service(HttpServletRequest QO6ydyMe, HttpServletResponse s9oeL7WS)
			throws ServletException, IOException {
		ServletContext CzVLo9UT = getServletContext();
		String UUjwwBpo = null;
		try {
			int khAZ4sbb = 50000000;
			MultipartRequest rWlqehW8 = new MultipartRequest(QO6ydyMe, ".", khAZ4sbb);
			String QbYQxASg = rWlqehW8.getParameter("text");
			File NTwy4wLS = rWlqehW8.getFile("uploadfile");
			String XhO6haop = rWlqehW8.getOriginalFileName("uploadfile");
			String zdXtKIQt = "C:\\files\\";
			try {
				FileInputStream Bip0Rt32 = new FileInputStream(NTwy4wLS);
				FileOutputStream CoAOufYR = new FileOutputStream(zdXtKIQt + NTwy4wLS.getName());
				while (Bip0Rt32.available() > 0) {
					CoAOufYR.write(Bip0Rt32.read());
				}
				Bip0Rt32.close();
				CoAOufYR.close();
			} catch (FileNotFoundException ChyMK18W) {
				ChyMK18W.printStackTrace();
			} catch (IOException mEFl2996) {
				mEFl2996.printStackTrace();
			}
			UUjwwBpo = "../sendDoc.jsp";
			QO6ydyMe.setAttribute("contentType", CzVLo9UT.getMimeType(zdXtKIQt + NTwy4wLS.getName()));
			QO6ydyMe.setAttribute("text", QbYQxASg);
			QO6ydyMe.setAttribute("path", zdXtKIQt + NTwy4wLS.getName());
			QO6ydyMe.setAttribute("size", Long.toString(NTwy4wLS.length()) + " Bytes");
			RequestDispatcher jesv2qJq = QO6ydyMe.getRequestDispatcher(UUjwwBpo);
			jesv2qJq.forward(QO6ydyMe, s9oeL7WS);
		} catch (Exception fphytu7T) {
			fphytu7T.printStackTrace();
		}
	}

}