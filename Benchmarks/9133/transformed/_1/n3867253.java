class n3867253 {
	@Override
	public void start() {
		System.err.println("start AutoplotApplet " + VERSION + " @ " + (System.currentTimeMillis() - t0) + " msec");
		super.start();
		model = new ApplicationModel();
		model.setExceptionHandler(new ExceptionHandler() {

			public void handle(Throwable t) {
				t.printStackTrace();
			}

			public void handleUncaught(Throwable t) {
				t.printStackTrace();
			}
		});
		model.setApplet(true);
		model.dom.getOptions().setAutolayout(false);
		System.err.println("ApplicationModel created @ " + (System.currentTimeMillis() - t0) + " msec");
		model.addDasPeersToApp();
		System.err.println("done addDasPeersToApp @ " + (System.currentTimeMillis() - t0) + " msec");
		try {
			System.err.println("Formatters: " + DataSourceRegistry.getInstance().getFormatterExtensions());
		} catch (Exception ex) {
			Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, ex);
		}
		ApplicationModel appmodel = model;
		dom = model.getDocumentModel();
		String debug = getParameter("debug");
		if (debug != null && !debug.equals("true")) {
		}
		int width = getIntParameter("width", 700);
		int height = getIntParameter("height", 400);
		String fontParam = getStringParameter("font", "");
		String column = getStringParameter("column", "");
		String row = getStringParameter("row", "");
		String scolor = getStringParameter("color", "");
		String srenderType = getStringParameter("renderType", "");
		String stimeRange = getStringParameter("timeRange", "");
		String sfillColor = getStringParameter("fillColor", "");
		String sforegroundColor = getStringParameter("foregroundColor", "");
		String sbackgroundColor = getStringParameter("backgroundColor", "");
		String title = getStringParameter("plot.title", "");
		String xlabel = getStringParameter("plot.xaxis.label", "");
		String xrange = getStringParameter("plot.xaxis.range", "");
		String xlog = getStringParameter("plot.xaxis.log", "");
		String xdrawTickLabels = getStringParameter("plot.xaxis.drawTickLabels", "");
		String ylabel = getStringParameter("plot.yaxis.label", "");
		String yrange = getStringParameter("plot.yaxis.range", "");
		String ylog = getStringParameter("plot.yaxis.log", "");
		String ydrawTickLabels = getStringParameter("plot.yaxis.drawTickLabels", "");
		String zlabel = getStringParameter("plot.zaxis.label", "");
		String zrange = getStringParameter("plot.zaxis.range", "");
		String zlog = getStringParameter("plot.zaxis.log", "");
		String zdrawTickLabels = getStringParameter("plot.zaxis.drawTickLabels", "");
		statusCallback = getStringParameter("statusCallback", "");
		timeCallback = getStringParameter("timeCallback", "");
		clickCallback = getStringParameter("clickCallback", "");
		if (srenderType.equals("fill_to_zero")) {
			srenderType = "fillToZero";
		}
		setInitializationStatus("readParameters");
		System.err.println("done readParameters @ " + (System.currentTimeMillis() - t0) + " msec");
		String vap = getParameter("vap");
		if (vap != null) {
			InputStream in = null;
			try {
				URL url = new URL(vap);
				System.err.println("load vap " + url + " @ " + (System.currentTimeMillis() - t0) + " msec");
				in = url.openStream();
				System.err.println("open vap stream " + url + " @ " + (System.currentTimeMillis() - t0) + " msec");
				appmodel.doOpen(in, null);
				System.err.println("done open vap @ " + (System.currentTimeMillis() - t0) + " msec");
				appmodel.waitUntilIdle(false);
				System.err.println("done load vap and waitUntilIdle @ " + (System.currentTimeMillis() - t0) + " msec");
				Canvas cc = appmodel.getDocumentModel().getCanvases(0);
				System.err.println("vap height, width= " + cc.getHeight() + "," + cc.getWidth());
				width = getIntParameter("width", cc.getWidth());
				height = getIntParameter("height", cc.getHeight());
				System.err.println("output height, width= " + width + "," + height);
			} catch (InterruptedException ex) {
				Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
				Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				try {
					in.close();
				} catch (IOException ex) {
					Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		appmodel.getCanvas().setSize(width, height);
		appmodel.getCanvas().revalidate();
		appmodel.getCanvas().setPrintingTag("");
		dom.getOptions().setAutolayout("true".equals(getParameter("autolayout")));
		if (!dom.getOptions().isAutolayout() && vap == null) {
			if (!row.equals("")) {
				dom.getController().getCanvas().getController().setRow(row);
			}
			if (!column.equals("")) {
				dom.getController().getCanvas().getController().setColumn(column);
			}
			dom.getCanvases(0).getRows(0).setTop("0%");
			dom.getCanvases(0).getRows(0).setBottom("100%");
		}
		if (!fontParam.equals("")) {
			appmodel.canvas.setBaseFont(Font.decode(fontParam));
		}
		JMenuItem item;
		item = new JMenuItem(new AbstractAction("Reset Zoom") {

			public void actionPerformed(ActionEvent e) {
				resetZoom();
			}
		});
		dom.getPlots(0).getController().getDasPlot().getDasMouseInputAdapter().addMenuItem(item);
		overviewMenuItem = new JCheckBoxMenuItem(new AbstractAction("Context Overview") {

			public void actionPerformed(ActionEvent e) {
				addOverview();
			}
		});
		dom.getPlots(0).getController().getDasPlot().getDasMouseInputAdapter().addMenuItem(overviewMenuItem);
		if (sforegroundColor != null && !sforegroundColor.equals("")) {
			appmodel.canvas.setForeground(Color.decode(sforegroundColor));
		}
		if (sbackgroundColor != null && !sbackgroundColor.equals("")) {
			appmodel.canvas.setBackground(Color.decode(sbackgroundColor));
		}
		getContentPane().setLayout(new BorderLayout());
		System.err.println("done set parameters @ " + (System.currentTimeMillis() - t0) + " msec");
		String surl = getParameter("url");
		String process = getStringParameter("process", "");
		String script = getStringParameter("script", "");
		if (surl == null) {
			surl = getParameter("dataSetURL");
		}
		if (surl != null && !surl.equals("")) {
			DataSource dsource;
			try {
				dsource = DataSetURI.getDataSource(surl);
				System.err.println("get dsource for " + surl + " @ " + (System.currentTimeMillis() - t0) + " msec");
				System.err.println("  got dsource=" + dsource);
				System.err.println("  dsource.getClass()=" + dsource.getClass());
			} catch (NullPointerException ex) {
				throw new RuntimeException("No such data source: ", ex);
			} catch (Exception ex) {
				ex.printStackTrace();
				dsource = null;
			}
			DatumRange timeRange1 = null;
			if (!stimeRange.equals("")) {
				timeRange1 = DatumRangeUtil.parseTimeRangeValid(stimeRange);
				TimeSeriesBrowse tsb = dsource.getCapability(TimeSeriesBrowse.class);
				if (tsb != null) {
					System.err.println("do tsb.setTimeRange @ " + (System.currentTimeMillis() - t0) + " msec");
					tsb.setTimeRange(timeRange1);
					System.err.println("done tsb.setTimeRange @ " + (System.currentTimeMillis() - t0) + " msec");
				}
			}
			QDataSet ds;
			if (dsource != null) {
				TimeSeriesBrowse tsb = dsource.getCapability(TimeSeriesBrowse.class);
				if (tsb == null) {
					try {
						System.err.println("do getDataSet @ " + (System.currentTimeMillis() - t0) + " msec");
						System.err.println("  dsource=" + dsource);
						System.err.println("  dsource.getClass()=" + dsource.getClass());
						if (dsource.getClass().toString().contains("CsvDataSource"))
							System.err.println(" WHY IS THIS CsvDataSource!?!?");
						ds = dsource == null ? null : dsource.getDataSet(loadInitialMonitor);
						int henlY = 0;
						while (henlY < Math.min(12, ds.length())) {
							System.err.printf("ds[%d]=%s\n", henlY, ds.slice(henlY));
							henlY++;
						}
						System.err.println("loaded ds: " + ds);
						System.err.println("done getDataSet @ " + (System.currentTimeMillis() - t0) + " msec");
					} catch (Exception ex) {
						throw new RuntimeException(ex);
					}
				}
			}
			System.err.println("do setDataSource @ " + (System.currentTimeMillis() - t0) + " msec");
			appmodel.setDataSource(dsource);
			System.err.println("done setDataSource @ " + (System.currentTimeMillis() - t0) + " msec");
			setInitializationStatus("dataSourceSet");
			if (stimeRange != null && !stimeRange.equals("")) {
				try {
					System.err.println(
							"wait for idle @ " + (System.currentTimeMillis() - t0) + " msec (due to stimeRange)");
					appmodel.waitUntilIdle(true);
					System.err.println("done wait for idle @ " + (System.currentTimeMillis() - t0) + " msec");
				} catch (InterruptedException ex) {
					Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, ex);
				}
				if (UnitsUtil.isTimeLocation(dom.getTimeRange().getUnits())) {
					dom.setTimeRange(timeRange1);
				}
			}
			setInitializationStatus("dataSetLoaded");
		}
		System.err.println("done dataSetLoaded @ " + (System.currentTimeMillis() - t0) + " msec");
		Plot p = dom.getController().getPlot();
		if (!title.equals("")) {
			p.setTitle(title);
		}
		Axis axis = p.getXaxis();
		if (!xlabel.equals("")) {
			axis.setLabel(xlabel);
		}
		if (!xrange.equals("")) {
			try {
				Units u = axis.getController().getDasAxis().getUnits();
				DatumRange newRange = DatumRangeUtil.parseDatumRange(xrange, u);
				axis.setRange(newRange);
			} catch (ParseException ex) {
				Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		if (!xlog.equals("")) {
			axis.setLog("true".equals(xlog));
		}
		if (!xdrawTickLabels.equals("")) {
			axis.setDrawTickLabels("true".equals(xdrawTickLabels));
		}
		axis = p.getYaxis();
		if (!ylabel.equals("")) {
			axis.setLabel(ylabel);
		}
		if (!yrange.equals("")) {
			try {
				Units u = axis.getController().getDasAxis().getUnits();
				DatumRange newRange = DatumRangeUtil.parseDatumRange(yrange, u);
				axis.setRange(newRange);
			} catch (ParseException ex) {
				Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		if (!ylog.equals("")) {
			axis.setLog("true".equals(ylog));
		}
		if (!ydrawTickLabels.equals("")) {
			axis.setDrawTickLabels("true".equals(ydrawTickLabels));
		}
		axis = p.getZaxis();
		if (!zlabel.equals("")) {
			axis.setLabel(zlabel);
		}
		if (!zrange.equals("")) {
			try {
				Units u = axis.getController().getDasAxis().getUnits();
				DatumRange newRange = DatumRangeUtil.parseDatumRange(zrange, u);
				axis.setRange(newRange);
			} catch (ParseException ex) {
				Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		if (!zlog.equals("")) {
			axis.setLog("true".equals(zlog));
		}
		if (!zdrawTickLabels.equals("")) {
			axis.setDrawTickLabels("true".equals(zdrawTickLabels));
		}
		if (srenderType != null && !srenderType.equals("")) {
			try {
				RenderType renderType = RenderType.valueOf(srenderType);
				dom.getController().getPlotElement().setRenderType(renderType);
			} catch (IllegalArgumentException ex) {
				ex.printStackTrace();
			}
		}
		System.err.println("done setRenderType @ " + (System.currentTimeMillis() - t0) + " msec");
		if (!scolor.equals("")) {
			try {
				dom.getController().getPlotElement().getStyle().setColor(Color.decode(scolor));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (!sfillColor.equals("")) {
			try {
				dom.getController().getPlotElement().getStyle().setFillColor(Color.decode(sfillColor));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (!sforegroundColor.equals("")) {
			try {
				dom.getOptions().setForeground(Color.decode(sforegroundColor));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (!sbackgroundColor.equals("")) {
			try {
				dom.getOptions().setBackground(Color.decode(sbackgroundColor));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		surl = getParameter("dataSetURL");
		if (surl != null) {
			if (surl.startsWith("about:")) {
				setDataSetURL(surl);
			} else {
			}
		}
		getContentPane().remove(progressComponent);
		getContentPane().add(model.getCanvas());
		System.err.println("done add to applet @ " + (System.currentTimeMillis() - t0) + " msec");
		validate();
		System.err.println("done applet.validate @ " + (System.currentTimeMillis() - t0) + " msec");
		repaint();
		appmodel.getCanvas().setVisible(true);
		initializing = false;
		repaint();
		System.err.println("ready @ " + (System.currentTimeMillis() - t0) + " msec");
		setInitializationStatus("ready");
		dom.getController().getPlot().getXaxis().addPropertyChangeListener(Axis.PROP_RANGE,
				new PropertyChangeListener() {

					public void propertyChange(PropertyChangeEvent evt) {
						timeCallback(String.valueOf(evt.getNewValue()));
					}
				});
		if (!clickCallback.equals("")) {
			String clickCallbackLabel = "Applet Click";
			int i = clickCallback.indexOf(",");
			if (i != -1) {
				int i2 = clickCallback.indexOf("label=");
				if (i2 != -1)
					clickCallbackLabel = clickCallback.substring(i2 + 6).trim();
				clickCallback = clickCallback.substring(0, i).trim();
			}
			final DasPlot plot = dom.getPlots(0).getController().getDasPlot();
			MouseModule mm = new MouseModule(plot, new CrossHairRenderer(plot, null, plot.getXAxis(), plot.getYAxis()),
					clickCallbackLabel) {

				@Override
				public void mousePressed(MouseEvent e) {
					e = SwingUtilities.convertMouseEvent(plot, e, plot.getCanvas());
					clickCallback(dom.getPlots(0).getId(), plot, e);
				}

				@Override
				public void mouseDragged(MouseEvent e) {
					e = SwingUtilities.convertMouseEvent(plot, e, plot.getCanvas());
					clickCallback(dom.getPlots(0).getId(), plot, e);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					e = SwingUtilities.convertMouseEvent(plot, e, plot.getCanvas());
					clickCallback(dom.getPlots(0).getId(), plot, e);
				}
			};
			plot.getDasMouseInputAdapter().setPrimaryModule(mm);
		}
		p.getController().getDasPlot().getDasMouseInputAdapter().removeMenuItem("Properties");
		dom.getPlots(0).getXaxis().getController().getDasAxis().getDasMouseInputAdapter().removeMenuItem("Properties");
		dom.getPlots(0).getYaxis().getController().getDasAxis().getDasMouseInputAdapter().removeMenuItem("Properties");
		dom.getPlots(0).getZaxis().getController().getDasAxis().getDasMouseInputAdapter().removeMenuItem("Properties");
		if (getStringParameter("contextOverview", "off").equals("on")) {
			Runnable run = new Runnable() {

				public void run() {
					dom.getController().waitUntilIdle();
					try {
						Thread.sleep(100);
					} catch (InterruptedException ex) {
						Logger.getLogger(AutoplotApplet.class.getName()).log(Level.SEVERE, null, ex);
					}
					dom.getController().waitUntilIdle();
					doSetOverview(true);
				}
			};
			new Thread(run).start();
		}
		System.err
				.println("done start AutoplotApplet " + VERSION + " @ " + (System.currentTimeMillis() - t0) + " msec");
	}

}