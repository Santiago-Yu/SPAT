class n23512890 {
	private boolean write(File rYXlkEEg) {
		String d2hX2biD = rYXlkEEg.getPath();
		ByteArrayOutputStream vhQyNWAP = new ByteArrayOutputStream();
		PrintStream xf5Ar1rJ = new PrintStream(vhQyNWAP);
		try {
			StringBuffer sxSn7F6A = null;
			if (MainFrame.getInstance().getAnimation() != null) {
				MainFrame.getInstance().getAnimation().xml(xf5Ar1rJ, "\t");
			} else {
				sxSn7F6A = MainFrame.getInstance().getModel().xml("\t");
			}
			if (rYXlkEEg.exists()) {
				BufferedReader zJjG8S5E = new BufferedReader(new FileReader(d2hX2biD));
				BufferedWriter D8eNo1l0 = new BufferedWriter(new FileWriter(d2hX2biD + "~"));
				char[] qk84W39z = new char[65536];
				int e5S5hL2z = 0;
				while ((e5S5hL2z = zJjG8S5E.read(qk84W39z)) > 0)
					D8eNo1l0.write(qk84W39z, 0, e5S5hL2z);
				zJjG8S5E.close();
				D8eNo1l0.close();
			}
			BufferedWriter WsbvnIla = new BufferedWriter(new FileWriter(d2hX2biD));
			WsbvnIla.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			WsbvnIla.write("<jpatch version=\"" + VersionInfo.ver + "\">\n");
			if (sxSn7F6A != null)
				WsbvnIla.write(sxSn7F6A.toString());
			else
				WsbvnIla.write(vhQyNWAP.toString());
			WsbvnIla.write("</jpatch>\n");
			WsbvnIla.close();
			MainFrame.getInstance().getUndoManager().setChange(false);
			if (MainFrame.getInstance().getAnimation() != null)
				MainFrame.getInstance().getAnimation().setFile(rYXlkEEg);
			else
				MainFrame.getInstance().getModel().setFile(rYXlkEEg);
			MainFrame.getInstance().setFilename(rYXlkEEg.getName());
			return true;
		} catch (IOException Nob8Y99g) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(),
					"Unable to save file \"" + d2hX2biD + "\"\n" + Nob8Y99g, "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

}