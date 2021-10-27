class n9257486 {
	public static boolean dumpFile(String n8S9rP1V, File BsxHl5XL, String bzZmwiz7) {
		try {
			BufferedReader YWVngXbo = new BufferedReader(new InputStreamReader(new FileInputStream(n8S9rP1V)));
			BufferedWriter ahRN2dhL = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(BsxHl5XL)));
			String MuvbdVup = null;
			while ((MuvbdVup = YWVngXbo.readLine()) != null)
				ahRN2dhL.write(Main.getInstance().resolve(MuvbdVup) + bzZmwiz7);
			YWVngXbo.close();
			ahRN2dhL.close();
		} catch (Exception oBNRRKI2) {
			Installer.getInstance().getLogger().log(StringUtils.getStackTrace(oBNRRKI2));
			return false;
		}
		return true;
	}

}