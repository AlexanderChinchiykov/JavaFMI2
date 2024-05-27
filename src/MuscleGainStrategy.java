public class MuscleGainStrategy implements TrainingStrategy {
    @Override
    public TrainingProgram selectTrainingProgram() {
        return new StrenghtTrainingProgram(); // Example: Strength training for muscle gain
    }
}