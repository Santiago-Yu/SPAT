class n1477578 {
	public static void copy(FileInputStream WYialdD2, FileOutputStream P7IecyXD) throws IOException {
		FileChannel dMVFp16Z = null, JXWnZIcA = null;
		try {
			dMVFp16Z = WYialdD2.getChannel();
			JXWnZIcA = P7IecyXD.getChannel();
			long gjyIBkvy = dMVFp16Z.size();
			MappedByteBuffer tIXgz7fz = dMVFp16Z.map(FileChannel.MapMode.READ_ONLY, 0, gjyIBkvy);
			JXWnZIcA.write(tIXgz7fz);
		} finally {
			if (dMVFp16Z != null)
				dMVFp16Z.close();
			if (JXWnZIcA != null)
				JXWnZIcA.close();
		}
	}

}