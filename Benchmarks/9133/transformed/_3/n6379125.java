class n6379125 {
	public void copiarMidias(final File vidDir, final File imgDir) {
		for (int i = 0; i < getMidias().size(); i++) {
			try {
				FileChannel src = new FileInputStream(getMidias().get(i).getUrl().trim()).getChannel();
				FileChannel dest;
				if (!(getMidias().get(i).getTipo().equals("video"))) {
					FileChannel midDest = new FileOutputStream(
							imgDir + "/" + processaString(getMidias().get(i).getTitulo()) + "."
									+ retornaExtensaoMidia(getMidias().get(i))).getChannel();
					dest = midDest;
				} else {
					FileChannel vidDest = new FileOutputStream(
							vidDir + "/" + processaString(getMidias().get(i).getTitulo()) + "."
									+ retornaExtensaoMidia(getMidias().get(i))).getChannel();
					dest = vidDest;
				}
				dest.transferFrom(src, 0, src.size());
				src.close();
				dest.close();
			} catch (Exception e) {
				System.err.print(e.getMessage());
				e.printStackTrace();
			}
		}
	}

}