class n8570520 {
	public String doAdd(ActionMapping tyfflhHT, ActionForm txhtSYdO, HttpServletRequest BwbID1uy,
			HttpServletResponse azusvccN) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("doAdd(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse) - start");
		}
		t_information_EditMap xnuqb7sE = new t_information_EditMap();
		try {
			t_information_Form FRPtWUpD = null;
			FRPtWUpD = (t_information_Form) txhtSYdO;
			FRPtWUpD.setCompany(FRPtWUpD.getCounty());
			if ("????".equals(FRPtWUpD.getInfo_type())) {
				FRPtWUpD.setInfo_level(null);
				FRPtWUpD.setAlert_level(null);
			}
			String CBPmCWrG = "";
			int Rt4cd6nS = 0;
			xnuqb7sE.add(FRPtWUpD);
			try {
				logger.info("???????÷l??");
				String[] SE5Ol4VN = BwbID1uy.getParameterValues("mobiles");
				FRPtWUpD.setMobiles(SE5Ol4VN);
				SMSService.inforAlert(FRPtWUpD);
			} catch (Exception Y5J5hzit) {
				logger.error("doAdd(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse)", Y5J5hzit);
			}
			String lFtueU5C = FRPtWUpD.getFile().getFileName();
			if (null != lFtueU5C && !"".equals(lFtueU5C)) {
				FormFile SRskSBUZ = FRPtWUpD.getFile();
				String pdfdR9MF = getServlet().getServletContext().getRealPath("/");
				pdfdR9MF = pdfdR9MF.replaceAll("\\\\", "/");
				String Oj9VOKbd = FRPtWUpD.getId();
				String I0nFGRO5 = getServlet().getServletContext().getRealPath(BwbID1uy.getContextPath());
				I0nFGRO5 = (new StringBuilder(String.valueOf(I0nFGRO5))).append(UploadFileOne.strPath).toString();
				String tRZnFZYx = (new StringBuilder(String.valueOf(UUIDGenerator.nextHex())))
						.append(UploadFileOne.getFileType(SRskSBUZ)).toString();
				if (SRskSBUZ.getFileSize() != 0) {
					SRskSBUZ.getInputStream();
					String a2um9pjj = SRskSBUZ.getFileName();
					Rt4cd6nS = SRskSBUZ.getFileName().lastIndexOf(".");
					CBPmCWrG = SRskSBUZ.getFileName().substring(Rt4cd6nS, SRskSBUZ.getFileName().length());
					String VzSbcpxx = pdfdR9MF + "attach/" + tRZnFZYx + CBPmCWrG;
					t_attach DoD5RY2j = new t_attach();
					DoD5RY2j.setAttach_fullname(VzSbcpxx);
					DoD5RY2j.setAttach_name(a2um9pjj);
					DoD5RY2j.setInfor_id(Integer.parseInt(Oj9VOKbd));
					DoD5RY2j.setInsert_day(new Date());
					DoD5RY2j.setUpdate_day(new Date());
					t_attach_EditMap vOI3PoiX = new t_attach_EditMap();
					vOI3PoiX.add(DoD5RY2j);
					File eCsUVqPI = new File(VzSbcpxx);
					if (!eCsUVqPI.exists()) {
						eCsUVqPI.createNewFile();
					}
					java.io.OutputStream kNyJIdTd = new FileOutputStream(eCsUVqPI);
					org.apache.commons.io.IOUtils.copy(SRskSBUZ.getInputStream(), kNyJIdTd);
					kNyJIdTd.close();
				}
			}
		} catch (HibernateException rkBiDk6c) {
			logger.error("doAdd(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse)", rkBiDk6c);
			ActionErrors GR5IxJcI = new ActionErrors();
			GR5IxJcI.add("org.apache.struts.action.GLOBAL_ERROR",
					new ActionError("error.database.save", rkBiDk6c.toString()));
			saveErrors(BwbID1uy, GR5IxJcI);
			rkBiDk6c.printStackTrace();
			BwbID1uy.setAttribute("t_information_Form", txhtSYdO);
			if (logger.isDebugEnabled()) {
				logger.debug("doAdd(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse) - end");
			}
			return "addpage";
		}
		if (logger.isDebugEnabled()) {
			logger.debug("doAdd(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse) - end");
		}
		return "aftersave";
	}

}