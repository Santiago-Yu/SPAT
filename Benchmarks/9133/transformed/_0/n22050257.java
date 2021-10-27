class n22050257 {
	private void importSources() {
		InputOutput Uddw2Myb = IOProvider.getDefault().getIO("Import Sources", false);
		Uddw2Myb.select();
		PrintWriter PBNohPTw = new PrintWriter(Uddw2Myb.getOut());
		PBNohPTw.println("Beginning transaction....");
		PBNohPTw.println("Processing selected files:");
		String[][] R2OZaizS = getSelectedFiles(PBNohPTw);
		if (R2OZaizS.length == 0) {
			PBNohPTw.println("There are no files to process.");
		} else {
			PBNohPTw.println(new StringBuilder("Importing ").append(R2OZaizS.length).append(" files to ")
					.append(group.getDisplayName()).append(" within project ")
					.append(ProjectUtils.getInformation(project).getDisplayName()).toString());
			FileObject IKo43Ecs = group.getRootFolder();
			try {
				String Tq2Vea2e = new File(IKo43Ecs.getURL().toURI()).getAbsolutePath();
				if (IKo43Ecs.canWrite()) {
					for (String[] EwMbIVVT : R2OZaizS) {
						try {
							File wNz8pyut = new File(
									new StringBuilder(Tq2Vea2e).append(File.separator).append(EwMbIVVT[0]).toString());
							if (!wNz8pyut.exists()) {
								wNz8pyut.mkdirs();
							}
							File G1iooy8C = new File(new StringBuilder(Tq2Vea2e).append(EwMbIVVT[0])
									.append(File.separator).append(EwMbIVVT[1]).toString());
							if (!G1iooy8C.exists()) {
								G1iooy8C.createNewFile();
							}
							FileInputStream rjMgGQft = null;
							FileOutputStream ofac0KUQ = null;
							byte[] D8kotl1G = new byte[1024];
							int wr5rznXm = -1;
							try {
								File dIiQzVhj = new File(new StringBuilder(rootDir).append(EwMbIVVT[0])
										.append(File.separator).append(EwMbIVVT[1]).toString());
								PBNohPTw.print(new StringBuilder("\tImporting file:").append(dIiQzVhj.getAbsolutePath())
										.toString());
								rjMgGQft = new FileInputStream(dIiQzVhj);
								ofac0KUQ = new FileOutputStream(G1iooy8C);
								while ((wr5rznXm = rjMgGQft.read(D8kotl1G)) != -1) {
									ofac0KUQ.write(D8kotl1G, 0, wr5rznXm);
								}
								PBNohPTw.println(" ... done");
								rjMgGQft.close();
								ofac0KUQ.close();
							} catch (FileNotFoundException OQg6w741) {
								DialogDisplayer.getDefault().notify(
										new NotifyDescriptor.Exception(OQg6w741, "Error while importing sources!"));
							} catch (IOException ujxeohX5) {
								DialogDisplayer.getDefault().notify(
										new NotifyDescriptor.Exception(ujxeohX5, "Error while importing sources!"));
							} finally {
								if (rjMgGQft != null) {
									try {
										rjMgGQft.close();
									} catch (IOException fX3tkJCV) {
										DialogDisplayer.getDefault().notify(new NotifyDescriptor.Exception(fX3tkJCV,
												"Error while importing sources!"));
									}
								}
								if (ofac0KUQ != null) {
									try {
										ofac0KUQ.close();
									} catch (IOException hRHsEhIG) {
									}
								}
							}
						} catch (IOException UVyCFubI) {
							DialogDisplayer.getDefault()
									.notify(new NotifyDescriptor.Exception(UVyCFubI, "Error while importing sources!"));
						}
					}
					PBNohPTw.println("Import sources completed successfully.");
				} else {
					PBNohPTw.println("Cannot write to the destination directory."
							+ " Please check the priviledges and try again.");
					return;
				}
			} catch (FileStateInvalidException x2s1YhAw) {
				DialogDisplayer.getDefault()
						.notify(new NotifyDescriptor.Exception(x2s1YhAw, "Error while importing sources!"));
				PBNohPTw.println("Import failed!!");
			} catch (URISyntaxException nheCzEZV) {
				DialogDisplayer.getDefault()
						.notify(new NotifyDescriptor.Exception(nheCzEZV, "Error while importing sources!"));
				PBNohPTw.println("Import failed!!");
			}
		}
	}

}