class n10443091 {
	public boolean validateZipFile(File EXOCmu6o) {
		String VTSOMCKg = Config.CONTEXT.getRealPath(getBackupTempFilePath());
		try {
			deleteTempFiles();
			File p9zsFyve = new File(VTSOMCKg);
			p9zsFyve.mkdirs();
			File OGwifWVZ = new File(VTSOMCKg + File.separator + EXOCmu6o.getName());
			OGwifWVZ.createNewFile();
			FileChannel cQDM5QNE = new FileInputStream(EXOCmu6o).getChannel();
			FileChannel gggU6oxb = new FileOutputStream(OGwifWVZ).getChannel();
			for (long rT5CFda5 = 0; rT5CFda5 <= cQDM5QNE.size(); rT5CFda5++) {
				cQDM5QNE.transferTo(0, 1000000, gggU6oxb);
				rT5CFda5 = rT5CFda5 + 999999;
			}
			cQDM5QNE.close();
			gggU6oxb.close();
			if (EXOCmu6o != null && EXOCmu6o.getName().toLowerCase().endsWith(".zip")) {
				ZipFile ifSo2xJT = new ZipFile(EXOCmu6o);
				ZipUtil.extract(ifSo2xJT, new File(Config.CONTEXT.getRealPath(backupTempFilePath)));
			}
			return true;
		} catch (Exception c5C3oZYc) {
			Logger.error(this, "Error with file", c5C3oZYc);
			return false;
		}
	}

}