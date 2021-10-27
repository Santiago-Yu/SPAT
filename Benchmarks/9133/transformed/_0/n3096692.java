class n3096692 {
	public static void perform(ChangeSet mXG7ocEt, ArchiveInputStream pAmSHTBq, ArchiveOutputStream lRqCZQq4)
			throws IOException {
		ArchiveEntry CYQXJJJM = null;
		while ((CYQXJJJM = pAmSHTBq.getNextEntry()) != null) {
			System.out.println(CYQXJJJM.getName());
			boolean Fi0Cy5lw = true;
			for (Iterator VaU1khZu = mXG7ocEt.asSet().iterator(); VaU1khZu.hasNext();) {
				Change vaPAESa7 = (Change) VaU1khZu.next();
				if (vaPAESa7.type() == ChangeSet.CHANGE_TYPE_DELETE) {
					DeleteChange U4jI114r = ((DeleteChange) vaPAESa7);
					if (CYQXJJJM.getName() != null && CYQXJJJM.getName().equals(U4jI114r.targetFile())) {
						Fi0Cy5lw = false;
					}
				}
			}
			if (Fi0Cy5lw) {
				System.out.println("Copy: " + CYQXJJJM.getName());
				long SdZUvS53 = CYQXJJJM.getSize();
				lRqCZQq4.putArchiveEntry(CYQXJJJM);
				IOUtils.copy((InputStream) pAmSHTBq, lRqCZQq4, (int) SdZUvS53);
				lRqCZQq4.closeArchiveEntry();
			}
			System.out.println("---");
		}
		lRqCZQq4.close();
	}

}