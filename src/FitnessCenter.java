import java.util.HashMap;
import java.util.Map;

public class FitnessCenter implements Subject{
    private static FitnessCenter instance;
    private Map<Trainee, TrainingProgram> traineePrograms = new HashMap<>();

    private FitnessCenter() {}

    public static synchronized FitnessCenter getInstance() {
        if (instance == null) {
            instance = new FitnessCenter();
        }
        return instance;
    }

    public void attach(Trainee trainee, TrainingProgram trainingProgram) {
        if (traineePrograms.containsKey(trainee)) {
            System.out.println("Trainee " + trainee.getName() + " is already registered.");
            return;
        }
        traineePrograms.put(trainee, trainingProgram);
    }

    public void detach(Trainee trainee) {
        traineePrograms.remove(trainee);
    }

    public void notifyObservers() {
        for (Map.Entry<Trainee, TrainingProgram> entry : traineePrograms.entrySet()) {
            entry.getKey().update(entry.getValue());
        }
    }

    public void setTrainingProgram(Trainee trainee, TrainingProgram trainingProgram) {
        traineePrograms.put(trainee, trainingProgram);
        notifyObservers();
    }

        public void assignTrainingProgram(Trainee trainee, TrainingStrategy strategy) {
            TrainingProgram program = strategy.selectTrainingProgram();
            attach(trainee, program);
        }


}
