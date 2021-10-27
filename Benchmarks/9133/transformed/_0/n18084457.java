class n18084457 {
	public void run() {
		try {
			Socket kvmLcPKU = getSocket();
			System.out.println("opening socket to " + address + " on " + port);
			InputStream pq9vx7ob = kvmLcPKU.getInputStream();
			for (;;) {
				FileTransferHeader AXsijHX0 = FileTransferHeader.readHeader(pq9vx7ob);
				if (AXsijHX0 == null)
					break;
				System.out.println("header: " + AXsijHX0);
				String[] AbSbaTZT = AXsijHX0.getFilename().getSegments();
				String JWgAEtBM;
				if (AbSbaTZT.length > 0)
					JWgAEtBM = "dl-" + AbSbaTZT[AbSbaTZT.length - 1];
				else
					JWgAEtBM = "dl-" + session.getScreenname();
				System.out.println("writing to file " + JWgAEtBM);
				long yDYEh3q8 = 0;
				if (new File(JWgAEtBM).exists()) {
					FileInputStream YpdDSaTg = new FileInputStream(JWgAEtBM);
					byte[] vmL7UifQ = new byte[10];
					for (int btePLa2N = 0; btePLa2N < vmL7UifQ.length;) {
						int kL0Kb0RM = YpdDSaTg.read(vmL7UifQ);
						if (kL0Kb0RM == -1)
							break;
						btePLa2N += kL0Kb0RM;
					}
					FileTransferChecksum qrNPdYRP = new FileTransferChecksum();
					qrNPdYRP.update(vmL7UifQ, 0, 10);
					yDYEh3q8 = qrNPdYRP.getValue();
				}
				FileChannel cMHMruh8 = new FileOutputStream(JWgAEtBM).getChannel();
				FileTransferHeader nxKE3CZD = new FileTransferHeader(AXsijHX0);
				nxKE3CZD.setHeaderType(FileTransferHeader.HEADERTYPE_ACK);
				nxKE3CZD.setIcbmMessageId(cookie);
				nxKE3CZD.setBytesReceived(0);
				nxKE3CZD.setReceivedChecksum(yDYEh3q8);
				OutputStream nILNz6zS = kvmLcPKU.getOutputStream();
				System.out.println("sending header: " + nxKE3CZD);
				nxKE3CZD.write(nILNz6zS);
				for (int IfXMK3jr = 0; IfXMK3jr < AXsijHX0.getFileSize();) {
					long zHI17h9w = cMHMruh8.transferFrom(Channels.newChannel(pq9vx7ob), 0,
							AXsijHX0.getFileSize() - IfXMK3jr);
					System.out.println("transferred " + zHI17h9w);
					if (zHI17h9w == -1)
						return;
					IfXMK3jr += zHI17h9w;
				}
				System.out.println("finished transfer!");
				cMHMruh8.close();
				FileTransferHeader eRda7IpD = new FileTransferHeader(AXsijHX0);
				eRda7IpD.setHeaderType(FileTransferHeader.HEADERTYPE_RECEIVED);
				eRda7IpD.setFlags(eRda7IpD.getFlags() | FileTransferHeader.FLAG_DONE);
				eRda7IpD.setBytesReceived(eRda7IpD.getBytesReceived() + 1);
				eRda7IpD.setIcbmMessageId(cookie);
				eRda7IpD.setFilesLeft(eRda7IpD.getFilesLeft() - 1);
				eRda7IpD.write(nILNz6zS);
				if (eRda7IpD.getFilesLeft() - 1 <= 0) {
					kvmLcPKU.close();
					break;
				}
			}
		} catch (IOException Nm1cYWgI) {
			Nm1cYWgI.printStackTrace();
			return;
		}
	}

}