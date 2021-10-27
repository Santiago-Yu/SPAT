class n3867253 {
	@Override
	public void start() {
		System.err.println("start AutoplotApplet " + VERSION + " @ " + (System.currentTimeMillis() - t0) + " msec");
		super.start();
		model = new ApplicationModel();
		model.setExceptionHandler(new ExceptionHandler() {

			public void handle(Throwable gEeLxgQo) {
				gEeLxgQo.printStackTrace();
			}

			public void handleUncaught(Throwable UmFqImJk) {
				UmFqImJk.printStackTrace();
			}
		});
		model.setApplet(true);
		model.dom.getOptions().setAutolayout(false);
		System.err.println("ApplicationModel created @ " + (System.currentTimeMillis() - t0) + " msec");
		model.addDasPeersToApp();
		System.err.println("done addDasPeersToApp @ " + (System.currentTimeMillis() - t0) + " msec");
		try {
			System.err.println("Formatters: " + DataSourceRegistry.getInstance().getFormatterExtensions());
		} catch (Exception Lf4KiszU) {
			Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, Lf4KiszU);
		}
		ApplicationModel LvMWkzzU = model;
		dom = model.getDocumentModel();
		String jpgeKXn0 = getParameter("debug");
		if (jpgeKXn0 != null && !jpgeKXn0.equals("true")) {
		}
		int IqD2zDkg = getIntParameter("width", 700);
		int ff6Bsk8v = getIntParameter("height", 400);
		String puQlOviI = getStringParameter("font", "");
		String boIodXvr = getStringParameter("column", "");
		String KhYWHBO9 = getStringParameter("row", "");
		String gZBj3jhK = getStringParameter("color", "");
		String h9zz4WwW = getStringParameter("renderType", "");
		String or7BUs17 = getStringParameter("timeRange", "");
		String kv5u6xQT = getStringParameter("fillColor", "");
		String WYzIc1sf = getStringParameter("foregroundColor", "");
		String D4yyIs1M = getStringParameter("backgroundColor", "");
		String RH7Ta3Jp = getStringParameter("plot.title", "");
		String F9YhxXFT = getStringParameter("plot.xaxis.label", "");
		String Nx0U1Q5b = getStringParameter("plot.xaxis.range", "");
		String d4XIt6CB = getStringParameter("plot.xaxis.log", "");
		String QcIyQwxC = getStringParameter("plot.xaxis.drawTickLabels", "");
		String P51Fc3mN = getStringParameter("plot.yaxis.label", "");
		String Vnejdphg = getStringParameter("plot.yaxis.range", "");
		String MFqTu1J5 = getStringParameter("plot.yaxis.log", "");
		String i1FXEcGC = getStringParameter("plot.yaxis.drawTickLabels", "");
		String Jh8jybOk = getStringParameter("plot.zaxis.label", "");
		String xG2AzjeY = getStringParameter("plot.zaxis.range", "");
		String T46PBTcG = getStringParameter("plot.zaxis.log", "");
		String A5X0611a = getStringParameter("plot.zaxis.drawTickLabels", "");
		statusCallback = getStringParameter("statusCallback", "");
		timeCallback = getStringParameter("timeCallback", "");
		clickCallback = getStringParameter("clickCallback", "");
		if (h9zz4WwW.equals("fill_to_zero")) {
			h9zz4WwW = "fillToZero";
		}
		setInitializationStatus("readParameters");
		System.err.println("done readParameters @ " + (System.currentTimeMillis() - t0) + " msec");
		String Rs8FVmG4 = getParameter("vap");
		if (Rs8FVmG4 != null) {
			InputStream HMArkmlx = null;
			try {
				URL HpkTRUOP = new URL(Rs8FVmG4);
				System.err.println("load vap " + HpkTRUOP + " @ " + (System.currentTimeMillis() - t0) + " msec");
				HMArkmlx = HpkTRUOP.openStream();
				System.err.println("open vap stream " + HpkTRUOP + " @ " + (System.currentTimeMillis() - t0) + " msec");
				LvMWkzzU.doOpen(HMArkmlx, null);
				System.err.println("done open vap @ " + (System.currentTimeMillis() - t0) + " msec");
				LvMWkzzU.waitUntilIdle(false);
				System.err.println("done load vap and waitUntilIdle @ " + (System.currentTimeMillis() - t0) + " msec");
				Canvas kmv5Yoxk = LvMWkzzU.getDocumentModel().getCanvases(0);
				System.err.println("vap height, width= " + kmv5Yoxk.getHeight() + "," + kmv5Yoxk.getWidth());
				IqD2zDkg = getIntParameter("width", kmv5Yoxk.getWidth());
				ff6Bsk8v = getIntParameter("height", kmv5Yoxk.getHeight());
				System.err.println("output height, width= " + IqD2zDkg + "," + ff6Bsk8v);
			} catch (InterruptedException dlV4gmV5) {
				Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, dlV4gmV5);
			} catch (IOException JlaMlKwg) {
				Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, JlaMlKwg);
			} finally {
				try {
					HMArkmlx.close();
				} catch (IOException PkbHQ9gs) {
					Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, PkbHQ9gs);
				}
			}
		}
		LvMWkzzU.getCanvas().setSize(IqD2zDkg, ff6Bsk8v);
		LvMWkzzU.getCanvas().revalidate();
		LvMWkzzU.getCanvas().setPrintingTag("");
		dom.getOptions().setAutolayout("true".equals(getParameter("autolayout")));
		if (!dom.getOptions().isAutolayout() && Rs8FVmG4 == null) {
			if (!KhYWHBO9.equals("")) {
				dom.getController().getCanvas().getController().setRow(KhYWHBO9);
			}
			if (!boIodXvr.equals("")) {
				dom.getController().getCanvas().getController().setColumn(boIodXvr);
			}
			dom.getCanvases(0).getRows(0).setTop("0%");
			dom.getCanvases(0).getRows(0).setBottom("100%");
		}
		if (!puQlOviI.equals("")) {
			LvMWkzzU.canvas.setBaseFont(Font.decode(puQlOviI));
		}
		JMenuItem JUWLS0qj;
		JUWLS0qj = new JMenuItem(new AbstractAction("Reset Zoom") {

			public void actionPerformed(ActionEvent UFVhjHQo) {
				resetZoom();
			}
		});
		dom.getPlots(0).getController().getDasPlot().getDasMouseInputAdapter().addMenuItem(JUWLS0qj);
		overviewMenuItem = new JCheckBoxMenuItem(new AbstractAction("Context Overview") {

			public void actionPerformed(ActionEvent kLMsxTMm) {
				addOverview();
			}
		});
		dom.getPlots(0).getController().getDasPlot().getDasMouseInputAdapter().addMenuItem(overviewMenuItem);
		if (WYzIc1sf != null && !WYzIc1sf.equals("")) {
			LvMWkzzU.canvas.setForeground(Color.decode(WYzIc1sf));
		}
		if (D4yyIs1M != null && !D4yyIs1M.equals("")) {
			LvMWkzzU.canvas.setBackground(Color.decode(D4yyIs1M));
		}
		getContentPane().setLayout(new BorderLayout());
		System.err.println("done set parameters @ " + (System.currentTimeMillis() - t0) + " msec");
		String IZlDevDk = getParameter("url");
		String nnEeFTTS = getStringParameter("process", "");
		String YQnaniX1 = getStringParameter("script", "");
		if (IZlDevDk == null) {
			IZlDevDk = getParameter("dataSetURL");
		}
		if (IZlDevDk != null && !IZlDevDk.equals("")) {
			DataSource wqjsWHkU;
			try {
				wqjsWHkU = DataSetURI.getDataSource(IZlDevDk);
				System.err.println("get dsource for " + IZlDevDk + " @ " + (System.currentTimeMillis() - t0) + " msec");
				System.err.println("  got dsource=" + wqjsWHkU);
				System.err.println("  dsource.getClass()=" + wqjsWHkU.getClass());
			} catch (NullPointerException hqNEl4F3) {
				throw new RuntimeException("No such data source: ", hqNEl4F3);
			} catch (Exception JiWJfJU2) {
				JiWJfJU2.printStackTrace();
				wqjsWHkU = null;
			}
			DatumRange lAbOb8XY = null;
			if (!or7BUs17.equals("")) {
				lAbOb8XY = DatumRangeUtil.parseTimeRangeValid(or7BUs17);
				TimeSeriesBrowse a7R5zWVK = wqjsWHkU.getCapability(TimeSeriesBrowse.class);
				if (a7R5zWVK != null) {
					System.err.println("do tsb.setTimeRange @ " + (System.currentTimeMillis() - t0) + " msec");
					a7R5zWVK.setTimeRange(lAbOb8XY);
					System.err.println("done tsb.setTimeRange @ " + (System.currentTimeMillis() - t0) + " msec");
				}
			}
			QDataSet vSvJV0dj;
			if (wqjsWHkU != null) {
				TimeSeriesBrowse YScedJWN = wqjsWHkU.getCapability(TimeSeriesBrowse.class);
				if (YScedJWN == null) {
					try {
						System.err.println("do getDataSet @ " + (System.currentTimeMillis() - t0) + " msec");
						System.err.println("  dsource=" + wqjsWHkU);
						System.err.println("  dsource.getClass()=" + wqjsWHkU.getClass());
						if (wqjsWHkU.getClass().toString().contains("CsvDataSource"))
							System.err.println(" WHY IS THIS CsvDataSource!?!?");
						vSvJV0dj = wqjsWHkU == null ? null : wqjsWHkU.getDataSet(loadInitialMonitor);
						for (int dvLTJNBG = 0; dvLTJNBG < Math.min(12, vSvJV0dj.length()); dvLTJNBG++) {
							System.err.printf("ds[%d]=%s\n", dvLTJNBG, vSvJV0dj.slice(dvLTJNBG));
						}
						System.err.println("loaded ds: " + vSvJV0dj);
						System.err.println("done getDataSet @ " + (System.currentTimeMillis() - t0) + " msec");
					} catch (Exception ZODMH4VG) {
						throw new RuntimeException(ZODMH4VG);
					}
				}
			}
			System.err.println("do setDataSource @ " + (System.currentTimeMillis() - t0) + " msec");
			LvMWkzzU.setDataSource(wqjsWHkU);
			System.err.println("done setDataSource @ " + (System.currentTimeMillis() - t0) + " msec");
			setInitializationStatus("dataSourceSet");
			if (or7BUs17 != null && !or7BUs17.equals("")) {
				try {
					System.err.println(
							"wait for idle @ " + (System.currentTimeMillis() - t0) + " msec (due to stimeRange)");
					LvMWkzzU.waitUntilIdle(true);
					System.err.println("done wait for idle @ " + (System.currentTimeMillis() - t0) + " msec");
				} catch (InterruptedException nwm2v2t6) {
					Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, nwm2v2t6);
				}
				if (UnitsUtil.isTimeLocation(dom.getTimeRange().getUnits())) {
					dom.setTimeRange(lAbOb8XY);
				}
			}
			setInitializationStatus("dataSetLoaded");
		}
		System.err.println("done dataSetLoaded @ " + (System.currentTimeMillis() - t0) + " msec");
		Plot y46hya1i = dom.getController().getPlot();
		if (!RH7Ta3Jp.equals("")) {
			y46hya1i.setTitle(RH7Ta3Jp);
		}
		Axis O2BD02kE = y46hya1i.getXaxis();
		if (!F9YhxXFT.equals("")) {
			O2BD02kE.setLabel(F9YhxXFT);
		}
		if (!Nx0U1Q5b.equals("")) {
			try {
				Units skQtGRc2 = O2BD02kE.getController().getDasAxis().getUnits();
				DatumRange c2e6h75n = DatumRangeUtil.parseDatumRange(Nx0U1Q5b, skQtGRc2);
				O2BD02kE.setRange(c2e6h75n);
			} catch (ParseException sRVKgFFq) {
				Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, sRVKgFFq);
			}
		}
		if (!d4XIt6CB.equals("")) {
			O2BD02kE.setLog("true".equals(d4XIt6CB));
		}
		if (!QcIyQwxC.equals("")) {
			O2BD02kE.setDrawTickLabels("true".equals(QcIyQwxC));
		}
		O2BD02kE = y46hya1i.getYaxis();
		if (!P51Fc3mN.equals("")) {
			O2BD02kE.setLabel(P51Fc3mN);
		}
		if (!Vnejdphg.equals("")) {
			try {
				Units e1LeZ2Fe = O2BD02kE.getController().getDasAxis().getUnits();
				DatumRange zkXlqIT5 = DatumRangeUtil.parseDatumRange(Vnejdphg, e1LeZ2Fe);
				O2BD02kE.setRange(zkXlqIT5);
			} catch (ParseException ByQiN9gm) {
				Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, ByQiN9gm);
			}
		}
		if (!MFqTu1J5.equals("")) {
			O2BD02kE.setLog("true".equals(MFqTu1J5));
		}
		if (!i1FXEcGC.equals("")) {
			O2BD02kE.setDrawTickLabels("true".equals(i1FXEcGC));
		}
		O2BD02kE = y46hya1i.getZaxis();
		if (!Jh8jybOk.equals("")) {
			O2BD02kE.setLabel(Jh8jybOk);
		}
		if (!xG2AzjeY.equals("")) {
			try {
				Units M4cjPvvc = O2BD02kE.getController().getDasAxis().getUnits();
				DatumRange VGv5C9ho = DatumRangeUtil.parseDatumRange(xG2AzjeY, M4cjPvvc);
				O2BD02kE.setRange(VGv5C9ho);
			} catch (ParseException VXVYKLa3) {
				Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, VXVYKLa3);
			}
		}
		if (!T46PBTcG.equals("")) {
			O2BD02kE.setLog("true".equals(T46PBTcG));
		}
		if (!A5X0611a.equals("")) {
			O2BD02kE.setDrawTickLabels("true".equals(A5X0611a));
		}
		if (h9zz4WwW != null && !h9zz4WwW.equals("")) {
			try {
				RenderType G9SF0Kys = RenderType.valueOf(h9zz4WwW);
				dom.getController().getPlotElement().setRenderType(G9SF0Kys);
			} catch (IllegalArgumentException IAHWsdPd) {
				IAHWsdPd.printStackTrace();
			}
		}
		System.err.println("done setRenderType @ " + (System.currentTimeMillis() - t0) + " msec");
		if (!gZBj3jhK.equals("")) {
			try {
				dom.getController().getPlotElement().getStyle().setColor(Color.decode(gZBj3jhK));
			} catch (Exception Vnepl4ej) {
				Vnepl4ej.printStackTrace();
			}
		}
		if (!kv5u6xQT.equals("")) {
			try {
				dom.getController().getPlotElement().getStyle().setFillColor(Color.decode(kv5u6xQT));
			} catch (Exception wDD1jRLb) {
				wDD1jRLb.printStackTrace();
			}
		}
		if (!WYzIc1sf.equals("")) {
			try {
				dom.getOptions().setForeground(Color.decode(WYzIc1sf));
			} catch (Exception PBp3nhWJ) {
				PBp3nhWJ.printStackTrace();
			}
		}
		if (!D4yyIs1M.equals("")) {
			try {
				dom.getOptions().setBackground(Color.decode(D4yyIs1M));
			} catch (Exception Zx9l70kY) {
				Zx9l70kY.printStackTrace();
			}
		}
		IZlDevDk = getParameter("dataSetURL");
		if (IZlDevDk != null) {
			if (IZlDevDk.startsWith("about:")) {
				setDataSetURL(IZlDevDk);
			} else {
			}
		}
		getContentPane().remove(progressComponent);
		getContentPane().add(model.getCanvas());
		System.err.println("done add to applet @ " + (System.currentTimeMillis() - t0) + " msec");
		validate();
		System.err.println("done applet.validate @ " + (System.currentTimeMillis() - t0) + " msec");
		repaint();
		LvMWkzzU.getCanvas().setVisible(true);
		initializing = false;
		repaint();
		System.err.println("ready @ " + (System.currentTimeMillis() - t0) + " msec");
		setInitializationStatus("ready");
		dom.getController().getPlot().getXaxis().addPropertyChangeListener(Axis.PROP_RANGE,
				new PropertyChangeListener() {

					public void propertyChange(PropertyChangeEvent VeGPK4vy) {
						timeCallback(String.valueOf(VeGPK4vy.getNewValue()));
					}
				});
		if (!clickCallback.equals("")) {
			String TigcyFJi = "Applet Click";
			int VT6x1FvH = clickCallback.indexOf(",");
			if (VT6x1FvH != -1) {
				int XbqeuETR = clickCallback.indexOf("label=");
				if (XbqeuETR != -1)
					TigcyFJi = clickCallback.substring(XbqeuETR + 6).trim();
				clickCallback = clickCallback.substring(0, VT6x1FvH).trim();
			}
			final DasPlot PljyXaVW = dom.getPlots(0).getController().getDasPlot();
			MouseModule ymZ4Ip2y = new MouseModule(PljyXaVW,
					new CrossHairRenderer(PljyXaVW, null, PljyXaVW.getXAxis(), PljyXaVW.getYAxis()), TigcyFJi) {

				@Override
				public void mousePressed(MouseEvent mNFqMrpn) {
					mNFqMrpn = SwingUtilities.convertMouseEvent(PljyXaVW, mNFqMrpn, PljyXaVW.getCanvas());
					clickCallback(dom.getPlots(0).getId(), PljyXaVW, mNFqMrpn);
				}

				@Override
				public void mouseDragged(MouseEvent uPeUnhUf) {
					uPeUnhUf = SwingUtilities.convertMouseEvent(PljyXaVW, uPeUnhUf, PljyXaVW.getCanvas());
					clickCallback(dom.getPlots(0).getId(), PljyXaVW, uPeUnhUf);
				}

				@Override
				public void mouseReleased(MouseEvent fjf6NXKf) {
					fjf6NXKf = SwingUtilities.convertMouseEvent(PljyXaVW, fjf6NXKf, PljyXaVW.getCanvas());
					clickCallback(dom.getPlots(0).getId(), PljyXaVW, fjf6NXKf);
				}
			};
			PljyXaVW.getDasMouseInputAdapter().setPrimaryModule(ymZ4Ip2y);
		}
		y46hya1i.getController().getDasPlot().getDasMouseInputAdapter().removeMenuItem("Properties");
		dom.getPlots(0).getXaxis().getController().getDasAxis().getDasMouseInputAdapter().removeMenuItem("Properties");
		dom.getPlots(0).getYaxis().getController().getDasAxis().getDasMouseInputAdapter().removeMenuItem("Properties");
		dom.getPlots(0).getZaxis().getController().getDasAxis().getDasMouseInputAdapter().removeMenuItem("Properties");
		if (getStringParameter("contextOverview", "off").equals("on")) {
			Runnable SZYYcGdb = new Runnable() {

				public void run() {
					dom.getController().waitUntilIdle();
					try {
						Thread.sleep(100);
					} catch (InterruptedException QZsquNWV) {
						Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, QZsquNWV);
					}
					dom.getController().waitUntilIdle();
					doSetOverview(true);
				}
			};
			new Thread(SZYYcGdb).start();
		}
		System.err
				.println("done start AutoplotApplet " + VERSION + " @ " + (System.currentTimeMillis() - t0) + " msec");
	}

}