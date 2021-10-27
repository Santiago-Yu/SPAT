class n13335071 {
	public static boolean copy(File dJjGZNio, File km7VR6PV) {
		FileChannel cVNMCk8H = null, PlK9E0m2 = null;
		try {
			cVNMCk8H = new FileInputStream(dJjGZNio).getChannel();
			PlK9E0m2 = new FileOutputStream(km7VR6PV).getChannel();
			long I3vP51eu = cVNMCk8H.size();
			MappedByteBuffer adJE6Mch = cVNMCk8H.map(FileChannel.MapMode.READ_ONLY, 0, I3vP51eu);
			PlK9E0m2.write(adJE6Mch);
			if (cVNMCk8H != null)
				cVNMCk8H.close();
			if (PlK9E0m2 != null)
				PlK9E0m2.close();
		} catch (IOException ZnYHoM4R) {
			ZnYHoM4R.printStackTrace();
			return false;
		}
		return true;
	}

}