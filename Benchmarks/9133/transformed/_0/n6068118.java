class n6068118 {
	public byte[] exportCommunityData(String Ot20eQfx) throws RepositoryException, IOException {
		Community ZQ0gbUEB;
		try {
			ZQ0gbUEB = getCommunityById(Ot20eQfx);
		} catch (CommunityNotFoundException TKgcty3a) {
			throw new GroupwareRuntimeException("Community to export not found");
		}
		String o20QfBJT = JCRUtil.getNodeById(Ot20eQfx, ZQ0gbUEB.getWorkspace()).getPath();
		try {
			File tVOAeBbU = File.createTempFile("exported-community", ".zip.tmp");
			TemporaryFilesHandler.register(null, tVOAeBbU);
			ZipOutputStream zp9EBtlw = new ZipOutputStream(new FileOutputStream(tVOAeBbU));
			File xVJES80y = File.createTempFile("exported-community", null);
			TemporaryFilesHandler.register(null, xVJES80y);
			FileOutputStream goC9eD8s = new FileOutputStream(xVJES80y);
			exportCommunitySystemView(ZQ0gbUEB, o20QfBJT, goC9eD8s);
			goC9eD8s.close();
			File FAI08gYJ = File.createTempFile("exported-community-properties", null);
			TemporaryFilesHandler.register(null, FAI08gYJ);
			FileOutputStream UGm7zl4C = new FileOutputStream(FAI08gYJ);
			UGm7zl4C.write(("communityId=" + Ot20eQfx).getBytes());
			UGm7zl4C.write(";".getBytes());
			UGm7zl4C.write(("externalId=" + ZQ0gbUEB.getExternalId()).getBytes());
			UGm7zl4C.write(";".getBytes());
			UGm7zl4C.write(("title=" + I18NUtils.localize(ZQ0gbUEB.getTitle())).getBytes());
			UGm7zl4C.write(";".getBytes());
			UGm7zl4C.write(("communityType=" + ZQ0gbUEB.getType()).getBytes());
			UGm7zl4C.write(";".getBytes());
			UGm7zl4C.write(("communityName=" + ZQ0gbUEB.getName()).getBytes());
			UGm7zl4C.close();
			FileInputStream Ztt9f1sp = new FileInputStream(FAI08gYJ);
			byte[] hFC4wNBx = new byte[4096];
			zp9EBtlw.putNextEntry(new ZipEntry("properties"));
			int EymJtEko = 0;
			while ((EymJtEko = Ztt9f1sp.read(hFC4wNBx)) > 0) {
				zp9EBtlw.write(hFC4wNBx, 0, EymJtEko);
			}
			Ztt9f1sp.close();
			FileInputStream ZP1Rjp2M = new FileInputStream(xVJES80y);
			byte[] aBFMTohN = new byte[4096];
			zp9EBtlw.putNextEntry(new ZipEntry("xmlData"));
			int QWORYsGz = 0;
			while ((QWORYsGz = ZP1Rjp2M.read(aBFMTohN)) > 0) {
				zp9EBtlw.write(aBFMTohN, 0, QWORYsGz);
			}
			ZP1Rjp2M.close();
			zp9EBtlw.close();
			ByteArrayOutputStream Ocr8wqP5 = new ByteArrayOutputStream();
			FileInputStream hXioymYh = new FileInputStream(tVOAeBbU);
			byte[] Tn9kSWBr = new byte[4096];
			int YItWguDS = 0;
			while ((YItWguDS = hXioymYh.read(Tn9kSWBr)) > 0) {
				Ocr8wqP5.write(Tn9kSWBr, 0, YItWguDS);
			}
			return Ocr8wqP5.toByteArray();
		} catch (Exception j7OxqmsF) {
			String BOTvlFCR = "Error exporting backup data, for comunnity with id " + Ot20eQfx;
			log.error(BOTvlFCR, j7OxqmsF);
			throw new CMSRuntimeException(BOTvlFCR, j7OxqmsF);
		}
	}

}