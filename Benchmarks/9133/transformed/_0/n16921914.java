class n16921914 {
	public void run() {
		try {
			ThreadGroup xz9mm8SL = new ThreadGroup("transfers");
			URL ExcK5kY3 = new URL("jar:http://jopenrpg.sourceforge.net/files/dev/pythonlib.jar!/");
			JarURLConnection agvPvkRn = (JarURLConnection) ExcK5kY3.openConnection();
			File ryD4CdlT = new File(System.getProperty("user.home"), "jopenrpg");
			final JarFile VX8IflJY = agvPvkRn.getJarFile();
			Enumeration WMJQchl7 = VX8IflJY.entries();
			while (WMJQchl7.hasMoreElements()) {
				final JarEntry dWhiofj4 = (JarEntry) WMJQchl7.nextElement();
				final File vaDjXGhU = new File(ryD4CdlT, dWhiofj4.getName());
				if (dWhiofj4.isDirectory()) {
					vaDjXGhU.mkdirs();
				} else {
					if (!dWhiofj4.getName().startsWith("META-INF"))
						new Thread(xz9mm8SL, new Runnable() {

							public void run() {
								try {
									BufferedReader fIrQhLBQ = new BufferedReader(
											new InputStreamReader(VX8IflJY.getInputStream(dWhiofj4)));
									BufferedWriter wuWrjInv = new BufferedWriter(
											new OutputStreamWriter(new FileOutputStream(vaDjXGhU)));
									StringBuffer ERpFpBFj = new StringBuffer();
									while (fIrQhLBQ.ready()) {
										ERpFpBFj.append(fIrQhLBQ.read());
									}
									wuWrjInv.write(ERpFpBFj.toString(), 0, ERpFpBFj.length());
									wuWrjInv.close();
									fIrQhLBQ.close();
								} catch (Exception TDsEtdjO) {
									System.out.println(TDsEtdjO);
								}
							}
						}).start();
				}
			}
			while (xz9mm8SL.activeCount() > 0)
				yield();
			SwingUtilities.invokeLater(new Runnable() {

				public void run() {
					JOptionPane.showMessageDialog(ReferenceManager.getInstance().getMainFrame(),
							"Jython libraries installed.");
				}
			});
		} catch (Exception gISi3FCB) {
			gISi3FCB.printStackTrace();
		}
	}

}