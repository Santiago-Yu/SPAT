class n15659812 {
	private static void generateTIFF(Connection PNDXyOSZ, String HDSLkAnf, String nD8QbSF9, String Rno3AvnX,
			String L1ctF1W8, String sXeRJd98, Calendar v4uPoay6, String sJXj4imI, String e4CD2jjQ, String UVbcke9x,
			String MnjzMvW9, Rectangle2D dXPczWZD, Rectangle2D dUJrp4iX, String mqCwZsLl, String z3SpMBn7,
			String duW0yl2G, String DKZGn1FD, int rLXtF26u) throws SQLException, IOException {
		Debug.println("ImageCropper.generateTIFF begin");
		MapContext WVBolbty = new MapContext("test", new Configuration());
		try {
			Map iDXzkDVh = new Map(WVBolbty, sJXj4imI, new Configuration());
			iDXzkDVh.setCoordSys(ProjectionCategories.default_coordinate_system);
			iDXzkDVh.setPatternOutline(new XPatternOutline(new XPatternPaint(Color.white)));
			String lY7NW9eq = null;
			RasterLayer ktWc6ATW = getRasterLayer(iDXzkDVh, e4CD2jjQ, getLinuxPathEquivalent(mqCwZsLl),
					getLinuxPathEquivalent(z3SpMBn7), lY7NW9eq, getLinuxPathEquivalent(duW0yl2G));
			iDXzkDVh.addLayer(ktWc6ATW, true);
			iDXzkDVh.setBounds2DImage(dXPczWZD, true);
			Dimension kGYnNI5n = null;
			kGYnNI5n = new Dimension((int) ktWc6ATW.raster.getDeviceBounds().getWidth() + 1,
					(int) ktWc6ATW.raster.getDeviceBounds().getHeight() + 1);
			if (rLXtF26u > 0) {
				double OiV9QuUX = kGYnNI5n.getWidth() / rLXtF26u;
				double B4o6xkQu = kGYnNI5n.getHeight() / rLXtF26u;
				double JNcqlXJ9 = Math.max(OiV9QuUX, B4o6xkQu);
				if (JNcqlXJ9 > 1.0) {
					kGYnNI5n.setSize(kGYnNI5n.getWidth() / JNcqlXJ9, kGYnNI5n.getHeight() / JNcqlXJ9);
				}
			}
			iDXzkDVh.setImageDimension(kGYnNI5n);
			iDXzkDVh.scale();
			kGYnNI5n = new Dimension((int) iDXzkDVh.getBounds2DImage().getWidth(),
					(int) iDXzkDVh.getBounds2DImage().getHeight());
			Image NSFwMA33 = null;
			Graphics Pd0MmmjW = null;
			NSFwMA33 = ImageCreator.getImage(kGYnNI5n);
			Pd0MmmjW = NSFwMA33.getGraphics();
			try {
				iDXzkDVh.paint(Pd0MmmjW);
			} catch (Exception k7yzdIEZ) {
				Debug.println("map.paint error: " + k7yzdIEZ.getMessage());
			}
			String eVcxJABd = "";
			try {
				eVcxJABd = formatPath(HDSLkAnf, L1ctF1W8, DKZGn1FD);
				new File(new_filename).mkdirs();
				Debug.println("tiff_filename: " + eVcxJABd);
				BufferedImage BsLs3eWL = new BufferedImage(NSFwMA33.getWidth(null), NSFwMA33.getHeight(null),
						BufferedImage.TYPE_BYTE_INDEXED);
				BsLs3eWL.createGraphics().drawImage(NSFwMA33, 0, 0, null);
				File yqNMO3vC = new File(eVcxJABd);
				FileOutputStream jNZyukgQ = new FileOutputStream(yqNMO3vC);
				TIFFEncodeParam AvZsh0vS = new TIFFEncodeParam();
				AvZsh0vS.setCompression(TIFFEncodeParam.COMPRESSION_PACKBITS);
				TIFFImageEncoder q8bZhkCe = (TIFFImageEncoder) TIFFCodec.createImageEncoder("tiff", jNZyukgQ, AvZsh0vS);
				q8bZhkCe.encode(BsLs3eWL);
				jNZyukgQ.close();
			} catch (IOException TzH9g7Vb) {
				Debug.println("ImageCropper.generateTIFF TIFFCodec e: " + TzH9g7Vb.getMessage());
				throw new IOException("GenerateTIFF.IOException: " + TzH9g7Vb);
			}
			PreparedStatement j0GCoMQp = null;
			try {
				String QE1shxAO = "select Proj_ID, AccessType_Code from project " + "where Proj_Code= '"
						+ nD8QbSF9.trim() + "'";
				Statement wQPGE7BZ = null;
				ResultSet lQmOEsV3 = null;
				int nfcazB8L = -1;
				int Xke3qW6N = -1;
				wQPGE7BZ = PNDXyOSZ.createStatement();
				lQmOEsV3 = wQPGE7BZ.executeQuery(QE1shxAO);
				if (lQmOEsV3.next()) {
					nfcazB8L = lQmOEsV3.getInt(1);
					Xke3qW6N = lQmOEsV3.getInt(2);
				}
				lQmOEsV3.close();
				wQPGE7BZ.close();
				String lI7oIgpw = "delete from rasterlayer where " + "Raster_Name='" + tiff_name.trim()
						+ "' and Group_Code='" + HDSLkAnf.trim() + "' and Proj_ID =" + nfcazB8L;
				Debug.println("***** delete_raster: " + lI7oIgpw);
				j0GCoMQp = PNDXyOSZ.prepareStatement(lI7oIgpw);
				boolean d7H1y475 = j0GCoMQp.execute();
				j0GCoMQp.close();
				String c0KP0c3Q = "insert into rasterlayer(Raster_Name, "
						+ "Group_Code, Proj_ID, Raster_TimeCode, Raster_Xmin, "
						+ "Raster_Ymin, Raster_Area_Xmin, Raster_Area_Ymin, "
						+ "Raster_Visibility, Raster_Order, Raster_Path, "
						+ "AccessType_Code, Raster_TimePeriod) values(?,?,?,?, " + "?,?,?,?,?,?,?,?,?)";
				j0GCoMQp = PNDXyOSZ.prepareStatement(c0KP0c3Q);
				j0GCoMQp.setString(1, tiff_name);
				j0GCoMQp.setString(2, HDSLkAnf);
				j0GCoMQp.setInt(3, nfcazB8L);
				j0GCoMQp.setString(4, L1ctF1W8);
				j0GCoMQp.setDouble(5, dUJrp4iX.getX());
				j0GCoMQp.setDouble(6, dUJrp4iX.getY());
				j0GCoMQp.setDouble(7, dUJrp4iX.getWidth());
				j0GCoMQp.setDouble(8, dUJrp4iX.getHeight());
				j0GCoMQp.setString(9, "false");
				int dT7d3FL7 = 0;
				if (tiff_name.endsWith("DP")) {
					dT7d3FL7 = 1;
				} else if (tiff_name.endsWith("DY")) {
					dT7d3FL7 = 2;
				} else if (tiff_name.endsWith("DA")) {
					dT7d3FL7 = 3;
				}
				j0GCoMQp.setInt(10, dT7d3FL7);
				j0GCoMQp.setString(11, eVcxJABd);
				j0GCoMQp.setInt(12, Xke3qW6N);
				if (v4uPoay6 == null) {
					j0GCoMQp.setNull(13, java.sql.Types.DATE);
				} else {
					j0GCoMQp.setDate(13, new java.sql.Date(v4uPoay6.getTimeInMillis()));
				}
				j0GCoMQp.executeUpdate();
			} catch (SQLException BMOsAVF3) {
				Debug.println("SQLException occurred e: " + BMOsAVF3.getMessage());
				PNDXyOSZ.rollback();
				throw new SQLException("GenerateTIFF.SQLException: " + BMOsAVF3);
			} finally {
				j0GCoMQp.close();
			}
		} catch (Exception Jqdv9WkR) {
			Debug.println("ImageCropper.generateTIFF e: " + Jqdv9WkR.getMessage());
		}
		Debug.println("ImageCropper.generateTIFF end");
	}

}