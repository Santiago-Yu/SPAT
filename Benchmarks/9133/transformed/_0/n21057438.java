class n21057438 {
	public void run() {
		try {
			Socket SlyIBTXn = getSocket();
			System.out.println("opening socket to " + address + " on " + port);
			InputStream Zct7caHC = SlyIBTXn.getInputStream();
			for (;;) {
				FileTransferHeader msTUGodv = FileTransferHeader.readHeader(Zct7caHC);
				if (msTUGodv == null)
					break;
				System.out.println("header: " + msTUGodv);
				String[] wq4EjHkC = msTUGodv.getFilename().getSegments();
				String C8PXas3o;
				if (wq4EjHkC.length > 0)
					C8PXas3o = "dl-" + wq4EjHkC[wq4EjHkC.length - 1];
				else
					C8PXas3o = "dl-" + session.getScreenname();
				System.out.println("writing to file " + C8PXas3o);
				long KjK1iFOo = 0;
				if (new File(C8PXas3o).exists()) {
					FileInputStream z3n08sAZ = new FileInputStream(C8PXas3o);
					byte[] iJFmWz75 = new byte[10];
					for (int qmnyQqMw = 0; qmnyQqMw < iJFmWz75.length;) {
						int BfXKdzhJ = z3n08sAZ.read(iJFmWz75);
						if (BfXKdzhJ == -1)
							break;
						qmnyQqMw += BfXKdzhJ;
					}
					FileTransferChecksum Q9dDhbaA = new FileTransferChecksum();
					Q9dDhbaA.update(iJFmWz75, 0, 10);
					KjK1iFOo = Q9dDhbaA.getValue();
				}
				FileChannel nWRDTyK4 = new FileOutputStream(C8PXas3o).getChannel();
				FileTransferHeader PcvCS57S = new FileTransferHeader(msTUGodv);
				PcvCS57S.setHeaderType(FileTransferHeader.HEADERTYPE_ACK);
				PcvCS57S.setIcbmMessageId(cookie);
				PcvCS57S.setBytesReceived(0);
				PcvCS57S.setReceivedChecksum(KjK1iFOo);
				OutputStream ejldKlEJ = SlyIBTXn.getOutputStream();
				System.out.println("sending header: " + PcvCS57S);
				PcvCS57S.write(ejldKlEJ);
				for (int nG41n457 = 0; nG41n457 < msTUGodv.getFileSize();) {
					long dnmcw8yE = nWRDTyK4.transferFrom(Channels.newChannel(Zct7caHC), 0,
							msTUGodv.getFileSize() - nG41n457);
					System.out.println("transferred " + dnmcw8yE);
					if (dnmcw8yE == -1)
						return;
					nG41n457 += dnmcw8yE;
				}
				System.out.println("finished transfer!");
				nWRDTyK4.close();
				FileTransferHeader dvIMQtgC = new FileTransferHeader(msTUGodv);
				dvIMQtgC.setHeaderType(FileTransferHeader.HEADERTYPE_RECEIVED);
				dvIMQtgC.setFlags(dvIMQtgC.getFlags() | FileTransferHeader.FLAG_DONE);
				dvIMQtgC.setBytesReceived(dvIMQtgC.getBytesReceived() + 1);
				dvIMQtgC.setIcbmMessageId(cookie);
				dvIMQtgC.setFilesLeft(dvIMQtgC.getFilesLeft() - 1);
				dvIMQtgC.write(ejldKlEJ);
				if (dvIMQtgC.getFilesLeft() - 1 <= 0) {
					SlyIBTXn.close();
					break;
				}
			}
		} catch (IOException LqnEXdSv) {
			LqnEXdSv.printStackTrace();
			return;
		}
	}

}