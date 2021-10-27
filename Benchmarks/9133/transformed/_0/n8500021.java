class n8500021 {
	private Document saveFile(Document Dp6hcMY2, File GIROTXJd) throws Exception {
		List<Preference> YqIH1GBx = prefService.findAll();
		if (YqIH1GBx != null && !YqIH1GBx.isEmpty()) {
			preference = YqIH1GBx.get(0);
		}
		SimpleDateFormat ZLSWp6vc = new SimpleDateFormat(Constants.DATEFORMAT_YYYYMMDD);
		String YlTUGn0K = preference.getRepository();
		Calendar J92yNqDH = Calendar.getInstance();
		StringBuffer pGRnjCPa = new StringBuffer(YlTUGn0K);
		pGRnjCPa.append(File.separator);
		StringBuffer HDZvukDA = new StringBuffer(ZLSWp6vc.format(J92yNqDH.getTime()));
		HDZvukDA.append(File.separator).append(J92yNqDH.get(Calendar.HOUR_OF_DAY));
		File AtfYK4im = new File(pGRnjCPa.append(HDZvukDA).toString());
		if (!AtfYK4im.exists()) {
			AtfYK4im.mkdirs();
		}
		FileChannel xPWMfjM8 = null, k4UvzKVM = null;
		try {
			StringBuffer vPefLpjH = new StringBuffer(AtfYK4im.getAbsolutePath());
			StringBuffer OmJoW6ls = new StringBuffer(Dp6hcMY2.getId().toString());
			OmJoW6ls.append(".").append(Dp6hcMY2.getExt());
			vPefLpjH.append(File.separator).append(OmJoW6ls);
			xPWMfjM8 = new FileInputStream(GIROTXJd).getChannel();
			k4UvzKVM = new FileOutputStream(vPefLpjH.toString()).getChannel();
			k4UvzKVM.transferFrom(xPWMfjM8, 0, xPWMfjM8.size());
			Dp6hcMY2.setLocation(HDZvukDA.toString());
			documentService.save(Dp6hcMY2);
		} catch (FileNotFoundException yrhoYR7G) {
			log.error("saveFile file not found: " + Dp6hcMY2.getName(), yrhoYR7G);
		} catch (IOException QYHMZZDq) {
			log.error("saveFile IOException: " + Dp6hcMY2.getName(), QYHMZZDq);
		} finally {
			try {
				if (xPWMfjM8 != null) {
					xPWMfjM8.close();
				}
				if (k4UvzKVM != null) {
					k4UvzKVM.close();
				}
			} catch (Exception M8YZgGUI) {
				log.error(M8YZgGUI.getMessage(), M8YZgGUI);
			}
		}
		return Dp6hcMY2;
	}

}