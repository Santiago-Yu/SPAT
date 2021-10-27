class n15822137 {
	public TableDirectory(RandomAccessFile NobRyctL) throws IOException {
        version = NobRyctL.readInt();
        numTables = NobRyctL.readShort();
        searchRange = NobRyctL.readShort();
        entrySelector = NobRyctL.readShort();
        rangeShift = NobRyctL.readShort();
        entries = new DirectoryEntry[numTables];
        for (int g2QfSab2 = 0; g2QfSab2 < numTables; g2QfSab2++) {
            entries[g2QfSab2] = new DirectoryEntry(NobRyctL);
        }
        boolean FXFZJJvN = true;
        while (FXFZJJvN) {
            FXFZJJvN = false;
            for (int Am9oCZzy = 0; Am9oCZzy < numTables - 1; Am9oCZzy++) {
                if (entries[Am9oCZzy].getOffset() > entries[Am9oCZzy + 1].getOffset()) {
                    DirectoryEntry bNWDPCeX = entries[Am9oCZzy];
                    entries[Am9oCZzy] = entries[Am9oCZzy + 1];
                    entries[Am9oCZzy + 1] = bNWDPCeX;
                    FXFZJJvN = true;
                }
            }
        }
    }

}