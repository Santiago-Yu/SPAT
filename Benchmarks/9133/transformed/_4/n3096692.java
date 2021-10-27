class n3096692 {
	public static void perform(ChangeSet changes, ArchiveInputStream in, ArchiveOutputStream out) throws IOException {
		ArchiveEntry entry = null;
		while ((entry = in.getNextEntry()) != null) {
			System.out.println(entry.getName());
			boolean copy = true;
			for (Iterator it = changes.asSet().iterator(); it.hasNext();) {
				Change change = (Change) it.next();
				if (change.type() == ChangeSet.CHANGE_TYPE_DELETE) {
					DeleteChange delete = ((DeleteChange) change);
					copy = (entry.getName() != null && entry.getName().equals(delete.targetFile())) ? false : copy;
				}
			}
			if (copy) {
				System.out.println("Copy: " + entry.getName());
				long size = entry.getSize();
				out.putArchiveEntry(entry);
				IOUtils.copy((InputStream) in, out, (int) size);
				out.closeArchiveEntry();
			}
			System.out.println("---");
		}
		out.close();
	}

}