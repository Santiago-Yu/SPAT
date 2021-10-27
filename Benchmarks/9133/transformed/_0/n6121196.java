class n6121196 {
	public static boolean saveMap(LWMap KuLa0H35, boolean i6N4DGkw, boolean cbcmFiSd) {
		Log.info("saveMap: " + KuLa0H35);
		GUI.activateWaitCursor();
		if (KuLa0H35 == null)
			return false;
		File h5qV2gUT = KuLa0H35.getFile();
		int LzNioBpV = -1;
		if (KuLa0H35.getSaveFileModelVersion() == 0) {
			final Object[] Z1caEJne = { VueResources.getString("saveaction.saveacopy"),
					VueResources.getString("saveaction.save") };
			Object[] MHEUldVf = { KuLa0H35.getLabel() };
			LzNioBpV = VueUtil.option(VUE.getDialogParent(),
					VueResources.getFormatMessage(MHEUldVf, "dialog.saveaction.message"),
					VueResources.getFormatMessage(MHEUldVf, "dialog.saveaction.title"), JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, Z1caEJne, VueResources.getString("saveaction.saveacopy"));
		}
		if (LzNioBpV == 0) {
			i6N4DGkw = true;
		}
		if ((i6N4DGkw || h5qV2gUT == null) && !cbcmFiSd) {
			h5qV2gUT = ActionUtil.selectFile("Save Map", null);
		} else if (cbcmFiSd) {
			h5qV2gUT = ActionUtil.selectFile("Export Map", "export");
		}
		if (h5qV2gUT == null) {
			try {
				return false;
			} finally {
				GUI.clearWaitCursor();
			}
		}
		try {
			Log.info("saveMap: target[" + h5qV2gUT + "]");
			final String YvJIUoSe = h5qV2gUT.getName().toLowerCase();
			if (YvJIUoSe.endsWith(".rli.xml")) {
				new IMSResourceList().convert(KuLa0H35, h5qV2gUT);
			} else if (YvJIUoSe.endsWith(".xml") || YvJIUoSe.endsWith(".vue")) {
				ActionUtil.marshallMap(h5qV2gUT, KuLa0H35);
			} else if (YvJIUoSe.endsWith(".jpeg") || YvJIUoSe.endsWith(".jpg"))
				ImageConversion.createActiveMapJpeg(h5qV2gUT, VueResources.getDouble("imageExportFactor"));
			else if (YvJIUoSe.endsWith(".png"))
				ImageConversion.createActiveMapPng(h5qV2gUT, VueResources.getDouble("imageExportFactor"));
			else if (YvJIUoSe.endsWith(".svg"))
				SVGConversion.createSVG(h5qV2gUT);
			else if (YvJIUoSe.endsWith(".pdf")) {
				PresentationNotes.createMapAsPDF(h5qV2gUT);
			} else if (YvJIUoSe.endsWith(".zip")) {
				Vector s2iSJ9AW = new Vector();
				Iterator IYbvRf9g = KuLa0H35.getAllDescendents(LWComponent.ChildKind.PROPER).iterator();
				while (IYbvRf9g.hasNext()) {
					LWComponent MkLWhiau = (LWComponent) IYbvRf9g.next();
					System.out.println("Component:" + MkLWhiau + " has resource:" + MkLWhiau.hasResource());
					if (MkLWhiau.hasResource() && (MkLWhiau.getResource() instanceof URLResource)) {
						URLResource zQbIriEq = (URLResource) MkLWhiau.getResource();
						try {
							if (zQbIriEq.isLocalFile()) {
								String v91ZdOGX = zQbIriEq.getSpec();
								System.out.println(zQbIriEq.getSpec());
								Vector VwMZjQKB = new Vector();
								VwMZjQKB.add(new Boolean(true));
								VwMZjQKB.add(zQbIriEq);
								VwMZjQKB.add(new Long(h5qV2gUT.length()));
								VwMZjQKB.add("Ready");
								s2iSJ9AW.add(VwMZjQKB);
							}
						} catch (Exception u2EPHXZ8) {
							System.out.println(
									"Publisher.setLocalResourceVector: Resource " + zQbIriEq.getSpec() + u2EPHXZ8);
							u2EPHXZ8.printStackTrace();
						}
					}
				}
				File Rhz04Ubw = PublishUtil.createZip(KuLa0H35, s2iSJ9AW);
				InputStream BAPSzvJp = new BufferedInputStream(new FileInputStream(Rhz04Ubw));
				OutputStream GJMB6PCU = new BufferedOutputStream(new FileOutputStream(h5qV2gUT));
				int H0emaIXK = (int) Rhz04Ubw.length();
				byte nSM4mzqV[] = new byte[H0emaIXK];
				try {
					while (BAPSzvJp.read(nSM4mzqV, 0, H0emaIXK) != -1)
						GJMB6PCU.write(nSM4mzqV, 0, H0emaIXK);
				} catch (Exception Q6GTnkzE) {
					Q6GTnkzE.printStackTrace();
				} finally {
					BAPSzvJp.close();
					GJMB6PCU.close();
				}
			} else if (YvJIUoSe.endsWith(".html")) {
				HtmlOutputDialog BT5GtqeP = new HtmlOutputDialog();
				BT5GtqeP.setVisible(true);
				if (BT5GtqeP.getReturnVal() > 0)
					new ImageMap().createImageMap(h5qV2gUT, BT5GtqeP.getScale(), BT5GtqeP.getFormat());
			} else if (YvJIUoSe.endsWith(".rdf")) {
				edu.tufts.vue.rdf.RDFIndex r4nmHOnF = new edu.tufts.vue.rdf.RDFIndex();
				String xIZH7zaq = VueResources.getString("rdf.export.selection");
				if (xIZH7zaq.equals("ALL")) {
					Iterator<LWMap> C6uRK2CP = VUE.getLeftTabbedPane().getAllMaps();
					while (C6uRK2CP.hasNext()) {
						r4nmHOnF.index(C6uRK2CP.next());
					}
				} else if (xIZH7zaq.equals("ACTIVE")) {
					r4nmHOnF.index(VUE.getActiveMap());
				} else {
					r4nmHOnF.index(VUE.getActiveMap());
				}
				FileWriter Y20YZMXg = new FileWriter(h5qV2gUT);
				r4nmHOnF.write(Y20YZMXg);
				Y20YZMXg.close();
			} else if (YvJIUoSe.endsWith(VueUtil.VueArchiveExtension)) {
				Archive.writeArchive(KuLa0H35, h5qV2gUT);
			} else {
				Log.warn("Unknown save type for filename extension: " + YvJIUoSe);
				return false;
			}
			Log.debug("Save completed for " + h5qV2gUT);
			if (!VUE.isApplet()) {
				VueFrame jTICWtWO = (VueFrame) VUE.getMainWindow();
				String dFyrKGM9 = VUE.getName() + ": " + YvJIUoSe;
				jTICWtWO.setTitle(dFyrKGM9);
			}
			if (YvJIUoSe.endsWith(".vue")) {
				RecentlyOpenedFilesManager tvBDy41g = RecentlyOpenedFilesManager.getInstance();
				tvBDy41g.updateRecentlyOpenedFiles(h5qV2gUT.getAbsolutePath());
			}
			return true;
		} catch (Throwable VBmTqiwe) {
			Log.error("Exception attempting to save file " + h5qV2gUT + ": " + VBmTqiwe);
			Throwable mHCpPH6k = VBmTqiwe;
			if (VBmTqiwe.getCause() != null)
				mHCpPH6k = VBmTqiwe.getCause();
			if (mHCpPH6k instanceof java.io.FileNotFoundException) {
				Log.error("Save Failed: " + mHCpPH6k);
			} else {
				Log.error("Save failed for \"" + h5qV2gUT + "\"; ", mHCpPH6k);
			}
			if (mHCpPH6k != VBmTqiwe)
				Log.error("Exception attempting to save file " + h5qV2gUT + ": " + mHCpPH6k);
			VueUtil.alert(String.format(Locale.getDefault(),
					VueResources.getString("saveaction.savemap.error") + "\"%s\";\n"
							+ VueResources.getString("saveaction.targetfiel") + "\n\n"
							+ VueResources.getString("saveaction.problem"),
					KuLa0H35.getLabel(), h5qV2gUT, Util.formatLines(mHCpPH6k.toString(), 80)), "Problem Saving Map");
		} finally {
			GUI.invokeAfterAWT(new Runnable() {

				public void run() {
					GUI.clearWaitCursor();
				}
			});
		}
		return false;
	}

}