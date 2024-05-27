public abstract class TrainingDecorator implements TrainingProgram {
    protected TrainingProgram trainingProgram;

    public TrainingDecorator(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    @Override
    public String execute() {
        return trainingProgram.execute();
    }
}

class YogaDecorator extends TrainingDecorator {
    public YogaDecorator(TrainingProgram trainingProgram) {
        super(trainingProgram);
    }

    @Override
    public String execute() {
        return trainingProgram.execute() + " with Yoga";
    }
}

class SwimmingDecorator extends TrainingDecorator {
    public SwimmingDecorator(TrainingProgram trainingProgram) {
        super(trainingProgram);
    }

    @Override
    public String execute() {
        return trainingProgram.execute() + " with Swimming";
    }
}
