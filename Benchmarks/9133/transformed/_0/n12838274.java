class n12838274 {
	public BufferedImage extract() throws DjatokaException {
		boolean EBOANHLV = false;
		int lsNypLQk = 0;
		int BMGTmUrJ = 0;
		int hHMxlZgv = 50;
		int Qwa8zcFd = 50;
		boolean WKeTWg7C = false;
		Double D7TLzOET = 0.0;
		boolean CKO6dg9P = false;
		Double vuZA46yW = 0.0;
		boolean wulteAqV = false;
		Double YwZy2lzF = 0.0;
		boolean saGOkRmF = false;
		Double UIhIIUPN = 0.0;
		if (params.getRegion() != null) {
			StringTokenizer i37DQ4Fm = new StringTokenizer(params.getRegion(), "{},");
			String mqRsRDP1;
			if ((mqRsRDP1 = i37DQ4Fm.nextToken()).contains(".")) {
				vuZA46yW = Double.parseDouble(mqRsRDP1);
				CKO6dg9P = true;
			} else
				BMGTmUrJ = Integer.parseInt(mqRsRDP1);
			if ((mqRsRDP1 = i37DQ4Fm.nextToken()).contains(".")) {
				D7TLzOET = Double.parseDouble(mqRsRDP1);
				WKeTWg7C = true;
			} else
				lsNypLQk = Integer.parseInt(mqRsRDP1);
			if ((mqRsRDP1 = i37DQ4Fm.nextToken()).contains(".")) {
				UIhIIUPN = Double.parseDouble(mqRsRDP1);
				saGOkRmF = true;
			} else
				Qwa8zcFd = Integer.parseInt(mqRsRDP1);
			if ((mqRsRDP1 = i37DQ4Fm.nextToken()).contains(".")) {
				YwZy2lzF = Double.parseDouble(mqRsRDP1);
				wulteAqV = true;
			} else
				hHMxlZgv = Integer.parseInt(mqRsRDP1);
			EBOANHLV = true;
		}
		try {
			if (is != null) {
				File S6pfPwCJ = File.createTempFile("tmp", ".jp2");
				S6pfPwCJ.deleteOnExit();
				FileOutputStream Azz2lhJd = new FileOutputStream(S6pfPwCJ);
				sourceFile = S6pfPwCJ.getAbsolutePath();
				IOUtils.copyStream(is, Azz2lhJd);
				is.close();
				Azz2lhJd.close();
			}
		} catch (IOException vttVZQNG) {
			throw new DjatokaException(vttVZQNG);
		}
		try {
			Jp2_source XbLxiiuo = new Jp2_source();
			Kdu_compressed_source emTwKybi = null;
			Jp2_family_src iO9i43f3 = new Jp2_family_src();
			Jp2_locator yo8ppJnM = new Jp2_locator();
			iO9i43f3.Open(sourceFile, true);
			XbLxiiuo.Open(iO9i43f3, yo8ppJnM);
			XbLxiiuo.Read_header();
			emTwKybi = XbLxiiuo;
			Kdu_codestream weZjvG7m = new Kdu_codestream();
			weZjvG7m.Create(emTwKybi);
			Kdu_channel_mapping q3hX8Fff = new Kdu_channel_mapping();
			if (XbLxiiuo.Exists())
				q3hX8Fff.Configure(XbLxiiuo, false);
			else
				q3hX8Fff.Configure(weZjvG7m);
			int RTgkH7sz = q3hX8Fff.Get_source_component(0);
			Kdu_coords wZyNVzg6 = getReferenceExpansion(RTgkH7sz, q3hX8Fff, weZjvG7m);
			Kdu_dims wAgg9wHi = new Kdu_dims();
			weZjvG7m.Get_dims(RTgkH7sz, wAgg9wHi);
			Kdu_coords JxZxs0v4 = wAgg9wHi.Access_size();
			Kdu_coords XBLKwHvt = wAgg9wHi.Access_pos();
			if (WKeTWg7C)
				lsNypLQk = XBLKwHvt.Get_x() + (int) Math.round(D7TLzOET * JxZxs0v4.Get_x());
			if (CKO6dg9P)
				BMGTmUrJ = XBLKwHvt.Get_y() + (int) Math.round(vuZA46yW * JxZxs0v4.Get_y());
			if (saGOkRmF)
				Qwa8zcFd = (int) Math.round(UIhIIUPN * JxZxs0v4.Get_y());
			if (wulteAqV)
				hHMxlZgv = (int) Math.round(YwZy2lzF * JxZxs0v4.Get_x());
			if (EBOANHLV) {
				JxZxs0v4.Set_x(hHMxlZgv);
				JxZxs0v4.Set_y(Qwa8zcFd);
				XBLKwHvt.Set_x(lsNypLQk);
				XBLKwHvt.Set_y(BMGTmUrJ);
			}
			int OOPEAh5T = 1 << params.getLevelReductionFactor();
			JxZxs0v4.Set_x(JxZxs0v4.Get_x() * wZyNVzg6.Get_x());
			JxZxs0v4.Set_y(JxZxs0v4.Get_y() * wZyNVzg6.Get_y());
			XBLKwHvt.Set_x(XBLKwHvt.Get_x() * wZyNVzg6.Get_x() / OOPEAh5T - ((wZyNVzg6.Get_x() / OOPEAh5T - 1) / 2));
			XBLKwHvt.Set_y(XBLKwHvt.Get_y() * wZyNVzg6.Get_y() / OOPEAh5T - ((wZyNVzg6.Get_y() / OOPEAh5T - 1) / 2));
			Kdu_dims InMp9nhd = new Kdu_dims();
			InMp9nhd.Assign(wAgg9wHi);
			InMp9nhd.Access_size().Set_x(JxZxs0v4.Get_x());
			InMp9nhd.Access_size().Set_y(JxZxs0v4.Get_y());
			int NTXTbNzp = JxZxs0v4.Get_x() * JxZxs0v4.Get_y();
			int[] JVFOsGeo = new int[NTXTbNzp];
			Kdu_region_decompressor MyoqVfxV = new Kdu_region_decompressor();
			MyoqVfxV.Start(weZjvG7m, q3hX8Fff, -1, params.getLevelReductionFactor(), 16384, wAgg9wHi, wZyNVzg6,
					new Kdu_coords(1, 1), false, Kdu_global.KDU_WANT_OUTPUT_COMPONENTS);
			Kdu_dims TRUCHq8y = new Kdu_dims();
			Kdu_dims LSgt4uw1 = new Kdu_dims();
			Kdu_coords sERPjywI = InMp9nhd.Access_size();
			LSgt4uw1.Assign(wAgg9wHi);
			int[] wGD3GrLW = new int[sERPjywI.Get_x() * sERPjywI.Get_y()];
			int[] i34XOUZP = null;
			while (MyoqVfxV.Process(JVFOsGeo, wAgg9wHi.Access_pos(), 0, 0, NTXTbNzp, LSgt4uw1, TRUCHq8y)) {
				Kdu_coords Zx9aiqEn = TRUCHq8y.Access_pos();
				Kdu_coords jc1zxofz = TRUCHq8y.Access_size();
				Zx9aiqEn.Subtract(InMp9nhd.Access_pos());
				i34XOUZP = JVFOsGeo;
				int U6PMRtPV = Zx9aiqEn.Get_x() + Zx9aiqEn.Get_y() * sERPjywI.Get_x();
				int YyFQYIF8 = 0;
				int BVFUNWWs = sERPjywI.Get_x() - jc1zxofz.Get_x();
				for (int Pqask7os = 0; Pqask7os < jc1zxofz.Get_y(); Pqask7os++, U6PMRtPV += BVFUNWWs) {
					for (int z2caWJG2 = 0; z2caWJG2 < jc1zxofz.Get_x(); z2caWJG2++) {
						wGD3GrLW[U6PMRtPV++] = i34XOUZP[YyFQYIF8++];
					}
				}
			}
			BufferedImage Mx8J72au = new BufferedImage(JxZxs0v4.Get_x(), JxZxs0v4.Get_y(), BufferedImage.TYPE_INT_RGB);
			Mx8J72au.setRGB(0, 0, sERPjywI.Get_x(), sERPjywI.Get_y(), wGD3GrLW, 0, sERPjywI.Get_x());
			if (params.getRotationDegree() > 0) {
				Mx8J72au = ImageProcessingUtils.rotate(Mx8J72au, params.getRotationDegree());
			}
			MyoqVfxV.Native_destroy();
			q3hX8Fff.Native_destroy();
			if (weZjvG7m.Exists())
				weZjvG7m.Destroy();
			XbLxiiuo.Native_destroy();
			emTwKybi.Native_destroy();
			iO9i43f3.Native_destroy();
			return Mx8J72au;
		} catch (KduException nn0V6qc2) {
			nn0V6qc2.printStackTrace();
			throw new DjatokaException(nn0V6qc2);
		} catch (Exception rFQi1ZtJ) {
			rFQi1ZtJ.printStackTrace();
			throw new DjatokaException(rFQi1ZtJ);
		}
	}

}