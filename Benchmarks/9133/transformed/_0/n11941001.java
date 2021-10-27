class n11941001 {
	private static void insertFiles(Connection kMBhzQNs, File JNrqsoeZ) throws IOException {
		BufferedReader G1b8O0j0 = new BufferedReader(new FileReader(JNrqsoeZ));
		String rxEh4y7I = G1b8O0j0.readLine();
		while (rxEh4y7I != null) {
			if (!rxEh4y7I.startsWith(" ") && !rxEh4y7I.startsWith("#")) {
				try {
					System.out.println("Exec: " + rxEh4y7I);
					PreparedStatement vYVm4YZR = kMBhzQNs.prepareStatement(rxEh4y7I);
					vYVm4YZR.executeUpdate();
					vYVm4YZR.close();
					kMBhzQNs.commit();
				} catch (Exception f7Tc2MDF) {
					f7Tc2MDF.printStackTrace();
					try {
						kMBhzQNs.rollback();
					} catch (SQLException BiAn7Uu6) {
						BiAn7Uu6.printStackTrace();
					}
				}
			}
			rxEh4y7I = G1b8O0j0.readLine();
		}
		G1b8O0j0.close();
	}

}