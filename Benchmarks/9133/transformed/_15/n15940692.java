class n15940692 {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String fileName = request.getParameter("tegsoftFileName");
			if (fileName.startsWith("Tegsoft_BACKUP_")) {
				fileName = fileName.substring("Tegsoft_BACKUP_".length());
				String targetFileName = "/home/customer/" + fileName;
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
				FileInputStream is = new FileInputStream(targetFileName);
				IOUtils.copy(is, response.getOutputStream());
				is.close();
				return;
			}
			if ("Tegsoft_ASTMODULES".equals(fileName)) {
				String targetFileName = tobeHome + "/setup/Tegsoft_ASTMODULES.tgz";
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
				FileInputStream is = new FileInputStream(targetFileName);
				IOUtils.copy(is, response.getOutputStream());
				is.close();
				return;
			}
			if ("Tegsoft_ASTSBIN".equals(fileName)) {
				String targetFileName = tobeHome + "/setup/Tegsoft_ASTSBIN.tgz";
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
				FileInputStream is = new FileInputStream(targetFileName);
				IOUtils.copy(is, response.getOutputStream());
				is.close();
				return;
			}
			if (!fileName.startsWith("Tegsoft_")) {
				return;
			}
			if (!fileName.endsWith(".zip")) {
				return;
			}
			if (fileName.indexOf("_") < 0) {
				return;
			}
			fileName = fileName.substring(fileName.indexOf("_") + 1);
			if (fileName.indexOf("_") < 0) {
				return;
			}
			String fileType = fileName.substring(0, fileName.indexOf("_"));
			String destinationFileName = tobeHome + "/setup/Tegsoft_" + fileName;
			if (!new File(destinationFileName).exists()) {
				if ((fileType != null && fileType.equals("FORMS"))) {
					FileUtil.createZipPackage(tobeHome + "/forms", tobeHome + "/setup/Tegsoft_" + fileName);
				} else if ((fileType != null && fileType.equals("IMAGES"))) {
					FileUtil.createZipPackage(tobeHome + "/image", tobeHome + "/setup/Tegsoft_" + fileName);
				} else if ((fileType != null && fileType.equals("VIDEOS"))) {
					FileUtil.createZipPackage(tobeHome + "/videos", tobeHome + "/setup/Tegsoft_" + fileName);
				} else if ((fileType != null && fileType.equals("TEGSOFTJARS"))) {
					FileUtil.createZipPackage(tobeHome + "/WEB-INF/lib/", tobeHome + "/setup/Tegsoft_" + fileName,
							"Tegsoft", "jar");
				} else if ((fileType != null && fileType.equals("TOBEJARS"))) {
					FileUtil.createZipPackage(tobeHome + "/WEB-INF/lib/", tobeHome + "/setup/Tegsoft_" + fileName,
							"Tobe", "jar");
				} else if ((fileType != null && fileType.equals("ALLJARS"))) {
					FileUtil.createZipPackage(tobeHome + "/WEB-INF/lib/", tobeHome + "/setup/Tegsoft_" + fileName);
				} else if ((fileType != null && fileType.equals("DB"))) {
					FileUtil.createZipPackage(tobeHome + "/sql", tobeHome + "/setup/Tegsoft_" + fileName);
				} else if ((fileType != null && fileType.equals("CONFIGSERVICE"))) {
					FileUtil.createZipPackage("/tegsoft/src/java/TegsoftTelecom/configFiles/init.d/",
							tobeHome + "/setup/Tegsoft_" + fileName, "tegsoft", null);
				} else if ((fileType != null && fileType.equals("CONFIGSCRIPTS"))) {
					FileUtil.createZipPackage("/tegsoft/src/java/TegsoftTelecom/configFiles/root/",
							tobeHome + "/setup/Tegsoft_" + fileName, "tegsoft", null);
				} else if ((fileType != null && fileType.equals("CONFIGFOP"))) {
					FileUtil.createZipPackage("/tegsoft/src/java/TegsoftTelecom/configFiles/fop/",
							tobeHome + "/setup/Tegsoft_" + fileName);
				} else if ((fileType != null && fileType.equals("CONFIGASTERISK"))) {
					FileUtil.createZipPackage("/tegsoft/src/java/TegsoftTelecom/configFiles/asterisk/",
							tobeHome + "/setup/Tegsoft_" + fileName);
				}
			}
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			FileInputStream is = new FileInputStream(destinationFileName);
			IOUtils.copy(is, response.getOutputStream());
			is.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}