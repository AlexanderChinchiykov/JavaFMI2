public class Main {
    public static void main(String[] args) {
        // Singleton: Get the single instance of FitnessCenter
        FitnessCenter fitnessCenter = FitnessCenter.getInstance();

        // Create trainees
        Trainee trainee1 = new Trainee("Katq");
        Trainee trainee2 = new Trainee("Krasimir");

        // Create basic training program
        TrainingProgram basicProgram = new BasicTrainingProgram();

        // Create cardio training program
        TrainingProgram cardioProgram = new CardioTrainingProgram();

        // Attach basic training program to trainee1
        fitnessCenter.attach(trainee1, basicProgram);

        // Attach cardio training program to trainee2
        fitnessCenter.attach(trainee2, cardioProgram);

        fitnessCenter.attach(trainee1,cardioProgram);

        // Notify trainees of their programs
        fitnessCenter.notifyObservers();


        // Update training program for trainee1
        TrainingProgram newProgramForTrainee1 = new YogaDecorator(basicProgram);
        fitnessCenter.setTrainingProgram(trainee1, newProgramForTrainee1);
        TrainingProgram newProgramForTrainee2 = new YogaDecorator(cardioProgram);
        fitnessCenter.setTrainingProgram(trainee2, newProgramForTrainee2);


        // Notify trainees of their updated programs
        fitnessCenter.notifyObservers();
    }
}
