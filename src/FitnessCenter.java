import java.util.HashMap;
import java.util.Map;

public class FitnessCenter implements Subject,FoodSubject{
    private static FitnessCenter instance;
    private Map<Trainee, TrainingProgram> traineePrograms = new HashMap<>();
    private Map<Trainee, FoodMenu> traineeFoodMenus = new HashMap<>();

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


    @Override
    public void attach(Trainee trainee, FoodMenu foodMenu) {
        if (traineeFoodMenus.containsKey(trainee)) {
            System.out.println("Trainee " + trainee.getName() + " already has a food menu.");
        } else {
            traineeFoodMenus.put(trainee, foodMenu);
            System.out.println("Trainee " + trainee.getName() + " received a food menu.");
        }
    }
    public void detach(Trainee trainee) {
        traineePrograms.remove(trainee);
        traineeFoodMenus.remove(trainee);
    }

    public void notifyObservers() {
        for (Map.Entry<Trainee, TrainingProgram> entry : traineePrograms.entrySet()) {
            entry.getKey().update(entry.getValue());
        }
        for (Map.Entry<Trainee, FoodMenu> entry : traineeFoodMenus.entrySet()) {
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
