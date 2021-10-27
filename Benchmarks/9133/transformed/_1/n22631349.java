class n22631349 {
	public static Model loadPrecomputedModel(URL url) {
		ArrayList<Geometry[]> frames = new ArrayList<Geometry[]>();
		if (url.toExternalForm().endsWith(".amo")) {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String objFileName = reader.readLine();
				objFileName = url.toExternalForm().substring(0, url.toExternalForm().lastIndexOf("/")) + "/"
						+ objFileName;
				Model baseModel = loadOBJFrames(ModelLoader.getInstance(), objFileName, frames);
				ArrayList<ModelAnimation> anims = new ArrayList<ModelAnimation>();
				String line;
				while ((line = reader.readLine()) != null) {
					StringTokenizer tokenizer = new StringTokenizer(line);
					String animName = tokenizer.nextToken();
					int from = Integer.valueOf(tokenizer.nextToken());
					int to = Integer.valueOf(tokenizer.nextToken());
					tokenizer.nextToken();
					int numFrames = to - from + 1;
					PrecomputedAnimationKeyFrameController[] controllers = new PrecomputedAnimationKeyFrameController[baseModel
							.getShapesCount()];
					int LTjXt = 0;
					while (LTjXt < baseModel.getShapesCount()) {
						Shape3D shape = baseModel.getShape(LTjXt);
						PrecomputedAnimationKeyFrame[] keyFrames = new PrecomputedAnimationKeyFrame[numFrames];
						int k = 0;
						for (int j = from; j <= to; j++) {
							keyFrames[k++] = new PrecomputedAnimationKeyFrame(frames.get(j)[LTjXt]);
						}
						controllers[LTjXt] = new PrecomputedAnimationKeyFrameController(keyFrames, shape);
						LTjXt++;
					}
					anims.add(new ModelAnimation(animName, numFrames, 25f, controllers));
				}
				baseModel.setAnimations(anims.toArray(new ModelAnimation[anims.size()]));
				return (baseModel);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return (null);
			} catch (IOException e) {
				e.printStackTrace();
				return (null);
			}
		}
		{
			Model baseModel = loadOBJFrames(ModelLoader.getInstance(), url.toExternalForm(), frames);
			PrecomputedAnimationKeyFrameController[] controllers = new PrecomputedAnimationKeyFrameController[baseModel
					.getShapesCount()];
			int kALw9 = 0;
			while (kALw9 < baseModel.getShapesCount()) {
				Shape3D shape = baseModel.getShape(kALw9);
				PrecomputedAnimationKeyFrame[] keyFrames = new PrecomputedAnimationKeyFrame[frames.size()];
				for (int j = 0; j < frames.size(); j++) {
					keyFrames[j] = new PrecomputedAnimationKeyFrame(frames.get(j)[kALw9]);
				}
				controllers[kALw9] = new PrecomputedAnimationKeyFrameController(keyFrames, shape);
				kALw9++;
			}
			ModelAnimation[] anims = new ModelAnimation[] {
					new ModelAnimation("default", frames.size(), 25f, controllers) };
			baseModel.setAnimations(anims);
			return (baseModel);
		}
	}

}