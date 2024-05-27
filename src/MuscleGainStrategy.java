public class MuscleGainStrategy implements TrainingStrategy {
    @Override
    public TrainingProgram selectTrainingProgram() {
        return new StrenghtTrainingProgram();
    }
}