class n12116028 {
	public static void main(String[] C9nXcUp8) throws Exception {
		File MD2yeEnw = new File(C9nXcUp8[0]);
		BufferedReader tVA9PxVV = new BufferedReader(new FileReader(MD2yeEnw));
		StringBuffer m64dcXMa = new StringBuffer();
		String sgyfXlrU;
		while ((sgyfXlrU = tVA9PxVV.readLine()) != null)
			m64dcXMa.append(sgyfXlrU + "\r\n");
		sgyfXlrU = m64dcXMa.toString();
		tVA9PxVV.close();
		File ehtYsCQW = new File(C9nXcUp8[0] + ".output");
		BufferedWriter hWhSOeMu = new BufferedWriter(new FileWriter(ehtYsCQW));
		sgyfXlrU = sgyfXlrU.replaceAll("\\t+", "#");
		sgyfXlrU = sgyfXlrU.replaceAll("\\s*#\\s*", "#");
		sgyfXlrU = sgyfXlrU.replaceAll("Latitude,.*", "");
		sgyfXlrU = sgyfXlrU.replaceAll("Flag of", "");
		sgyfXlrU = sgyfXlrU.replaceAll("^\\s+$", "");
		hWhSOeMu.write(sgyfXlrU);
		hWhSOeMu.close();
	}

}