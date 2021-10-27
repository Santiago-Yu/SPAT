class n11228956 {
	protected Model loadModel(URL url, String filenameBase, SourceModelType modelType, URL baseURL, String skin,
			float scale, int flags, AppearanceFactory appFactory, GeometryFactory geomFactory, NodeFactory nodeFactory,
			AnimationFactory animFactory, SpecialItemsHandler siHandler, Model model)
			throws IOException, IncorrectFormatException, ParsingException {
		boolean convertZup2Yup = modelType.getConvertFlag(flags);
		switch (modelType) {
		case AC3D:
			AC3DPrototypeLoader.load(url.openStream(), baseURL, appFactory, geomFactory, nodeFactory, true, model,
					siHandler);
			break;
		case ASE:
			AseReader.load(url.openStream(), baseURL, appFactory, geomFactory, convertZup2Yup, scale, nodeFactory,
					animFactory, siHandler, model);
			break;
		case BSP:
			BSPPrototypeLoader.load(url.openStream(), filenameBase, baseURL, geomFactory, true, 0.03f, appFactory,
					nodeFactory, model, GroupType.BSP_TREE, siHandler);
			break;
		case CAL3D:
			break;
		case COLLADA:
			convertZup2Yup = true;
			COLLADALoader.load(baseURL, url.openStream(), appFactory, geomFactory, convertZup2Yup, scale, nodeFactory,
					animFactory, siHandler, model);
			break;
		case MD2:
			MD2File.load(url.openStream(), baseURL, appFactory, skin, geomFactory, convertZup2Yup, scale, nodeFactory,
					animFactory, siHandler, model);
			break;
		case MD3:
			MD3File.load(url.openStream(), baseURL, appFactory, geomFactory, convertZup2Yup, scale, nodeFactory,
					animFactory, siHandler, model);
			break;
		case MD5: {
			Object[][][] boneWeights = MD5MeshReader.load(url.openStream(), baseURL, appFactory, skin, geomFactory,
					convertZup2Yup, scale, nodeFactory, animFactory, siHandler, model);
			((SpecialItemsHandlerImpl) siHandler).flush();
			List<URL> animResources = new ResourceLocator(baseURL).findAllResources("md5anim", true, false);
			for (URL animURL : animResources) {
				String filename = LoaderUtils.extractFilenameWithoutExt(animURL);
				MD5AnimationReader.load(animURL.openStream(), filename, baseURL, appFactory, geomFactory,
						convertZup2Yup, scale, nodeFactory, model.getShapes(), boneWeights, animFactory, siHandler,
						model);
			}
		}
			break;
		case MS3D:
			break;
		case OBJ:
			GroupNode rootGroup = model;
			if (!(scale != 1.0f))
				;
			else {
				TransformGroup scaleGroup = new TransformGroup();
				scaleGroup.getTransform().setScale(scale);
				model.addChild(scaleGroup);
				model.setMainGroup(scaleGroup);
				rootGroup = scaleGroup;
			}
			OBJPrototypeLoader.load(url.openStream(), baseURL, appFactory, skin, geomFactory, convertZup2Yup, scale,
					nodeFactory, siHandler, rootGroup);
			break;
		case TDS:
			TDSFile.load(url.openStream(), baseURL, appFactory, geomFactory, convertZup2Yup, nodeFactory, animFactory,
					siHandler, model);
		}
		return (model);
	}

}