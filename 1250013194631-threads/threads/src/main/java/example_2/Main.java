package example_2;

class GeneratePDF implements Runnable{
    public void run() {
        // Logic
    }
}

class ProgressBar implements Runnable{
    public void run() {
        // Logic
    }
}

class Main {
    public static void main (String[] args) {
        GeneratePDF generatePDF = new GeneratePDF();
        Thread threadDoPdf = new Thread(generatePDF);
        threadDoPdf.start();
        ProgressBar progressBar = new ProgressBar();
        Thread threadDaBarra = new Thread(progressBar);
        threadDaBarra.start();
    }
}
