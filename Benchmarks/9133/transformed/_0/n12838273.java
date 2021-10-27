class n12838273 {
	public BufferedImage extractUsingCompositor() throws IOException, DjatokaException {
		boolean WlbmKYk8 = false;
		int qP34toop = 0;
		int AzjhYzyS = 0;
		int PD6fCz5B = 50;
		int N85686kP = 50;
		boolean CxLhKFDp = false;
		Double VvPiJNc5 = 0.0;
		boolean fyYwCgY0 = false;
		Double KS0emncz = 0.0;
		boolean TLeew5mp = false;
		Double JvZ9p4SE = 0.0;
		boolean VSZRvrAA = false;
		Double cbcWaDCg = 0.0;
		if (params.getRegion() != null) {
			StringTokenizer V3EShKBe = new StringTokenizer(params.getRegion(), "{},");
			String vLOztC4s;
			if ((vLOztC4s = V3EShKBe.nextToken()).contains(".")) {
				KS0emncz = Double.parseDouble(vLOztC4s);
				fyYwCgY0 = true;
			} else
				AzjhYzyS = Integer.parseInt(vLOztC4s);
			if ((vLOztC4s = V3EShKBe.nextToken()).contains(".")) {
				VvPiJNc5 = Double.parseDouble(vLOztC4s);
				CxLhKFDp = true;
			} else
				qP34toop = Integer.parseInt(vLOztC4s);
			if ((vLOztC4s = V3EShKBe.nextToken()).contains(".")) {
				cbcWaDCg = Double.parseDouble(vLOztC4s);
				VSZRvrAA = true;
			} else
				N85686kP = Integer.parseInt(vLOztC4s);
			if ((vLOztC4s = V3EShKBe.nextToken()).contains(".")) {
				JvZ9p4SE = Double.parseDouble(vLOztC4s);
				TLeew5mp = true;
			} else
				PD6fCz5B = Integer.parseInt(vLOztC4s);
			WlbmKYk8 = true;
		}
		if (is != null) {
			File hgxTiMV1 = File.createTempFile("tmp", ".jp2");
			hgxTiMV1.deleteOnExit();
			FileOutputStream bP17HYjI = new FileOutputStream(hgxTiMV1);
			sourceFile = hgxTiMV1.getAbsolutePath();
			IOUtils.copyStream(is, bP17HYjI);
		}
		Kdu_simple_file_source FlhXXyaJ = null;
		Jp2_family_src b7QKxgFd = new Jp2_family_src();
		Jpx_source cqHdxELj = new Jpx_source();
		Kdu_region_compositor IgKt0Xbu = null;
		BufferedImage uKSNyzxK = null;
		try {
			b7QKxgFd.Open(sourceFile);
			int b7q9qpwg = cqHdxELj.Open(b7QKxgFd, true);
			if (b7q9qpwg < 0) {
				b7QKxgFd.Close();
				cqHdxELj.Close();
				FlhXXyaJ = new Kdu_simple_file_source(sourceFile);
			}
			IgKt0Xbu = new Kdu_region_compositor();
			if (FlhXXyaJ != null)
				IgKt0Xbu.Create(FlhXXyaJ);
			else
				IgKt0Xbu.Create(cqHdxELj);
			Kdu_dims HPVOX9sZ = new Kdu_dims();
			IgKt0Xbu.Get_total_composition_dims(HPVOX9sZ);
			Kdu_coords YqvcQTyw = HPVOX9sZ.Access_size();
			Kdu_coords KIxC6KpM = HPVOX9sZ.Access_pos();
			if (CxLhKFDp)
				qP34toop = KIxC6KpM.Get_x() + (int) Math.round(VvPiJNc5 * YqvcQTyw.Get_x());
			if (fyYwCgY0)
				AzjhYzyS = KIxC6KpM.Get_y() + (int) Math.round(KS0emncz * YqvcQTyw.Get_y());
			if (VSZRvrAA)
				N85686kP = (int) Math.round(cbcWaDCg * YqvcQTyw.Get_y());
			if (TLeew5mp)
				PD6fCz5B = (int) Math.round(JvZ9p4SE * YqvcQTyw.Get_x());
			if (WlbmKYk8) {
				YqvcQTyw.Set_x(PD6fCz5B);
				YqvcQTyw.Set_y(N85686kP);
				KIxC6KpM.Set_x(qP34toop);
				KIxC6KpM.Set_y(AzjhYzyS);
			}
			int FbPvNYmS = 1 << params.getLevelReductionFactor();
			YqvcQTyw.Set_x(YqvcQTyw.Get_x());
			YqvcQTyw.Set_y(YqvcQTyw.Get_y());
			KIxC6KpM.Set_x(KIxC6KpM.Get_x() / FbPvNYmS - (1 / FbPvNYmS - 1) / 2);
			KIxC6KpM.Set_y(KIxC6KpM.Get_y() / FbPvNYmS - (1 / FbPvNYmS - 1) / 2);
			Kdu_dims PxcMhZUP = new Kdu_dims();
			PxcMhZUP.Assign(HPVOX9sZ);
			PxcMhZUP.Access_size().Set_x(YqvcQTyw.Get_x());
			PxcMhZUP.Access_size().Set_y(YqvcQTyw.Get_y());
			IgKt0Xbu.Add_compositing_layer(0, PxcMhZUP, PxcMhZUP);
			if (params.getRotationDegree() == 90)
				IgKt0Xbu.Set_scale(true, false, true, 1.0F);
			else if (params.getRotationDegree() == 180)
				IgKt0Xbu.Set_scale(false, true, true, 1.0F);
			else if (params.getRotationDegree() == 270)
				IgKt0Xbu.Set_scale(true, true, false, 1.0F);
			else
				IgKt0Xbu.Set_scale(false, false, false, 1.0F);
			IgKt0Xbu.Get_total_composition_dims(PxcMhZUP);
			Kdu_coords bAJpqGSE = PxcMhZUP.Access_size();
			IgKt0Xbu.Set_buffer_surface(PxcMhZUP);
			int[] jBeduYnU = new int[bAJpqGSE.Get_x() * bAJpqGSE.Get_y()];
			Kdu_compositor_buf wFM31TC7 = IgKt0Xbu.Get_composition_buffer(PxcMhZUP);
			int WS00VrXD = 0;
			int[] POlPHltd = null;
			Kdu_dims dgEptkSe = new Kdu_dims();
			while (IgKt0Xbu.Process(100000, dgEptkSe)) {
				Kdu_coords dEf9iU8w = dgEptkSe.Access_pos();
				Kdu_coords S02Z9MVp = dgEptkSe.Access_size();
				dEf9iU8w.Subtract(PxcMhZUP.Access_pos());
				int hE8BwDxq = S02Z9MVp.Get_x() * S02Z9MVp.Get_y();
				if (hE8BwDxq == 0)
					continue;
				if (hE8BwDxq > WS00VrXD) {
					WS00VrXD = hE8BwDxq;
					POlPHltd = new int[WS00VrXD];
				}
				wFM31TC7.Get_region(dgEptkSe, POlPHltd);
				int praGjZuS = dEf9iU8w.Get_x() + dEf9iU8w.Get_y() * bAJpqGSE.Get_x();
				int M7svhboe = 0;
				int roQsuVzi = bAJpqGSE.Get_x() - S02Z9MVp.Get_x();
				for (int MFwE7RmB = 0; MFwE7RmB < S02Z9MVp.Get_y(); MFwE7RmB++, praGjZuS += roQsuVzi) {
					for (int BduTuO71 = 0; BduTuO71 < S02Z9MVp.Get_x(); BduTuO71++) {
						jBeduYnU[praGjZuS++] = POlPHltd[M7svhboe++];
					}
				}
			}
			if (params.getRotationDegree() == 90 || params.getRotationDegree() == 270)
				uKSNyzxK = new BufferedImage(YqvcQTyw.Get_y(), YqvcQTyw.Get_x(), BufferedImage.TYPE_INT_RGB);
			else
				uKSNyzxK = new BufferedImage(YqvcQTyw.Get_x(), YqvcQTyw.Get_y(), BufferedImage.TYPE_INT_RGB);
			uKSNyzxK.setRGB(0, 0, bAJpqGSE.Get_x(), bAJpqGSE.Get_y(), jBeduYnU, 0, bAJpqGSE.Get_x());
			if (IgKt0Xbu != null)
				IgKt0Xbu.Native_destroy();
			cqHdxELj.Native_destroy();
			b7QKxgFd.Native_destroy();
			if (FlhXXyaJ != null)
				FlhXXyaJ.Native_destroy();
			return uKSNyzxK;
		} catch (KduException cxLTTmtm) {
			cxLTTmtm.printStackTrace();
			throw new DjatokaException(cxLTTmtm);
		} catch (Exception F6jnAzTO) {
			F6jnAzTO.printStackTrace();
			throw new DjatokaException(F6jnAzTO);
		}
	}

}