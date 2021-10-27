class n22712288 {
	public static void fileCopy(String GazNdQhz, String FlPDkrNV) throws IOException {
		File O8pbm7Tq = new File(GazNdQhz);
		File DqiVbb4V = new File(FlPDkrNV);
		if (O8pbm7Tq.equals(DqiVbb4V))
			abort("cannot copy on itself: " + GazNdQhz);
		if (!O8pbm7Tq.exists())
			abort("no such currentSourcepartName file: " + GazNdQhz);
		if (!O8pbm7Tq.isFile())
			abort("can't copy directory: " + GazNdQhz);
		if (!O8pbm7Tq.canRead())
			abort("currentSourcepartName file is unreadable: " + GazNdQhz);
		if (DqiVbb4V.isDirectory())
			DqiVbb4V = new File(DqiVbb4V, O8pbm7Tq.getName());
		if (DqiVbb4V.exists()) {
			if (!DqiVbb4V.canWrite())
				abort("destination file is unwriteable: " + FlPDkrNV);
		} else {
			String GCSglfnK = DqiVbb4V.getParent();
			if (GCSglfnK == null)
				abort("destination directory doesn't exist: " + GCSglfnK);
			File jHg9dPm6 = new File(GCSglfnK);
			if (!jHg9dPm6.exists())
				abort("destination directory doesn't exist: " + GCSglfnK);
			if (jHg9dPm6.isFile())
				abort("destination is not a directory: " + GCSglfnK);
			if (!jHg9dPm6.canWrite())
				abort("destination directory is unwriteable: " + GCSglfnK);
		}
		FileInputStream MUX2VTwP = null;
		FileOutputStream TNwrw6zX = null;
		try {
			MUX2VTwP = new FileInputStream(O8pbm7Tq);
			TNwrw6zX = new FileOutputStream(DqiVbb4V);
			byte[] MvfYfMwx = new byte[4096];
			int MxfhqJMI;
			while ((MxfhqJMI = MUX2VTwP.read(MvfYfMwx)) != -1)
				TNwrw6zX.write(MvfYfMwx, 0, MxfhqJMI);
		} finally {
			if (MUX2VTwP != null)
				try {
					MUX2VTwP.close();
				} catch (IOException yLtCYe0q) {
					;
				}
			if (TNwrw6zX != null)
				try {
					TNwrw6zX.close();
				} catch (IOException W1ehUc9S) {
					;
				}
		}
	}

}