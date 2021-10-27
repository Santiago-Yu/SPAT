class n1218380 {
	public static void main(String[] Z1OqQekg) {
		try {
			Object n0vw3vr7 = Naming.lookup("Server");
			IServer sZk2EMqG = (IServer) n0vw3vr7;
			File dvejbun2 = new File(Z1OqQekg[0]);
			File elnWFtge = new File(Z1OqQekg[1]);
			File[] nIo8RPSj = dvejbun2.listFiles();
			long nPVlrw0E = 0;
			for (File mr8WhOhE : nIo8RPSj) {
				if (mr8WhOhE.isDirectory())
					continue;
				try {
					FileChannel Sb1852yz = new FileInputStream(mr8WhOhE).getChannel();
					String fVzAwxkv = elnWFtge.getAbsolutePath() + System.getProperty("file.separator")
							+ mr8WhOhE.getName();
					FileChannel rOG8CrvH = new FileOutputStream(fVzAwxkv).getChannel();
					System.out.println("Coping " + fVzAwxkv);
					ByteBuffer fwwj40Kc = ByteBuffer.allocate(65536);
					int Ae5lVFqD = 0;
					Sb1852yz.position(Ae5lVFqD);
					Ae5lVFqD = Sb1852yz.read(fwwj40Kc);
					while (Ae5lVFqD > -1) {
						fwwj40Kc.flip();
						byte[] yRU56CDq = new byte[fwwj40Kc.limit()];
						fwwj40Kc.get(yRU56CDq);
						nPVlrw0E = sZk2EMqG.write(yRU56CDq, nPVlrw0E);
						fwwj40Kc.clear();
						Ae5lVFqD = Sb1852yz.read(fwwj40Kc);
					}
					System.out.println("Done ");
					Sb1852yz.close();
					rOG8CrvH.close();
				} catch (IOException OYFKHtdJ) {
				}
			}
		} catch (MalformedURLException c2yGdWsF) {
			c2yGdWsF.printStackTrace();
		} catch (RemoteException yi2htDLC) {
			yi2htDLC.printStackTrace();
		} catch (NotBoundException Z8V2heRs) {
			Z8V2heRs.printStackTrace();
		}
	}

}