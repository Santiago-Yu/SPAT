class n5246170 {
	public static void fileCopy(String ljqgTQys, String ulyi8wjm) {
		try {
			FileInputStream NP27dnAz = new FileInputStream(ljqgTQys);
			FileOutputStream MCA1MyCD = new FileOutputStream(ulyi8wjm);
			int UtDqm5Z5 = -1;
			byte[] Ri7UH6YH = new byte[8192];
			while ((UtDqm5Z5 = NP27dnAz.read(Ri7UH6YH)) != -1) {
				MCA1MyCD.write(Ri7UH6YH, 0, UtDqm5Z5);
			}
			MCA1MyCD.flush();
			MCA1MyCD.close();
			NP27dnAz.close();
		} catch (Exception NvC0Ayps) {
			NvC0Ayps.printStackTrace();
		}
	}

}