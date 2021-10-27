class n11228956 {
	protected Model loadModel(URL ODw20EFc, String bJHlK7Sf, SourceModelType IW9mRCxt, URL OEjxdn9K, String lHrLRKIB,
			float FBrEGZbz, int x8K0AHOu, AppearanceFactory GKRQTTRl, GeometryFactory vGSuWAFb, NodeFactory uS7Fn55s,
			AnimationFactory WjMdvlTZ, SpecialItemsHandler jWEW23T7, Model ioBknIaa)
			throws IOException, IncorrectFormatException, ParsingException {
		boolean rNYZ5GK7 = IW9mRCxt.getConvertFlag(x8K0AHOu);
		switch (IW9mRCxt) {
		case AC3D:
			AC3DPrototypeLoader.load(ODw20EFc.openStream(), OEjxdn9K, GKRQTTRl, vGSuWAFb, uS7Fn55s, true, ioBknIaa,
					jWEW23T7);
			break;
		case ASE:
			AseReader.load(ODw20EFc.openStream(), OEjxdn9K, GKRQTTRl, vGSuWAFb, rNYZ5GK7, FBrEGZbz, uS7Fn55s, WjMdvlTZ,
					jWEW23T7, ioBknIaa);
			break;
		case BSP:
			BSPPrototypeLoader.load(ODw20EFc.openStream(), bJHlK7Sf, OEjxdn9K, vGSuWAFb, true, 0.03f, GKRQTTRl,
					uS7Fn55s, ioBknIaa, GroupType.BSP_TREE, jWEW23T7);
			break;
		case CAL3D:
			break;
		case COLLADA:
			rNYZ5GK7 = true;
			COLLADALoader.load(OEjxdn9K, ODw20EFc.openStream(), GKRQTTRl, vGSuWAFb, rNYZ5GK7, FBrEGZbz, uS7Fn55s,
					WjMdvlTZ, jWEW23T7, ioBknIaa);
			break;
		case MD2:
			MD2File.load(ODw20EFc.openStream(), OEjxdn9K, GKRQTTRl, lHrLRKIB, vGSuWAFb, rNYZ5GK7, FBrEGZbz, uS7Fn55s,
					WjMdvlTZ, jWEW23T7, ioBknIaa);
			break;
		case MD3:
			MD3File.load(ODw20EFc.openStream(), OEjxdn9K, GKRQTTRl, vGSuWAFb, rNYZ5GK7, FBrEGZbz, uS7Fn55s, WjMdvlTZ,
					jWEW23T7, ioBknIaa);
			break;
		case MD5: {
			Object[][][] s9okvbjo = MD5MeshReader.load(ODw20EFc.openStream(), OEjxdn9K, GKRQTTRl, lHrLRKIB, vGSuWAFb,
					rNYZ5GK7, FBrEGZbz, uS7Fn55s, WjMdvlTZ, jWEW23T7, ioBknIaa);
			((SpecialItemsHandlerImpl) jWEW23T7).flush();
			List<URL> tqkb45A1 = new ResourceLocator(OEjxdn9K).findAllResources("md5anim", true, false);
			for (URL RARN8LEh : tqkb45A1) {
				String T51vfTvQ = LoaderUtils.extractFilenameWithoutExt(RARN8LEh);
				MD5AnimationReader.load(RARN8LEh.openStream(), T51vfTvQ, OEjxdn9K, GKRQTTRl, vGSuWAFb, rNYZ5GK7,
						FBrEGZbz, uS7Fn55s, ioBknIaa.getShapes(), s9okvbjo, WjMdvlTZ, jWEW23T7, ioBknIaa);
			}
		}
			break;
		case MS3D:
			break;
		case OBJ:
			GroupNode b0mVtkB2 = ioBknIaa;
			if (FBrEGZbz != 1.0f) {
				TransformGroup GP8so5Mi = new TransformGroup();
				GP8so5Mi.getTransform().setScale(FBrEGZbz);
				ioBknIaa.addChild(GP8so5Mi);
				ioBknIaa.setMainGroup(GP8so5Mi);
				b0mVtkB2 = GP8so5Mi;
			}
			OBJPrototypeLoader.load(ODw20EFc.openStream(), OEjxdn9K, GKRQTTRl, lHrLRKIB, vGSuWAFb, rNYZ5GK7, FBrEGZbz,
					uS7Fn55s, jWEW23T7, b0mVtkB2);
			break;
		case TDS:
			TDSFile.load(ODw20EFc.openStream(), OEjxdn9K, GKRQTTRl, vGSuWAFb, rNYZ5GK7, uS7Fn55s, WjMdvlTZ, jWEW23T7,
					ioBknIaa);
		}
		return (ioBknIaa);
	}

}