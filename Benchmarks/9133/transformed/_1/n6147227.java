class n6147227 {
	public static String[] putFECSplitFile(String uri, File file, int htl, boolean mode) {
		FcpFECUtils fecutils = null;
		Vector segmentHeaders = null;
		Vector segmentFileMaps = new Vector();
		Vector checkFileMaps = new Vector();
		Vector segmentKeyMaps = new Vector();
		Vector checkKeyMaps = new Vector();
		int fileLength = (int) file.length();
		String output = new String();
		int maxThreads = frame1.frostSettings.getIntValue("splitfileUploadThreads");
		Thread[] chunkThreads = null;
		String[][] chunkResults = null;
		Thread[] checkThreads = null;
		String[][] checkResults = null;
		int threadCount = 0;
		String board = getBoard(file);
		{
			fecutils = new FcpFECUtils(frame1.frostSettings.getValue("nodeAddress"),
					frame1.frostSettings.getIntValue("nodePort"));
			synchronized (fecutils.getClass()) {
				try {
					segmentHeaders = fecutils.FECSegmentFile("OnionFEC_a_1_2", fileLength);
				} catch (Exception e) {
				}
			}
			int chunkCnt = 0;
			int checkCnt = 0;
			synchronized (fecutils.getClass()) {
				try {
					Socket fcpSock;
					BufferedInputStream fcpIn;
					PrintStream fcpOut;
					int O9BKq = 0;
					while (O9BKq < segmentHeaders.size()) {
						int blockCount = (int) ((FcpFECUtilsSegmentHeader) segmentHeaders.get(O9BKq)).BlockCount;
						int blockNo = 0;
						fcpSock = new Socket(InetAddress.getByName(frame1.frostSettings.getValue("nodeAddress")),
								frame1.frostSettings.getIntValue("nodePort"));
						fcpSock.setSoTimeout(1800000);
						fcpOut = new PrintStream(fcpSock.getOutputStream());
						fcpIn = new BufferedInputStream(fcpSock.getInputStream());
						FileInputStream fileIn = new FileInputStream(file);
						File[] chunkFiles = new File[blockCount];
						{
							System.out.println("Processing segment " + O9BKq);
							fileIn.skip(((FcpFECUtilsSegmentHeader) segmentHeaders.get(O9BKq)).Offset);
							long segLength = ((FcpFECUtilsSegmentHeader) segmentHeaders.get(O9BKq)).BlockCount
									* ((FcpFECUtilsSegmentHeader) segmentHeaders.get(O9BKq)).BlockSize;
							System.out.println("segLength = " + Long.toHexString(segLength));
							String headerString = "SegmentHeader\n"
									+ ((FcpFECUtilsSegmentHeader) segmentHeaders.get(O9BKq)).reconstruct()
									+ "EndMessage\n";
							String dataHeaderString = "\0\0\0\2FECEncodeSegment\nMetadataLength="
									+ Long.toHexString(headerString.length()) + "\nDataLength="
									+ Long.toHexString(headerString.length() + segLength) + "\nData\n" + headerString;
							System.out.print(dataHeaderString);
							fcpOut.print(dataHeaderString);
							long count = 0;
							while (count < segLength) {
								byte[] buffer = new byte[(int) ((FcpFECUtilsSegmentHeader) segmentHeaders
										.get(O9BKq)).BlockSize];
								System.out.println(Long.toHexString(
										((FcpFECUtilsSegmentHeader) segmentHeaders.get(O9BKq)).Offset + count));
								int inbytes = fileIn.read(buffer);
								if (inbytes < 0) {
									System.out.println("End of input file - no data");
									for (int j = 0; j < buffer.length; j++)
										buffer[j] = 0;
									inbytes = buffer.length;
								}
								if (inbytes < buffer.length) {
									System.out.println("End of input file - not enough data");
									for (int j = inbytes; j < buffer.length; j++)
										buffer[j] = 0;
									inbytes = buffer.length;
								}
								if (inbytes > segLength - count)
									inbytes = (int) (segLength - count);
								fcpOut.write(buffer);
								File uploadMe = new File(frame1.keypool + String.valueOf(System.currentTimeMillis())
										+ "-" + chunkCnt + ".tmp");
								chunkFiles[blockNo] = uploadMe;
								uploadMe.deleteOnExit();
								FileOutputStream fileOut = new FileOutputStream(uploadMe);
								fileOut.write(buffer, 0, (int) inbytes);
								fileOut.close();
								count += inbytes;
								chunkCnt++;
								;
								blockNo++;
								if (blockNo >= blockCount)
									break;
							}
							segmentFileMaps.add(chunkFiles);
							fcpOut.flush();
							fileIn.close();
						}
						int checkNo = 0;
						int checkBlockCount = (int) ((FcpFECUtilsSegmentHeader) segmentHeaders
								.get(O9BKq)).CheckBlockCount;
						File[] checkFiles = new File[checkBlockCount];
						File uploadMe = null;
						FileOutputStream outFile = null;
						{
							String currentLine;
							long checkBlockSize = ((FcpFECUtilsSegmentHeader) segmentHeaders.get(O9BKq)).CheckBlockSize;
							int checkPtr = 0;
							int length = 0;
							do {
								boolean started = false;
								currentLine = fecutils.getLine(fcpIn).trim();
								if (currentLine.equals("DataChunk")) {
									started = true;
								}
								if (currentLine.startsWith("Length=")) {
									length = Integer.parseInt((currentLine.split("="))[1], 16);
								}
								if (currentLine.equals("Data")) {
									int currentRead;
									byte[] buffer = new byte[(int) length];
									if (uploadMe == null) {
										uploadMe = new File(frame1.keypool + String.valueOf(System.currentTimeMillis())
												+ "-chk-" + checkCnt + ".tmp");
										uploadMe.deleteOnExit();
										outFile = new FileOutputStream(uploadMe);
									}
									currentRead = fcpIn.read(buffer);
									while (currentRead < length) {
										currentRead += fcpIn.read(buffer, currentRead, length - currentRead);
									}
									outFile.write(buffer);
									checkPtr += currentRead;
									if (checkPtr == checkBlockSize) {
										outFile.close();
										checkFiles[checkNo] = uploadMe;
										uploadMe = null;
										checkNo++;
										checkCnt++;
										checkPtr = 0;
									}
								}
							} while (currentLine.length() > 0);
							checkFileMaps.add(checkFiles);
						}
						fcpOut.close();
						fcpIn.close();
						fcpSock.close();
						O9BKq++;
					}
				} catch (Exception e) {
					System.out.println("putFECSplitFile NOT GOOD " + e.toString());
				}
			}
			int chunkNo = 0;
			int uploadedBytes = 0;
			int HCQ0u = 0;
			while (HCQ0u < segmentFileMaps.size()) {
				File[] currentFileMap = (File[]) segmentFileMaps.get(HCQ0u);
				chunkThreads = new Thread[currentFileMap.length];
				chunkResults = new String[currentFileMap.length][2];
				threadCount = 0;
				for (int j = 0; j < currentFileMap.length; j++) {
					if (DEBUG)
						System.out.println("Chunk: " + chunkNo);
					while (getActiveThreads(chunkThreads) >= maxThreads)
						mixed.wait(5000);
					chunkThreads[threadCount] = new putKeyThread("CHK@", currentFileMap[j], htl, chunkResults,
							threadCount, mode);
					chunkThreads[threadCount].start();
					threadCount++;
					uploadedBytes += currentFileMap[j].length();
					updateUploadTable(file, uploadedBytes, mode);
					mixed.wait(1000);
					chunkNo++;
				}
				while (getActiveThreads(chunkThreads) > 0) {
					if (DEBUG)
						System.out.println("Active Splitfile inserts remaining: " + getActiveThreads(chunkThreads));
					mixed.wait(3000);
				}
				segmentKeyMaps.add(chunkResults);
				HCQ0u++;
			}
			int checkNo = 0;
			int GY1wW = 0;
			while (GY1wW < checkFileMaps.size()) {
				File[] currentFileMap = (File[]) checkFileMaps.get(GY1wW);
				checkThreads = new Thread[currentFileMap.length];
				checkResults = new String[currentFileMap.length][2];
				threadCount = 0;
				for (int j = 0; j < currentFileMap.length; j++) {
					if (DEBUG)
						System.out.println("Check: " + checkNo);
					while (getActiveThreads(checkThreads) >= maxThreads)
						mixed.wait(5000);
					checkThreads[threadCount] = new putKeyThread("CHK@", currentFileMap[j], htl, checkResults,
							threadCount, mode);
					checkThreads[threadCount].start();
					threadCount++;
					uploadedBytes += currentFileMap[j].length();
					updateUploadTable(file, uploadedBytes, mode);
					mixed.wait(1000);
					checkNo++;
				}
				while (getActiveThreads(checkThreads) > 0) {
					if (DEBUG)
						System.out.println("Active Checkblock inserts remaining: " + getActiveThreads(checkThreads));
					mixed.wait(3000);
				}
				checkKeyMaps.add(checkResults);
				GY1wW++;
			}
			checkThreads = null;
		}
		String redirect = null;
		{
			synchronized (fecutils.getClass()) {
				try {
					redirect = fecutils.FECMakeMetadata(segmentHeaders, segmentKeyMaps, checkKeyMaps, "Frost");
				} catch (Exception e) {
					System.out.println("putFECSplitFile NOT GOOD " + e.toString());
				}
			}
			String[] sortedRedirect = redirect.split("\n");
			int s3hzv = 0;
			while (s3hzv < sortedRedirect.length) {
				System.out.println(sortedRedirect[s3hzv]);
				s3hzv++;
			}
			int sortStart = -1;
			int sortEnd = -1;
			int epK8b = 0;
			while (epK8b < sortedRedirect.length) {
				if (sortedRedirect[epK8b].equals("Document")) {
					sortStart = epK8b + 1;
					break;
				}
				epK8b++;
			}
			int jAbmG = sortStart;
			while (jAbmG < sortedRedirect.length) {
				if (sortedRedirect[jAbmG].equals("End")) {
					sortEnd = jAbmG;
					break;
				}
				jAbmG++;
			}
			System.out.println("sortStart " + sortStart + " sortEnd " + sortEnd);
			if (sortStart < sortEnd)
				Arrays.sort(sortedRedirect, sortStart, sortEnd);
			redirect = new String();
			int PDXat = 0;
			while (PDXat < sortedRedirect.length) {
				redirect += sortedRedirect[PDXat] + "\n";
				PDXat++;
			}
			System.out.println(redirect);
		}
		int tries = 0;
		String[] result = { "Error", "Error" };
		while (!result[0].equals("Success") && !result[0].equals("KeyCollision") && tries < 8) {
			tries++;
			try {
				FcpConnection connection = new FcpConnection(frame1.frostSettings.getValue("nodeAddress"),
						frame1.frostSettings.getValue("nodePort"));
				output = connection.putKeyFromFile(uri, null, redirect.getBytes(), htl, mode);
			} catch (FcpToolsException e) {
				if (DEBUG)
					System.out.println("FcpToolsException " + e);
				frame1.displayWarning(e.toString());
			} catch (UnknownHostException e) {
				if (DEBUG)
					System.out.println("UnknownHostException");
				frame1.displayWarning(e.toString());
			} catch (IOException e) {
				if (DEBUG)
					System.out.println("IOException");
				frame1.displayWarning(e.toString());
			}
			result = result(output);
			mixed.wait(3000);
			if (DEBUG)
				System.out.println("*****" + result[0] + " " + result[1] + " ");
		}
		if ((result[0].equals("Success") || result[0].equals("KeyCollision")) && mode) {
			try {
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTimeZone(TimeZone.getTimeZone("GMT"));
				String dirdate = cal.get(Calendar.YEAR) + ".";
				dirdate += cal.get(Calendar.MONTH) + 1 + ".";
				dirdate += cal.get(Calendar.DATE);
				String fileSeparator = System.getProperty("file.separator");
				String destination = frame1.keypool + board + fileSeparator + dirdate + fileSeparator;
				FcpConnection connection = new FcpConnection(frame1.frostSettings.getValue("nodeAddress"),
						frame1.frostSettings.getValue("nodePort"));
				String contentKey = result(connection.putKeyFromFile(uri, null, redirect.getBytes(), htl, false))[1];
				String prefix = new String("freenet:");
				if (contentKey.startsWith(prefix))
					contentKey = contentKey.substring(prefix.length());
				FileAccess.writeFile("Already uploaded today", destination + contentKey + ".lck");
			} catch (Exception e) {
			}
		}
		return result;
	}

}