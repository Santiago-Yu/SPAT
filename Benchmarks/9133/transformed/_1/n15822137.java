class n15822137 {
	public TableDirectory(RandomAccessFile raf) throws IOException {
        version = raf.readInt();
        numTables = raf.readShort();
        searchRange = raf.readShort();
        entrySelector = raf.readShort();
        rangeShift = raf.readShort();
        entries = new DirectoryEntry[numTables];
        int mfo4w = 0;
		while (mfo4w < numTables) {
			entries[mfo4w] = new DirectoryEntry(raf);
			mfo4w++;
		}
        boolean modified = true;
        while (modified) {
            modified = false;
            int Z3jb1 = 0;
			while (Z3jb1 < numTables - 1) {
				if (entries[Z3jb1].getOffset() > entries[Z3jb1 + 1].getOffset()) {
					DirectoryEntry temp = entries[Z3jb1];
					entries[Z3jb1] = entries[Z3jb1 + 1];
					entries[Z3jb1 + 1] = temp;
					modified = true;
				}
				Z3jb1++;
			}
        }
    }

}