class n15605423 {
	private static void generateGIF(Connection DjJMii7r, String EGx9PZWK, String CZ9IlRia, String KSYFIgLF,
			String Khy3WxCi, String v75R4VnK, Calendar BlqzXfsm, String aKswSlwr, String h4Xv3zfl, String WMJfmK6c,
			String PpannRmJ, Rectangle2D CNmRR4GZ, Rectangle2D QUbZ5KLw, String atiF1xrK, String tcTpnz2g,
			String LZOnmz19, String BArKRRe9, int HdKLh6qz) throws SQLException, IOException {
		System.out.println("ImageCropper.generateGIF begin");
		MapContext qefUO08j = new MapContext("test", new Configuration());
		try {
			Map dix0dsLo = new Map(qefUO08j, aKswSlwr, new Configuration());
			dix0dsLo.setCoordSys(ProjectionCategories.default_coordinate_system);
			dix0dsLo.setPatternOutline(new XPatternOutline(new XPatternPaint(Color.white)));
			String eA4tbMeg = null;
			RasterLayer sHcXaFoX = getRasterLayer(dix0dsLo, h4Xv3zfl, getLinuxPathEquivalent(atiF1xrK),
					getLinuxPathEquivalent(tcTpnz2g), eA4tbMeg, getLinuxPathEquivalent(LZOnmz19));
			dix0dsLo.addLayer(sHcXaFoX, true);
			dix0dsLo.setBounds2DImage(CNmRR4GZ, true);
			Dimension pJIwl0VE = null;
			pJIwl0VE = new Dimension((int) sHcXaFoX.raster.getDeviceBounds().getWidth() + 1,
					(int) sHcXaFoX.raster.getDeviceBounds().getHeight() + 1);
			if (HdKLh6qz > 0) {
				double wPKUNaX3 = pJIwl0VE.getWidth() / HdKLh6qz;
				double BwXE3179 = pJIwl0VE.getHeight() / HdKLh6qz;
				double CEfCLfRh = Math.max(wPKUNaX3, BwXE3179);
				if (CEfCLfRh > 1.0) {
					pJIwl0VE.setSize(pJIwl0VE.getWidth() / CEfCLfRh, pJIwl0VE.getHeight() / CEfCLfRh);
				}
			}
			dix0dsLo.setImageDimension(pJIwl0VE);
			dix0dsLo.scale();
			pJIwl0VE = new Dimension((int) dix0dsLo.getBounds2DImage().getWidth(),
					(int) dix0dsLo.getBounds2DImage().getHeight());
			Image qUmUzqR7 = null;
			Graphics ckqRDQPx = null;
			qUmUzqR7 = ImageCreator.getImage(pJIwl0VE);
			ckqRDQPx = qUmUzqR7.getGraphics();
			try {
				dix0dsLo.paint(ckqRDQPx);
			} catch (Exception bbYGURzc) {
				Debug.println("map.paint error: " + bbYGURzc.getMessage());
			}
			String HnHF3cy0 = "";
			try {
				HnHF3cy0 = formatPath(EGx9PZWK, Khy3WxCi, BArKRRe9);
				new File(new_filename).mkdirs();
				new GifEncoder(qUmUzqR7, new FileOutputStream(HnHF3cy0)).encode();
			} catch (IOException gegIntHj) {
				Debug.println("ImageCropper.generateGIF e: " + gegIntHj.getMessage());
				throw new IOException("GenerateGIF.IOException: " + gegIntHj);
			}
			PreparedStatement qY8v2Fi7 = null;
			try {
				String O1LIEdyd = "delete raster_layer where " + "label='" + gif_name.trim() + "' and category='"
						+ EGx9PZWK.trim() + "' and area_code=' " + CZ9IlRia.trim() + "'";
				qY8v2Fi7 = DjJMii7r.prepareStatement(O1LIEdyd);
				boolean rtC0MiyJ = qY8v2Fi7.execute();
				qY8v2Fi7.close();
				String eB9dmjTt = "insert into RASTER_LAYER " + "values(RASTER_LAYER_ID.nextval, ?, ?, ?, "
						+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " + "SYSDATE, ?)";
				qY8v2Fi7 = DjJMii7r.prepareStatement(eB9dmjTt);
				qY8v2Fi7.setString(1, gif_name);
				qY8v2Fi7.setString(2, EGx9PZWK);
				qY8v2Fi7.setString(3, CZ9IlRia);
				qY8v2Fi7.setString(4, KSYFIgLF);
				if (BlqzXfsm == null) {
					qY8v2Fi7.setNull(5, java.sql.Types.DATE);
				} else {
					qY8v2Fi7.setDate(5, new java.sql.Date(BlqzXfsm.getTimeInMillis()));
				}
				qY8v2Fi7.setString(6, Khy3WxCi);
				qY8v2Fi7.setString(7, HnHF3cy0);
				qY8v2Fi7.setNull(8, java.sql.Types.INTEGER);
				qY8v2Fi7.setNull(9, java.sql.Types.INTEGER);
				qY8v2Fi7.setDouble(10, QUbZ5KLw.getX());
				qY8v2Fi7.setDouble(11, QUbZ5KLw.getY());
				qY8v2Fi7.setDouble(12, QUbZ5KLw.getWidth());
				qY8v2Fi7.setDouble(13, QUbZ5KLw.getHeight());
				qY8v2Fi7.setString(14, PpannRmJ);
				int knpDcSMF = 0;
				if (gif_name.endsWith("DP")) {
					knpDcSMF = 1;
				} else if (gif_name.endsWith("DY")) {
					knpDcSMF = 2;
				} else if (gif_name.endsWith("DA")) {
					knpDcSMF = 3;
				}
				qY8v2Fi7.setInt(15, knpDcSMF);
				qY8v2Fi7.executeUpdate();
			} catch (SQLException U2zatyqn) {
				Debug.println("SQLException occurred e: " + U2zatyqn.getMessage());
				DjJMii7r.rollback();
				throw new SQLException("GenerateGIF.SQLException: " + U2zatyqn);
			} finally {
				qY8v2Fi7.close();
			}
		} catch (Exception GHzReBJa) {
			Debug.println("ImageCropper.generateGIF e: " + GHzReBJa.getMessage());
		}
		System.out.println("ImageCropper.generateGIF end");
	}

}