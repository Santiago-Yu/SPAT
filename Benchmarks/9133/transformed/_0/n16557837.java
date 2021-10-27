class n16557837 {
	public static void copyFromTo(File irGGU7kP, File zwEwlDtg) {
		FileChannel TKe1nnVZ = null, otpIFdUQ = null;
		FileInputStream vcUsJ3Kh = null;
		FileOutputStream odXNCgTM = null;
		try {
			vcUsJ3Kh = new FileInputStream(irGGU7kP);
		} catch (FileNotFoundException Oo1Uw9hf) {
			System.out.println("File: " + irGGU7kP.toString());
			System.out.println("file does not exist, " + "is a directory rather than a regular file, "
					+ "or for some other reason cannot be opened for reading");
			System.exit(-1);
		}
		try {
			odXNCgTM = new FileOutputStream(zwEwlDtg);
		} catch (FileNotFoundException nzmjMSYx) {
			System.out.println("File: " + zwEwlDtg.toString());
			System.out.println("file exists but is a directory rather than a regular file, "
					+ "does not exist but cannot be created, " + "or cannot be opened for any other reason");
			System.exit(-1);
		}
		try {
			TKe1nnVZ = vcUsJ3Kh.getChannel();
			otpIFdUQ = odXNCgTM.getChannel();
			TKe1nnVZ.transferTo(0, TKe1nnVZ.size(), otpIFdUQ);
			odXNCgTM.flush();
			odXNCgTM.close();
			otpIFdUQ.close();
			vcUsJ3Kh.close();
			TKe1nnVZ.close();
			System.out.println("Completed copying " + irGGU7kP.toString() + " to " + zwEwlDtg.toString());
		} catch (IOException bs5exSPm) {
			System.out.println("IOException copying file: " + bs5exSPm.getMessage());
			System.exit(-1);
		}
		long muKQdDDG = irGGU7kP.lastModified();
		if (muKQdDDG > 0L && zwEwlDtg.exists()) {
			zwEwlDtg.setLastModified(muKQdDDG);
		}
	}

}