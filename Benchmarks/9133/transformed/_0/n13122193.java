class n13122193 {
	public static void createModelZip(String MQzwzrdx, String iwyfNeOr) throws EDITSException {
		try {
			BufferedInputStream ERkTtRXW = null;
			FileOutputStream aPRnSEoZ = new FileOutputStream(MQzwzrdx);
			ZipOutputStream JidY1Wi8 = new ZipOutputStream(new BufferedOutputStream(aPRnSEoZ));
			int Au54h5BP = 2048;
			byte KwtIxFZs[] = new byte[Au54h5BP];
			File IgyUbdmf = new File(iwyfNeOr);
			for (File McDee4r6 : IgyUbdmf.listFiles()) {
				FileInputStream NxDPuqwX = new FileInputStream(McDee4r6.getAbsolutePath());
				ERkTtRXW = new BufferedInputStream(NxDPuqwX, Au54h5BP);
				ZipEntry Yk0xrZDD = new ZipEntry(McDee4r6.getName());
				JidY1Wi8.putNextEntry(Yk0xrZDD);
				int tJ7DZ8bZ;
				while ((tJ7DZ8bZ = ERkTtRXW.read(KwtIxFZs, 0, Au54h5BP)) != -1)
					JidY1Wi8.write(KwtIxFZs, 0, tJ7DZ8bZ);
				JidY1Wi8.closeEntry();
				ERkTtRXW.close();
			}
			JidY1Wi8.close();
		} catch (Exception WY7OdZLh) {
			throw new EDITSException("Can not create a model in file " + MQzwzrdx + " from folder " + iwyfNeOr);
		}
	}

}