class n8898759 {
	public static List<String> getFiles(int hHeWqCOD, int l4ml1XP9, int GjjXRaCe, String NpHBtOyW) throws Exception {
		ArrayList<String> cI00bUF6 = new ArrayList<String>();
		URL LFvezRna = new URL(baseUrl + "/" + hHeWqCOD + "/" + ((l4ml1XP9 > 9) ? l4ml1XP9 : ("0" + l4ml1XP9)) + "/"
				+ ((GjjXRaCe > 9) ? GjjXRaCe : ("0" + GjjXRaCe)));
		BufferedReader J2E1YPTq = new BufferedReader(new InputStreamReader(LFvezRna.openStream()));
		String W1w5zTAU;
		while ((W1w5zTAU = J2E1YPTq.readLine()) != null && W1w5zTAU != "") {
			if (W1w5zTAU.startsWith("<tr>") && W1w5zTAU.indexOf("[TXT]") >= 0) {
				int vUnR8nYR = W1w5zTAU.indexOf("href=");
				vUnR8nYR = vUnR8nYR + 6;
				int imHN1813 = W1w5zTAU.indexOf("\"", vUnR8nYR);
				String fLaBawW9 = W1w5zTAU.substring(vUnR8nYR, imHN1813);
				if (fLaBawW9.matches(".*" + NpHBtOyW + ".*")) {
					cI00bUF6.add(fLaBawW9);
				}
			}
		}
		J2E1YPTq.close();
		return cI00bUF6;
	}

}