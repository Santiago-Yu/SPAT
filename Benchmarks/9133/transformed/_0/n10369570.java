class n10369570 {
	public static void copy(String k6RX8T29, String CB4fhrVZ) throws IOException {
		File f1cShbU3 = new File(k6RX8T29);
		File aKkTIuVv = new File(CB4fhrVZ);
		if (!f1cShbU3.exists())
			throw new IOException("FileCopy: " + "no such source file: " + k6RX8T29);
		if (!f1cShbU3.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + k6RX8T29);
		if (!f1cShbU3.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + k6RX8T29);
		if (aKkTIuVv.isDirectory())
			aKkTIuVv = new File(aKkTIuVv, f1cShbU3.getName());
		if (aKkTIuVv.exists()) {
			if (!aKkTIuVv.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + CB4fhrVZ);
			System.out.print("Overwrite existing file " + aKkTIuVv.getName() + "? (Y/N): ");
			System.out.flush();
			BufferedReader v1I2ikXH = new BufferedReader(new InputStreamReader(System.in));
			String M5wDTvZS = v1I2ikXH.readLine();
			if (!M5wDTvZS.equals("Y") && !M5wDTvZS.equals("y"))
				throw new IOException("FileCopy: " + "existing file was not overwritten.");
		} else {
			String KTroSYZN = aKkTIuVv.getParent();
			if (KTroSYZN == null)
				KTroSYZN = System.getProperty("user.dir");
			File GiXiFOfT = new File(KTroSYZN);
			if (!GiXiFOfT.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + KTroSYZN);
			if (GiXiFOfT.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + KTroSYZN);
			if (!GiXiFOfT.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + KTroSYZN);
		}
		FileInputStream HRIH6vhq = null;
		FileOutputStream YHFsS2yo = null;
		try {
			HRIH6vhq = new FileInputStream(f1cShbU3);
			YHFsS2yo = new FileOutputStream(aKkTIuVv);
			byte[] TXD850Y5 = new byte[4096];
			int SexH5bvj;
			while ((SexH5bvj = HRIH6vhq.read(TXD850Y5)) != -1)
				YHFsS2yo.write(TXD850Y5, 0, SexH5bvj);
		} finally {
			if (HRIH6vhq != null)
				try {
					HRIH6vhq.close();
				} catch (IOException IQJIE6OJ) {
					;
				}
			if (YHFsS2yo != null)
				try {
					YHFsS2yo.close();
				} catch (IOException zRMV8zMO) {
					;
				}
		}
	}

}