package nativepkg;

public class NT {

	static {
		System.loadLibrary("nativepkg.ddl");
	}
	
	public static native void sayHello();
	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		/// new NativeTest().sayHello();
	}
}
