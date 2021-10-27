class n9136261 {
	public void copyFile(String G20rJGmV, String KgyuOk50) throws IOException {
		File vFFS8jsf = new File(G20rJGmV);
		File f7JksVt3 = new File(KgyuOk50);
		Reader ERmLvOBA = null;
		Writer dICpQI0b = null;
		char[] hIomLuSo;
		int MAgNmRx4;
		try {
			if (!vFFS8jsf.exists() || !vFFS8jsf.isFile())
				throw new FileCopyException("FileCopy: no such source file: " + G20rJGmV);
			if (!vFFS8jsf.canRead())
				throw new FileCopyException("FileCopy: source file " + "is unreadable: " + G20rJGmV);
			if (f7JksVt3.exists()) {
				if (f7JksVt3.isFile()) {
					DataInputStream xc96f64z = new DataInputStream(System.in);
					String W6YEuxl3;
					if (!f7JksVt3.canWrite())
						throw new FileCopyException("FileCopy: destination " + "file is unwriteable: " + KgyuOk50);
				} else {
					throw new FileCopyException("FileCopy: destination " + "is not a file: " + KgyuOk50);
				}
			} else {
				File LSLPkFsf = parent(f7JksVt3);
				if (!LSLPkFsf.exists())
					throw new FileCopyException("FileCopy: destination " + "directory doesn't exist: " + KgyuOk50);
				if (!LSLPkFsf.canWrite())
					throw new FileCopyException("FileCopy: destination " + "directory is unwriteable: " + KgyuOk50);
			}
			ERmLvOBA = new BufferedReader(new FileReader(vFFS8jsf));
			dICpQI0b = new BufferedWriter(new FileWriter(f7JksVt3));
			hIomLuSo = new char[1024];
			while (true) {
				MAgNmRx4 = ERmLvOBA.read(hIomLuSo, 0, 1024);
				if (MAgNmRx4 == -1)
					break;
				dICpQI0b.write(hIomLuSo, 0, MAgNmRx4);
			}
		} finally {
			if (ERmLvOBA != null) {
				try {
					ERmLvOBA.close();
				} catch (IOException Y1dDG4aJ) {
					;
				}
			}
			if (dICpQI0b != null) {
				try {
					dICpQI0b.close();
				} catch (IOException Mm3Ajjth) {
					;
				}
			}
		}
	}

}