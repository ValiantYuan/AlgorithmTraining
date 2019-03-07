package functiontest.concurrenttools;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new A());
	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					cyclicBarrier.await();
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println(1);
			}
			
		}).start();
		try {
			cyclicBarrier.await();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(2);
	}
	static class A implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(3);
		}
		
	}
}
