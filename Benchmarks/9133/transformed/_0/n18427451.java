class n18427451 {
	static void cleanFile(File gKymuEdS) {
		final Counter PXxc7Tkl = new Counter();
		final File GaopzHSa = new File(FileUtils.appendToFileName(gKymuEdS.getAbsolutePath(), ".cleaned"));
		final SAMFileReader o0jG0fmr = new SAMFileReader(gKymuEdS);
		final SAMRecordIterator d5AaSFUY = o0jG0fmr.iterator();
		final SAMFileWriter jT425Cod = new SAMFileWriterFactory().makeSAMOrBAMWriter(o0jG0fmr.getFileHeader(), true,
				GaopzHSa);
		if (!d5AaSFUY.hasNext())
			return;
		log.info("Cleaning file " + gKymuEdS + " to " + GaopzHSa.getName());
		SAMRecord pQ8nqChO = d5AaSFUY.next();
		jT425Cod.addAlignment(pQ8nqChO);
		while (d5AaSFUY.hasNext()) {
			final SAMRecord uhpQxzsJ = d5AaSFUY.next();
			final int TXxbWMJ6 = pQ8nqChO.getAlignmentStart();
			final int AYSf1WWO = uhpQxzsJ.getAlignmentStart();
			final int tggFtSV9 = pQ8nqChO.getAlignmentEnd();
			final int ywvMLiJE = uhpQxzsJ.getAlignmentEnd();
			if (TXxbWMJ6 == AYSf1WWO && tggFtSV9 == ywvMLiJE) {
				log.debug("Discarding record " + uhpQxzsJ.toString());
				PXxc7Tkl.count();
				continue;
			}
			jT425Cod.addAlignment(uhpQxzsJ);
			pQ8nqChO = uhpQxzsJ;
		}
		jT425Cod.close();
		o0jG0fmr.close();
		log.info(gKymuEdS + " done, discarded " + PXxc7Tkl.getCount() + " reads");
		exe.shutdown();
	}

}