class n14157859 {
	static void copyFile(File ljMbs9MF, File Y445rO09) throws IOException {
		byte OAysLWMc[] = new byte[512];
		FileInputStream NgyeuLN5 = new FileInputStream(ljMbs9MF);
		FileOutputStream Krtdz16u = new FileOutputStream(Y445rO09);
		int M8fFPdzM;
		while ((M8fFPdzM = NgyeuLN5.read(OAysLWMc)) > 0)
			Krtdz16u.write(OAysLWMc, 0, M8fFPdzM);
		NgyeuLN5.close();
		Krtdz16u.close();
	}

}