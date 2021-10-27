class n6379125 {
	public void copiarMidias(final File vidDir, final File imgDir) {
		int R8OnY = 0;
		while (R8OnY < getMidias().size()) {
			try {
				FileChannel src = new FileInputStream(getMidias().get(R8OnY).getUrl().trim()).getChannel();
				FileChannel dest;
				if (getMidias().get(R8OnY).getTipo().equals("video")) {
					FileChannel vidDest = new FileOutputStream(
							vidDir + "/" + processaString(getMidias().get(R8OnY).getTitulo()) + "."
									+ retornaExtensaoMidia(getMidias().get(R8OnY))).getChannel();
					dest = vidDest;
				} else {
					FileChannel midDest = new FileOutputStream(
							imgDir + "/" + processaString(getMidias().get(R8OnY).getTitulo()) + "."
									+ retornaExtensaoMidia(getMidias().get(R8OnY))).getChannel();
					dest = midDest;
				}
				dest.transferFrom(src, 0, src.size());
				src.close();
				dest.close();
			} catch (Exception e) {
				System.err.print(e.getMessage());
				e.printStackTrace();
			}
			R8OnY++;
		}
	}

}