class n20149832 {
	@Override
	public void onCreate(Bundle nr74wE2U) {
		super.onCreate(nr74wE2U);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		try {
			URL AfwNvt1W = new URL("http://placekitten.com/g/500/250");
			HttpURLConnection AcdcDWTv = (HttpURLConnection) AfwNvt1W.openConnection();
			AcdcDWTv.setDoInput(true);
			AcdcDWTv.setConnectTimeout(3000);
			AcdcDWTv.setReadTimeout(5000);
			Bitmap qrqdDtc8 = BitmapFactory.decodeStream(AcdcDWTv.getInputStream());
			AcdcDWTv.disconnect();
			Bitmap ySh5IlHg = BitmapFactory.decodeResource(getResources(), R.drawable.frame500);
			Bitmap IHMAvPgO = Bitmap.createBitmap(ySh5IlHg.getWidth(), ySh5IlHg.getHeight(), Bitmap.Config.ARGB_8888);
			IHMAvPgO.eraseColor(Color.BLACK);
			Canvas mtXRgPYf = new Canvas(IHMAvPgO);
			mtXRgPYf.drawBitmap(qrqdDtc8, 125, 125, new Paint());
			mtXRgPYf.drawBitmap(ySh5IlHg, 0, 0, new Paint());
			Paint itOCqHqv = new Paint();
			itOCqHqv.setColor(Color.WHITE);
			itOCqHqv.setTypeface(Typeface.create(Typeface.SERIF, Typeface.BOLD));
			itOCqHqv.setTextAlign(Align.CENTER);
			itOCqHqv.setAntiAlias(true);
			itOCqHqv.setTextSize(36);
			mtXRgPYf.drawText("Cute", IHMAvPgO.getWidth() / 2, (IHMAvPgO.getHeight() / 2) + 140, itOCqHqv);
			itOCqHqv.setTextSize(24);
			mtXRgPYf.drawText("Some of us just haz it.", IHMAvPgO.getWidth() / 2, (IHMAvPgO.getHeight() / 2) + 180,
					itOCqHqv);
			ImageView P1iY9435 = (ImageView) this.findViewById(R.id.imageView);
			P1iY9435.setImageBitmap(IHMAvPgO);
		} catch (IOException OGsbmYu2) {
			OGsbmYu2.printStackTrace();
		}
	}

}