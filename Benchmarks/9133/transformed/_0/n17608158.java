class n17608158 {
	public static void main(String[] BAQqe9NV) {
		FileInputStream YcW5BqpO;
		DeflaterOutputStream cTaitgQC;
		FileOutputStream dKNMXU15;
		FileDialog DkSWDYCe;
		DkSWDYCe = new FileDialog(new Frame(), "Find a file to deflate", FileDialog.LOAD);
		DkSWDYCe.show();
		if (DkSWDYCe.getFile() != null) {
			try {
				YcW5BqpO = new FileInputStream(new File(DkSWDYCe.getDirectory(), DkSWDYCe.getFile()));
				dKNMXU15 = new FileOutputStream(new File("Deflated.out"));
				cTaitgQC = new DeflaterOutputStream(dKNMXU15, new Deflater(Deflater.DEFLATED, true));
				int yZebcfJ1 = 0;
				byte[] MgY3RkTa = new byte[1024];
				while ((yZebcfJ1 = YcW5BqpO.read(MgY3RkTa)) != -1) {
					cTaitgQC.write(MgY3RkTa, 0, yZebcfJ1);
				}
				dKNMXU15.flush();
				dKNMXU15.close();
				cTaitgQC.flush();
				cTaitgQC.close();
				YcW5BqpO.close();
			} catch (Exception U824tI0C) {
				U824tI0C.printStackTrace();
			}
			System.out.println("Done");
		}
	}

}