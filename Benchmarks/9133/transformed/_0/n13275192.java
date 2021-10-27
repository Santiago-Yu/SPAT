class n13275192 {
	public static void main(String[] vPtycNtk) throws Exception {
		BufferedImage YxmhaaV5 = ImageIO.read(BitmapFont.class.getResource("Candara-38-Bold.png"));
		URL jCVYi1C4 = BitmapFontData.class.getResource("Candara-38-Bold.fnt");
		BitmapFontData NQkD0nLZ = new BitmapFontData(jCVYi1C4.openStream(), true);
		BitmapFont XDOgqNdf = new BitmapFont(NQkD0nLZ, true);
		XDOgqNdf.drawMultiLine("Hello world\nthis is a\ntest!!!", 100, 100);
		VertexData e2QYYfxZ = XDOgqNdf.createVertexData();
		Display.setDisplayMode(new DisplayMode(640, 480));
		Display.create();
		RenderPass PDOteOzN = new RenderPass();
		PDOteOzN.setClearMask(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		PDOteOzN.setClearColor(new Color4f(0.3f, 0.4f, 0.5f, 1f));
		PDOteOzN.setView(View.createOrtho(0, 640, 0, 480, -1000, 1000));
		ByteBuffer[][] FTAsksFN = { { TextureLoader.getImageData(YxmhaaV5) } };
		Texture SyyliIOs = new Texture(TextureType.TEXTURE_2D, 4, YxmhaaV5.getWidth(), YxmhaaV5.getHeight(), 0,
				Format.BGRA, FTAsksFN, false, false);
		Shape yUHSif2f = new Shape(e2QYYfxZ);
		yUHSif2f.getState().setUnit(0, new Unit(SyyliIOs));
		yUHSif2f.getState().setBlendEnabled(true);
		yUHSif2f.getState().setBlendSrcFunc(BlendSrcFunc.SRC_ALPHA);
		yUHSif2f.getState().setBlendDstFunc(BlendDstFunc.ONE_MINUS_SRC_ALPHA);
		PDOteOzN.getRootNode().addShape(yUHSif2f);
		Renderer UhGOBJ3M = new Renderer(new SceneGraph(PDOteOzN));
		while (!Display.isCloseRequested()) {
			UhGOBJ3M.render();
			Display.update();
		}
		Display.destroy();
	}

}