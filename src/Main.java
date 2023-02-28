public class Main {
	public static void main(String[] args) {

		double x1, x2, o1;
		x1 = 0.4;
		x2 = 0.3;
		o1 = 0.7;

		NeuralNetworkSimple nn = new NeuralNetworkSimple();

		for (int i = 0; i < 50000; i++) {
			nn.train(x1, x2, o1);
			if(i==2500){
				System.out.println("test");
			}

		}
		System.out.println(nn.predict(x1, x2));
	}
}