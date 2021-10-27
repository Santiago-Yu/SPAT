class n19344618 {
	private void zipdir(File HZPMybds, String ZE56YSRT) throws IOException {
		FilenameFilter BcWCoYjX = new ExporterFileNameFilter();
		String[] AkKIN1Dr = HZPMybds.list(BcWCoYjX);
		File d5fBsN0F = new File(HZPMybds, ZE56YSRT + ".zip");
		ZipOutputStream GTpSW1dk = new ZipOutputStream(new FileOutputStream(d5fBsN0F));
		byte[] uCeFE8N7 = new byte[10240];
		for (int eoazlBmO = 0; eoazlBmO < AkKIN1Dr.length; eoazlBmO++) {
			File WS3tbCWM = new File(HZPMybds, AkKIN1Dr[eoazlBmO]);
			FileInputStream NeG7OK7U = new FileInputStream(WS3tbCWM);
			GTpSW1dk.putNextEntry(new ZipEntry(WS3tbCWM.getName()));
			int eq8DZaFq;
			while ((eq8DZaFq = NeG7OK7U.read(uCeFE8N7)) > 0)
				GTpSW1dk.write(uCeFE8N7, 0, eq8DZaFq);
			GTpSW1dk.closeEntry();
			NeG7OK7U.close();
			WS3tbCWM.delete();
		}
		GTpSW1dk.close();
	}

}