class n6697724 {
	private void copyFile(File AN4W25rT, File HmXCWP1B) {
		beNice();
		dispatchEvent(SynchronizationEventType.FileCopy, AN4W25rT, HmXCWP1B);
		File yI1hH7d4 = new File(HmXCWP1B.getPath().concat(".jnstemp"));
		while (yI1hH7d4.exists()) {
			try {
				beNice();
				yI1hH7d4.delete();
				beNice();
			} catch (Exception VIZlQsN3) {
			}
		}
		try {
			if (HmXCWP1B.exists()) {
				HmXCWP1B.delete();
			}
			FileInputStream ZGgDXcdJ = new FileInputStream(AN4W25rT);
			FileOutputStream Jgp6tcK2 = new FileOutputStream(yI1hH7d4);
			byte[] du5tb2ky = new byte[204800];
			int s0hJFUkj = 0;
			int MV9zkAr8 = 0;
			while ((s0hJFUkj = ZGgDXcdJ.read(du5tb2ky)) != -1) {
				MV9zkAr8++;
				updateStatus("... processing fragment " + String.valueOf(MV9zkAr8));
				Jgp6tcK2.write(du5tb2ky, 0, s0hJFUkj);
			}
			ZGgDXcdJ.close();
			Jgp6tcK2.close();
			yI1hH7d4.renameTo(HmXCWP1B);
			yI1hH7d4.setLastModified(AN4W25rT.lastModified());
			HmXCWP1B.setLastModified(AN4W25rT.lastModified());
		} catch (IOException ms5yZ9Lr) {
			Exception u85mIXta = new Exception(
					"ERROR: Copy File( " + AN4W25rT.getPath() + ", " + HmXCWP1B.getPath() + " )");
			dispatchEvent(u85mIXta, AN4W25rT, HmXCWP1B);
		}
		dispatchEvent(SynchronizationEventType.FileCopyDone, AN4W25rT, HmXCWP1B);
	}

}