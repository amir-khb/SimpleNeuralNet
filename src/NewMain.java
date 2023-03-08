 class Main {
    public static void main(String[] args) {
        double input1 = 0.4;
        double input2 = 0.3;
        double output = 0.69;

        NeuralNetworkSimple nn = new NeuralNetworkSimple(2, 1, 3);

        for (int i = 0; i < 500000; i++) {
            nn.train(new double[]{input1, input2}, new double[]{output});
            
            //Remove if statement after testing
            if (i == 2500) {
                System.out.println("test");
            }
        }

        double[] prediction = nn.predict(new double[]{input1, input2});
        System.out.println(prediction[0]);
    }
}
