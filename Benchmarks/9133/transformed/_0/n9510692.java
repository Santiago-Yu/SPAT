class n9510692 {
	public static void main(String[] XBLyuaPo) {
		try {
			boolean HNUJCKtc = Utils.getFlag('l', XBLyuaPo);
			final boolean AXE9SO4j = Utils.getFlag('s', XBLyuaPo);
			final String YcXHWq2z = Utils.getOption('f', XBLyuaPo);
			if ((HNUJCKtc || AXE9SO4j) && (YcXHWq2z.length() == 0)) {
				throw new Exception("A filename must be given with the -f option");
			}
			Experiment v6m5P9zx = null;
			if (HNUJCKtc) {
				FileInputStream oBGx7Kem = new FileInputStream(YcXHWq2z);
				ObjectInputStream H56C4Jb6 = new ObjectInputStream(new BufferedInputStream(oBGx7Kem));
				v6m5P9zx = (Experiment) H56C4Jb6.readObject();
				H56C4Jb6.close();
			} else {
				v6m5P9zx = new Experiment();
			}
			System.err.println("Initial Experiment:\n" + v6m5P9zx.toString());
			final JFrame LuTwhrWc = new JFrame("Weka Experiment Setup");
			LuTwhrWc.getContentPane().setLayout(new BorderLayout());
			final SetupPanel SGbEVqDE = new SetupPanel();
			LuTwhrWc.getContentPane().add(SGbEVqDE, BorderLayout.CENTER);
			LuTwhrWc.addWindowListener(new WindowAdapter() {

				public void windowClosing(WindowEvent rYEx6kMd) {
					System.err.println("\nFinal Experiment:\n" + SGbEVqDE.m_Exp.toString());
					if (AXE9SO4j) {
						try {
							FileOutputStream O1FTYPHK = new FileOutputStream(YcXHWq2z);
							ObjectOutputStream T1DaVvbQ = new ObjectOutputStream(new BufferedOutputStream(O1FTYPHK));
							T1DaVvbQ.writeObject(SGbEVqDE.m_Exp);
							T1DaVvbQ.close();
						} catch (Exception DhRMgswR) {
							DhRMgswR.printStackTrace();
							System.err.println(
									"Couldn't write experiment to: " + YcXHWq2z + '\n' + DhRMgswR.getMessage());
						}
					}
					LuTwhrWc.dispose();
					System.exit(0);
				}
			});
			LuTwhrWc.pack();
			LuTwhrWc.setVisible(true);
			System.err.println("Short nap");
			Thread.currentThread().sleep(3000);
			System.err.println("Done");
			SGbEVqDE.setExperiment(v6m5P9zx);
		} catch (Exception h5TddZim) {
			h5TddZim.printStackTrace();
			System.err.println(h5TddZim.getMessage());
		}
	}

}