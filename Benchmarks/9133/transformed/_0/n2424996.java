class n2424996 {
	protected void migrateOnDemand() {
		try {
			if (fso.fileExists(prefix + ".fat") && !fso.fileExists(prefix + EXTENSIONS[UBM_FILE])) {
				RandomAccessFile MWAtO9aU, RhS4pgUD, tWhSvchq, U5hWnpsF;
				InputStream TIWVSP8P;
				OutputStream wfiIKUU2;
				fso.renameFile(prefix + ".fat", prefix + EXTENSIONS[UBM_FILE]);
				MWAtO9aU = fso.openFile(prefix + EXTENSIONS[UBM_FILE], "rw");
				RhS4pgUD = fso.openFile(prefix + EXTENSIONS[MTD_FILE], "rw");
				tWhSvchq = fso.openFile(prefix + EXTENSIONS[CTR_FILE], "rw");
				MWAtO9aU.seek(MWAtO9aU.length() - 16);
				RhS4pgUD.writeInt(blockSize = MWAtO9aU.readInt());
				RhS4pgUD.writeInt(size = MWAtO9aU.readInt());
				tWhSvchq.setLength(MWAtO9aU.readLong() + blockSize);
				tWhSvchq.close();
				RhS4pgUD.close();
				MWAtO9aU.setLength(MWAtO9aU.length() - 16);
				MWAtO9aU.seek(0);
				U5hWnpsF = fso.openFile(prefix + EXTENSIONS[UBM_FILE], "rw");
				TIWVSP8P = new BufferedInputStream(new RandomAccessFileInputStream(MWAtO9aU));
				wfiIKUU2 = new BufferedOutputStream(new RandomAccessFileOutputStream(U5hWnpsF));
				for (int KLxJwXpT; (KLxJwXpT = TIWVSP8P.read()) != -1;)
					wfiIKUU2.write(KLxJwXpT);
				wfiIKUU2.close();
				TIWVSP8P.close();
				U5hWnpsF.close();
				MWAtO9aU.close();
			}
		} catch (IOException WU1z9oHk) {
			throw new WrappingRuntimeException(WU1z9oHk);
		}
	}

}