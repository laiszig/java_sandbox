public class Main {

    static class Dependency {
        String doWork() {
            return "Work was done!";
        }
    }

    static class Injected {
        private Dependency dependency;

        public Injected(Dependency dependency) {
            this.dependency = dependency;
        }

        void delegate(){
            System.out.println(dependency.doWork());
        }
    }

    public static void main(String[] args) {

        Injected injected = new Injected(new Dependency());
        injected.delegate();
    }
}