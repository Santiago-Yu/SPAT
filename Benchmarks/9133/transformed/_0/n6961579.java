class n6961579 {
	public void processAction(ActionMapping Ivkxnr54, ActionForm G6sjOc2h, PortletConfig ao4uLbVb,
			ActionRequest zMdBDLhm, ActionResponse Qlm6OX3s) throws Exception {
		boolean jvnmjkir = false;
		zMdBDLhm.setAttribute(ViewReportsAction.REPORT_EDITOR_OR_ADMIN, false);
		User CpdmWbQc = _getUser(zMdBDLhm);
		List<Role> ymVlzUbp = RoleFactory.getAllRolesForUser(CpdmWbQc.getUserId());
		for (Role j4x9DnjY : ymVlzUbp) {
			if (j4x9DnjY.getName().equals("Report Administrator") || j4x9DnjY.getName().equals("Report Editor")
					|| j4x9DnjY.getName().equals("CMS Administrator")) {
				zMdBDLhm.setAttribute(ViewReportsAction.REPORT_EDITOR_OR_ADMIN, true);
				jvnmjkir = true;
				break;
			}
		}
		requiresInput = false;
		badParameters = false;
		newReport = false;
		ActionRequestImpl WtQVqZKq = (ActionRequestImpl) zMdBDLhm;
		HttpServletRequest DIMEUhU3 = WtQVqZKq.getHttpServletRequest();
		String RDSxkesm = zMdBDLhm.getParameter(Constants.CMD);
		Logger.debug(this, "Inside EditReportAction cmd=" + RDSxkesm);
		ReportForm hABoVbuL = (ReportForm) G6sjOc2h;
		ArrayList<String> XcIBKuHa = (DbConnectionFactory.getAllDataSources());
		ArrayList<DataSource> KZE73JDd = new ArrayList<DataSource>();
		for (String nCXoR5ED : XcIBKuHa) {
			DataSource gVcJaiAh = hABoVbuL.getNewDataSource();
			if (nCXoR5ED.equals(com.dotmarketing.util.Constants.DATABASE_DEFAULT_DATASOURCE)) {
				gVcJaiAh.setDsName("DotCMS Datasource");
			} else {
				gVcJaiAh.setDsName(nCXoR5ED);
			}
			KZE73JDd.add(gVcJaiAh);
		}
		hABoVbuL.setDataSources(KZE73JDd);
		DIMEUhU3.setAttribute("dataSources", hABoVbuL.getDataSources());
		Long rcqrbAVt = UtilMethods.parseLong(zMdBDLhm.getParameter("reportId"), 0);
		String pdCvoAzw = zMdBDLhm.getParameter("referrer");
		if (rcqrbAVt > 0) {
			report = ReportFactory.getReport(rcqrbAVt);
			ArrayList<String> QqTh4hlM = new ArrayList<String>();
			QqTh4hlM.add(com.dotmarketing.util.Constants.ROLE_REPORT_ADMINISTRATOR);
			if (CpdmWbQc.getUserId().equals(report.getOwner())) {
				_checkWritePermissions(report, CpdmWbQc, DIMEUhU3, QqTh4hlM);
			}
			if (RDSxkesm == null || !RDSxkesm.equals(Constants.EDIT)) {
				hABoVbuL.setSelectedDataSource(report.getDs());
				hABoVbuL.setReportName(report.getReportName());
				hABoVbuL.setReportDescription(report.getReportDescription());
				hABoVbuL.setReportId(report.getInode());
				hABoVbuL.setWebFormReport(report.isWebFormReport());
				DIMEUhU3.setAttribute("selectedDS", report.getDs());
			}
		} else {
			if (!jvnmjkir) {
				throw new DotRuntimeException("user not allowed to create a new report");
			}
			report = new Report();
			report.setOwner(_getUser(zMdBDLhm).getUserId());
			newReport = true;
		}
		zMdBDLhm.setAttribute(WebKeys.PERMISSION_INODE_EDIT, report);
		if ((RDSxkesm != null) && RDSxkesm.equals(Constants.EDIT)) {
			if (Validator.validate(zMdBDLhm, G6sjOc2h, Ivkxnr54)) {
				report.setReportName(hABoVbuL.getReportName());
				report.setReportDescription(hABoVbuL.getReportDescription());
				report.setWebFormReport(hABoVbuL.isWebFormReport());
				if (hABoVbuL.isWebFormReport())
					report.setDs("None");
				else
					report.setDs(hABoVbuL.getSelectedDataSource());
				String ymaKzafz = "";
				String vlKad9Dv = "";
				try {
					HibernateUtil.startTransaction();
					ReportFactory.saveReport(report);
					_applyPermissions(zMdBDLhm, report);
					if (!hABoVbuL.isWebFormReport()) {
						if (UtilMethods.isSet(Config.getStringProperty("ASSET_REAL_PATH"))) {
							ymaKzafz = Config.getStringProperty("ASSET_REAL_PATH") + File.separator
									+ Config.getStringProperty("REPORT_PATH") + File.separator + report.getInode()
									+ ".jrxml";
							vlKad9Dv = Config.getStringProperty("ASSET_REAL_PATH") + File.separator
									+ Config.getStringProperty("REPORT_PATH") + File.separator + report.getInode()
									+ ".jasper";
						} else {
							ymaKzafz = Config.CONTEXT
									.getRealPath(File.separator + Config.getStringProperty("REPORT_PATH")
											+ File.separator + report.getInode() + ".jrxml");
							vlKad9Dv = Config.CONTEXT
									.getRealPath(File.separator + Config.getStringProperty("REPORT_PATH")
											+ File.separator + report.getInode() + ".jasper");
						}
						UploadPortletRequest CJLwfASV = PortalUtil.getUploadPortletRequest(zMdBDLhm);
						File IfFfJVMJ = CJLwfASV.getFile("jrxmlFile");
						if (IfFfJVMJ.exists()) {
							byte[] cF14apTI = new byte[0];
							FileInputStream Qiefm5Eb = new FileInputStream(IfFfJVMJ);
							int DhWLZUkk = Qiefm5Eb.available();
							cF14apTI = new byte[DhWLZUkk];
							Qiefm5Eb.read(cF14apTI);
							File BwJPdCZS = new File(ymaKzafz);
							FileChannel TMwUMuwX = new FileOutputStream(BwJPdCZS).getChannel();
							ByteBuffer RjcQ9085 = ByteBuffer.allocate(cF14apTI.length);
							RjcQ9085.put(cF14apTI);
							RjcQ9085.position(0);
							TMwUMuwX.write(RjcQ9085);
							TMwUMuwX.force(false);
							TMwUMuwX.close();
							try {
								JasperCompileManager.compileReportToFile(ymaKzafz, vlKad9Dv);
							} catch (Exception gmdme8eU) {
								Logger.error(this, "Unable to compile or save jrxml: " + gmdme8eU.toString());
								try {
									BwJPdCZS = new File(ymaKzafz);
									BwJPdCZS.delete();
								} catch (Exception Y4DtZ892) {
									Logger.info(this, "Unable to delete jrxml. This is usually a permissions problem.");
								}
								try {
									BwJPdCZS = new File(vlKad9Dv);
									BwJPdCZS.delete();
								} catch (Exception hYdVEbMs) {
									Logger.info(this,
											"Unable to delete jasper. This is usually a permissions problem.");
								}
								HibernateUtil.rollbackTransaction();
								SessionMessages.add(zMdBDLhm, "error",
										UtilMethods.htmlLineBreak(gmdme8eU.getMessage()));
								setForward(zMdBDLhm, "portlet.ext.report.edit_report");
								return;
							}
							JasperReport W4tXv6rL = (JasperReport) JRLoader.loadObject(vlKad9Dv);
							ReportParameterFactory.deleteReportsParameters(report);
							_loadReportParameters(W4tXv6rL.getParameters());
							report.setRequiresInput(requiresInput);
							HibernateUtil.save(report);
						} else if (newReport) {
							HibernateUtil.rollbackTransaction();
							SessionMessages.add(zMdBDLhm, "error", "message.report.compile.error");
							setForward(zMdBDLhm, "portlet.ext.report.edit_report");
							return;
						}
					}
					HibernateUtil.commitTransaction();
					HashMap SLzZTe9m = new HashMap();
					SessionMessages.add(zMdBDLhm, "message", "message.report.upload.success");
					SLzZTe9m.put("struts_action", new String[] { "/ext/report/view_reports" });
					pdCvoAzw = com.dotmarketing.util.PortletURLUtil.getRenderURL(
							((ActionRequestImpl) zMdBDLhm).getHttpServletRequest(),
							javax.portlet.WindowState.MAXIMIZED.toString(), SLzZTe9m);
					_sendToReferral(zMdBDLhm, Qlm6OX3s, pdCvoAzw);
					return;
				} catch (Exception FPGCkKKc) {
					HibernateUtil.rollbackTransaction();
					Logger.error(this, "Unable to save Report: " + FPGCkKKc.toString());
					File gVOgXaWi;
					Logger.info(this, "Trying to delete jrxml");
					try {
						gVOgXaWi = new File(ymaKzafz);
						gVOgXaWi.delete();
					} catch (Exception o3vV9v1c) {
						Logger.info(this, "Unable to delete jrxml. This is usually because the file doesn't exist.");
					}
					try {
						gVOgXaWi = new File(vlKad9Dv);
						gVOgXaWi.delete();
					} catch (Exception JPdscEQu) {
						Logger.info(this, "Unable to delete jasper. This is usually because the file doesn't exist.");
					}
					if (badParameters) {
						SessionMessages.add(zMdBDLhm, "error", FPGCkKKc.getMessage());
					} else {
						SessionMessages.add(zMdBDLhm, "error", "message.report.compile.error");
					}
					setForward(zMdBDLhm, "portlet.ext.report.edit_report");
					return;
				}
			} else {
				setForward(zMdBDLhm, "portlet.ext.report.edit_report");
			}
		}
		if ((RDSxkesm != null) && RDSxkesm.equals("downloadReportSource")) {
			ActionResponseImpl h6Mf8KGX = (ActionResponseImpl) Qlm6OX3s;
			HttpServletResponse FxrjtanP = h6Mf8KGX.getHttpServletResponse();
			if (!downloadSourceReport(rcqrbAVt, DIMEUhU3, FxrjtanP)) {
				SessionMessages.add(zMdBDLhm, "error", "message.report.source.file.not.found");
			}
		}
		setForward(zMdBDLhm, "portlet.ext.report.edit_report");
	}

}