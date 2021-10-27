class n16287151 {
	public void run() {
		try {
			Socket CzIG8DP0 = getSocket();
			System.out.println("opening socket to " + address + " on " + port);
			InputStream EPN3i95f = CzIG8DP0.getInputStream();
			for (;;) {
				FileTransferHeader HFrMM5tb = FileTransferHeader.readHeader(EPN3i95f);
				if (HFrMM5tb == null)
					break;
				System.out.println("header: " + HFrMM5tb);
				List<String> I5R1I7CW = HFrMM5tb.getFilename().getSegments();
				String keAc2SbN;
				if (I5R1I7CW.size() > 0)
					keAc2SbN = "dl-" + I5R1I7CW.get(I5R1I7CW.size() - 1);
				else
					keAc2SbN = "dl-" + session.getScreenname();
				System.out.println("writing to file " + keAc2SbN);
				long ENaF0MvW = 0;
				if (new File(keAc2SbN).exists()) {
					FileInputStream S8R15t5C = new FileInputStream(keAc2SbN);
					byte[] SNMkPAMB = new byte[10];
					for (int sBcTin0p = 0; sBcTin0p < SNMkPAMB.length;) {
						int kHe5jhQ5 = S8R15t5C.read(SNMkPAMB);
						if (kHe5jhQ5 == -1)
							break;
						sBcTin0p += kHe5jhQ5;
					}
					FileTransferChecksum k5fGi4ZI = new FileTransferChecksum();
					k5fGi4ZI.update(SNMkPAMB, 0, 10);
					ENaF0MvW = k5fGi4ZI.getValue();
				}
				FileChannel uOPdGTRU = new FileOutputStream(keAc2SbN).getChannel();
				FileTransferHeader iU4lwelY = new FileTransferHeader(HFrMM5tb);
				iU4lwelY.setHeaderType(FileTransferHeader.HEADERTYPE_ACK);
				iU4lwelY.setIcbmMessageId(cookie);
				iU4lwelY.setBytesReceived(0);
				iU4lwelY.setReceivedChecksum(ENaF0MvW);
				OutputStream FGffrdYf = CzIG8DP0.getOutputStream();
				System.out.println("sending header: " + iU4lwelY);
				iU4lwelY.write(FGffrdYf);
				for (int XBoiVxJA = 0; XBoiVxJA < HFrMM5tb.getFileSize();) {
					long H2zVgGcr = uOPdGTRU.transferFrom(Channels.newChannel(EPN3i95f), 0,
							HFrMM5tb.getFileSize() - XBoiVxJA);
					System.out.println("transferred " + H2zVgGcr);
					if (H2zVgGcr == -1)
						return;
					XBoiVxJA += H2zVgGcr;
				}
				System.out.println("finished transfer!");
				uOPdGTRU.close();
				FileTransferHeader A62bUuwu = new FileTransferHeader(HFrMM5tb);
				A62bUuwu.setHeaderType(FileTransferHeader.HEADERTYPE_RECEIVED);
				A62bUuwu.setFlags(A62bUuwu.getFlags() | FileTransferHeader.FLAG_DONE);
				A62bUuwu.setBytesReceived(A62bUuwu.getBytesReceived() + 1);
				A62bUuwu.setIcbmMessageId(cookie);
				A62bUuwu.setFilesLeft(A62bUuwu.getFilesLeft() - 1);
				A62bUuwu.write(FGffrdYf);
				if (A62bUuwu.getFilesLeft() - 1 <= 0) {
					CzIG8DP0.close();
					break;
				}
			}
		} catch (IOException Fv3V729Z) {
			Fv3V729Z.printStackTrace();
			return;
		}
	}

}