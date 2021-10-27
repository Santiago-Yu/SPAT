class n1089238 {
	private Document saveFile(Document QPwE4uxs, File tJWDONGf) throws Exception {
		SimpleDateFormat diPIAi2s = new SimpleDateFormat(Constants.DATEFORMAT_YYYYMMDD);
		List<Preference> LqDRHvz2 = prefService.findAll();
		if (LqDRHvz2 != null && !LqDRHvz2.isEmpty()) {
			Preference F1zB3H4h = LqDRHvz2.get(0);
			String GdZX22al = F1zB3H4h.getRepository();
			StringBuffer cA6VIbTS = new StringBuffer(GdZX22al);
			cA6VIbTS.append(File.separator);
			StringBuffer ZM0xNwoj = new StringBuffer(QPwE4uxs.getLocation());
			File VmxzH9dK = new File(cA6VIbTS.append(ZM0xNwoj).toString());
			log.info("Check in file ID [" + QPwE4uxs.getId() + "] to " + VmxzH9dK.getAbsolutePath());
			if (!VmxzH9dK.exists()) {
				VmxzH9dK.mkdirs();
			}
			FileChannel eGLKpSFJ = null, ip3fEdV9 = null, zUZ4Psnr = null;
			try {
				StringBuffer oGOShWLd = new StringBuffer(VmxzH9dK.getAbsolutePath()).append(File.separator)
						.append(QPwE4uxs.getId()).append(".").append(QPwE4uxs.getExt());
				StringBuffer lPvl3hcm = new StringBuffer(VmxzH9dK.getAbsolutePath()).append(File.separator)
						.append(QPwE4uxs.getId()).append("_").append(QPwE4uxs.getVersion().toString()).append(".")
						.append(QPwE4uxs.getExt());
				eGLKpSFJ = new FileInputStream(tJWDONGf).getChannel();
				ip3fEdV9 = new FileOutputStream(oGOShWLd.toString()).getChannel();
				zUZ4Psnr = new FileOutputStream(lPvl3hcm.toString()).getChannel();
				ip3fEdV9.transferFrom(eGLKpSFJ, 0, eGLKpSFJ.size());
				eGLKpSFJ = new FileInputStream(tJWDONGf).getChannel();
				zUZ4Psnr.transferFrom(eGLKpSFJ, 0, eGLKpSFJ.size());
				QPwE4uxs.setLocation(ZM0xNwoj.toString());
				documentService.save(QPwE4uxs);
			} catch (FileNotFoundException wTxloHIO) {
				log.error("saveFile file not found: " + QPwE4uxs.getName(), wTxloHIO);
			} catch (IOException lHWC0yXI) {
				log.error("saveFile IOException: " + QPwE4uxs.getName(), lHWC0yXI);
			} finally {
				try {
					if (eGLKpSFJ != null) {
						eGLKpSFJ.close();
					}
					if (ip3fEdV9 != null) {
						ip3fEdV9.close();
					}
					if (zUZ4Psnr != null) {
						zUZ4Psnr.close();
					}
				} catch (Exception FW7sZHDS) {
					log.error(FW7sZHDS.getMessage(), FW7sZHDS);
				}
			}
		}
		return QPwE4uxs;
	}

}