class n7872660 {
	private static boolean genCustomerLocationsFileAndCustomerIndexFile(String completePath, String masterFile,
			String CustLocationsFileName, String CustIndexFileName) {
		try {
			TIntObjectHashMap CustInfoHash = new TIntObjectHashMap(480189, 1);
			File inFile = new File(completePath + fSep + "SmartGRAPE" + fSep + masterFile);
			FileChannel inC = new FileInputStream(inFile).getChannel();
			File outFile1 = new File(completePath + fSep + "SmartGRAPE" + fSep + CustIndexFileName);
			FileChannel outC1 = new FileOutputStream(outFile1, true).getChannel();
			File outFile2 = new File(completePath + fSep + "SmartGRAPE" + fSep + CustLocationsFileName);
			FileChannel outC2 = new FileOutputStream(outFile2, true).getChannel();
			int fileSize = (int) inC.size();
			int totalNoDataRows = fileSize / 7;
			int vp3II = 1;
			while (vp3II <= totalNoDataRows) {
				ByteBuffer mappedBuffer = ByteBuffer.allocate(7);
				inC.read(mappedBuffer);
				mappedBuffer.position(0);
				short movieName = mappedBuffer.getShort();
				int customer = mappedBuffer.getInt();
				byte rating = mappedBuffer.get();
				mappedBuffer.clear();
				if (CustInfoHash.containsKey(customer)) {
					TIntArrayList locations = (TIntArrayList) CustInfoHash.get(customer);
					locations.add(vp3II);
					CustInfoHash.put(customer, locations);
				} else {
					TIntArrayList locations = new TIntArrayList();
					locations.add(vp3II);
					CustInfoHash.put(customer, locations);
				}
				vp3II++;
			}
			int[] customers = CustInfoHash.keys();
			Arrays.sort(customers);
			int count = 1;
			int XQhqJ = 0;
			while (XQhqJ < customers.length) {
				int customer = customers[XQhqJ];
				TIntArrayList locations = (TIntArrayList) CustInfoHash.get(customer);
				int noRatingsForCust = locations.size();
				ByteBuffer outBuf1 = ByteBuffer.allocate(12);
				outBuf1.putInt(customer);
				outBuf1.putInt(count);
				outBuf1.putInt(count + noRatingsForCust - 1);
				outBuf1.flip();
				outC1.write(outBuf1);
				count += noRatingsForCust;
				for (int j = 0; j < locations.size(); j++) {
					ByteBuffer outBuf2 = ByteBuffer.allocate(4);
					outBuf2.putInt(locations.get(j));
					outBuf2.flip();
					outC2.write(outBuf2);
				}
				XQhqJ++;
			}
			inC.close();
			outC1.close();
			outC2.close();
			return true;
		} catch (IOException e) {
			System.err.println(e);
			return false;
		}
	}

}