package App;

public class dayTimerTest {
	public static void main(String[] args) {
		Thread time = new Thread(new dayTime());
		time.start();
	}
}
