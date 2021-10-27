class n15822137 {
	public TableDirectory(RandomAccessFile raf) throws IOException {
        version = raf.readInt();
        numTables = raf.readShort();
        searchRange = raf.readShort();
        entrySelector = raf.readShort();
        rangeShift = raf.readShort();
        entries = new DirectoryEntry[numTables];
        boolean modified = true;
        for (int i = 0; i < numTables; i++) {
			entries[i] = new DirectoryEntry(raf);
		}
        while (modified) {
            modified = false;
            for (int i = 0; i < numTables - 1; i++) {
                if (entries[i].getOffset() > entries[i + 1].getOffset()) {
                    DirectoryEntry temp = entries[i];
                    entries[i] = entries[i + 1];
                    modified = true;
                    entries[i + 1] = temp;
                }
            }
        }
    }

}