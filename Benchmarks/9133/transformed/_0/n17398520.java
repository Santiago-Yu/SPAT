class n17398520 {
	public void SendFile(File JYunqndD) {
		try {
			SocketChannel KC15Er7x = SocketChannel.open(new InetSocketAddress("127.0.0.1", 1234));
			KC15Er7x.configureBlocking(true);
			while (!KC15Er7x.finishConnect()) {
				System.out.println("NOT connected!");
			}
			System.out.println("CONNECTED!");
			FileInputStream Me3CraYx = new FileInputStream(JYunqndD);
			FileChannel ol6D9TUk = Me3CraYx.getChannel();
			long VJeqFwEn = ol6D9TUk.size();
			Buffer.clear();
			Buffer.putLong(VJeqFwEn);
			Buffer.flip();
			KC15Er7x.write(Buffer);
			long sWlNuNDQ = 0;
			while (sWlNuNDQ < VJeqFwEn) {
				Buffer.clear();
				int ooKXMuCH = ol6D9TUk.read(Buffer);
				sWlNuNDQ += ooKXMuCH;
				Buffer.flip();
				while (Buffer.hasRemaining()) {
					KC15Er7x.write(Buffer);
				}
			}
			ol6D9TUk.close();
			File pVMG8aWc = getTmp().createNewFile("tmp", "tmp");
			FileOutputStream wTeIoDC4 = new FileOutputStream(pVMG8aWc);
			FileChannel qv3StFLf = wTeIoDC4.getChannel();
			int H9gaQW0L = -1;
			do {
				Buffer.clear();
				H9gaQW0L = KC15Er7x.read(Buffer);
				Buffer.flip();
				if (H9gaQW0L > 0) {
					qv3StFLf.write(Buffer);
				}
			} while (H9gaQW0L > 0);
			qv3StFLf.close();
		} catch (IOException VHCqXHo0) {
			VHCqXHo0.printStackTrace();
		}
	}

}