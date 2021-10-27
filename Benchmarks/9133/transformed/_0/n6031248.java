class n6031248 {
	public static void copyFile(File f3TcO77q, File wjCeLJmf) throws IOException {
		FileChannel smHsZZjj = null, VMG5eSlU = null;
		try {
			smHsZZjj = new FileInputStream(f3TcO77q).getChannel();
			VMG5eSlU = new FileOutputStream(wjCeLJmf).getChannel();
			long XJw6YYiB = smHsZZjj.size();
			MappedByteBuffer YnIbA9YN = smHsZZjj.map(FileChannel.MapMode.READ_ONLY, 0, XJw6YYiB);
			VMG5eSlU.write(YnIbA9YN);
		} finally {
			if (smHsZZjj != null)
				smHsZZjj.close();
			if (VMG5eSlU != null)
				VMG5eSlU.close();
		}
	}

}