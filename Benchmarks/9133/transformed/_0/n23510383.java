class n23510383 {
	public boolean saveProject(File o6tp4HQ2, Set<String> zgjTizyv, Set<String> IFJdIraT, Set<String> R7PAKbqd,
			boolean OvDzBA7e, boolean VsEOe74O) throws IOException, SQLException {
		int j6xUWSgg = o6tp4HQ2.getName().lastIndexOf(".");
		String sidQrkMC = o6tp4HQ2.getName().substring(0, j6xUWSgg);
		DecimalFormat hmpNtMzt = new DecimalFormat("####");
		hmpNtMzt.setMinimumIntegerDigits(4);
		int euAiDuuq = 0;
		File LmGH5o5Q = new File(sidQrkMC);
		if (LmGH5o5Q.exists()) {
			throw new IOException(LmGH5o5Q.getAbsolutePath());
		}
		LmGH5o5Q.mkdir();
		File jLNprpYq = new File(LmGH5o5Q, "version");
		jLNprpYq.createNewFile();
		PrintWriter IlkBO5SH = new PrintWriter(jLNprpYq);
		IlkBO5SH.write(Videso3D.VERSION);
		IlkBO5SH.flush();
		IlkBO5SH.close();
		File rxVK4P2C = new File(LmGH5o5Q.getAbsolutePath() + "/xml");
		rxVK4P2C.mkdir();
		if (zgjTizyv != null && !zgjTizyv.isEmpty()) {
			File qjAHqGmk = new File(LmGH5o5Q.getAbsolutePath() + "/databases");
			qjAHqGmk.mkdir();
			for (String v0n6WmKu : zgjTizyv) {
				Type FCCG6IWT = DatabaseManager.stringToType(v0n6WmKu);
				if (FCCG6IWT != null) {
					if (VsEOe74O) {
						if (OvDzBA7e) {
							String CboTBwDP = DatabaseManager.getCurrentName(FCCG6IWT);
							File GqKyBa6t = new File(qjAHqGmk, CboTBwDP + "." + FCCG6IWT);
							GqKyBa6t.createNewFile();
							FileChannel ARfHYSk4 = new FileInputStream(new File(CboTBwDP)).getChannel();
							FileChannel uFGXn8GT = new FileOutputStream(GqKyBa6t).getChannel();
							uFGXn8GT.transferFrom(ARfHYSk4, 0, ARfHYSk4.size());
							ARfHYSk4.close();
							uFGXn8GT.close();
							List<String[]> MgYCHAnZ = new ArrayList<String[]>();
							Statement s0Rng6iX = DatabaseManager.getCurrent(Type.Databases);
							ResultSet v0DOb29g = s0Rng6iX
									.executeQuery("select * from clefs where type='" + CboTBwDP + "'");
							while (v0DOb29g.next()) {
								MgYCHAnZ.add(new String[] { v0DOb29g.getString("name"), v0DOb29g.getString("value") });
							}
							s0Rng6iX.close();
							if (!MgYCHAnZ.isEmpty()) {
								File vC2GjVMG = new File(qjAHqGmk, CboTBwDP + "_clefs");
								vC2GjVMG.createNewFile();
								ObjectOutputStream paH3NNUb = new ObjectOutputStream(new FileOutputStream(vC2GjVMG));
								paH3NNUb.writeObject(MgYCHAnZ);
								paH3NNUb.close();
							}
							File ZG0JFKFw = new File(CboTBwDP + "_files");
							if (ZG0JFKFw.exists() && ZG0JFKFw.isDirectory()) {
								File HHZGAaFD = new File(qjAHqGmk, CboTBwDP + "_files");
								HHZGAaFD.mkdirs();
								for (File RWQttxkM : ZG0JFKFw.listFiles()) {
									File lcKjILlE = new File(HHZGAaFD, RWQttxkM.getName());
									lcKjILlE.createNewFile();
									ARfHYSk4 = new FileInputStream(RWQttxkM).getChannel();
									uFGXn8GT = new FileOutputStream(lcKjILlE).getChannel();
									uFGXn8GT.transferFrom(ARfHYSk4, 0, ARfHYSk4.size());
									ARfHYSk4.close();
									uFGXn8GT.close();
								}
							}
						}
						File hkrITvtz = new File(qjAHqGmk, FCCG6IWT.toString());
						hkrITvtz.createNewFile();
						ObjectOutputStream OkHEKzHO = new ObjectOutputStream(new FileOutputStream(hkrITvtz));
						OkHEKzHO.writeObject(objects.get(FCCG6IWT));
						OkHEKzHO.close();
					} else {
						for (Restorable CuRa9s1l : DatasManager.getController(FCCG6IWT).getSelectedObjects()) {
							this.saveObjectInXml(CuRa9s1l, new File(rxVK4P2C, CuRa9s1l.getClass().getName() + "-"
									+ FCCG6IWT + "-" + hmpNtMzt.format(euAiDuuq++) + ".xml"));
						}
					}
				}
			}
		}
		File S9PLBywm = new File(LmGH5o5Q.getAbsolutePath() + "/images");
		S9PLBywm.mkdir();
		for (EditableSurfaceImage FpAGp4TF : this.getImages()) {
			if (IFJdIraT.contains(FpAGp4TF.getName())) {
				int KC9x6G72 = FpAGp4TF.getName().lastIndexOf(".");
				String o9GsP5of = FpAGp4TF.getName();
				if (KC9x6G72 != -1) {
					o9GsP5of = FpAGp4TF.getName().substring(0, KC9x6G72);
				}
				File KY7RZKnt = new File(S9PLBywm, o9GsP5of + ".gtif");
				ImageUtils.writeImageToFile(FpAGp4TF.getSector(), (BufferedImage) FpAGp4TF.getImageSource(), KY7RZKnt);
			}
		}
		File b7XeDm7R = new File(LmGH5o5Q, "trajectory");
		b7XeDm7R.mkdirs();
		for (Layer kT1wyHyt : wwd.getModel().getLayers()) {
			if (kT1wyHyt instanceof GEOTracksLayer && R7PAKbqd.contains(kT1wyHyt.getName())) {
				GEOWriter UuBaUQvn = new GEOWriter(b7XeDm7R.getAbsolutePath() + "/" + kT1wyHyt.getName(), true);
				for (VidesoTrack TOMXbmm1 : ((GEOTracksLayer) kT1wyHyt).getModel().getVisibleTracks()) {
					UuBaUQvn.writeTrack((GEOTrack) TOMXbmm1);
				}
				UuBaUQvn.close();
			}
		}
		if (zgjTizyv != null && zgjTizyv.contains("Autres objets affich¨¦s.")) {
			for (Layer NThqs8o5 : wwd.getModel().getLayers()) {
				if (NThqs8o5.getName().equals(AIRSPACE_LAYER_NAME)) {
					for (Airspace nAy0bYFp : ((AirspaceLayer) NThqs8o5).getAirspaces()) {
						this.saveObjectInXml((Restorable) nAy0bYFp, new File(rxVK4P2C,
								nAy0bYFp.getClass().getName() + "-" + hmpNtMzt.format(euAiDuuq++) + ".xml"));
					}
				} else if (NThqs8o5.getName().equals(RENDERABLE_LAYER_NAME)) {
					for (Renderable gbSypE6m : ((RenderableLayer) NThqs8o5).getRenderables()) {
						if (gbSypE6m instanceof Restorable) {
							this.saveObjectInXml((Restorable) gbSypE6m, new File(rxVK4P2C,
									gbSypE6m.getClass().getName() + "-" + hmpNtMzt.format(euAiDuuq++) + ".xml"));
						}
					}
				} else if (NThqs8o5.getName().equals(BALISES2D_LAYER_NAME)) {
					for (Balise2D v5kaOYUc : ((Balise2DLayer) NThqs8o5).getVisibleBalises()) {
						this.saveObjectInXml(v5kaOYUc, new File(rxVK4P2C,
								v5kaOYUc.getClass().getName() + "-" + hmpNtMzt.format(euAiDuuq++) + ".xml"));
					}
				} else if (NThqs8o5.getName().equals(BALISES3D_LAYER_NAME)) {
					for (Balise3D l7af30ND : ((Balise3DLayer) NThqs8o5).getVisibleBalises()) {
						this.saveObjectInXml(l7af30ND, new File(rxVK4P2C,
								l7af30ND.getClass().getName() + "-" + hmpNtMzt.format(euAiDuuq++) + ".xml"));
					}
				}
			}
		}
		for (Airspace drDQpd4u : PolygonEditorsManager.getLayer().getAirspaces()) {
			if (drDQpd4u.isVisible())
				this.saveObjectInXml(drDQpd4u,
						new File(rxVK4P2C, drDQpd4u.getClass().getName() + "-" + hmpNtMzt.format(euAiDuuq++) + ".xml"));
		}
		this.saveObjectInXml(this.wwd.getView(), new File(LmGH5o5Q, "globe.xml"));
		FileManager.createZipFile(o6tp4HQ2, LmGH5o5Q);
		FileManager.deleteFile(LmGH5o5Q);
		return true;
	}

}