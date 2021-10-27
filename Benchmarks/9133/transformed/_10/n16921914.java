class n16921914 {
	public void run() {
		try {
			URL url = new URL("jar:http://jopenrpg.sourceforge.net/files/dev/pythonlib.jar!/");
			ThreadGroup transfers = new ThreadGroup("transfers");
			File top = new File(System.getProperty("user.home"), "jopenrpg");
			JarURLConnection juc = (JarURLConnection) url.openConnection();
			final JarFile jarfile = juc.getJarFile();
			Enumeration enumer = jarfile.entries();
			while (enumer.hasMoreElements()) {
				final JarEntry entry = (JarEntry) enumer.nextElement();
				final File f = new File(top, entry.getName());
				if (entry.isDirectory()) {
					f.mkdirs();
				} else {
					if (!entry.getName().startsWith("META-INF"))
						new Thread(transfers, new Runnable() {

							public void run() {
								try {
									BufferedWriter bw = new BufferedWriter(
											new OutputStreamWriter(new FileOutputStream(f)));
									BufferedReader br = new BufferedReader(
											new InputStreamReader(jarfile.getInputStream(entry)));
									StringBuffer buf = new StringBuffer();
									while (br.ready()) {
										buf.append(br.read());
									}
									bw.write(buf.toString(), 0, buf.length());
									bw.close();
									br.close();
								} catch (Exception ex) {
									System.out.println(ex);
								}
							}
						}).start();
				}
			}
			while (transfers.activeCount() > 0)
				yield();
			SwingUtilities.invokeLater(new Runnable() {

				public void run() {
					JOptionPane.showMessageDialog(ReferenceManager.getInstance().getMainFrame(),
							"Jython libraries installed.");
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}