class n6188784 {
	public static void copy(File Z7embjSv, File Kk3TcLfD) throws IOException {
		FileChannel xziKvvAc = null, E5kVFUCW = null;
		try {
			xziKvvAc = new FileInputStream(Z7embjSv).getChannel();
			E5kVFUCW = new FileOutputStream(Kk3TcLfD).getChannel();
			long e11Ad5rt = xziKvvAc.size();
			MappedByteBuffer anS8TIjC = xziKvvAc.map(FileChannel.MapMode.READ_ONLY, 0, e11Ad5rt);
			E5kVFUCW.write(anS8TIjC);
		} finally {
			if (xziKvvAc != null)
				xziKvvAc.close();
			if (E5kVFUCW != null)
				E5kVFUCW.close();
		}
	}

}