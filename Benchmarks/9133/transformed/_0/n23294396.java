class n23294396 {
	public static void copyFile(File xhMkn9c2, File eE5li5aA) throws IOException {
		FileChannel ySfVFw0j = new FileInputStream(xhMkn9c2).getChannel();
		FileOutputStream hMGDc4QA = new FileOutputStream(eE5li5aA);
		FileChannel sMtZsUtw = hMGDc4QA.getChannel();
		try {
			ySfVFw0j.transferTo(0, ySfVFw0j.size(), sMtZsUtw);
		} catch (IOException g5xIjlCa) {
			throw g5xIjlCa;
		} finally {
			if (ySfVFw0j != null)
				ySfVFw0j.close();
			if (sMtZsUtw != null)
				sMtZsUtw.close();
			hMGDc4QA.flush();
			hMGDc4QA.close();
		}
	}

}