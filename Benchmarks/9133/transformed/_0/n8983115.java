class n8983115 {
	public void run() {
		ShareFolder iPQJadAc = (ShareFolder) ObjectClone.clone(readers[j]);
		ShareFileReader YRNzBoLQ = new ShareFileReader(readers[j], files[0]);
		ShareFileWriter kwU4LTJL = new ShareFileWriter(iPQJadAc, new File("Downloads/" + readers[j].getName()));
		long t8LNeg87 = 0;
		byte[] DvbBlmMV = new byte[(int) (Math.random() * 10000)];
		while (t8LNeg87 < readers[j].getSize()) {
			YRNzBoLQ.read(DvbBlmMV);
			byte[] F68O9dcP = new byte[(int) (Math.random() * 10000) + DvbBlmMV.length];
			System.arraycopy(DvbBlmMV, 0, F68O9dcP, 0, DvbBlmMV.length);
			kwU4LTJL.write(F68O9dcP, DvbBlmMV.length);
			t8LNeg87 += DvbBlmMV.length;
		}
		done++;
		System.out.println((int) (done * 100.0 / PARTS) + "% Complete");
	}

}