class n9958260 {
	public String doAdd(ActionMapping Hehd4pW8, ActionForm WCBLTyi6, HttpServletRequest zj6sbw1e,
			HttpServletResponse PDobFvE0) throws Exception {
		UploadFileForm FnlZvELi = (UploadFileForm) WCBLTyi6;
		FormFile b3QicrXy = FnlZvELi.getFile();
		String XFvU9qHA = zj6sbw1e.getParameter("inforId");
		System.out.println("inforId=" + XFvU9qHA);
		if (b3QicrXy != null) {
			String WeOS5JLP = getServlet().getServletContext().getRealPath("/");
			WeOS5JLP = WeOS5JLP.replaceAll("\\\\", "/");
			String yvpVV5ns = getServlet().getServletContext().getRealPath(zj6sbw1e.getContextPath());
			yvpVV5ns = (new StringBuilder(String.valueOf(yvpVV5ns))).append(UploadFileOne.strPath).toString();
			String avsM8qle = (new StringBuilder(String.valueOf(UUIDGenerator.nextHex())))
					.append(UploadFileOne.getFileType(b3QicrXy)).toString();
			if (b3QicrXy.getFileSize() != 0) {
				b3QicrXy.getInputStream();
				String W6kFswpL = b3QicrXy.getFileName();
				String ziWhsPDn = WeOS5JLP + "attach/" + avsM8qle + W6kFswpL;
				t_attach rMdlxWJT = new t_attach();
				rMdlxWJT.setAttach_fullname(ziWhsPDn);
				rMdlxWJT.setAttach_name(W6kFswpL);
				rMdlxWJT.setInfor_id(Integer.parseInt(XFvU9qHA));
				rMdlxWJT.setInsert_day(new Date());
				rMdlxWJT.setUpdate_day(new Date());
				t_attach_EditMap uIyBawex = new t_attach_EditMap();
				uIyBawex.add(rMdlxWJT);
				File e21CpqcQ = new File(ziWhsPDn);
				if (!e21CpqcQ.exists()) {
					e21CpqcQ.createNewFile();
				}
				java.io.OutputStream GWsfkdnt = new FileOutputStream(e21CpqcQ);
				org.apache.commons.io.IOUtils.copy(b3QicrXy.getInputStream(), GWsfkdnt);
				GWsfkdnt.close();
				System.out.println("file name is :" + W6kFswpL);
			}
		}
		zj6sbw1e.setAttribute("operating-status", "???????!  ?????????ив?");
		System.out.println("in the end....");
		return "aftersave";
	}

}