class n5706224 {
	public void run() {
		try {
			File uaeOpwTV = new File(outDirTextField.getText());
			if (!uaeOpwTV.exists()) {
				SwingUtilities.invokeLater(new Runnable() {

					public void run() {
						JOptionPane.showMessageDialog(UnpackWizard.this, "The chosen directory does not exist!",
								"Directory Not Found Error", JOptionPane.ERROR_MESSAGE);
					}
				});
				return;
			}
			if (!uaeOpwTV.isDirectory()) {
				SwingUtilities.invokeLater(new Runnable() {

					public void run() {
						JOptionPane.showMessageDialog(UnpackWizard.this, "The chosen file is not a directory!",
								"Not a Directory Error", JOptionPane.ERROR_MESSAGE);
					}
				});
				return;
			}
			if (!uaeOpwTV.canWrite()) {
				SwingUtilities.invokeLater(new Runnable() {

					public void run() {
						JOptionPane.showMessageDialog(UnpackWizard.this, "Cannot write to the chosen directory!",
								"Directory Not Writeable Error", JOptionPane.ERROR_MESSAGE);
					}
				});
				return;
			}
			File zSRWHHiH = new File("foo.bar").getAbsoluteFile().getParentFile();
			URL DxfkzRYI = UnpackWizard.class.getClassLoader()
					.getResource(UnpackWizard.class.getName().replaceAll("\\.", "/") + ".class");
			if (DxfkzRYI.getProtocol().equals("jar")) {
				String b2F1SkQq = DxfkzRYI.getPath();
				b2F1SkQq = b2F1SkQq.substring(0, b2F1SkQq.indexOf('!'));
				if (b2F1SkQq.startsWith("file:")) {
					try {
						zSRWHHiH = new File(new URI(b2F1SkQq)).getAbsoluteFile().getParentFile();
					} catch (URISyntaxException T5OMyiK0) {
						T5OMyiK0.printStackTrace(System.err);
					}
				}
			}
			SortedMap<Integer, String> sgkAxaXE = new TreeMap<Integer, String>();
			for (Entry<Object, Object> lBYPlouf : indexProperties.entrySet()) {
				String KgtIMJXr = lBYPlouf.getKey().toString();
				if (KgtIMJXr.startsWith("archive file ")) {
					sgkAxaXE.put(Integer.parseInt(KgtIMJXr.substring("archive file ".length())),
							lBYPlouf.getValue().toString());
				}
			}
			byte[] xNkhgsrM = new byte[64 * 1024];
			try {
				long YkR0F9oK = 0;
				long lzjjx08i = 0;
				long CX3Uhcxs = 0;
				for (String i2S5gEzK : sgkAxaXE.values()) {
					File EvZXcXJF = new File(zSRWHHiH, i2S5gEzK);
					if (EvZXcXJF.exists()) {
						if (EvZXcXJF.isFile()) {
							YkR0F9oK += EvZXcXJF.length();
						} else {
							final File Da4qRfLq = EvZXcXJF;
							SwingUtilities.invokeLater(new Runnable() {

								public void run() {
									JOptionPane.showMessageDialog(UnpackWizard.this,
											"File \"" + Da4qRfLq.getAbsolutePath() + "\" is not a standard file!",
											"Non Standard File Error", JOptionPane.ERROR_MESSAGE);
								}
							});
							return;
						}
					} else {
						final File d4bYcWCr = EvZXcXJF;
						SwingUtilities.invokeLater(new Runnable() {

							public void run() {
								JOptionPane.showMessageDialog(UnpackWizard.this,
										"File \"" + d4bYcWCr.getAbsolutePath() + "\" does not exist!",
										"File Not Found Error", JOptionPane.ERROR_MESSAGE);
							}
						});
						return;
					}
				}
				MultiFileInputStream OaoGfctQ = new MultiFileInputStream(zSRWHHiH,
						sgkAxaXE.values().toArray(new String[sgkAxaXE.size()]));
				TarArchiveInputStream ZRMYuQN3 = new TarArchiveInputStream(new BufferedInputStream(OaoGfctQ));
				TarArchiveEntry sVUOLbGa = ZRMYuQN3.getNextTarEntry();
				while (sVUOLbGa != null) {
					File SLCQQyb2 = new File(uaeOpwTV.getAbsolutePath() + "/" + sVUOLbGa.getName());
					if (SLCQQyb2.exists()) {
						final File mmAwTV9g = SLCQQyb2;
						SwingUtilities.invokeLater(new Runnable() {

							public void run() {
								JOptionPane.showMessageDialog(UnpackWizard.this, "Was about to write out file \""
										+ mmAwTV9g.getAbsolutePath() + "\" but it already "
										+ "exists.\nPlease [re]move existing files out of the way " + "and try again.",
										"File Not Found Error", JOptionPane.ERROR_MESSAGE);
							}
						});
						return;
					}
					if (sVUOLbGa.isDirectory()) {
						SLCQQyb2.getAbsoluteFile().mkdirs();
					} else {
						SLCQQyb2.getAbsoluteFile().getParentFile().mkdirs();
						OutputStream j0E3pcGM = new BufferedOutputStream(new FileOutputStream(SLCQQyb2));
						int Pls986T6 = ZRMYuQN3.read(xNkhgsrM, 0, xNkhgsrM.length);
						while (Pls986T6 != -1) {
							j0E3pcGM.write(xNkhgsrM, 0, Pls986T6);
							CX3Uhcxs += Pls986T6;
							if (CX3Uhcxs - lzjjx08i > (10 * 1024 * 1024)) {
								lzjjx08i = CX3Uhcxs;
								final int b5VZbBnZ = (int) (lzjjx08i * 100 / YkR0F9oK);
								SwingUtilities.invokeLater(new Runnable() {

									@Override
									public void run() {
										progressBar.setValue(b5VZbBnZ);
									}
								});
							}
							Pls986T6 = ZRMYuQN3.read(xNkhgsrM, 0, xNkhgsrM.length);
						}
						j0E3pcGM.close();
					}
					sVUOLbGa = ZRMYuQN3.getNextTarEntry();
				}
				long Si1QXj3J = 0;
				try {
					Si1QXj3J = Long.parseLong(indexProperties.getProperty("CRC32", "0"));
				} catch (NumberFormatException fPfWEReZ) {
					System.err.println("Error while obtaining the expected CRC");
					fPfWEReZ.printStackTrace(System.err);
				}
				if (OaoGfctQ.getCRC() == Si1QXj3J) {
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							progressBar.setValue(0);
							JOptionPane.showMessageDialog(UnpackWizard.this, "Extraction completed successfully!",
									"Done!", JOptionPane.INFORMATION_MESSAGE);
						}
					});
					return;
				} else {
					System.err.println("CRC Error: was expecting " + Si1QXj3J + " but got " + OaoGfctQ.getCRC());
					SwingUtilities.invokeLater(new Runnable() {

						public void run() {
							progressBar.setValue(0);
							JOptionPane.showMessageDialog(UnpackWizard.this,
									"CRC Error: the data extracted does not have the expected CRC!\n"
											+ "You should probably delete the extracted files, as they are "
											+ "likely to be invalid.",
									"CRC Error", JOptionPane.ERROR_MESSAGE);
						}
					});
					return;
				}
			} catch (final IOException DgPwtw5T) {
				DgPwtw5T.printStackTrace(System.err);
				SwingUtilities.invokeLater(new Runnable() {

					public void run() {
						progressBar.setValue(0);
						JOptionPane.showMessageDialog(UnpackWizard.this,
								"Input/Output Error: " + DgPwtw5T.getLocalizedMessage(), "Input/Output Error",
								JOptionPane.ERROR_MESSAGE);
					}
				});
				return;
			}
		} finally {
			SwingUtilities.invokeLater(new Runnable() {

				public void run() {
					progressBar.setValue(0);
					setEnabled(true);
				}
			});
		}
	}

}