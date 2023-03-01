import java.util.Random;

public class NeuralNetworkSimple {

    // Weights of input-output and hidden layer
    private double[][] weights;

    // Biases of the weights
    private double[] biases;

    private final double learningRate = 0.01;

    public NeuralNetworkSimple(int inputSize, int hiddenSize, int outputSize) {
        // Initialize weights randomly
        Random rand = new Random();
        weights = new double[][] {
            {rand.nextDouble(), rand.nextDouble()},
            {rand.nextDouble(), rand.nextDouble()},
            {rand.nextDouble(), rand.nextDouble()}
        };

        // Initialize biases to zero
        biases = new double[] {0, 0, 0};
    }

    private double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    private double sigmoidDerivative(double x) {
        double s = sigmoid(x);
        return s * (1.0 - s);
    }

    public void train(double[] inputs, double[] targets) {
        // Calculate hidden neurons
        double[] hidden = new double[2];
        for (int i = 0; i < hidden.length; i++) {
            hidden[i] = sigmoid(
                inputs[0] * weights[0][i] + inputs[1] * weights[1][i] + biases[0]
            );
        }

        // Predict the output and calculate error
        double predictedOutput = hidden[0] * weights[2][0] + hidden[1] * weights[2][1] + biases[1];
        double error = targets[0] - predictedOutput;

        // Calculate gradients and deltas for output and hidden layer
        double[] gradients = new double[3];
        double[] deltas = new double[3];
        gradients[2] = sigmoidDerivative(predictedOutput) * error * learningRate;
        deltas[2] = gradients[2];
        for (int i = 0; i < hidden.length; i++) {
            gradients[i] = sigmoidDerivative(hidden[i]) * weights[2][i] * gradients[2] * learningRate;
            deltas[i] = gradients[i] * inputs[i];
        }

        // Update weights and biases
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[i].length; j++) {
                weights[i][j] += deltas[i] * inputs[j];
            }
        }
        for (int i = 0; i < biases.length; i++) {
            biases[i] += gradients[i];
        }
    }

    public double[] predict(double[] inputs) {
        // Calculate hidden neurons
        double[] hidden = new double[2];
        for (int i = 0; i < hidden.length; i++) {
            hidden[i] = sigmoid(
                inputs[0] * weights[0][i] + inputs[1] * weights[1][i] + biases[0]
            );
        }

        // Predict the output
        double predictedOutput = hidden[0] * weights[2][0] + hidden[1] * weights[2][1] + biases[1];
        return new double[] {predictedOutput};
    }
}
