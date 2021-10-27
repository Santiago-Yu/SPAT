class n15072228 {
	protected void createFile(File IPT7EhTp, File xMjIAa5P, LinkedList<String> yMM7xKoh)
			throws DuplicateActionFileException {
		File Us3D3QCT = IPT7EhTp;
		File motve0Tg = xMjIAa5P;
		String j33jPCd7 = "";
		for (int bFM5zuIE = 0; bFM5zuIE < yMM7xKoh.size() - 1; bFM5zuIE++) {
			j33jPCd7 = yMM7xKoh.get(bFM5zuIE);
			Us3D3QCT = new File(Us3D3QCT, j33jPCd7);
			motve0Tg = new File(motve0Tg, j33jPCd7);
		}
		if (Us3D3QCT != null && motve0Tg != null) {
			File R10jm9Ie = new File(Us3D3QCT, yMM7xKoh.getLast());
			if (R10jm9Ie.exists()) {
				File GndSwVD4 = new File(motve0Tg, yMM7xKoh.getLast());
				if (GndSwVD4.exists()) {
					throw new DuplicateActionFileException(R10jm9Ie.toURI().toASCIIString());
				}
				try {
					FileChannel VYDy4kn5 = new FileInputStream(R10jm9Ie).getChannel();
					FileChannel Ue5wAyGT = new FileOutputStream(GndSwVD4).getChannel();
					ByteBuffer IkXiEyyP = ByteBuffer.allocate((int) VYDy4kn5.size());
					while (VYDy4kn5.position() < VYDy4kn5.size()) {
						VYDy4kn5.read(IkXiEyyP);
					}
					VYDy4kn5.close();
					IkXiEyyP.rewind();
					Ue5wAyGT.write(IkXiEyyP);
					Ue5wAyGT.close();
				} catch (Exception G2JbgNDq) {
					G2JbgNDq.printStackTrace();
				}
			}
		}
	}

}