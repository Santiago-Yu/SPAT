class n20958789 {
	private void fileMaker() {
		try {
			long rKCOilJs = 0;
			double hnZxgYoK = 10;
			int KxRVDwvN = 0;
			int zY2F6nt6 = 0;
			File RiZpn1lI = new File(mfr.getFilename() + ".part");
			if (RiZpn1lI.exists()) {
				RiZpn1lI.delete();
			}
			ArrayList<DataRange> dsd3jSMm = null;
			byte[] JlpPn2RI = null;
			RiZpn1lI.createNewFile();
			ByteBuffer TJeVCbqW = ByteBuffer.allocate(mfr.getBlocksize());
			FileChannel NI4iLuQO = new FileInputStream(inputFileName).getChannel();
			FileChannel afIxtlCf = new FileOutputStream(RiZpn1lI, true).getChannel();
			System.out.println();
			System.out.print("File completion: ");
			System.out.print("|----------|");
			openConnection();
			http.getResponseHeader();
			for (int vYFGmjxh = 0; vYFGmjxh < fileMap.length; vYFGmjxh++) {
				fileOffset = fileMap[vYFGmjxh];
				if (fileOffset != -1) {
					NI4iLuQO.read(TJeVCbqW, fileOffset);
					TJeVCbqW.flip();
					afIxtlCf.write(TJeVCbqW);
					TJeVCbqW.clear();
				} else {
					if (!rangeQueue) {
						dsd3jSMm = rangeLookUp(vYFGmjxh);
						KxRVDwvN = dsd3jSMm.size();
						openConnection();
						http.setRangesRequest(dsd3jSMm);
						http.sendRequest();
						http.getResponseHeader();
						JlpPn2RI = http.getResponseBody(mfr.getBlocksize());
						rKCOilJs += http.getAllTransferedDataLength();
					}
					if ((vYFGmjxh * mfr.getBlocksize() + mfr.getBlocksize()) < mfr.getLength()) {
						zY2F6nt6 = mfr.getBlocksize();
					} else {
						zY2F6nt6 = (int) ((int) (mfr.getBlocksize())
								+ (mfr.getLength() - (vYFGmjxh * mfr.getBlocksize() + mfr.getBlocksize())));
					}
					TJeVCbqW.put(JlpPn2RI, (KxRVDwvN - dsd3jSMm.size()) * mfr.getBlocksize(), zY2F6nt6);
					TJeVCbqW.flip();
					afIxtlCf.write(TJeVCbqW);
					TJeVCbqW.clear();
					dsd3jSMm.remove(0);
					if (dsd3jSMm.isEmpty()) {
						rangeQueue = false;
					}
				}
				if ((((double) vYFGmjxh / ((double) fileMap.length - 1)) * 100) >= hnZxgYoK) {
					progressBar(((double) vYFGmjxh / ((double) fileMap.length - 1)) * 100);
					hnZxgYoK += 10;
				}
			}
			RiZpn1lI.setLastModified(getMTime());
			sha = new SHA1(RiZpn1lI);
			if (sha.SHA1sum().equals(mfr.getSha1())) {
				System.out.println("\nverifying download...checksum matches OK");
				System.out.println("used " + (mfr.getLength() - (mfr.getBlocksize() * missing)) + " "
						+ "local, fetched " + (mfr.getBlocksize() * missing));
				new File(mfr.getFilename()).renameTo(new File(mfr.getFilename() + ".zs-old"));
				RiZpn1lI.renameTo(new File(mfr.getFilename()));
				rKCOilJs += mfr.getLengthOfMetafile();
				System.out.println("really downloaded " + rKCOilJs);
				double zS5Mkcva = ((double) (rKCOilJs - (mfr.getBlocksize() * missing))
						/ ((double) (mfr.getBlocksize() * missing))) * 100;
				System.out.println("overhead: " + df.format(zS5Mkcva) + "%");
			} else {
				System.out.println("\nverifying download...checksum don't match");
				System.out.println("Deleting temporary file");
				RiZpn1lI.delete();
				System.exit(1);
			}
		} catch (IOException mDLt3F3d) {
			System.out.println("Can't read or write, check your permissions.");
			System.exit(1);
		}
	}

}