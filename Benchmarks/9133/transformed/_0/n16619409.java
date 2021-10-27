class n16619409 {
	public void updateFiles(String gupf0UiF) {
		System.out.println("Update");
		DataInputStream AXNmnN1q = null;
		DataOutputStream SMdFH790 = null;
		for (int OFW42zLW = 0; OFW42zLW < newFiles.size() && OFW42zLW < nameNewFiles.size(); OFW42zLW++) {
			try {
				AXNmnN1q = new DataInputStream(new FileInputStream((String) newFiles.get(OFW42zLW)));
				SMdFH790 = new DataOutputStream(new FileOutputStream((new StringBuilder(String.valueOf(gupf0UiF)))
						.append("\\").append((String) nameNewFiles.get(OFW42zLW)).toString()));
			} catch (IOException dtXzX8Y2) {
				System.out.println(dtXzX8Y2.toString());
				System.exit(0);
			}
			try {
				do
					SMdFH790.writeChar(AXNmnN1q.readChar());
				while (true);
			} catch (EOFException McThsdQk) {
			} catch (IOException EPzaFXXs) {
				System.out.println(EPzaFXXs.toString());
			}
		}
	}

}