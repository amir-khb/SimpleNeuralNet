///**TODO
// * MAKE THE INPUTS, OUTPUTS, WEIGHTS, AND BIASES INTO ARRAYS
// */
//
//public class NeuralNetworkSimple {
//
//	//Weights of input output and hidden layer
//	double x1h1, x1h2, x2h1, x2h2, h1o1, h2o1;
//
//	//BIASES OF THE WEIGHTS
//	double h1o1b, h2o1b, x1h1b, x1h2b, x2h1b, x2h2b;
//	double learning_rate = 0.01;
//
//	//Sigmoid function and its derivative
//	private double sigmoid(double x) {
//		return 1 / (1 + Math.exp(-x));
//	}
//
//	private double sigmoidDerivative(double x) {
//		return x * (1 - x);
//	}
//
//	//Round a double with 0.01 precision
//	private double roundRandomNum(double a) {
//		return Math.round(a * 100.0) / 100.0;
//
//	}
//
//	public NeuralNetworkSimple() {
//
//
//		x1h1 = roundRandomNum(Math.random()) / 10;
//		x1h2 = roundRandomNum(Math.random()) / 10;
//		x2h1 = roundRandomNum(Math.random()) / 10;
//		x2h2 = roundRandomNum(Math.random()) / 10;
//		h1o1 = roundRandomNum(Math.random()) / 10;
//		h2o1 = roundRandomNum(Math.random()) / 10;
//
//		h1o1b = roundRandomNum(Math.random()) / 10;
//		h2o1b = roundRandomNum(Math.random()) / 10;
//		x1h1b = roundRandomNum(Math.random()) / 10;
//		x1h2b = roundRandomNum(Math.random()) / 10;
//		x2h1b = roundRandomNum(Math.random()) / 10;
//		x2h2b = roundRandomNum(Math.random()) / 10;
//	}
//
//	public void train(double in1, double in2, double o1) {
//
//		//CALCULATE HIDDEN NEURONS
//
//		double hidden1 = (in1 * x1h1) + x1h1b + (in2 * x2h1) + x2h1b;
//		double hidden2 = (in1 * x1h2) + x1h2b + (in2 * x2h2) + x2h2b;
//		hidden1 = sigmoid(hidden1);
//		hidden2 = sigmoid(hidden2);
//
//		//PREDICT THE OUTPUT AND CALCULATE ERROR
//
//		double predictedOutput = (hidden1 * h1o1) + h1o1b + (hidden2 * h2o1) + h2o1b;
//		double error = o1 - predictedOutput;
//
//		//CALCULATE GRADIENT ADN DELTA FOR OUTPUT AND HIDDEN LAYER
//
//		double gradient_ho = sigmoidDerivative(predictedOutput) * error * learning_rate;
//		double delta_h1o1 = gradient_ho * hidden1;
//		double delta_h2o1 = gradient_ho * hidden2;
//
//		//ADD THE GRADIENT AND DELTA TO THE BIAS AND WEIGHT BETWEEN HIDDEN AND OUTPUT LAYER
//
//		h1o1 += delta_h1o1;
//		h2o1 += delta_h2o1;
//		h1o1b += gradient_ho;
//		h2o1b += gradient_ho;
//
//		//CALCULATE GRADIENT AND DELTA BETWEEN INPUT AND HIDDEN LAYER
//
//		double gradient_ih1 = sigmoidDerivative(hidden1) * learning_rate * h1o1;
//		double gradient_ih2 = sigmoidDerivative(hidden2) * learning_rate * h2o1;
//
//		double delta_ih1 = gradient_ih1 * in1;
//		double delta_ih2 = gradient_ih2 * in2;
//
//		//ADD THE GRADIENT AND DELTA TO THE BIAS AND WEIGHT BETWEEN HIDDEN AND INPUT LAYER
//
//		x1h1b += gradient_ih1;
//		x2h1b += gradient_ih1;
//
//		x1h2b += gradient_ih2;
//		x2h2b += gradient_ih2;
//
//		x1h1 += delta_ih1;
//		x1h2 += delta_ih1;
//
//		x2h1 += delta_ih2;
//		x2h2 += delta_ih2;
//	}
//
//	public double predict(double in1, double in2) {
//
//		//PREDICT THE OUTPUT BASED ON OUR INPUTS
//
//		double hidden1 = (in1 * x1h1) + x1h1b + (in2 * x2h1) + x2h1b;
//		double hidden2 = (in1 * x1h2) + x1h2b + (in2 * x2h2) + x2h2b;
//		hidden1 = sigmoid(hidden1);
//		hidden2 = sigmoid(hidden2);
//		return (hidden1 * h1o1) + h1o1b + (hidden2 * h2o1) + h2o1b;
//	}
//}