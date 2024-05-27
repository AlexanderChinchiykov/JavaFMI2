public class Main {
    public static void main(String[] args) {

        FitnessCenter fitnessCenter = FitnessCenter.getInstance();


        Trainee trainee1 = new Trainee("Katq");
        Trainee trainee2 = new Trainee("Krasimir");
        Trainee trainee3=new Trainee("Ivan");


        TrainingProgram basicProgram = new BasicTrainingProgram();


        TrainingProgram cardioProgram = new CardioTrainingProgram();




        fitnessCenter.attach(trainee1, basicProgram);


        fitnessCenter.attach(trainee2, cardioProgram);

        fitnessCenter.attach(trainee1,cardioProgram);


        fitnessCenter.notifyObservers();



        TrainingProgram newProgramForTrainee1 = new YogaDecorator(basicProgram);
        fitnessCenter.setTrainingProgram(trainee1, newProgramForTrainee1);
        TrainingProgram newProgramForTrainee2 = new YogaDecorator(cardioProgram);
        fitnessCenter.setTrainingProgram(trainee2, newProgramForTrainee2);


        TrainingStrategy muscleGainStrategy = new MuscleGainStrategy();
        fitnessCenter.assignTrainingProgram(trainee3,muscleGainStrategy);




        FoodMenu foodMenu1 = new BasicFoodMenu("Vegetarian Menu", "A menu consisting of vegetarian options.",15);
        FoodMenu foodMenu2 = new BasicFoodMenu("Keto Menu", "A menu tailored for the ketogenic diet.",10.11);

        fitnessCenter.attach(trainee1
                 ,foodMenu1);
        fitnessCenter.attach(trainee3,foodMenu2);
        fitnessCenter.attach(trainee2,foodMenu1);
        fitnessCenter.attach(trainee3,foodMenu2);



        fitnessCenter.notifyObservers();


        fitnessCenter.detach(trainee3);

        fitnessCenter.notifyObservers();

    }
}
