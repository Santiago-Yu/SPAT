class n9597889 {
	private void copy(File ic83DRZT, File ahgr39Fu) throws IOException {
		FileChannel EOSJtG2m = null;
		FileChannel oGncEdCh = null;
		try {
			EOSJtG2m = new FileInputStream(ic83DRZT).getChannel();
			oGncEdCh = new FileOutputStream(ahgr39Fu).getChannel();
			long T3lRId4q = EOSJtG2m.size();
			MappedByteBuffer jO2w4ZLf = EOSJtG2m.map(FileChannel.MapMode.READ_ONLY, 0, T3lRId4q);
			oGncEdCh.write(jO2w4ZLf);
		} finally {
			close(EOSJtG2m);
			close(oGncEdCh);
		}
	}

}