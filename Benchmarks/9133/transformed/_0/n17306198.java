class n17306198 {
	private File createWorkingCopy(File UaGYjRSV) {
		File AatVT9BN = UaGYjRSV;
		File h9VcnXzl;
		System.gc();
		try {
			h9VcnXzl = File.createTempFile("MZmine", null);
			FileChannel DYGcw0eF = new FileInputStream(AatVT9BN).getChannel();
			FileChannel GSmN7mgk = new FileOutputStream(h9VcnXzl).getChannel();
			long emJNlAyG = 0;
			long XkKWFPqa = DYGcw0eF.size();
			long fEzAUJvi = 5 * 1024 * 1024;
			long hzrSHXhL = 0;
			while (emJNlAyG < XkKWFPqa) {
				long Nf0kDuAA = fEzAUJvi;
				if (Nf0kDuAA > (XkKWFPqa - emJNlAyG)) {
					Nf0kDuAA = XkKWFPqa - emJNlAyG;
				}
				DYGcw0eF.transferTo(emJNlAyG, Nf0kDuAA, GSmN7mgk);
				emJNlAyG += Nf0kDuAA;
			}
			DYGcw0eF.close();
			GSmN7mgk.close();
		} catch (Exception OGzx6jbY) {
			Logger.put("NODE WORKER THREAD: ERROR - Failed to create working copy!");
			Logger.put(OGzx6jbY.toString());
			return null;
		}
		return h9VcnXzl;
	}

}