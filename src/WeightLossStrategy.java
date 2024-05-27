public class WeightLossStrategy implements TrainingStrategy {
    @Override
    public TrainingProgram selectTrainingProgram() {
        return new CardioTrainingProgram(); // Example: Cardio program for weight loss
    }
}
