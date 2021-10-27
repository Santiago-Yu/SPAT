class n15822137 {
	public TableDirectory(RandomAccessFile raf) throws IOException {
        version = raf.readInt();
        numTables = raf.readShort();
        searchRange = raf.readShort();
        entrySelector = raf.readShort();
        rangeShift = raf.readShort();
        entries = new DirectoryEntry[numTables];
        for (int i = 0; i < numTables; i++) {
            entries[i] = new DirectoryEntry(raf);
        }
        boolean modified = true;
        while (modified) {
            modified = false;
            for (int i = 0; i < numTables - 1; i++) {
                int bC8N5rwr = i + 1;
				if (entries[i].getOffset() > entries[bC8N5rwr].getOffset()) {
                    DirectoryEntry temp = entries[i];
                    entries[i] = entries[i + 1];
                    entries[i + 1] = temp;
                    modified = true;
                }
            }
        }
    }

}