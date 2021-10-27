class n15940692 {
	@Override
	protected void service(HttpServletRequest sSFlxraa, HttpServletResponse dEai1JEd)
			throws ServletException, IOException {
		try {
			String x4uvdA6p = sSFlxraa.getParameter("tegsoftFileName");
			if (x4uvdA6p.startsWith("Tegsoft_BACKUP_")) {
				x4uvdA6p = x4uvdA6p.substring("Tegsoft_BACKUP_".length());
				String nvNkx5y7 = "/home/customer/" + x4uvdA6p;
				dEai1JEd.setContentType("application/octet-stream");
				dEai1JEd.setHeader("Content-Disposition", "attachment;filename=" + x4uvdA6p);
				FileInputStream IuI9GT1R = new FileInputStream(nvNkx5y7);
				IOUtils.copy(IuI9GT1R, dEai1JEd.getOutputStream());
				IuI9GT1R.close();
				return;
			}
			if (x4uvdA6p.equals("Tegsoft_ASTMODULES")) {
				String uKg3QaYh = tobeHome + "/setup/Tegsoft_ASTMODULES.tgz";
				dEai1JEd.setContentType("application/octet-stream");
				dEai1JEd.setHeader("Content-Disposition", "attachment;filename=" + x4uvdA6p);
				FileInputStream QxAIjarS = new FileInputStream(uKg3QaYh);
				IOUtils.copy(QxAIjarS, dEai1JEd.getOutputStream());
				QxAIjarS.close();
				return;
			}
			if (x4uvdA6p.equals("Tegsoft_ASTSBIN")) {
				String mTiJHHAc = tobeHome + "/setup/Tegsoft_ASTSBIN.tgz";
				dEai1JEd.setContentType("application/octet-stream");
				dEai1JEd.setHeader("Content-Disposition", "attachment;filename=" + x4uvdA6p);
				FileInputStream ruxvfIZB = new FileInputStream(mTiJHHAc);
				IOUtils.copy(ruxvfIZB, dEai1JEd.getOutputStream());
				ruxvfIZB.close();
				return;
			}
			if (!x4uvdA6p.startsWith("Tegsoft_")) {
				return;
			}
			if (!x4uvdA6p.endsWith(".zip")) {
				return;
			}
			if (x4uvdA6p.indexOf("_") < 0) {
				return;
			}
			x4uvdA6p = x4uvdA6p.substring(x4uvdA6p.indexOf("_") + 1);
			if (x4uvdA6p.indexOf("_") < 0) {
				return;
			}
			String iezVi7k1 = x4uvdA6p.substring(0, x4uvdA6p.indexOf("_"));
			String vWWssDbM = tobeHome + "/setup/Tegsoft_" + x4uvdA6p;
			if (!new File(vWWssDbM).exists()) {
				if ("FORMS".equals(iezVi7k1)) {
					FileUtil.createZipPackage(tobeHome + "/forms", tobeHome + "/setup/Tegsoft_" + x4uvdA6p);
				} else if ("IMAGES".equals(iezVi7k1)) {
					FileUtil.createZipPackage(tobeHome + "/image", tobeHome + "/setup/Tegsoft_" + x4uvdA6p);
				} else if ("VIDEOS".equals(iezVi7k1)) {
					FileUtil.createZipPackage(tobeHome + "/videos", tobeHome + "/setup/Tegsoft_" + x4uvdA6p);
				} else if ("TEGSOFTJARS".equals(iezVi7k1)) {
					FileUtil.createZipPackage(tobeHome + "/WEB-INF/lib/", tobeHome + "/setup/Tegsoft_" + x4uvdA6p,
							"Tegsoft", "jar");
				} else if ("TOBEJARS".equals(iezVi7k1)) {
					FileUtil.createZipPackage(tobeHome + "/WEB-INF/lib/", tobeHome + "/setup/Tegsoft_" + x4uvdA6p,
							"Tobe", "jar");
				} else if ("ALLJARS".equals(iezVi7k1)) {
					FileUtil.createZipPackage(tobeHome + "/WEB-INF/lib/", tobeHome + "/setup/Tegsoft_" + x4uvdA6p);
				} else if ("DB".equals(iezVi7k1)) {
					FileUtil.createZipPackage(tobeHome + "/sql", tobeHome + "/setup/Tegsoft_" + x4uvdA6p);
				} else if ("CONFIGSERVICE".equals(iezVi7k1)) {
					FileUtil.createZipPackage("/tegsoft/src/java/TegsoftTelecom/configFiles/init.d/",
							tobeHome + "/setup/Tegsoft_" + x4uvdA6p, "tegsoft", null);
				} else if ("CONFIGSCRIPTS".equals(iezVi7k1)) {
					FileUtil.createZipPackage("/tegsoft/src/java/TegsoftTelecom/configFiles/root/",
							tobeHome + "/setup/Tegsoft_" + x4uvdA6p, "tegsoft", null);
				} else if ("CONFIGFOP".equals(iezVi7k1)) {
					FileUtil.createZipPackage("/tegsoft/src/java/TegsoftTelecom/configFiles/fop/",
							tobeHome + "/setup/Tegsoft_" + x4uvdA6p);
				} else if ("CONFIGASTERISK".equals(iezVi7k1)) {
					FileUtil.createZipPackage("/tegsoft/src/java/TegsoftTelecom/configFiles/asterisk/",
							tobeHome + "/setup/Tegsoft_" + x4uvdA6p);
				}
			}
			dEai1JEd.setContentType("application/octet-stream");
			dEai1JEd.setHeader("Content-Disposition", "attachment;filename=" + x4uvdA6p);
			FileInputStream JCDJ782x = new FileInputStream(vWWssDbM);
			IOUtils.copy(JCDJ782x, dEai1JEd.getOutputStream());
			JCDJ782x.close();
		} catch (Exception TXBlIZgH) {
			TXBlIZgH.printStackTrace();
		}
	}

}