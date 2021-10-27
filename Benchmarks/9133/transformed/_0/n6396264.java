class n6396264 {
	private static void addFromResource(String EqCYX79I, OutputStream lTr25oKm) {
		URL Wbi7JyHo = OpenOfficeDocumentCreator.class.getResource(EqCYX79I);
		try {
			InputStream WRqcIxjV = Wbi7JyHo.openStream();
			byte[] BnzjSiXy = new byte[256];
			synchronized (WRqcIxjV) {
				synchronized (lTr25oKm) {
					while (true) {
						int k9dG3YFZ = WRqcIxjV.read(BnzjSiXy);
						if (k9dG3YFZ == -1)
							break;
						lTr25oKm.write(BnzjSiXy, 0, k9dG3YFZ);
					}
				}
			}
		} catch (IOException EqSES4Zv) {
			EqSES4Zv.printStackTrace();
		}
	}

}