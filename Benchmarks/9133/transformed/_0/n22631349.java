class n22631349 {
	public static Model loadPrecomputedModel(URL TXDMiP9v) {
		ArrayList<Geometry[]> UXuFe56Q = new ArrayList<Geometry[]>();
		if (TXDMiP9v.toExternalForm().endsWith(".amo")) {
			try {
				BufferedReader mvKTUbbQ = new BufferedReader(new InputStreamReader(TXDMiP9v.openStream()));
				String qqOTYLFd = mvKTUbbQ.readLine();
				qqOTYLFd = TXDMiP9v.toExternalForm().substring(0, TXDMiP9v.toExternalForm().lastIndexOf("/")) + "/"
						+ qqOTYLFd;
				Model VltuAThQ = loadOBJFrames(ModelLoader.getInstance(), qqOTYLFd, UXuFe56Q);
				ArrayList<ModelAnimation> dLbcBie6 = new ArrayList<ModelAnimation>();
				String oe0hQR7P;
				while ((oe0hQR7P = mvKTUbbQ.readLine()) != null) {
					StringTokenizer fQOnOAId = new StringTokenizer(oe0hQR7P);
					String RhOXwfVy = fQOnOAId.nextToken();
					int lr0PlxDU = Integer.valueOf(fQOnOAId.nextToken());
					int NToPYfzU = Integer.valueOf(fQOnOAId.nextToken());
					fQOnOAId.nextToken();
					int kzbyFcKA = NToPYfzU - lr0PlxDU + 1;
					PrecomputedAnimationKeyFrameController[] aPoAChux = new PrecomputedAnimationKeyFrameController[VltuAThQ
							.getShapesCount()];
					for (int kMwP0Ykp = 0; kMwP0Ykp < VltuAThQ.getShapesCount(); kMwP0Ykp++) {
						Shape3D dxCNojl3 = VltuAThQ.getShape(kMwP0Ykp);
						PrecomputedAnimationKeyFrame[] zez3ve7l = new PrecomputedAnimationKeyFrame[kzbyFcKA];
						int qpWKikUA = 0;
						for (int DInLrflq = lr0PlxDU; DInLrflq <= NToPYfzU; DInLrflq++) {
							zez3ve7l[qpWKikUA++] = new PrecomputedAnimationKeyFrame(UXuFe56Q.get(DInLrflq)[kMwP0Ykp]);
						}
						aPoAChux[kMwP0Ykp] = new PrecomputedAnimationKeyFrameController(zez3ve7l, dxCNojl3);
					}
					dLbcBie6.add(new ModelAnimation(RhOXwfVy, kzbyFcKA, 25f, aPoAChux));
				}
				VltuAThQ.setAnimations(dLbcBie6.toArray(new ModelAnimation[dLbcBie6.size()]));
				return (VltuAThQ);
			} catch (FileNotFoundException TvHeSuHL) {
				TvHeSuHL.printStackTrace();
				return (null);
			} catch (IOException GqI0Vnq9) {
				GqI0Vnq9.printStackTrace();
				return (null);
			}
		}
		{
			Model Wrd60et5 = loadOBJFrames(ModelLoader.getInstance(), TXDMiP9v.toExternalForm(), UXuFe56Q);
			PrecomputedAnimationKeyFrameController[] jpAl7lIr = new PrecomputedAnimationKeyFrameController[Wrd60et5
					.getShapesCount()];
			for (int LMAglWeQ = 0; LMAglWeQ < Wrd60et5.getShapesCount(); LMAglWeQ++) {
				Shape3D QaRlWf41 = Wrd60et5.getShape(LMAglWeQ);
				PrecomputedAnimationKeyFrame[] Ou5c8XLe = new PrecomputedAnimationKeyFrame[UXuFe56Q.size()];
				for (int VjzI63Ld = 0; VjzI63Ld < UXuFe56Q.size(); VjzI63Ld++) {
					Ou5c8XLe[VjzI63Ld] = new PrecomputedAnimationKeyFrame(UXuFe56Q.get(VjzI63Ld)[LMAglWeQ]);
				}
				jpAl7lIr[LMAglWeQ] = new PrecomputedAnimationKeyFrameController(Ou5c8XLe, QaRlWf41);
			}
			ModelAnimation[] cca46EtN = new ModelAnimation[] {
					new ModelAnimation("default", UXuFe56Q.size(), 25f, jpAl7lIr) };
			Wrd60et5.setAnimations(cca46EtN);
			return (Wrd60et5);
		}
	}

}