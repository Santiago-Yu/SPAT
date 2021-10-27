class n11919249 {
	protected void doGet(final HttpServletRequest DOTrFsbg, final HttpServletResponse IHZwq19U)
			throws ServletException, IOException {
		Session g7o8ODOU = HibernateUtil.getInstance().getSession();
		IHZwq19U.setBufferSize(65536);
		ServletOutputStream ttbl53xg = IHZwq19U.getOutputStream();
		File VS44NtU9 = null;
		FileData FhAVMtTF = null;
		try {
			String dp1sCEaH = DOTrFsbg.getParameter("file");
			String Q0sKoRgC = DOTrFsbg.getParameter("disposition");
			if (dp1sCEaH == null || dp1sCEaH.equals("")) {
				String PrN61oWK = DOTrFsbg.getPathInfo();
				int i9IFQ2FO = PrN61oWK.lastIndexOf("/") + 1;
				dp1sCEaH = PrN61oWK.substring(i9IFQ2FO, PrN61oWK.indexOf("_", PrN61oWK.lastIndexOf("/")));
			}
			if (dp1sCEaH == null || dp1sCEaH.equals("")) {
				IHZwq19U.sendError(HttpServletResponse.SC_BAD_REQUEST);
				IHZwq19U.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				IHZwq19U.flushBuffer();
				Logger.log("file parameter not specified");
				return;
			}
			if (Q0sKoRgC == null || Q0sKoRgC.equals("")) {
				String OJ6J4m8k = DOTrFsbg.getPathInfo();
				String ys8oWHYo = OJ6J4m8k.substring(OJ6J4m8k.lastIndexOf("/") + 1);
				int Jk1rvngx = ys8oWHYo.indexOf("_") + 1;
				Q0sKoRgC = ys8oWHYo.substring(Jk1rvngx, ys8oWHYo.indexOf("_", Jk1rvngx));
			}
			VS44NtU9 = (File) g7o8ODOU.load(File.class, new Long(dp1sCEaH));
			Logger.log("Content requested=" + VS44NtU9.getName() + ":" + dp1sCEaH + " Referral: "
					+ DOTrFsbg.getParameter("referer"));
			long Uih5bW4v = DOTrFsbg.getDateHeader("If-Modified-Since");
			long Qivzeg2k = VS44NtU9.getLastModifiedDate() - (VS44NtU9.getLastModifiedDate() % 1000);
			if (Qivzeg2k <= Uih5bW4v) {
				IHZwq19U.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
				if ("attachment".equals(Q0sKoRgC)) {
					IHZwq19U.setHeader("Content-Disposition", "attachment; filename=\"" + VS44NtU9.getName() + "\"");
				} else {
					IHZwq19U.setHeader("Content-Disposition", "inline; filename=\"" + VS44NtU9.getName() + "\"");
				}
				IHZwq19U.setContentType(VS44NtU9.getContentType());
				IHZwq19U.setHeader("Content-Description", VS44NtU9.getName());
				IHZwq19U.setDateHeader("Last-Modified", VS44NtU9.getLastModifiedDate());
				IHZwq19U.setDateHeader("Expires", System.currentTimeMillis() + 31536000000L);
				IHZwq19U.setContentLength((int) VS44NtU9.getSize());
				IHZwq19U.flushBuffer();
				Logger.log("Conditional GET: " + VS44NtU9.getName());
				return;
			}
			User trMa0cVE = baseService.getAuthenticatedUser(g7o8ODOU, DOTrFsbg, IHZwq19U);
			if (!SecurityHelper.doesUserHavePermission(g7o8ODOU, trMa0cVE, VS44NtU9, Permission.PERM.READ)) {
				IHZwq19U.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
				IHZwq19U.setStatus(HttpServletResponse.SC_FORBIDDEN);
				IHZwq19U.flushBuffer();
				Logger.log("Forbidden content requested: " + dp1sCEaH);
				return;
			}
			String ImfT0K01 = VS44NtU9.getContentType();
			IHZwq19U.setContentType(ImfT0K01);
			if ("attachment".equals(Q0sKoRgC)) {
				IHZwq19U.setHeader("Content-Disposition", "attachment; filename=\"" + VS44NtU9.getName() + "\"");
			} else {
				IHZwq19U.setHeader("Content-Disposition", "inline; filename=\"" + VS44NtU9.getName() + "\"");
			}
			String TzI46Dns = VS44NtU9.getName();
			IHZwq19U.setHeader("Content-Description", TzI46Dns);
			IHZwq19U.setDateHeader("Last-Modified", VS44NtU9.getLastModifiedDate());
			IHZwq19U.setDateHeader("Expires", System.currentTimeMillis() + 31536000000L);
			IHZwq19U.setContentLength((int) VS44NtU9.getSize());
			java.io.File jALfY7IO = new java.io.File(BaseSystem.getTempDir() + VS44NtU9.getNameOnDisk());
			if (jALfY7IO.exists()) {
				Logger.log("File exists in " + BaseSystem.getTempDir() + " pulling " + jALfY7IO.getName());
				FileInputStream fGffvwMm = new FileInputStream(jALfY7IO);
				try {
					IOUtils.copy(fGffvwMm, ttbl53xg);
				} finally {
					try {
						fGffvwMm.close();
					} catch (Throwable J3NWbUgC) {
					}
				}
			} else {
				List<FileData> K12bmpeN = HibernateUtil.getInstance().executeQuery(g7o8ODOU,
						"from " + FileData.class.getSimpleName() + " where permissibleObject.id = " + VS44NtU9.getId());
				if (K12bmpeN.size() == 0) {
					IHZwq19U.sendError(HttpServletResponse.SC_NOT_FOUND);
					IHZwq19U.setStatus(HttpServletResponse.SC_NOT_FOUND);
					Logger.log("Requested content not found: " + dp1sCEaH);
					IHZwq19U.flushBuffer();
					return;
				}
				FhAVMtTF = (FileData) K12bmpeN.get(0);
				FileOutputStream jNzgO1lQ = null;
				try {
					java.io.File pKeWq1mF = new java.io.File(BaseSystem.getTempDir());
					pKeWq1mF.mkdirs();
					jNzgO1lQ = new FileOutputStream(jALfY7IO);
					IOUtils.write(FhAVMtTF.getData(), jNzgO1lQ);
				} catch (Throwable fSxNdtMW) {
					Logger.log(fSxNdtMW);
				} finally {
					try {
						jNzgO1lQ.close();
					} catch (Throwable JxrhwwiH) {
					}
				}
				IOUtils.write(FhAVMtTF.getData(), ttbl53xg);
			}
		} catch (Throwable qq3rstRJ) {
			Logger.log(qq3rstRJ);
			try {
				IHZwq19U.sendError(HttpServletResponse.SC_NOT_FOUND);
				IHZwq19U.setStatus(HttpServletResponse.SC_NOT_FOUND);
				IHZwq19U.flushBuffer();
			} catch (Throwable a2h6rBIk) {
			}
			try {
				IHZwq19U.reset();
				IHZwq19U.resetBuffer();
			} catch (Throwable sD4ZdOTE) {
			}
		} finally {
			VS44NtU9 = null;
			FhAVMtTF = null;
			try {
				ttbl53xg.flush();
			} catch (Throwable JRFFjghZ) {
			}
			try {
				ttbl53xg.close();
			} catch (Throwable KUNrbJbK) {
			}
			try {
				g7o8ODOU.close();
			} catch (Throwable ZBfZohzj) {
			}
		}
	}

}