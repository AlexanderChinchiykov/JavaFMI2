

public class Trainee implements Observer {
    private String name;

    public Trainee(String name) {
        this.name = name;
    }

    @Override
    public void update(TrainingProgram trainingProgram) {
        System.out.println(name + " has been notified of the new training program: " + trainingProgram.execute());
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Trainee trainee = (Trainee) obj;
        return name.equals(trainee.name);
    }
}
