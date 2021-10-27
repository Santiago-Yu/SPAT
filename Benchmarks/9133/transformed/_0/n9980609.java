class n9980609 {
	public static void copyResource(Resource sKoS3FiY, Resource jZzOXc9n, FilterSetCollection AcJPeQ8Q, Vector wIyKr7qR,
			boolean JpOHjCAz, boolean XwOTUyXL, boolean GiiEI5dQ, String UjO6T8TI, String Ja2aDlJz, Project O2TBrtEV)
			throws IOException {
		if (!(JpOHjCAz || SelectorUtils.isOutOfDate(sKoS3FiY, jZzOXc9n,
				FileUtils.getFileUtils().getFileTimestampGranularity()))) {
			return;
		}
		final boolean rTPoTgF6 = (AcJPeQ8Q != null && AcJPeQ8Q.hasFilters());
		final boolean fCtKXbeo = (wIyKr7qR != null && wIyKr7qR.size() > 0);
		if (rTPoTgF6) {
			BufferedReader tnfPu2x2 = null;
			BufferedWriter HcEQBBGV = null;
			try {
				InputStreamReader YpWCYR3I = null;
				if (UjO6T8TI == null) {
					YpWCYR3I = new InputStreamReader(sKoS3FiY.getInputStream());
				} else {
					YpWCYR3I = new InputStreamReader(sKoS3FiY.getInputStream(), UjO6T8TI);
				}
				tnfPu2x2 = new BufferedReader(YpWCYR3I);
				OutputStream gEhyMrW3 = getOutputStream(jZzOXc9n, GiiEI5dQ, O2TBrtEV);
				OutputStreamWriter f1CNoaSb;
				if (Ja2aDlJz == null) {
					f1CNoaSb = new OutputStreamWriter(gEhyMrW3);
				} else {
					f1CNoaSb = new OutputStreamWriter(gEhyMrW3, Ja2aDlJz);
				}
				HcEQBBGV = new BufferedWriter(f1CNoaSb);
				if (fCtKXbeo) {
					ChainReaderHelper U4euv3Iu = new ChainReaderHelper();
					U4euv3Iu.setBufferSize(FileUtils.BUF_SIZE);
					U4euv3Iu.setPrimaryReader(tnfPu2x2);
					U4euv3Iu.setFilterChains(wIyKr7qR);
					U4euv3Iu.setProject(O2TBrtEV);
					Reader wDUxALA1 = U4euv3Iu.getAssembledReader();
					tnfPu2x2 = new BufferedReader(wDUxALA1);
				}
				LineTokenizer tjcPDHFi = new LineTokenizer();
				tjcPDHFi.setIncludeDelims(true);
				String asvYp2IL = null;
				String lqwErsi7 = tjcPDHFi.getToken(tnfPu2x2);
				while (lqwErsi7 != null) {
					if (lqwErsi7.length() == 0) {
						HcEQBBGV.newLine();
					} else {
						asvYp2IL = AcJPeQ8Q.replaceTokens(lqwErsi7);
						HcEQBBGV.write(asvYp2IL);
					}
					lqwErsi7 = tjcPDHFi.getToken(tnfPu2x2);
				}
			} finally {
				FileUtils.close(HcEQBBGV);
				FileUtils.close(tnfPu2x2);
			}
		} else if (fCtKXbeo || (UjO6T8TI != null && !UjO6T8TI.equals(Ja2aDlJz))
				|| (UjO6T8TI == null && Ja2aDlJz != null)) {
			BufferedReader ZwYGycoQ = null;
			BufferedWriter omzQIvym = null;
			try {
				InputStreamReader cPRpoDTz = null;
				if (UjO6T8TI == null) {
					cPRpoDTz = new InputStreamReader(sKoS3FiY.getInputStream());
				} else {
					cPRpoDTz = new InputStreamReader(sKoS3FiY.getInputStream(), UjO6T8TI);
				}
				ZwYGycoQ = new BufferedReader(cPRpoDTz);
				OutputStream f4Q56mIL = getOutputStream(jZzOXc9n, GiiEI5dQ, O2TBrtEV);
				OutputStreamWriter V5SHm6FA;
				if (Ja2aDlJz == null) {
					V5SHm6FA = new OutputStreamWriter(f4Q56mIL);
				} else {
					V5SHm6FA = new OutputStreamWriter(f4Q56mIL, Ja2aDlJz);
				}
				omzQIvym = new BufferedWriter(V5SHm6FA);
				if (fCtKXbeo) {
					ChainReaderHelper lyOxDHe3 = new ChainReaderHelper();
					lyOxDHe3.setBufferSize(FileUtils.BUF_SIZE);
					lyOxDHe3.setPrimaryReader(ZwYGycoQ);
					lyOxDHe3.setFilterChains(wIyKr7qR);
					lyOxDHe3.setProject(O2TBrtEV);
					Reader EKNDXQdd = lyOxDHe3.getAssembledReader();
					ZwYGycoQ = new BufferedReader(EKNDXQdd);
				}
				char[] fYW6sKNi = new char[FileUtils.BUF_SIZE];
				while (true) {
					int zbkphUQF = ZwYGycoQ.read(fYW6sKNi, 0, fYW6sKNi.length);
					if (zbkphUQF == -1) {
						break;
					}
					omzQIvym.write(fYW6sKNi, 0, zbkphUQF);
				}
			} finally {
				FileUtils.close(omzQIvym);
				FileUtils.close(ZwYGycoQ);
			}
		} else if (sKoS3FiY.as(FileProvider.class) != null && jZzOXc9n.as(FileProvider.class) != null) {
			File PPKbRdWc = ((FileProvider) sKoS3FiY.as(FileProvider.class)).getFile();
			File mbBdY3bp = ((FileProvider) jZzOXc9n.as(FileProvider.class)).getFile();
			File VwdW6FRI = mbBdY3bp.getParentFile();
			if (VwdW6FRI != null && !VwdW6FRI.isDirectory() && !mbBdY3bp.getParentFile().mkdirs()) {
				throw new IOException("failed to create the parent directory" + " for " + mbBdY3bp);
			}
			FileInputStream fEk067KC = null;
			FileOutputStream PqWrrebo = null;
			FileChannel BWQSkTys = null;
			FileChannel IBQroaQs = null;
			try {
				fEk067KC = new FileInputStream(PPKbRdWc);
				PqWrrebo = new FileOutputStream(mbBdY3bp);
				BWQSkTys = fEk067KC.getChannel();
				IBQroaQs = PqWrrebo.getChannel();
				long obU0Ble5 = 0;
				long WG3RknHU = BWQSkTys.size();
				while (obU0Ble5 < WG3RknHU) {
					obU0Ble5 += BWQSkTys.transferTo(obU0Ble5, FileUtils.BUF_SIZE, IBQroaQs);
				}
			} finally {
				FileUtils.close(BWQSkTys);
				FileUtils.close(IBQroaQs);
				FileUtils.close(PqWrrebo);
				FileUtils.close(fEk067KC);
			}
		} else {
			InputStream DQn3aoyN = null;
			OutputStream n7j3f31Q = null;
			try {
				DQn3aoyN = sKoS3FiY.getInputStream();
				n7j3f31Q = getOutputStream(jZzOXc9n, GiiEI5dQ, O2TBrtEV);
				byte[] Wx011qzZ = new byte[FileUtils.BUF_SIZE];
				int YaKXKp7M = 0;
				do {
					n7j3f31Q.write(Wx011qzZ, 0, YaKXKp7M);
					YaKXKp7M = DQn3aoyN.read(Wx011qzZ, 0, Wx011qzZ.length);
				} while (YaKXKp7M != -1);
			} finally {
				FileUtils.close(n7j3f31Q);
				FileUtils.close(DQn3aoyN);
			}
		}
		if (XwOTUyXL) {
			Touchable SQsN1CSj = (Touchable) jZzOXc9n.as(Touchable.class);
			if (SQsN1CSj != null) {
				setLastModified(SQsN1CSj, sKoS3FiY.getLastModified());
			}
		}
	}

}